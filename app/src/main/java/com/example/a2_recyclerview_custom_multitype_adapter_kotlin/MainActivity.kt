package com.example.a2_recyclerview_custom_multitype_adapter_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_recyclerview_custom_multitype_adapter_kotlin.adapter.CustomAdapter
import com.example.a2_recyclerview_custom_multitype_adapter_kotlin.adapter.CustomViewNoHolder
import com.example.a2_recyclerview_custom_multitype_adapter_kotlin.moel.Member

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for(i in 0..29){
            if(i == 0 || i == 6 || i == 15 || i == 25){
                members.add(Member("qwerty","qwerty",false))
            }else{
                members.add(Member("Sarvar"+i,"Khalmatov"+i, true))
            }
        }
        return members
    }

    private fun initViews() {
        context =  this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context,1)
    }


}