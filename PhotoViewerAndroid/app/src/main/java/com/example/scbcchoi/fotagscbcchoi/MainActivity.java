package com.example.scbcchoi.fotagscbcchoi;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Button;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import android.view.Window;
import android.graphics.drawable.ColorDrawable;
import android.content.DialogInterface;
import android.widget.RelativeLayout;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    boolean isImageFitToScreen = false;

    boolean isVisible;
    final String isVisibleState = "isVisibleState";

    final String rting = "rting";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            isVisible = savedInstanceState.getBoolean(isVisibleState);
            float [] ratings = savedInstanceState.getFloatArray(rting);
            for (int i=0; i<ratings.length; i++){
                Global.images[i].rating = ratings[i];
            }
        }

        GridView gridview = (GridView) findViewById(R.id.gridview);
        ImageAdapter imgAdpt = new ImageAdapter(this);
        gridview.setAdapter(imgAdpt);

        if (isVisible) {
            gridview.setVisibility(View.VISIBLE);
        } else {
            gridview.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(isVisibleState, isVisible);

        final float [] ratings = new float[10];
        for (int i=0; i<ratings.length; i++){
            ratings[i] = Global.images[i].rating;
        }
        outState.putFloatArray(rting, ratings);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        float [] ratings = savedInstanceState.getFloatArray(rting);
        for (int i=0; i<ratings.length; i++){
            Global.images[i].rating = ratings[i];
        }
    }

    public void clearImages(View view) {
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setVisibility(View.INVISIBLE);
        isVisible = false;
    }

    public void loadImages(View view) {
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setVisibility(View.VISIBLE);
        isVisible = true;
    }

    public void enlargeImage(int position) {
        imageView = (ImageView) findViewById(R.id.image_thumbnail);

        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(Global.images[position].source);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }
}
