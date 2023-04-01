package com.example.washingangel

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class WashTag : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var scrollView1: ScrollView
    private lateinit var scrollView2: ScrollView
    private lateinit var scrollView3: ScrollView
    private lateinit var tableLayout: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_washtag, container, false)

        // Initialize views
        spinner = view.findViewById(R.id.spinner)
        scrollView1 = view.findViewById(R.id.scroll_view1)
        scrollView2 = view.findViewById(R.id.scroll_view2)
        scrollView3 = view.findViewById(R.id.scroll_view3)
        tableLayout = view.findViewById(R.id.table_layout)

        // Set up the spinner adapter and onItemSelectedListener
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.countries_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        scrollView1.visibility = View.VISIBLE
                        scrollView2.visibility = View.GONE
                        scrollView3.visibility = View.GONE
                    }
                    1 -> {
                        scrollView1.visibility = View.GONE
                        scrollView2.visibility = View.VISIBLE
                        scrollView3.visibility = View.GONE
                    }
                    2 -> {
                        scrollView1.visibility = View.GONE
                        scrollView2.visibility = View.GONE
                        scrollView3.visibility = View.VISIBLE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Set up the onClickListener for the image buttons in the table layout
        for (i in 0 until tableLayout.childCount) {
            val tableRow = tableLayout.getChildAt(i) as TableRow
            for (j in 0 until tableRow.childCount) {
                val imageButton = tableRow.getChildAt(j) as ImageButton
                imageButton.setOnClickListener {
                    val dialog = Dialog(requireContext())
                    dialog.setContentView(R.layout.dialog)

                    val titleTextView = dialog.findViewById<TextView>(R.id.title_text_view)
                    val DescriptionTextView = dialog.findViewById<TextView>(R.id.description_text_view)
                    val closeButton = dialog.findViewById<Button>(R.id.close_button)

                    // Set the title and content of the dialog based on the clicked image button
                    titleTextView.text = "Info for button ($i,$j)"
                    DescriptionTextView.text = "This is the information for button ($i,$j)"

                    // Set the onClickListener for the close button to dismiss the dialog
                    closeButton.setOnClickListener { dialog.dismiss() }

                    dialog.show()
                }
            }
        }

        return view
    }
}

