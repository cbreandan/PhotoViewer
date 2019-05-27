package com.example.scbcchoi.fotagscbcchoi;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.util.Log;
import android.widget.RelativeLayout;
import android.content.DialogInterface.OnClickListener;

public class ImageAdapter extends BaseAdapter {
    public Context mContext;


    public Integer[] image_source = {
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_8, R.drawable.sample_9
    };

    public Image [] images = new Image [10];

    public ImageAdapter(Context c) {
        mContext = c;
        for (int i=0; i<Global.images.length; i++){
            Global.images[i] = new Image(Global.image_source[i]);
        }
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.image_item, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.image_thumbnail);

        imageView.setImageResource(Global.images[position].source);

        final Button clearRatingBtn = (Button)convertView.findViewById(R.id.clearRatingBtn);
        final RatingBar ratingBar = (RatingBar)convertView.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
                                                   @Override
                                                   public void onRatingChanged(RatingBar ratingBar, float rating,
                                                                               boolean fromUser) {
                                                       Global.images[position].rating = rating;
                                                   }
                                               });

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity)mContext).enlargeImage(position);
            }
        });
        ratingBar.setRating(Global.images[position].rating);

        clearRatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset
                ratingBar.setRating(0);
            }
        });
        /*
        filterRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.images[position].rating > 3) {
                    imageView.setVisibility(v.GONE);
                    ratingBar.setVisibility(v.GONE);
                    clearRatingBtn.setVisibility(v.GONE);
                }
            }
        });*/

        return convertView;
    }
}
