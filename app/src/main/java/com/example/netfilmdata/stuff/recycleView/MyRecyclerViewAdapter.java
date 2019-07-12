package com.example.netfilmdata.stuff.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netfilmdata.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecycleViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ListObject> data;

    public MyRecyclerViewAdapter(Context context, ArrayList<ListObject> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public MyRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle_list_object, parent, false);
        return new MyRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewHolder holder, int position) {
        ListObject listObject = data.get(position);

        holder.getTopicTextView().setText(listObject.topicText);
        holder.getInformationTextView().setText(listObject.informationText);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class MyRecycleViewHolder extends RecyclerView.ViewHolder {
        private TextView topicTextView;
        private TextView informationTextView;
        private CheckBox checkBox;

        public MyRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTextView = itemView.findViewById(R.id.TopicTextView);
            informationTextView = itemView.findViewById(R.id.InformationTextView);
            checkBox = itemView.findViewById(R.id.CheckBox);
        }

        public TextView getTopicTextView() {
            return topicTextView;
        }

        public TextView getInformationTextView() {
            return informationTextView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }
}
