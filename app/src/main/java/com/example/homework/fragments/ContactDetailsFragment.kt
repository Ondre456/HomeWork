package com.example.homework.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.homework.ContactClickListener
import com.example.homework.MainActivity
import com.example.homework.R
import com.example.homework.databinding.FragmentContactDetailsBinding

class ContactDetailsFragment : Fragment() {

    var binding: FragmentContactDetailsBinding? = null

    private var contactId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_details, container, false)
        contactId = arguments?.getInt("id")
        binding = FragmentContactDetailsBinding
            .bind(view).apply {
                val contact = (activity as ContactClickListener).contacts[contactId as Int]
                nameBox.text = contact.name
                phone.text = contact.number
                emailAddress.text = contact.email
                avatar.setImageResource(R.drawable.avatar)

                backButton.setOnClickListener {
                    parentFragmentManager.popBackStack()

                    (activity as MainActivity)
                        .supportActionBar?.title = getString(R.string.contactsList)
                }
            }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
