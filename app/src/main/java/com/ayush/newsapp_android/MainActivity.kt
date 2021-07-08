package com.ayush.newsapp_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayush.newsapp_android.adapter.NewsAdapter
import com.ayush.newsapp_android.newsInterface.ServiceInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar?.title = "News"

        configureRecyclerView()
        callAPI()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.news_menu) {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        return true
    }

    private fun configureRecyclerView() {
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun callAPI() {
        var rf = Retrofit.Builder()
            .baseUrl(ServiceInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceInterface::class.java)
        var api = rf.getTopHeadlines("us", "24a147d201c448d39c57a5ff8ea1abc8")
        api?.enqueue(object : Callback<NewsModel?> {
            override fun onResponse(call: Call<NewsModel?>, response: Response<NewsModel?>) {
                progress_circular.visibility = View.GONE
                val response = response.body()!!
                newsAdapter = NewsAdapter(baseContext, response)
                newsAdapter.notifyDataSetChanged()
                recycler_view.adapter = newsAdapter
            }
            override fun onFailure(call: Call<NewsModel?>, t: Throwable) {
                progress_circular.visibility = View.GONE
                Toast.makeText(applicationContext, "Something went wrong.", Toast.LENGTH_LONG).show()
                Log.d("MainActivity", "onFailure: "+t.message)
            }
        })
    }
}