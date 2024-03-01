package com.example.bubblynettest

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import models.User

class ViewUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)

        val usernameTextView: TextView = findViewById(R.id.usernameTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val profileImageView: ImageView = findViewById(R.id.profileImageView)

        val user: User? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("user", User::class.java) as? User
        } else {
            intent.getSerializableExtra("user") as? User
        }

        if (user != null) {
            val usernameLabel = getString(R.string.username_label, user.username)
            val emailLabel = getString(R.string.email_label, user.email)

            profileImageView.setImageResource(user.profileImage) // Set the image
            usernameTextView.text = usernameLabel
            emailTextView.text = emailLabel
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply{
            title = (user?.username + " Details") ?: "BubbleNet Test"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
