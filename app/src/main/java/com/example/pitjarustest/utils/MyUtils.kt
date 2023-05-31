package com.example.pitjarustest.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object MyUtils {
    fun getDate(format: String): String {
        val cal: Calendar = Calendar.getInstance()
        val date = SimpleDateFormat(format, Locale("id", "ID"))
        return date.format(cal.time)
    }
}