package com.example.android_w7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Danh sách các tên có sẵn
        val availableNames = listOf("Lương", "Hoàng", "Hiệp")

        // Prepare arrays of data with random names
        val itemList = arrayListOf<ItemModel>()

        val random = Random()
        for (i in 1..24) {
            // Xáo trộn danh sách tên
            val shuffledNames = availableNames.shuffled()

            // Lấy một số ngẫu nhiên để quyết định số lượng tên được chọn
            val numNames = random.nextInt(availableNames.size) + 1

            // Chọn numNames tên từ danh sách đã xáo trộn
            val selectedNames = shuffledNames.subList(0, numNames)

            // Kết hợp các tên để tạo tên mới
            val fullName = selectedNames.joinToString(" ")

            itemList.add(
                ItemModel(
                    i,
                    fullName,
                    "091231234",
                    fullName.toLowerCase().replace(" ", "") + "@gmail.com"
                )
            )
        }

        val adapter = MyCustomAdapter(itemList, this)
        val recycleView: RecyclerView = findViewById(R.id.RVLayout)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter

        registerForContextMenu(recycleView)
    }
}
