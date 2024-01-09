package com.example.ept

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ept.databinding.ActivitySignInBinding



class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Đăng Nhập"


        binding.SignInToSignUp.setOnClickListener{
            startActivity(Intent(this,SignUp::class.java))
            finish()
        }
        binding.SignInToPhone.setOnClickListener{
            startActivity(Intent(this,Phone::class.java))
            finish()
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val passSignIn = binding.password.text.toString()
            if(email.isNotEmpty() && passSignIn.isNotEmpty())
                MainActivity.auth.createUserWithEmailAndPassword(email,passSignIn).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this,it.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }

        binding.googleBtn.setOnClickListener{

        }
    }
}