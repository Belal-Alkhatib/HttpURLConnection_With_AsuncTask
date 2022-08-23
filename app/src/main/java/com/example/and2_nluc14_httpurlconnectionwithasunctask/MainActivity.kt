package com.example.and2_nluc14_httpurlconnectionwithasunctask

import android.app.ProgressDialog
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import com.example.and2_nluc14_httpurlconnectionwithasunctask.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val URL = "https://api.androidhive.info/volley/person_object.json"
    lateinit var progressDialog:ProgressDialog
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnStart.setOnClickListener {
            PostsAsyncTask().execute(URL)
        }

        binding!!.btnEx2.setOnClickListener {
            val i = Intent(this,MainActivityEx2::class.java)
            startActivity(i)
        }
    }

    inner class PostsAsyncTask():AsyncTask<String,Int,String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(this@MainActivity)
            progressDialog.setMessage("loading data")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg params: String?): String {
            // or URL مباشرة بالبرم انت ترسله عبر اكسيكيوت عند استدعاؤء الاسينك تاسك

            var respons = HttpHandeler.makeServiceCall(params[0])

            //**********  لعملية القراءة بشكل منفصل  ************

            /*
                        val jsonObj = JSONObject()
            val name = jsonObj.getString("name")
            val email = jsonObj.getString("email")
               //other nested object
                val phoneObj = jsonObj.getJSONObject("phone")
                val home = phoneObj.getString("home")
                val mobile = phoneObj.getString("mobile")

             */
            return respons!!


        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            binding!!.tvMsg.text = result
            if(progressDialog.isShowing)
                progressDialog.dismiss()

        }


    }
}