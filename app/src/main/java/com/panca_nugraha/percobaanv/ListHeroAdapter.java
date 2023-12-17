package com.panca_nugraha.percobaanv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private ArrayList<Hero> listHero;
    public ListHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback (OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hero hero = listHero.get(position);
        holder.imgPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDescription.setText(hero.getDescription());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition())));
    }
    public interface OnItemClickCallback{
        void onItemClicked(Hero data);
    }


    @Override
    public int getItemCount() {
        return listHero.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}

