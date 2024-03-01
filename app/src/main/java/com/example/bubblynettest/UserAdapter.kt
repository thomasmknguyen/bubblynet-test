package com.example.bubblynettest

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import models.User

class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, private val userList: List<User>) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.username)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    val user = userList[position]

                    val intent = Intent(context, ViewUserActivity::class.java)
                    intent.putExtra("user", user)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.user_item, viewGroup, false)
        return ViewHolder(view, userList)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentUser = userList[position]
        viewHolder.usernameTextView.text = currentUser.username
    }

    override fun getItemCount() = userList.size
}
