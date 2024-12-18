package com.ysanjeet535.voicerecorder.utils

import com.seskaydedicisi.org.apps.voicerecorder.utils.AppConstants
import java.text.SimpleDateFormat
import java.util.*

object AppUtils {
    fun getDate(date: Long): String {
//        var tempDate = date
//        tempDate *= 1000L
        return SimpleDateFormat(AppConstants.DATE_FORMAT, Locale.getDefault()).format(
            Date(
                date
            )
        )
    }
}