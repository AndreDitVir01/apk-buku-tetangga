package com.example.buku_tetangga.adapters.book;import android.content.Context;import android.content.Intent;import android.graphics.drawable.Drawable;import android.os.Bundle;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.TextView;import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.recyclerview.widget.RecyclerView;import com.bumptech.glide.Glide;import com.bumptech.glide.load.DataSource;import com.bumptech.glide.load.engine.GlideException;import com.bumptech.glide.request.RequestListener;import com.bumptech.glide.request.target.Target;import com.example.buku_tetangga.BookButangActivity;import com.example.buku_tetangga.Items.Buku;import com.example.buku_tetangga.R;import java.util.List;public class BukuLainAdapter extends RecyclerView.Adapter<BukuLainAdapter.ViewHolder> {    List<Buku> bukus;    Context context;    public BukuLainAdapter(Context context, List<Buku> bukus)    {        this.context = context;        this.bukus = bukus;    }    @NonNull    @Override    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {        View view = LayoutInflater.from(context).inflate(R.layout.single_product_design,viewGroup, false);        return new BukuLainAdapter.ViewHolder(view);    }    @Override    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {        final Buku buku = bukus.get(i);        viewHolder.judul_buku.setText(buku.getJudul_buku());        Glide.with(context)                .load(buku.getFoto())                .placeholder(R.drawable.cover_buku_1)                .error(R.drawable.ic_photo_camera_unactive_24dp)                .listener(new RequestListener<Drawable>() {                    @Override                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {                        return false;                    }                    @Override                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {                        return false;                    }                })                .override(100, 150)                .fitCenter()                .into(viewHolder.foto);        viewHolder.harga.setText(buku.getHarga());        viewHolder.pengarang.setText(buku.getPengarang());        viewHolder.lL_buku.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Intent i = new Intent(context, BookButangActivity.class);                Bundle bundle = new Bundle();                bundle.putString("rakbuku_id", buku.getRakbuku_id());                i.putExtras(bundle);                context.startActivity(i);            }        });    }    private String setStock(String stock) {        if(!stock.equals("0")){            return "Tersedia";        }        return "Habis";    }    @Override    public long getItemId(int position) {        return position;    }    @Override    public int getItemViewType(int position) {        return position;    }    @Override    public int getItemCount() {        return bukus.size();    }    public class ViewHolder extends RecyclerView.ViewHolder    {        TextView judul_buku;        ImageView foto;        TextView jumlah_stock, pengarang, harga;        LinearLayout lL_buku;        public ViewHolder(@NonNull View itemView)        {            super(itemView);            judul_buku = itemView.findViewById(R.id.judul_buku);            foto = itemView.findViewById(R.id.foto_buku);            jumlah_stock = itemView.findViewById(R.id.jumlah_stock);            pengarang = itemView.findViewById(R.id.farmerName);            harga = itemView.findViewById(R.id.harga_buku);            lL_buku = itemView.findViewById(R.id.lL_buku);        }    }}