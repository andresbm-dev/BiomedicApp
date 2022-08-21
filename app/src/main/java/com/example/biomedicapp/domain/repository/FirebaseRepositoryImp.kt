package com.example.biomedicapp.domain.repository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class FirebaseRepositoryImp @Inject constructor(
    private val firebaseAuth: FirebaseAuth
):FirebaseRepository {
    override suspend fun login(emaill: String, password: String): String {
        var userUid = ""
        var result = ""
        var bool = false
        return try {
            firebaseAuth.signInWithEmailAndPassword(emaill, password)
                .addOnSuccessListener {
                    userUid = it.user?.uid ?: ""
                }
                .addOnCompleteListener {
                    bool = it.isSuccessful
                }
                .addOnFailureListener {
                    result = it.message.toString()
                }
                .await()
            print(bool)
            print(result)
            userUid
        }catch (e:Exception){
            print(e)
            ""
        }
    }

    override suspend fun sigUp(email: String, passwrord: String): String {
        return try{
            var userUid = ""
            firebaseAuth.createUserWithEmailAndPassword(email,passwrord)
                .addOnSuccessListener {
                    userUid = it.user?.uid ?: ""
                }
                .await()
            userUid
        }catch (e:Exception){
            print(e)
            ""
        }
    }
}