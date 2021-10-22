package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.homework.fragments.ContactDetailsFragment
import com.example.homework.fragments.ContactFragment

class MainActivity : AppCompatActivity(), ICommunicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactFragment = ContactFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainer,contactFragment).commit()
        this.findViewById<TextView>(R.id.heading).text = "Список контактов"
    }

    override fun passData(name: String, number : String, email : String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("number", number)
        bundle.putString("email", email)

        val transaction = this.supportFragmentManager.beginTransaction()
        val contactDetailsFragment = ContactDetailsFragment()
        contactDetailsFragment.arguments = bundle

        transaction.replace(R.id.fragmentContainer,contactDetailsFragment)
        transaction.commit()
        this.findViewById<TextView>(R.id.heading).text = "Детали контакта"
    }

    fun buckClick(view: View) {
        val contactFragment = ContactFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,contactFragment)
            .commit()
        this.findViewById<TextView>(R.id.heading).text = "Список контактов"
    }
}