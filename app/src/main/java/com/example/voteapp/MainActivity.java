package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    TextView cand1, count1;
    TextView cand2, count2;
    TextView cand3, count3;
    ArrayList<Candidates> candidatesArrayList;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cand1 = findViewById(R.id.candidate1);
        cand2 = findViewById(R.id.candidate2);
        cand3 = findViewById(R.id.candidate3);
        count1 = findViewById(R.id.count1);
        count2 = findViewById(R.id.count2);
        count3 = findViewById(R.id.count3);


        candidatesArrayList = new ArrayList<>();
        Intent intent = getIntent();

        ArrayList<Candidates> candidates = (ArrayList<Candidates>) intent.getSerializableExtra("Candidates");
        if(candidates == null){
            for (int i = 1; i <= 3 ; i++) {
                Candidates candidate = new Candidates("C"+i, "Candidate "+i, 0);
                candidatesArrayList.add(candidate);
            }
        }else{
            candidatesArrayList = candidates;
        }


        cand1.setText(String.valueOf(candidatesArrayList.get(0).getName()));
        count1.setText(String.valueOf(candidatesArrayList.get(0).getNum_votes()));
        cand2.setText(String.valueOf(candidatesArrayList.get(1).getName()));
        count2.setText(String.valueOf(candidatesArrayList.get(1).getNum_votes()));
        cand3.setText(String.valueOf(candidatesArrayList.get(2).getName()));
        count3.setText(String.valueOf(candidatesArrayList.get(2).getNum_votes()));

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Candidates", candidatesArrayList);
                startActivity(intent);
            }
        });


    }



}