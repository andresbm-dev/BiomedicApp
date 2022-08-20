package com.example.biomedicapp.domain.repository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class FirebaseRepositoryImp @Inject constructor(
    private val firebaseAuth: FirebaseAuth
):FirebaseRepository {
    override suspend fun login(emaill: String, password: String): Boolean {

        var isSuccesFully = false
        try {
            firebaseAuth.signInWithEmailAndPassword(emaill, password)
                .addOnSuccessListener { isSuccesFully = true }
                .addOnFailureListener { isSuccesFully = false }
                .await()
            return isSuccesFully

        }catch (e:Exception){
            return false
        }
    }

    override suspend fun sigUp(email: String, passwrord: String): Boolean {
        return try{
            var isSuccessFull = false
            firebaseAuth.createUserWithEmailAndPassword(email,passwrord)
                .addOnCompleteListener { isSuccessFull = true }
                .addOnFailureListener { isSuccessFull = false }
                .await()
            return isSuccessFull
        }catch (e:Exception){
            print(e)
            false
        }
    }
}