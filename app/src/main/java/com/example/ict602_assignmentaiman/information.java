package com.example.ict602_assignmentaiman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

public class information extends AppCompatActivity {

    Toolbar informationToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        informationToolbar = findViewById(R.id.information_toolbar);
        setSupportActionBar(informationToolbar);
        getSupportActionBar().setTitle("Information");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);}


    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){

            super.onBackPressed();
        }
        return true;
    }
}