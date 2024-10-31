package com.example.transitionbetweenpages;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.transitionbetweenpages.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        b = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        int number1 = getIntent().getIntExtra("int",0);
        String word = getIntent().getStringExtra("String");
        double number2 = getIntent().getDoubleExtra("double",0.0);

        b.txt2.setText(number1+" "+word+" "+number2);

        Costumers m1 = (Costumers) getIntent().getSerializableExtra("m1");
        b.txt1.setText(m1.name+" "+m1.age);

        b.btn1.setOnClickListener(view->{
            Intent pass = new Intent(MainActivity2.this,MainActivity3.class);
            finish();
            startActivity(pass);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}