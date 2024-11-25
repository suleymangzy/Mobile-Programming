package com.example.widgets1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.widgets1.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout,"New Message",Snackbar.LENGTH_SHORT).show();

        b.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Snackbar.make(buttonView,"Toggle Button Open",Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(buttonView,"Toggle Button Closed",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        b.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Snackbar.make(buttonView,"Switch Open",Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(buttonView,"Switch Closed",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        b.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Snackbar.make(buttonView,"Radio Button Selected",Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(buttonView,"Radio Button Not Selected",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        b.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Snackbar.make(buttonView,"Check Box Selected",Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(buttonView,"Check Box Not Selected",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        b.button.setOnClickListener(view->{
            b.textView.setText(b.editTextText.getText());
        });

        b.button2.setOnClickListener(view->{

            Boolean tg = b.toggleButton.isChecked();
            Boolean sw = b.switch1.isChecked();
            Boolean rb = b.radioButton.isChecked();
            Boolean cb = b.checkBox.isChecked();

            Snackbar.make(view,"Toggle Button "+tg+", Switch "+sw+", Radio Butto "+rb+", Check Box "+cb,Snackbar.LENGTH_SHORT).show();

        });

        b.button3.setOnClickListener(view->{
            int views = b.progressBar.getVisibility();
            if (views == 0){
                b.progressBar.setVisibility(view.INVISIBLE);
            }else{
                b.progressBar.setVisibility(view.VISIBLE);
            }

            float star = b.ratingBar.getRating();
            Snackbar.make(view,"Points Earned: "+star,Snackbar.LENGTH_SHORT).show();

        });

        b.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b.textView2.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}