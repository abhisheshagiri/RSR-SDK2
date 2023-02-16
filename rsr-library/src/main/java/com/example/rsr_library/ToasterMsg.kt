package com.example.rsr_library

import android.content.Context
import android.widget.Toast


object ToasterMessage {
    fun show(c: Context?, message: String?) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }
}