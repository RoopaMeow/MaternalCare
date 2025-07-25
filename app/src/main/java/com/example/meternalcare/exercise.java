package com.example.meternalcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class exercise extends AppCompatActivity implements View.OnClickListener {
    private CardView D1,D2,D3,D4,D5,D6,D7,D8,D9,D10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        D1=(CardView) findViewById(R.id.d1);
        D2=(CardView) findViewById(R.id.d2);
        D3=(CardView) findViewById(R.id.d3);
        D4=(CardView) findViewById(R.id.d4);
        D5=(CardView) findViewById(R.id.d5);
        D6=(CardView) findViewById(R.id.d6);
        D7=(CardView) findViewById(R.id.d7);
        D8=(CardView) findViewById(R.id.d8);
        D9=(CardView) findViewById(R.id.d9);
        D10=(CardView) findViewById(R.id.d10);


        D1.setOnClickListener((View.OnClickListener) this);
        D2.setOnClickListener((View.OnClickListener) this);
        D3.setOnClickListener((View.OnClickListener) this);
        D4.setOnClickListener((View.OnClickListener) this);
        D5.setOnClickListener((View.OnClickListener) this);
        D6.setOnClickListener((View.OnClickListener) this);
        D7.setOnClickListener((View.OnClickListener) this);
        D8.setOnClickListener((View.OnClickListener) this);
        D9.setOnClickListener((View.OnClickListener) this);
        D10.setOnClickListener((View.OnClickListener) this);


    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.d1 :i=new Intent(this,d1.class); startActivity(i); break;
            case R.id.d2 :i=new Intent(this,d2.class); startActivity(i); break;
            case R.id.d3 :i=new Intent(this,d3.class); startActivity(i); break;
            case R.id.d4 :i=new Intent(this,d4.class); startActivity(i); break;
            case R.id.d5 :i=new Intent(this,d5.class); startActivity(i); break;
            case R.id.d6 :i=new Intent(this,d6.class); startActivity(i); break;
            case R.id.d7 :i=new Intent(this,d7.class); startActivity(i); break;
            case R.id.d8 :i=new Intent(this,d8.class); startActivity(i); break;
            case R.id.d9 :i=new Intent(this,d9.class); startActivity(i); break;
            case R.id.d10 :i=new Intent(this,d10.class); startActivity(i); break;
        }
    }
}
