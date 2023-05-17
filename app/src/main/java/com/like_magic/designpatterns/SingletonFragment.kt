package com.like_magic.designpatterns

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.like_magic.designpatterns.databinding.FragmentBuilderBinding
import com.like_magic.designpatterns.databinding.FragmentSingletonBinding

class SingletonFragment : Fragment() {

    private var _binding: FragmentSingletonBinding? = null
    private val binding: FragmentSingletonBinding
        get() = _binding ?: throw RuntimeException("FragmentSingletonBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingletonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sun1 = Sun.newInstance()
        val sun2 = Sun.newInstance()
        sun1.addTemp(100)
        binding.result.text = sun2.temp.toString()
    }

    companion object {
        fun newInstance() =
            SingletonFragment()
    }
}