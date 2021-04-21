package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailHero extends AppCompatActivity {
    private TextView tvNama, tvDetail;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);

        tvNama = findViewById(R.id.tv_title);
        tvDetail = (TextView) findViewById(R.id.tv_desc);
        photo = findViewById(R.id.iv_foto);

        tvDetail.setMovementMethod(new ScrollingMovementMethod());
        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("FOTO") && getIntent().hasExtra("NAMA") && getIntent().hasExtra("DETAIL")) {
            int pic = getIntent().getIntExtra("FOTO",0);
            String nm = getIntent().getStringExtra("NAMA");
            String desc = getIntent().getStringExtra("DETAIL");

            setDataActivity(pic,nm,desc);
        }
    }

    private void setDataActivity(int foto, String nm, String desc){
        Glide.with(this).asBitmap().load(foto).into(photo);
        tvNama.setText(nm);
        tvDetail.setText(desc);
    }
}