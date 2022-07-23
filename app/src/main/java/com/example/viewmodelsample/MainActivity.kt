package com.example.viewmodelsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var number = 0
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        numberWithoutViewModel()
        numberWithViewModel()

    }

    fun numberWithoutViewModel() {
        number_box.text = number.toString()
        button_add.setOnClickListener {
            number++
            number_box.text = number.toString()
        }
    }

    fun numberWithViewModel() {
        // rotacione a tela do celular e veja que apenas esse mantem o valor o outro o valor volta
        // para 0 pq a activity é destruida, esse é um dos motivos de usar viewModel
        second_number_box.text = viewModel.getCurrentCount().toString()
        second_button_add.setOnClickListener {
            second_number_box.text = viewModel.getUpdatedCount().toString()
        }
    }

}