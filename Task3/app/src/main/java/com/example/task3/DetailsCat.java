package com.example.task3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetailsCat extends AppCompatActivity {


    private ArrayList<CatType> catPictures;
    private CatType catPicture;
    private CatType clicked;
    private String searchedCat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_details);

        if(getActionBar() != null){ getActionBar().setDisplayHomeAsUpEnabled(true); }

        Intent intent = getIntent();
        clicked = (CatType) intent.getSerializableExtra("clickedCat");
        loadUI();

        RequestQueue queue = Volley.newRequestQueue(this);
        searchedCat = "https://api.thecatapi.com/v1/images/search?breed_id=" + clicked.getId();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, searchedCat, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Type catImageType = new TypeToken<ArrayList<CatType>>(){}.getType();
                catPictures = gson.fromJson(response, catImageType);
                catPicture = catPictures.get(0);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "650dd1c2-4a29-4ff2-91b1-a58b6b33c325");
                return headers;
            }
        };

        queue.add(stringRequest);
    }

    public void loadUI() {
        TextView breedView= findViewById(R.id.cat_breed);
        TextView temperamentView = findViewById(R.id.cat_temperament);
        TextView descriptionView = findViewById(R.id.cat_description);
        TextView weightView = findViewById(R.id.cat_weight);
        TextView originView = findViewById(R.id.cat_origin);
        TextView lifespanView = findViewById(R.id.life_span);
        TextView wikilinkView = findViewById(R.id.wikilink);
        TextView friendlinessView = findViewById(R.id.friendliness);

        breedView.setText(clicked.getBreed());
        temperamentView.setText(clicked.getTemperament());
        descriptionView.setText(clicked.getDescription());
        weightView.setText(clicked.getWeight());
        originView.setText(clicked.getOrigin());
        lifespanView.setText(clicked.getLifespan());
        wikilinkView.setText(clicked.getWikilink());
        friendlinessView.setText(clicked.getFriendlinesslevel());

            }

    }










