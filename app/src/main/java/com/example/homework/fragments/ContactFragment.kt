package com.example.homework.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.homework.ContactClickListener
import com.example.homework.R
import com.example.homework.databinding.FragmentContactDetailsBinding
import com.example.homework.databinding.FragmentContactBinding as FragmentContactBinding

class ContactFragment : Fragment() {
    private var communicator: ContactClickListener? = null
    private var binding: FragmentContactBinding? = null
    private var contactId: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContactClickListener) {
            communicator = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        communicator = null
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        communicator = activity as ContactClickListener
        binding = FragmentContactBinding
            .bind(view).apply {
                avatar.setImageResource(R.drawable.avatar)
                nameBox.text = "Иван Иванов"
                numberBox.text = "89888889898"
            }

        view.setOnClickListener {
            communicator?.onClick(contactId)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
