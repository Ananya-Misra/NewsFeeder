package com.example.newsapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
//import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var mAdapter: NewListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager =LinearLayoutManager(this)
        fetchData()
        mAdapter=NewListAdapter(this)
        recyclerview.adapter=mAdapter
    }



    private fun fetchData(){
//        val url="https://newsapi.org/v2/top-headlines?country=in&apiKey=df7a37e93b9849ccbc52f9885bd8ec98"
        val url=intent.getStringExtra("URL")
       //val url="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET,
                url,
                null,
                Response.Listener {
                    Log.d("V","DONE")
                    val newsArray=ArrayList<News>()
                    val newsJsonArray=it.getJSONArray("articles")
                    for(i in 0 until newsJsonArray.length()){
                        val obj=newsJsonArray.getJSONObject(i)
                        val news=News(
                                obj.getString("title") ,
                                obj.getString("author"),
                                obj.getString("url") ,
                                obj.getString("urlToImage")

                        )
                        Log.d("V","news")
                        newsArray.add(news)

                    }
                    mAdapter.updateNews(newsArray)
                },
                Response.ErrorListener {
                    // TODO: Handle error

                    Log.d("V","Error")
                }
        )
          MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(item:News) {
   val builder= CustomTabsIntent.Builder()
       val customTabsIntent=builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
       // builder.setToolbarColor(ContextCompat.getColor(this,R.color.purple_500));
//      builder.setColorScheme(ContextCompat.getColor(this,R.color.purple_500))
//       builder.setDefaultShareMenuItemEnabled(true)
//      builder.addDefaultShareMenuItem()
        //builder.setCloseButtonIcon(@NonNull icon: Bitmap)

    }
}