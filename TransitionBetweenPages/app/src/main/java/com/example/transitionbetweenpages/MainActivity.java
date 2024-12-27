package com.example.transitionbetweenpages;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.transitionbetweenpages.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());


        Costumers c1 = new Costumers("Süleyman",20);
        b.textView.setText("Page 1");
        b.btn.setOnClickListener(view->{
            Intent pass = new Intent (MainActivity.this, MainActivity2.class);
            Snackbar.make(view,"Hello",Snackbar.LENGTH_SHORT).show();
            pass.putExtra("int",15);
            pass.putExtra("String","Hello");
            pass.putExtra("double",25.18);
            pass.putExtra("c1",c1);
            startActivity(pass);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}