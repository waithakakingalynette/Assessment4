package com.lynn.assessment4.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.lynn.assessment4.databinding.ActivityMainBinding
import com.lynn.assessment4.model.ItemsAdapter
import com.lynn.assessment4.viewModel.ItemsViewModel


class MainActivity : AppCompatActivity() {
    val itemsViewModel: ItemsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var itemsAdapter: ItemsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        itemsViewModel.fetchItems()
        itemsViewModel.itemLiveData.observe(
            this,
            Observer { item ->
                val postsAdapter = ItemsAdapter(item?: emptyList())
                binding.rvItems.layoutManager = GridLayoutManager(this@MainActivity, 2)
                binding.rvItems.adapter = postsAdapter
            })

        itemsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })


    }
}
