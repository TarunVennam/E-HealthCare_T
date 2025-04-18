package com.example.e_healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealyhArticlesActivity extends AppCompatActivity {
    private String [][] health_details =
            {
                    {"Walking Daily","","","","Click for more Details"},
                    {"Home Care of COVID-19","","","","Click for more Details"},
                    {"Stop Smoking","","","","Click for more Details"},
                    {"Menstrual Cramps","","","","Click for more Details"},
                    {"Healthy Gut","","","","Click for more Details"}
            };
    private  int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa ;
    Button btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healyh_articles);
        btnBack = findViewById(R.id.buttonHABack);
        listView = findViewById(R.id.listViewHA);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealyhArticlesActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0;i<health_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1",health_details[i][0]);
            item.put("line2",health_details[i][1]);
            item.put("line3",health_details[i][2]);
            item.put("line4",health_details[i][3]);
            item.put("line5",health_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealyhArticlesActivity.this,HealyhArticlesDetailsActivity.class);
                it.putExtra("text1",health_details[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });

    }
}