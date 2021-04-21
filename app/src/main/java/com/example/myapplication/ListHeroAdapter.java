package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ViewHolder> {

    private List<Hero> heros;

    public ListHeroAdapter(List<Hero> heros) {
        this.heros = heros;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = heros.get(position);
        holder.ivPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.itemView.getContext(), DetailHero.class);
                i.putExtra("FOTO", hero.getPhoto());
                i.putExtra("NAMA", hero.getName());
                i.putExtra("DETAIL", hero.getDetail());

                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heros.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        ImageView ivPhoto;
        TextView tvName, tvDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_hero);
            tvName = itemView.findViewById(R.id.tv_hero_name);
            tvDetail = itemView.findViewById(R.id.tv_hero_detail);
        }
    }

}
