package com.example.androidWeek8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout cho fragment này
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val list = view.findViewById<RecyclerView>(R.id.listView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Chuẩn bị mảng dữ liệu
        val itemList = arrayListOf<ItemModel>()
        // Danh sách các tên có sẵn
        val availableNames = listOf("Lương", "Hoàng", "Hiệp")
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
        val adapter = CustomAdapter(itemList, requireContext())
        val list: RecyclerView = view.findViewById(R.id.listView)
        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = adapter
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}