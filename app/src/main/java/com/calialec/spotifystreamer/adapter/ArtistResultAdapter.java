package com.calialec.spotifystreamer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.calialec.spotifystreamer.R;
import com.calialec.spotifystreamer.model.ArtistParcelable;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtistResultAdapter extends ArrayAdapter<ArtistParcelable> {

    final private Context context;

    private static class ViewHolder {
        ImageView artistImage;
        TextView artistName;
    }

    public ArtistResultAdapter(Context context, List<ArtistParcelable> artists) {
        super(context, R.layout.list_item_artist_result, artists);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArtistParcelable artist = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_artist_result, parent, false);
            viewHolder.artistImage = (ImageView) convertView.findViewById(R.id.list_item_artist_image_imageview);
            viewHolder.artistName = (TextView) convertView.findViewById(R.id.list_item_artist_name_textview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (artist.imageUrl != null) {
            Picasso.with(context).load(artist.imageUrl).into(viewHolder.artistImage);
        }
        viewHolder.artistName.setText(artist.name);
        return convertView;
    }
}
