package com.gameonanil.instagramcloneapp.ui.start

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gameonanil.imatagramcloneapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_signup.*

class SignupFragment: Fragment(R.layout.fragment_signup) {
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()


        button_register.setOnClickListener {
            if (etSignupEmail.text.isBlank() || etSignUpPassword.text.isBlank()){
                Toast.makeText(activity, "Email and Password cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (etUserName.text.isBlank()){
                Toast.makeText(activity, "UserName cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val email = etSignupEmail.text.toString().trim()
            val password = etSignUpPassword.text.toString().trim()
            val username = etUserName.text.toString().trim()

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        Toast.makeText(activity, "signup success!!: uid= ${firebaseUser.uid}", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(activity, "signup failed: ${task.exception}", Toast.LENGTH_SHORT).show()
                    }

                }


        }
    }
}