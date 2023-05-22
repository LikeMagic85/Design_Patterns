package com.like_magic.designpatterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.like_magic.designpatterns.databinding.FragmentFacadeBinding

class FacadeFragment : Fragment() {

    private var _binding: FragmentFacadeBinding? = null
    private val binding: FragmentFacadeBinding
        get() = _binding ?: throw RuntimeException("FragmentFacadeBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFacadeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getUserBtn.setOnClickListener {
            val id = binding.userId.text.toString()
            if(id.isNotEmpty()){
                binding.result.text =  CacheManager().getUser(id.toInt()).toString()
            }else{
                Snackbar.make(binding.root, "Enter id", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() =
            FacadeFragment()
    }
}