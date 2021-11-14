package com.example.homework

interface ContactClickListener {
    fun onClick(id: Int)
    val contacts: List<Contact>
}
