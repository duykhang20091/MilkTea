package com.example.milkteamanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.model.TypeProduct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class Procduct extends AppCompatActivity {
    ListView listproduct;
    ArrayList<TypeProduct> arraytypepro;
    typeAdapter typeproAdapter;
    private String product_url = "http://10.102.17.26/Milktea/gettypeproduct.php";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procduct);
        listproduct=(ListView)findViewById(R.id.lvproduct);
        arraytypepro= new ArrayList<TypeProduct>();
        Button back=findViewById(R.id.btnBackProduct);
        GetData(product_url );
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Procduct.this, Home.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest    jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arraytypepro.add(new TypeProduct(
                                        object.getInt("id"),
                                        object.getString("name"),
                                        object.getString("image")));
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                        typeproAdapter.notifyDataSetChanged();
                       // Toast.makeText(Procduct.this,response.toString(),Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Procduct.this,"Error!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }



}

