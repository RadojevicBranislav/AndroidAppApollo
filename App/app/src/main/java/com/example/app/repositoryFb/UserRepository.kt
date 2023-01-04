package com.example.app.repositoryFb

import androidx.lifecycle.MutableLiveData
import com.example.app.modelsFb.User
import com.google.firebase.database.*

class UserRepository {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")

    @Volatile private var INSTANCE : UserRepository ?= null

    fun getInstance(): UserRepository
    {
        return INSTANCE ?: synchronized(this){
            val instance = UserRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadUsers(userList: MutableLiveData<List<User>>)
    {
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _userList : List<User> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(User::class.java)!!
                    }

                    userList.postValue(_userList)
                } catch (e: Exception){
                    println("Ness ne radi mamicu mu jebem ja" + e.printStackTrace())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}