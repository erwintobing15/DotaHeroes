package com.erwintobing15.dotaheroes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private ArrayList<Hero> heroArrayList;
    private OnItemClickCallback onItemClickCallback;

    public ListHeroAdapter(ArrayList<Hero> arrayList) {
        this.heroArrayList = arrayList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dota_hero_row, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hero hero = heroArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgHero);
        holder.tvName.setText(hero.getName());
        holder.tvBiography.setText(hero.getBiography());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.OnItemClicked(heroArrayList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHero;
        TextView tvName, tvBiography;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHero = itemView.findViewById(R.id.hero_img);
            tvName = itemView.findViewById(R.id.hero_name);
            tvBiography = itemView.findViewById(R.id.hero_biography);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void OnItemClicked(Hero data);
    }


}
