package com.example.materialdesign;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.materialdesign.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.button.setOnClickListener(view ->{
            b.textView.setText(b.textInput.getText());
        });

        b.button2.setOnClickListener(view -> {
            Snackbar sbr = Snackbar.make(view,"Snackbar example...",Snackbar.LENGTH_LONG);
            sbr.setAction("Okey", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b.textView.setText("Button was clicked.");
                }
            });
            sbr.show();
        });

        b.floatingActionButton.setOnClickListener(view ->{
             Snackbar.make(view,"Button was clicked.",Snackbar.LENGTH_SHORT).show();
        });

        setSupportActionBar(b.toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem mi = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) mi.getActionView();
        searchView.setOnQueryTextListener(this);
        return  super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Snackbar.make(findViewById(android.R.id.content),"Search was made: "+query,Snackbar.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Snackbar.make(findViewById(android.R.id.content),"Text changed: "+newText,Snackbar.LENGTH_SHORT).show();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.item1){
           Snackbar.make(findViewById(android.R.id.content),"Menu 1",Snackbar.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Snackbar.make(findViewById(android.R.id.content),"Menu 2",Snackbar.LENGTH_SHORT).show();
        }else if (id == R.id.item3) {
            Snackbar.make(findViewById(android.R.id.content),"Menu 3",Snackbar.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}