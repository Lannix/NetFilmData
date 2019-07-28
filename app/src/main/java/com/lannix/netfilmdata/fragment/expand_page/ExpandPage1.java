package com.lannix.netfilmdata.fragment.expand_page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lannix.netfilmdata.R;
import com.lannix.netfilmdata.fragment.MainActivityInterface;
import com.lannix.netfilmdata.stuff.OnBackPressedInterface;

public class ExpandPage1 extends Fragment implements OnBackPressedInterface {

    private Context context;
    private MainActivityInterface mainActivityInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_1, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof MainActivityInterface) {
            mainActivityInterface = (MainActivityInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onBackPressedAction() {
        getActivity().onBackPressed();
    }
}
