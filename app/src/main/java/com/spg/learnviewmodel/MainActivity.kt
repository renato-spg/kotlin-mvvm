package com.spg.learnviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.spg.learnviewmodel.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel :LoginViewModel by viewModels()

    private lateinit var edtName: EditText
    private lateinit var edtPass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        edtName= findViewById(R.id.edtName_activity_main)
        edtPass= findViewById(R.id.edtPass_activity_main)


        findViewById<Button>(R.id.btn_activity_main).setOnClickListener({

            val pass = edtPass.text.toString()
            val name = edtName.text.toString()
            viewModel.login(name, pass)
        })


       viewModel.loginResult.observe(this){
            result ->

            if(result.success){
                Toast.makeText(this, "e ne que deu?", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "deu errado", Toast.LENGTH_SHORT).show()
            }
        }


    }
}