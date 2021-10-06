package com.example.testproject

import android.os.Bundle
import android.view.View
import com.example.testproject.databinding.FragmentFirstBinding
import com.example.testproject.viewbinding.ViewBindingFragment

class FirstFragment : ViewBindingFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}