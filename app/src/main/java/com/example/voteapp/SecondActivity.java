package com.example.voteapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    Spinner sp;
    TextView tv;
    TextView tv_error;
    Boolean accept_terms = false;
    EditText i_name;
    EditText i_id;
    ToggleButton btn2;
    Button btn3;
    ArrayList<Candidates> candidatesArrayList;
    ArrayList<Voters> votersList;
    int index;
    String choice;





    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        sp = findViewById(R.id.candidate_list);
        tv = findViewById(R.id.message);
        tv_error = findViewById(R.id.err_msg);
        i_name = findViewById(R.id.i_name);
        i_id =  findViewById(R.id.i_id);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        votersList = new ArrayList<Voters>();

        Intent intent = getIntent();
        ArrayList<Candidates> candidatesArrayList = (ArrayList<Candidates>) intent.getSerializableExtra("candidates");


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;

                if(!(i_name.getText().toString().isEmpty() && i_id.getText().toString().isEmpty() && accept_terms==false && sp.getSelectedItem().toString().isEmpty())){
                    Log.e("Name Test", i_name.getText().toString());
                    Log.e("Id Test", i_id.getText().toString());
                    Log.e("Accept Test", accept_terms.toString());
                    Log.e("Index Test", sp.getSelectedItem().toString());

                    for (Voters voter : votersList) {
                        if(voter.getId() == Integer.parseInt(i_id.getText().toString())){

                            tv_error.setText("You only can vote once");
                            break;
                        }
                    }

                    tv_error.setText("YOUR VOTE HAS BEEN SAVED");
                    Log.e("ID Test", String.valueOf(sp.getSelectedItemPosition()));
                    int position =sp.getSelectedItemPosition();
                    votersList.add(new Voters(Integer.parseInt(i_id.getText().toString()), i_name.getText().toString()));
                    Candidates choosen_candidate = candidatesArrayList.get(position);
                    choosen_candidate.setNum_votes(choosen_candidate.getNum_votes()+1);
                    Log.e("List Test", String.valueOf(candidatesArrayList));
                }else{
                    tv_error.setText("ONE OR MORE FIELDS ARE EMPTY");
                }

            }
        });


/*
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {

                    btn2.setTextOn("Refuse");
                    accept_terms = false;

                } else {

                    btn2.setTextOff("Accept");
                    tv.setText(sp.getSelectedItem().toString());
                    accept_terms = true;
                    index = sp.getSelectedItemPosition();
                    choice =findViewById(R.id.message).toString();
                }
            }
        });*/
    }



    public void chooseCandidate(View view){

        tv.setText(sp.getSelectedItem().toString());
        accept_terms = true;
        index = sp.getSelectedItemPosition();
        choice =findViewById(R.id.message).toString();


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        intent.putExtra("Candidates", candidatesArrayList);
        startActivity(intent);
    }





}
