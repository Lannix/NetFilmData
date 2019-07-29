package com.lannix.netfilmdata.fragment.expand_page

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.lannix.netfilmdata.R
import com.lannix.netfilmdata.fragment.MainActivityInterface
import com.lannix.netfilmdata.stuff.OnBackPressedInterface

class ExpandPage1 : Fragment(), OnBackPressedInterface {

    private var context: Context? = null
    private var mainActivityInterface: MainActivityInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page_1, container, false)
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
        activity!!.onBackPressed()
    }
}
