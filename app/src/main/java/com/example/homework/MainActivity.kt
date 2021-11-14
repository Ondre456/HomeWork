package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.homework.fragments.ContactDetailsFragment
import com.example.homework.fragments.ContactFragment

class MainActivity : AppCompatActivity(), ContactClickListener {
    override val contacts = listOf<Contact>(
        Contact("Иван Иванов", "89888889898", "firstcontact@gmail.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val contactFragment = ContactFragment()
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainer, contactFragment
            ).commit()
        }

        supportActionBar?.title = getString(R.string.contactsList)
    }

    override fun onClick(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)

        val transaction = this.supportFragmentManager.beginTransaction()
        val contactDetailsFragment = ContactDetailsFragment()
        contactDetailsFragment.arguments = bundle

        transaction.replace(R.id.fragmentContainer, contactDetailsFragment)
        transaction.commit()
        transaction.addToBackStack(null)

        supportActionBar?.title = getString(R.string.contactDetails)
    }
}
