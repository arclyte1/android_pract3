package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pressCounter = Random.nextInt(10, 30)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miInfo -> {
                showInfo();
                return true
            }
            R.id.miNext -> {
                openSecondActivity()
                return true
            }
            android.R.id.home -> {
                finish()
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    private fun openSecondActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun showInfo() {
        pressCounter--
        if (pressCounter <= 0)
            binding.textView.text = "Молодец"
        else
            binding.textView.text = ("Думаю, что осталось $pressCounter раз нажать на эту кнопку")
    }


}