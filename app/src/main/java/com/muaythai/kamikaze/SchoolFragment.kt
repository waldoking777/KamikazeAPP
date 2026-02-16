package com.muaythai.kamikaze

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SchoolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_school, container, false)

        // Find the TextView
        val credoTextView = view.findViewById<TextView>(R.id.school_credo_text)

        // Get the HTML formatted string
        val credoHtml = getString(R.string.school_credo_desc)

        // Set the text, interpreting HTML tags
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            credoTextView.text = Html.fromHtml(credoHtml, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            credoTextView.text = Html.fromHtml(credoHtml)
        }

        return view
    }
}
