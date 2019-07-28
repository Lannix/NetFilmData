package com.lannix.netfilmdata.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lannix.netfilmdata.R;
import com.lannix.netfilmdata.stuff.OnBackPressedInterface;
import com.lannix.netfilmdata.stuff.recycleView.ListObject;
import com.lannix.netfilmdata.stuff.recycleView.MyRecyclerViewAdapter;

import java.util.ArrayList;

public class Page_1 extends Fragment implements OnBackPressedInterface {

    private Context context;
    private MainActivityInterface mainActivityInterface;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(context, getDataList(context));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<ListObject> getDataList(Context context) {
        String strings[] = context.getResources().getStringArray(R.array.recycle_strings);
        ArrayList<ListObject> listObjects = new ArrayList<>();
        for (int i = 0; i < strings.length / 2; i += 2) {
            ListObject listObject = new ListObject(strings[i], strings[i + 1]);
            listObjects.add(listObject);
        }
        return listObjects;
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
        //todo
    }
}
