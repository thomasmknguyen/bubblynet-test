package com.example.bubblynettest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.User

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = listOf(
            User(R.mipmap.default_pfp, "john_doe", "johndoe@email.com"),
            User(R.mipmap.default_pfp, "jane_smith", "janesmith@email.com"),
            User(R.mipmap.default_pfp, "bob_jones", "bobjones@email.com"),
            User(R.mipmap.default_pfp, "alice_williams", "alicewilliams@email.com"),
            User(R.mipmap.default_pfp, "charlie_brown", "charliebrown@email.com"),
            User(R.mipmap.default_pfp, "emma_davis", "emmadavis@email.com"),
            User(R.mipmap.default_pfp, "michael_miller", "michaelmiller@email.com"),
            User(R.mipmap.default_pfp, "olivia_wilson", "oliviawilson@email.com"),
            User(R.mipmap.default_pfp, "david_anderson", "davidanderson@email.com"),
            User(R.mipmap.default_pfp, "sophia_thomas", "sophiathomas@email.com")
        )


        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter(users)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter
    }
}
