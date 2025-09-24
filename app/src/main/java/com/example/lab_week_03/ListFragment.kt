package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private var coffeeListener: CoffeeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            coffeeListener = context
        } else {
            throw RuntimeException("$context must implement CoffeeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // daftar semua item kopi
        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino),
            view.findViewById(R.id.mocha)
        )

        // pasang click listener untuk setiap item
        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                coffeeListener?.onSelected(coffee.id)
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
