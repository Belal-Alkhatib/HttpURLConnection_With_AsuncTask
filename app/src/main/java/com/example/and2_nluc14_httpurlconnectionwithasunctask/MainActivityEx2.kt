package com.example.and2_nluc14_httpurlconnectionwithasunctask

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_ex2.*

class MainActivityEx2 : AppCompatActivity() {
    val URL = "https://api.androidhive.info/volley/person_array.json"
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ex2)

        btnStartEx2.setOnClickListener {
            PostsAsyncTask2().execute(URL)
        }
    }

    inner class PostsAsyncTask2(): AsyncTask<String, Int, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(this@MainActivityEx2)
            progressDialog.setMessage("loading data")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg params: String?): String {
            // or URL مباشرة بالبرم انت ترسله عبر اكسيكيوت عند استدعاؤء الاسينك تاسك

            var respons = HttpHandeler.makeServiceCall(params[0])
            return respons!!


        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tvMsgEx2.text = result
            if(progressDialog.isShowing)
                progressDialog.dismiss()

        }


    }
}