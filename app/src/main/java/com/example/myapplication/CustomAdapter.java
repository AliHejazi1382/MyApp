package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Books> {
    private Context context;
    private List<Books> books;
    public CustomAdapter(@NonNull Context context, @NonNull List<Books> books) {
        super(context, R.layout.list_layout, books);
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fill(position);
        return convertView;
    }

    public class ViewHolder {
        public ImageView imgPhoto;
        public TextView lblTitle;
        public TextView lblCategory;
        public TextView lblPrice;
        public ViewHolder(View v) {
            this.imgPhoto = v.findViewById(R.id.imgPhoto);
            this.lblTitle = v.findViewById(R.id.lblTitle);
            this.lblCategory = v.findViewById(R.id.lblCategory);
            this.lblPrice = v.findViewById(R.id.lblPrice);
        }

        public void fill(int position) {
            String photo = books.get(position).getPhoto();
            photo = photo.substring(0, photo.lastIndexOf("."));
            int resId = context.getResources().getIdentifier(photo, "drawable", context.getApplicationContext().getPackageName());
            imgPhoto.setImageResource(resId);
            lblTitle.setText(books.get(position).getTitle());
            lblCategory.setText(books.get(position).getaCategory());
            lblPrice.setText(String.valueOf(books.get(position).getPrice()) + "$");
        }
    }
}
