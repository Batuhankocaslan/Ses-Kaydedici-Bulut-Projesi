package com.seskaydedicisi.org.apps.voicerecorder.repo

import com.seskaydedicisi.org.apps.voicerecorder.database.AudioRecordDao
import com.seskaydedicisi.org.apps.voicerecorder.database.model.AudioRecord
import kotlinx.coroutines.flow.Flow

class RecorderRepoImpl(
    private val dao: AudioRecordDao,
) : RecorderRepo {
    override suspend fun insertRecording(recording: AudioRecord) {
        dao.insert(recording)
    }

    override suspend fun deleteRecording(recording: AudioRecord) {
        dao.delete(recording)
    }

    override suspend fun updateRecording(recording: AudioRecord) {
        dao.update(recording)
    }

    override fun getRecords(): Flow<List<AudioRecord>> {
        return dao.getRecords()
    }
    override fun getAllAudioRecords(
        searchQuery: String
    ): Flow<List<AudioRecord>> {
        return dao.getSearchRecords(searchQuery)
    }

    override suspend fun deleteAllAudioRecords() {
        dao.deleteAll()
    }

}