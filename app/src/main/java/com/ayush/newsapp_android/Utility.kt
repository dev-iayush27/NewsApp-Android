package com.ayush.newsapp_android

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun convertDate(date: String, requiredFormat: String): String {
    var df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
    var newDate: Date? = null
    try {
        newDate = df.parse(date)
        df = SimpleDateFormat(requiredFormat, Locale.US)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return newDate?.let { df.format(newDate) } ?: date
}