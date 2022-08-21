package com.example.biomedicapp.domain.repository

import com.example.biomedicapp.domain.model.UserFirebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class FirestoreUserRepositoryImp @Inject constructor():FirestoreUserRepository {
     val USER_COLLECTION = "users"

    override suspend fun createUser(user: UserFirebase): Boolean {
        var isSuccessFull = false
        return try{
            FirebaseFirestore.getInstance()
                .collection(USER_COLLECTION)
                .document(user.uid)
                .set(user, SetOptions.merge())
                .addOnCompleteListener {
                   isSuccessFull = it.isSuccessful
                }
                .await()
            isSuccessFull
        }catch (e:Exception){
           false
        }

    }

    override suspend fun getUser(uId: String): UserFirebase {
    var user = UserFirebase()
        return try {
        FirebaseFirestore.getInstance()
            .collection(USER_COLLECTION)
            .document(uId)
            .get()
            .addOnSuccessListener {
                user = it.toObject(UserFirebase::class.java)!!
            }
            .await()
            user

    }   catch (e:Exception){
        UserFirebase()
    }
    }
}