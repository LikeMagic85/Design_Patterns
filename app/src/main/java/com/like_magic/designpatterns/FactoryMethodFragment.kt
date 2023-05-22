package com.like_magic.designpatterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.like_magic.designpatterns.databinding.FragmentFactoryMethodBinding

class FactoryMethodFragment : Fragment() {

    private var _binding: FragmentFactoryMethodBinding? = null
    private val binding: FragmentFactoryMethodBinding
        get() = _binding ?: throw RuntimeException("FragmentSingletonBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFactoryMethodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val deliveryMethodFactory = DeliveryMethodFactory("Test", 1000, 50)
        val shipDelivery = deliveryMethodFactory.createDeliveryMethod("USA")
        if(shipDelivery is ShipDelivery){
            shipDelivery.type = "By river"
        }
        shipDelivery?.deliver()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() =
            FactoryMethodFragment()
    }
}