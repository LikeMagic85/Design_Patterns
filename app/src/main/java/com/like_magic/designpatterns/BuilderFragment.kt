package com.like_magic.designpatterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.like_magic.designpatterns.databinding.FragmentBuilderBinding

class BuilderFragment : Fragment() {

    private var _binding: FragmentBuilderBinding? = null
    private val binding: FragmentBuilderBinding
        get() = _binding ?: throw RuntimeException("FragmentBuilderBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuilderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.makeCoffeeBtn.setOnClickListener {
            val coffeeBuilder = Coffee.Builder()
            if (binding.doubleCoffeeCheckBox.isChecked){
                coffeeBuilder.doubleCoffee()
            }
            if(binding.milkCheckBox.isChecked){
                coffeeBuilder.addMilk()
            }
            val coffee = coffeeBuilder.build()
            binding.result.text = coffee.getConsist()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() =
            BuilderFragment()
    }
}