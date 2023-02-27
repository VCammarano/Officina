package com.android.academy.todolist

import java.time.LocalDateTime

interface ToDoService {
    fun getToDo(): List<ToDo>
}

class SimpleToDoService : ToDoService {
    private val todolist = mutableListOf<ToDo>(
        ToDo(1, "Fare la spesa", LocalDateTime.now(), false, null),
        ToDo(2, "Andare dal parrucchiere", LocalDateTime.now().plusDays(1), false, null),
        ToDo(3, "Portare a spasso il cane", LocalDateTime.now().plusHours(5), false, null),
        ToDo(4, "Leggere la posta", LocalDateTime.now().plusMinutes(1), false, null),
        ToDo(
            5,
            "Passare all'ufficio postale",
            LocalDateTime.now().plusMonths(1),
            false,
            "Occorre pagare tante bollette"
        ),
        ToDo(6, "Telefonare a Marco", LocalDateTime.now().minusHours(1), true, null),
    )

    override fun getToDo(): List<ToDo> = todolist.toList()
}