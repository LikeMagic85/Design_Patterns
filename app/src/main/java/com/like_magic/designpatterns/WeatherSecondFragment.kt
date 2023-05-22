package com.like_magic.designpatterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.like_magic.designpatterns.databinding.FragmentWeatherSecondBinding

class WeatherSecondFragment : Fragment(), WeatherObserver {

    private var _binding: FragmentWeatherSecondBinding? = null
    private val binding: FragmentWeatherSecondBinding
        get() = _binding ?: throw RuntimeException("FragmentWeatherSecondBinding is null")
    private val weatherSubject = WeatherSubject.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherSubject.addObserver(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        weatherSubject.removeObserver(this)
    }

    companion object {
        fun newInstance() =
            WeatherSecondFragment()
    }

    override fun onWeatherChange(weatherData: WeatherData) {
        requireActivity().runOnUiThread {
            binding.result.text = weatherData.toString()
        }
    }
}