package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.app.databinding.ActivityMainWindowBinding
import com.example.app.model.Astronaut
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainWindowActivity : AppCompatActivity() {
    var astronauts: List<Astronaut> = mutableListOf<Astronaut>()

    lateinit var txtView: TextView

    private lateinit var binding: ActivityMainWindowBinding


    //this is how fragments are changed
    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)

        fragmentTransaction.commit()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainWindowBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFragment(HomeFragment())

                R.id.satelite -> replaceFragment(SateliteFragment())

                R.id.profile -> replaceFragment(ProfileFragment())

                else ->{}
            }
            true

        }


        var astronauts: List<Astronaut> = arrayListOf<Astronaut>()
//        apiCall()
    }

//    private fun apiCall(){
//
//        val url = "http://api.open-notify.org/astros.json"
//
//
//
//        val queue = Volley.newRequestQueue(this)
//
//
//
//        val jsonObjectRequest = JsonObjectRequest(
//            Request.Method.GET,url, null,
//            Response.Listener {response->
//                //this method for our api call successful
//            try {
//                var dataJson: JSONArray= response.getJSONArray("people")
//                for(i in 0..dataJson.length()){
//                    var dataObj: JSONObject = dataJson.getJSONObject(i)
//                    var name: String = dataObj.getString("name")
//                    var craft: String = dataObj.getString("craft")
//                    astronauts += Astronaut(name, craft)
//
//                    Toast.makeText(this, "Fetch success", Toast.LENGTH_SHORT)
//
//                }
//            } catch (e: JSONException){
//                Toast.makeText(this, "Fetching failed", Toast.LENGTH_SHORT)
//
//            }
//
//
//            }, Response.ErrorListener {
//                //this is for api fail
//                Toast.makeText(this, "API failed", Toast.LENGTH_SHORT)
//
//            }
//        )
//        //set json request to queue
//        queue.add(jsonObjectRequest)
//        }
}
