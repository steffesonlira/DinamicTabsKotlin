package com.example.tabhost

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DynamicFragment : Fragment() {

    private lateinit var view2: View
    var value = 0
    private lateinit var c: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view2 = inflater.inflate(R.layout.fragment_dynamic, container, false)
        value = requireArguments().getInt("someInt", 0)
        c = view2.findViewById(R.id.c)
        c.setText("Fragment - $value`")
        return view2
    }

    companion object {
        fun addFrag(value: Int): DynamicFragment {
            val fragment = DynamicFragment()
            val args = Bundle()
            args.putInt("someInt", value)
            fragment.arguments = args
            return fragment
        }
    }

}