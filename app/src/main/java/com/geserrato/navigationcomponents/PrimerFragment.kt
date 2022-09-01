package com.geserrato.navigationcomponents

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class PrimerFragment : Fragment(R.layout.fragment_primer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_navegar)
        val result = view.findViewById<TextView>(R.id.txt_output)

        setFragmentResultListener("requestKey") { key, bundle ->
            val resultFragment = bundle.getString("bundleKey")
            result.text = resultFragment
        }

        button.setOnClickListener {
            val action =
                PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment("Gerardo", 30)
            findNavController().navigate(action)
        }
    }
}