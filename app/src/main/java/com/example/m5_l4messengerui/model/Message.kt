package com.example.m5_l4messengerui.model

data class Message(
    val profile: Int,
    val fullname: String,
    val isOnline: Boolean = false
)
