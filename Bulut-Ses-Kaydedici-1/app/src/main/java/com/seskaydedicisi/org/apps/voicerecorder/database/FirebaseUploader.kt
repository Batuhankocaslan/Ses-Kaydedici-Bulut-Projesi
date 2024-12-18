import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class FirebaseUploader {

    private val storage = FirebaseStorage.getInstance()
    val storageRef = storage.reference

    fun uploadAudio(filePath: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val file = File(filePath)
        val audioRef: StorageReference = storageRef.child("audioFiles/${file.name}")

        val uploadTask = audioRef.putFile(Uri.fromFile(file))
        uploadTask.addOnSuccessListener {
            onSuccess()
        }.addOnFailureListener { exception ->
            onFailure(exception)
        }

    }

}
