package com.example.ept

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ept.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title="Đăng Ký"

        binding.SignUpToSignIn.setOnClickListener{
            startActivity(Intent(this,SignIn::class.java))
            finish()
        }

        binding.createBtn.setOnClickListener {
            val getEmail = binding.createEmail.text.toString()
            val passSignUp = binding.passwordSignUp.text.toString()
            val renew = binding.reactpassword.text.toString()
            if(getEmail.isNotEmpty() && passSignUp.isNotEmpty() && renew != passSignUp)
                MainActivity.auth.createUserWithEmailAndPassword(getEmail,passSignUp).addOnCompleteListener {
                    if (it.isSuccessful){
                      startActivity(Intent(this,SignIn::class.java))
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                }
        }

    }
}


