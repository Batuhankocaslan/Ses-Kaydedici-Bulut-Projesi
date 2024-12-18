import android.util.Log
import com.seskaydedicisi.org.apps.voicerecorder.database.model.AudioRecord
import java.io.File

fun uploadAndSaveRecord(audioRecord: AudioRecord) {
    val uploader = FirebaseUploader()
    uploader.uploadAudio(audioRecord.filePath,
        onSuccess = {
            // Firebase Storage'deki dosya URL'sini al
            uploader.storageRef.child("audioFiles/${File(audioRecord.filePath).name}")
                .downloadUrl
                .addOnSuccessListener { uri ->
                    saveAudioMetadata(audioRecord, uri.toString())
                }
        },
        onFailure = { exception ->
            Log.e("AudioUpload", "Ses kaydı yüklenemedi: ${exception.message}")
        }
    )
}
