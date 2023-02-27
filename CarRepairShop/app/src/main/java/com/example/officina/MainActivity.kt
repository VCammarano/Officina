package com.example.officina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrepairshop.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up bottom navigation
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_clienti -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ClientiFragment())
                        .commit()
                    true
                }
                R.id.menu_auto -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AutoFragment())
                        .commit()
                    true
                }
                R.id.menu_interventi -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, InterventiFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }

        // Set default fragment
        binding.bottomNavigation.selectedItemId = R.id.menu_clienti
    }
}
