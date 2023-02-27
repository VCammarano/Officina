package com.android.academy.todolist

import java.time.LocalDateTime

// un elemento che rappresenta una "cosa da fare"
data class ToDo(
    val id: Long, // identificativo univoco (chiave)
    val subject: String, // cosa
    val date: LocalDateTime, // quando
    val complete: Boolean, // finito?
    val notes: String?  // note
)