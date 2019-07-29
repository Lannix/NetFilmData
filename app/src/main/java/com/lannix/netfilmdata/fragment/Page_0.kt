package com.lannix.netfilmdata.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.lannix.netfilmdata.R
import com.lannix.netfilmdata.stuff.OnBackPressedInterface

class Page_0 : Fragment() {

    private var fragment: MainActivityInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page_0, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainActivityInterface) {
            fragment = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }
}
