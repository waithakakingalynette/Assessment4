package com.lynn.assessment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lynn.assessment4.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        getItems()
    }

    private fun getItems() {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getItems()

        request.enqueue(object : Callback<List<Items>> {
            override fun onResponse(call: Call<List<Items>>, response: Response<List<Items>>) {
                if (response.isSuccessful) {
                    val items = response.body()

                    val itemAdapter = ItemsAdapter(items ?: emptyList())
                    binding.rvItems.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvItems.adapter = itemAdapter

                    Toast.makeText(
                        baseContext,
                        "Fetched ${items?.size} items",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        baseContext,
                        response.errorBody()?.string(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Items>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
