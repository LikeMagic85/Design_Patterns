package com.like_magic.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.like_magic.designpatterns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.builderBtn.setOnClickListener {
            navigateTo(BuilderFragment.newInstance())
        }
        binding.singletonBtn.setOnClickListener {
            navigateTo(SingletonFragment.newInstance())
        }
        binding.factoryMethodBtn.setOnClickListener {
            navigateTo(FactoryMethodFragment.newInstance())
        }
    }


    private fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, fragment)
            .commit()
    }
}