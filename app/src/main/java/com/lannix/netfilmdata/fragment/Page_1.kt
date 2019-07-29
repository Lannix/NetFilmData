package com.lannix.netfilmdata.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.lannix.netfilmdata.R
import com.lannix.netfilmdata.stuff.OnBackPressedInterface
import com.lannix.netfilmdata.stuff.recycleView.ListObject
import com.lannix.netfilmdata.stuff.recycleView.MyRecyclerViewAdapter

import java.util.ArrayList

class Page_1 : Fragment(), OnBackPressedInterface {

    private var context: Context? = null
    private var mainActivityInterface: MainActivityInterface? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page_1, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.setHasFixedSize(true)

        val adapter = MyRecyclerViewAdapter(context, getDataList(context!!))
        recyclerView!!.adapter = adapter
        return view
    }

    private fun getDataList(context: Context): ArrayList<ListObject> {
        val strings = context.resources.getStringArray(R.array.recycle_strings)
        val listObjects = ArrayList<ListObject>()
        var i = 0
        while (i < strings.size / 2) {
            val listObject = ListObject(strings[i], strings[i + 1])
            listObjects.add(listObject)
            i += 2
        }
        return listObjects
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.context = context
        if (context is MainActivityInterface) {
            mainActivityInterface = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onBackPressedAction() {
        //todo
    }
}
