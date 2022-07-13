package com.parthib.newshub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {


        holder.pcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Webview.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);

            }
        });

        holder.pheading1.setText(modelClassArrayList.get(position).getTitle());
        holder.pheading2.setText(modelClassArrayList.get(position).getDescription());
        holder.pdate.setText("Published at"+modelClassArrayList.get(position).getPublishedAt());
        holder.pauthor.setText(modelClassArrayList.get(position).getAuthor());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.pimageview);




    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pheading1,pheading2,pdate,pauthor;
        CardView pcardview;
        ImageView pimageview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pauthor=itemView.findViewById(R.id.author);
            pheading1=itemView.findViewById(R.id.heading1);
            pheading2=itemView.findViewById(R.id.heading2);
            pdate= itemView.findViewById(R.id.date);
            pimageview=itemView.findViewById(R.id.image);
            pcardview=itemView.findViewById(R.id.cardview);
        }
    }
}
