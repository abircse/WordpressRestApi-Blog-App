package com.example.wordpressapi

import BaseDataModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordpressapi.adapter.PostAdapter
import com.nexgen.tbl.base.network.APIClient
import com.nexgen.tbl.base.network.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var apiInterface: APIInterface
    private var postlist: List<BaseDataModel> = ArrayList()
    lateinit var postAdapter: PostAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiInterface = APIClient.client!!.create(APIInterface::class.java)

        recyclerView = findViewById(R.id.post_recyclerview)

        loadPost()
    }

    private fun loadPost() {

        val call  = apiInterface.loadPosts()
        call.enqueue(object : Callback<List<BaseDataModel>> {
            override fun onResponse(call: Call<List<BaseDataModel>>, response: Response<List<BaseDataModel>>) {
                postlist = response.body()!!
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                postAdapter = PostAdapter(this@MainActivity,postlist)
                recyclerView.adapter = postAdapter
                postAdapter.notifyDataSetChanged()

            }
            override fun onFailure(call: Call<List<BaseDataModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}