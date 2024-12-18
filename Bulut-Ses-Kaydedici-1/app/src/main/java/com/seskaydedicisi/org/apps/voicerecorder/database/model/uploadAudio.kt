import android.net.Uri
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import java.io.File

private fun uploadAudio(audioFile: Uri) {
    val storageRef = FirebaseStorage.getInstance().reference
    val audioRef = storageRef.child("audio/${audioFile.lastPathSegment}")

    val uploadTask = audioRef.putFile(audioFile)

    uploadTask.addOnSuccessListener {
        // Yükleme başarılı
        Log.d("FirebaseUpload", "Ses dosyası yüklendi: ${audioRef.path}")
    }.addOnFailureListener {
        // Yükleme hatası
        Log.e("FirebaseUpload", "Hata: ${it.message}")
    }
    val audioFileUri: Uri = Uri.fromFile(File("/path/to/recorded/audio.mp3"))
    uploadAudio(audioFileUri)

}
