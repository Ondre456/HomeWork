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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactDetailsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    var binding : FragmentContactDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var contactId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_details, container, false)
        contactId = arguments?.getInt("id")!!
        binding = FragmentContactDetailsBinding
            .bind(view).apply {
                val contact =(activity as ContactClickListener).Contacts[contactId]
                nameBox.text = contact.name
                Phone.text = contact.number
                EmailAddress.text = contact.email
                avatar.setImageResource(R.drawable.avatar)

                backButton.setOnClickListener {
                    val contactFragment = ContactFragment()
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentContainer,contactFragment)
                        ?.commit()
                    ( activity as MainActivity)
                        .supportActionBar?.title = getString(R.string.contactsList)
                }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
