package com.example.fruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DataInfo> list;
    public MyAdapter(Context context, ArrayList<DataInfo> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.item, null);
        }

        ImageView image = convertView.findViewById(R.id.image);
        TextView name =convertView.findViewById(R.id.name);
        TextView description = convertView.findViewById(R.id.description);
        final TextView quantity = convertView.findViewById(R.id.quantity);

        image.setImageResource(this.list.get(position).getImg());
        name.setText(this.list.get(position).getName());
        description.setText(this.list.get(position).getDescription());
        quantity.setText(String.valueOf(this.list.get(position).getQuantity()));

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q = (MyAdapter.this.list.get(position).getQuantity());
                if (q < 10){
                    MyAdapter.this.list.get(position).setQuantity((q+1));
                    quantity.setText(String.valueOf(MyAdapter.this.list.get(position).getQuantity()));
                }
                else {
                    Toast.makeText(context, context.getString(R.string.CANTIDAD), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }

}
