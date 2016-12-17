package com.greendaoexample;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gurpreet on 12/17/2016.
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder>{

    private ArrayList<Integer> mItems = new ArrayList<>();

    TextAdapter(ArrayList<Integer> mItems) {
        this.mItems = mItems;
    }

    @Override
    public TextAdapter.TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new TextViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TextAdapter.TextViewHolder holder, int position) {
        if (mItems != null && position >= 0 && position <= mItems.size()) {
            Log.d("TAG", "onBindViewHolder: "+mItems.get(position));
            holder.setData(mItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (mItems == null)
            return 0;
        else {
            return mItems.size();
        }
    }

    public void add() {
        mItems.add(mItems.size() + 1);
        notifyDataSetChanged();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Integer number;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void setData(Integer number) {
            this.number = number;
            textView.setText(number.toString());
        }
    }
}
