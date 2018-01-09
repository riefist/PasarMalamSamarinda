package com.muhamadarief.pasarmalamsmd;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhamadarief.pasarmalamsmd.API.ApiUtils;
import com.muhamadarief.pasarmalamsmd.model.Pasar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Muhamad Arief on 14/06/2017.
 */

public class PasarAdapter extends RecyclerView.Adapter<PasarAdapter.HolderItem> {

    private ArrayList<Pasar> pasars;
    private Context context;

    public PasarAdapter(Context context, ArrayList<Pasar> pasars){
        this.pasars = pasars;
        this.context = context;
    }

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_row_item, parent, false);

        HolderItem holderItem = new HolderItem(view);
        return holderItem;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, int position) {
        final Pasar pasarItem = pasars.get(position);

        holder.txt_nama_pasar.setText(pasarItem.getNama_lokasi());
        holder.txt_hari.setText(pasarItem.getHari());
        holder.txt_jam.setText(pasarItem.getJam());

        String photoUrl = ApiUtils.BASE_URL +""+pasarItem.getFoto_lokasi();

        Picasso.with(context)
                .load(photoUrl)
                .into(holder.img_pasar);

        holder.cv_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.DATA_PASAR, pasarItem);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pasars.size();
    }


    public class HolderItem extends RecyclerView.ViewHolder{

        public ImageView img_pasar;
        public TextView txt_nama_pasar,
                txt_hari, txt_jam;
        public CardView cv_item;


        public HolderItem(View itemView) {
            super(itemView);

            txt_nama_pasar = (TextView)itemView.findViewById(R.id.txt_nama_pasar);
            txt_hari = (TextView)itemView.findViewById(R.id.txt_hari);
            txt_jam = (TextView)itemView.findViewById(R.id.txt_jam);
            img_pasar = (ImageView) itemView.findViewById(R.id.img_pasar);
            cv_item = (CardView)itemView.findViewById(R.id.cv_item);

        }
    }
}
