package com.example.audiodb.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.audiodb.Models.Album;
import com.example.audiodb.Models.AlbumContainer;
import com.example.audiodb.R;
import com.example.audiodb.SongsActivity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private LayoutInflater inflater;
    private HashMap<String,String> albumHashMap;
    private AlbumContainer albumContainer;

    public AlbumAdapter(Context context, AlbumContainer albumContainer) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.albumContainer = albumContainer;
        //this.albumHashMap = albumHashMap;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.album_item, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        List<Album> albumList = albumContainer.getAlbum();
        Album album = albumList.get(position);
        if (!album.getIntYearReleased().equals("0")) {
            holder.albumName.setText(String.format(context.getResources().getString(R.string.album_title), album.getStrAlbum(), album.getIntYearReleased()));
        } else {
            holder.albumName.setText(album.getStrAlbum());
        }
        if (album.getStrAlbumThumb() != null) {
            if (!album.getStrAlbumThumb().equals("")) {
                Glide.with(context)
                        .load(album.getStrAlbumThumb())
                        //.placeholder(R.drawable.loading)
                        .thumbnail(Glide.with(context).load(R.drawable.loading))
                        .into(holder.albumCover);
            } else {
                holder.albumCover.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.no_cover));
            }
        } else {
            holder.albumCover.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.no_cover));
        }

        holder.itemView.setOnClickListener(v -> {
            Intent albumSongs = new Intent(context, SongsActivity.class);
            albumSongs.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            albumSongs.putExtra("IDALBUM", album.getIdAlbum());
            context.startActivity(albumSongs);

        });

    }

    @Override
    public int getItemCount() {
        return albumContainer.getAlbumSize() > 0 ? albumContainer.getAlbumSize() : 0;
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView albumName;
        ImageView albumCover;

        AlbumViewHolder(View itemView) {
            super(itemView);
            albumName = itemView.findViewById(R.id.albumName);
            albumCover = itemView.findViewById(R.id.albumCover);
        }

    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(albumContainer.getAlbum(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(albumContainer.getAlbum(), i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        albumContainer.getAlbum().remove(position);
        notifyItemRemoved(position);
    }

}