package com.example.meternalcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nutrientsanddietchart extends AppCompatActivity implements View.OnClickListener {
private CardView DN1,DN2,DN3,DN4,DN5,DN6,DN7,DN8,DN9,DN10;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrientsanddietchart);
        DN1=(CardView) findViewById(R.id.dn1);
        DN2=(CardView) findViewById(R.id.dn2);
        DN3=(CardView) findViewById(R.id.dn3);
        DN4=(CardView) findViewById(R.id.dn4);
        DN5=(CardView) findViewById(R.id.dn5);
        DN6=(CardView) findViewById(R.id.dn6);
        DN7=(CardView) findViewById(R.id.dn7);
        DN8=(CardView) findViewById(R.id.dn8);
        DN9=(CardView) findViewById(R.id.dn9);
        DN10=(CardView) findViewById(R.id.dn10);


        DN1.setOnClickListener((View.OnClickListener) this);
        DN2.setOnClickListener((View.OnClickListener) this);
        DN3.setOnClickListener((View.OnClickListener) this);
        DN4.setOnClickListener((View.OnClickListener) this);
        DN5.setOnClickListener((View.OnClickListener) this);
        DN6.setOnClickListener((View.OnClickListener) this);
        DN7.setOnClickListener((View.OnClickListener) this);
        DN8.setOnClickListener((View.OnClickListener) this);
        DN9.setOnClickListener((View.OnClickListener) this);
        DN10.setOnClickListener((View.OnClickListener) this);


        }
@Override
public void onClick(View v){
        Intent i;
        switch (v.getId()){
        case R.id.dn1 :
                i=new Intent(this,dn1.class);
                startActivity(i);
                break;
        case R.id.dn2 :
                i=new Intent(this,dn2.class);
                startActivity(i);
                break;
        case R.id.dn3 :
                i=new Intent(this,dn3.class);
                startActivity(i);
                break;
        case R.id.dn4 :
                i=new Intent(this,dn4.class);
                startActivity(i);
                break;
        case R.id.dn5 :
                i=new Intent(this,dn5.class);
                startActivity(i);
                break;
        case R.id.dn6 :
                i=new Intent(this,dn6.class);
                startActivity(i);
                break;
        case R.id.dn7 :
                i=new Intent(this,dn7.class);
                startActivity(i);
                break;
        case R.id.dn8 :
                i=new Intent(this,dn8.class);
                startActivity(i);
                break;
        case R.id.dn9 :
                i=new Intent(this,dn9.class);
                startActivity(i);
                break;
        case R.id.dn10 :
                i=new Intent(this,dn10.class);
                startActivity(i);
                break;
        }
        }
        }