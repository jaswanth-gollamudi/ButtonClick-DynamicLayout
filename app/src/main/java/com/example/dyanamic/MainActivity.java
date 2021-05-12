package com.example.dyanamic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout LayoutList;
    Button buttonAdd;

    List<String> caratList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);

        buttonAdd.setOnClickListener(this);
        caratList.add("Select");
        caratList.add("22car");
        caratList.add("24car");
}

    @Override
    public void onClick(View v) {
        addView();
    }

    private void addView() {


        View OrnamentName = getLayoutInflater().inflate(R.layout.add_ornaments,null,false);

        EditText editText = OrnamentName.findViewById(R.id.weight_grams);
        AppCompatSpinner spinner= OrnamentName.findViewById(R.id.spinner_carat);
        ImageView imageView= OrnamentName.findViewById(R.id.image_remove);

       ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,caratList);
       spinner.setAdapter(arrayAdapter);

       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               removeView(OrnamentName);
           }
       });


        LayoutList.addView(OrnamentName);


    }

    private void removeView(View view) {
         LayoutList.removeView(view);
    }
}