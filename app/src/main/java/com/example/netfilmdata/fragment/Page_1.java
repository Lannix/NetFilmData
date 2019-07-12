package com.example.netfilmdata.fragment;

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

import com.example.netfilmdata.R;

import org.simpleframework.xml.core.Persister;

import java.io.Reader;
import java.io.StringReader;

import me.saket.inboxrecyclerview.InboxRecyclerView;
import me.saket.inboxrecyclerview.dimming.TintPainter;
import me.saket.inboxrecyclerview.page.ExpandablePageLayout;

public class Page_1 extends Fragment {

    private Context context;
    private MainActivityInterface mainActivityInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_1, container, false);

        InboxRecyclerView recyclerView = view.findViewById(R.id.inbox_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        ExpandablePageLayout pageLayout = mainActivityInterface.getExpandablePageLayout();
        recyclerView.setExpandablePage(pageLayout);
        recyclerView.setTintPainter(TintPainter.uncoveredArea(Color.BLUE, 0.65F));

        String xml = getResources().getXml(R.xml.recycler_data).toString();
        Persister serializer = new Persister();
        getResources().getS

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
}
