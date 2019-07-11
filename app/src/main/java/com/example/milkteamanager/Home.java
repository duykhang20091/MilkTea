package com.example.milkteamanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LinearLayout product= findViewById(R.id.product);
        LinearLayout warehouse= findViewById(R.id.warehouse);
        LinearLayout menu= findViewById(R.id.menu);
        LinearLayout sale= findViewById(R.id.salemanager);
        LinearLayout sta= findViewById(R.id.statistical);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Home.this, Procduct.class);
                startActivity(i);
                finish();
            }
        });
        warehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Home.this, Warehouse.class);
                startActivity(i);
                finish();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Home.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        });
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Home.this, SaleManager.class);
                startActivity(i);
                finish();
            }
        });
        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Home.this, Statictical.class);
                startActivity(i);
                finish();
            }
        });
    }
}
