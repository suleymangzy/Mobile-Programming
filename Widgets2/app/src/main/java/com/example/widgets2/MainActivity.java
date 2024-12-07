package com.example.widgets2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.widgets2.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.button.setOnClickListener(view->{
            b.imageView.setImageResource(R.drawable.bluetooth_connected);
        });

        b.button2.setOnClickListener(view->{
            b.imageView.setImageResource(R.drawable.bluetooth_disabled);
        });

        String [] point = {".","..","..."};

        ArrayAdapter<String> adptr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,point);
        b.listView.setAdapter(adptr);

        b.listView.setOnItemClickListener((parent, view, position, id) -> {
                String preference = (String) parent.getItemAtPosition(position);
                b.textView1.setText(preference);
        });

        b.grid.setAdapter(adptr);

        b.grid.setOnItemClickListener((parent, view, position, id) -> {
               String preference = (String) parent.getItemAtPosition(position);
               b.textView2.setText(preference);
        });

        ArrayAdapter<String> adptr1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,point);
        b.spinner.setAdapter(adptr1);
        adptr1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        b.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String preference = (String) parent.getItemAtPosition(position);
                b.textView3.setText(preference);
                int i = b.spinner.getSelectedItemPosition();
                Snackbar.make(view,"Position: "+(i+1),Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}