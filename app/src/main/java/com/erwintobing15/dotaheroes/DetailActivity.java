package com.erwintobing15.dotaheroes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DetailActivity extends Activity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_BIO = "extra_bio";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_ROLE = "extra_role";
    public static final String EXTRA_SKILL = "extra_skill";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView heroImg = (ImageView) findViewById(R.id.detail_img);
        TextView heroName = (TextView) findViewById(R.id.detail_hero_name);
        TextView heroBio  = (TextView) findViewById(R.id.detail_hero_bio);
        TextView heroType = (TextView) findViewById(R.id.detail_hero_type);
        TextView heroRole = (TextView) findViewById(R.id.detail_hero_role);
        TextView heroSkill = (TextView) findViewById(R.id.detail_hero_skill);

        int image = getIntent().getIntExtra(EXTRA_IMAGE, 0);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String bio = getIntent().getStringExtra(EXTRA_BIO);
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        String role = getIntent().getStringExtra(EXTRA_ROLE);
        String skill = getIntent().getStringExtra(EXTRA_SKILL);

        heroImg.setImageResource(image);
        heroName.setText(name);
        heroBio.setText(bio);
        heroType.setText(type);
        heroRole.setText(role);
        heroSkill.setText(skill);

        // making back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}