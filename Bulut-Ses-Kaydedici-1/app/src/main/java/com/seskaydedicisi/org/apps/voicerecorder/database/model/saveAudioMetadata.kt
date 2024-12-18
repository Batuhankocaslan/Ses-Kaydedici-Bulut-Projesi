import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.seskaydedicisi.org.apps.voicerecorder.database.model.AudioRecord

fun saveAudioMetadata(audioRecord: AudioRecord, downloadUrl: String) {
    val db = FirebaseFirestore.getInstance()
    val metadata = hashMapOf(
        "filename" to audioRecord.filename,
        "filePath" to audioRecord.filePath,
        "date" to audioRecord.date,
        "duration" to audioRecord.duration,
        "downloadUrl" to downloadUrl
    )
    db.collection("audioMetadata")
        .add(metadata)
        .addOnSuccessListener { documentReference ->
            Log.d("Firestore", "Metadata kaydedildi: ${documentReference.id}")
        }
        .addOnFailureListener { exception ->
            Log.e("Firestore", "Metadata kaydedilemedi: ${exception.message}")
        }
}
