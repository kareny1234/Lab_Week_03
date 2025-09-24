package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private var coffeeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            coffeeId = it.getInt(ARG_COFFEE_ID, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeTitle: TextView = view.findViewById(R.id.coffee_title)
        val coffeeDesc: TextView = view.findViewById(R.id.coffee_desc)
        val backButton: Button = view.findViewById(R.id.btn_back)

        // isi data kopi berdasarkan ID
        when (coffeeId) {
            R.id.affogato -> {
                coffeeTitle.text = "AFFOGATO"
                coffeeDesc.text = "Espresso poured on a vanilla ice cream. Served in a cappuccino cup."
            }
            R.id.americano -> {
                coffeeTitle.text = "AMERICANO"
                coffeeDesc.text = "Espresso with added hot water (100-150 ml). Often\n" +
                        "served in a cappuccino cup. (The espresso is added into the hot water rather than\n" +
                        "all the water being flowed through the coffee that would lead to over\n" +
                        "extraction.)"
            }
            R.id.latte -> {
                coffeeTitle.text = "CAFFE LATTE"
                coffeeDesc.text = "A tall, mild 'milk coffee' (about 150-300 ml). An\n" +
                        "espresso with steamed milk and only a little milk foam poured over it. Serve in a\n" +
                        "latte glass or a coffee cup. Flavored syrup can be added."
            }
            R.id.cappuccino -> {
                coffeeTitle.text = "CAPPUCCINO"
                coffeeDesc.text = "A classic Italian coffee drink made with equal parts of espresso, steamed milk, and milk foam."
            }
            R.id.mocha -> {
                coffeeTitle.text = "MOCHA"
                coffeeDesc.text = "A delightful blend of espresso, steamed milk, and rich chocolate syrup, often topped with whipped cream."
            }
        }

        // tombol back: kembali ke back stack
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        private const val ARG_COFFEE_ID = "COFFEE_ID"

        fun newInstance(id: Int) = DetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_COFFEE_ID, id)
            }
        }
    }
}
