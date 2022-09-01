package com.geserrato.navigationcomponents

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class SegundoFragment : Fragment(R.layout.fragment_segundo) {
    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: SegundoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = args.nombre
        edad = args.edad
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txt_View)
        text.text = "$nombre $edad"
        val button = view.findViewById<Button>(R.id.btn_enviarDatos)
        button.setOnClickListener {
            val result = "Resultado otro valor"
            // bundleOf nos pide una clave valor
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(Uri.parse("cursoandroid://card"))
        }
    }

    companion object {
        private const val MY_NAME = "nombre"
        private const val MY_AGE = "edad"

        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            arguments = bundleOf(MY_NAME to nombre, MY_AGE to edad)
        }
    }
}