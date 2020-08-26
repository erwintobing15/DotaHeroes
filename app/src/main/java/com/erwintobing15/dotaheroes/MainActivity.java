package com.erwintobing15.dotaheroes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDotaHero;
    private ArrayList<Hero> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDotaHero = findViewById(R.id.rv_dota_heroes);
        rvDotaHero.setHasFixedSize(true);

        arrayList.addAll(HeroesData.getListData());
        showRecyclerList();


    }

    private void showRecyclerList() {
        rvDotaHero.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(arrayList);
        rvDotaHero.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void OnItemClicked(Hero hero) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_IMAGE, hero.getImage());
                intent.putExtra(DetailActivity.EXTRA_NAME, hero.getName());
                intent.putExtra(DetailActivity.EXTRA_BIO, hero.getBiography());
                intent.putExtra(DetailActivity.EXTRA_TYPE, hero.getType());
                intent.putExtra(DetailActivity.EXTRA_ROLE, hero.getRole());
                intent.putExtra(DetailActivity.EXTRA_SKILL, hero.getSkill());
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

}