package com.mad.cardviewui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mad.cardviewui.NewsAdapter
import com.mad.cardviewui.NewsResponse
import com.mad.cardviewui.RetrofitClient
import com.mad.cardviewui.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        fetchNews()
    }

    private fun fetchNews() {
        RetrofitClient.instance.getNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsList = response.body()?.articles ?: emptyList()
                    binding.recyclerView.adapter = NewsAdapter(newsList)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("NewsApp", "Error: ${t.message}")
            }
        })
    }
}
