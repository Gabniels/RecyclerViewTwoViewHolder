package com.example.twoviewholder

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twoviewholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainAdapter: MainAdapter by lazy { MainAdapter(getData().drop(2)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getData(): List<MainModel> {
        return listOf(
            MainModel("Item 1", 1),
            MainModel("Item 2", 1),
            MainModel("Item 3", 1),
            MainModel("Item 4", 1),
            MainModel("Item 5", 1),
            MainModel("Item 6", 1),
            MainModel("Item 7", 2),
            MainModel("Item 8", 2),
            MainModel("Item 9", 2),
            MainModel("Item 10", 2),
            MainModel("Item 11", 1),
            MainModel("Item 12", 1),
            MainModel("Item 13", 1),
            MainModel("Item 14", 1),
            MainModel("Item 15", 1),
            MainModel("Item 16", 1),
            MainModel("Item 17", 2),
            MainModel("Item 18", 2),
            MainModel("Item 19", 2),
            MainModel("Item 20", 2),
            MainModel("Item 21", 2),
            MainModel("Item 22", 2),
        )
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            val gridLayoutManager = GridLayoutManager(context, 5).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int = 1
                }
            }
            layoutManager = gridLayoutManager
            adapter = mainAdapter
        }
    }


}