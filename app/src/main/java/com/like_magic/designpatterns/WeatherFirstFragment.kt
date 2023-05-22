package com.like_magic.designpatterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.like_magic.designpatterns.databinding.FragmentWeatherFirstBinding

class WeatherFirstFragment : Fragment(), WeatherObserver {

    private var _binding: FragmentWeatherFirstBinding? = null
    private val binding: FragmentWeatherFirstBinding
        get() = _binding ?: throw RuntimeException("FragmentWeatherFirstBinding is null")
    private val weatherSubject = WeatherSubject.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherSubject.addObserver(this)
        weatherSubject.startPeriodicUpdates()
        binding.nextScreenBtn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.main_container, WeatherSecondFragment.newInstance())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        weatherSubject.removeObserver(this)
    }

    companion object {
        fun newInstance() =
            WeatherFirstFragment()
    }

    override fun onWeatherChange(weatherData: WeatherData) {
        binding.result.text = weatherData.temperature.toString()
    }
}