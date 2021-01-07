package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main0.*

class MainActivity0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main0)
//        val sports=btnbutton.text.toString()
//        val health=btnbutton1.text.toString()
//        val science=btnbutton2.text.toString()
//        val business=btnbutton3.text.toString()
//        val technology=btnbutton4.text.toString()
//        val entertainment=btnbutton5.text.toString()
        btnbutton.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                val url="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
                it.putExtra("URL",url)
                startActivity(it)
            }
        }
        btnbutton1.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                val url="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
                it.putExtra("URL",url)
                startActivity(it)
            }
        }
        btnbutton2.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                val url="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
                it.putExtra("URL",url)
                startActivity(it)
            }
        }
        btnbutton3.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                val url="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
                it.putExtra("URL",url)
                startActivity(it)
            }
        }
        btnbutton4.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                val url="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"

                it.putExtra("URL",url)
                startActivity(it)
            }
        }
        btnbutton5.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                val url="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
                it.putExtra("URL",url)
                startActivity(it)
            }
        }
    }
}