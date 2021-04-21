package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Hero> heroes = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_hero);
        recyclerView.setHasFixedSize(true);

        heroes.addAll(HeroDataSource.getListData());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter adapter = new ListHeroAdapter(heroes);
        recyclerView.setAdapter(adapter);
    }




}