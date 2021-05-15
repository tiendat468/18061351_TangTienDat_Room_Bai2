package com.example.th_lab_06_b;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.service.media.MediaBrowserService;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<product> list;
    List<product> products;
    Button btnSave, btnCancel;
    EditText place_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_travel);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        place_name = (EditText) findViewById(R.id.place_name);
        list = new ArrayList<product>();

//      DataBaseP db = Room.databaseBuilder(getApplicationContext(),DataBaseP.class, "Place_2").allowMainThreadQueries().build();
       DataBaseP db = DataBaseP.getInstance(this);
        ProductDao pDao = db.pDao();
//        product p = new product();
//
//        p.place = "Phus yeen";
//
//        pDao.insertP(p);
        products = pDao.getAll();

        list.addAll(products);
        adapter = new Adapter(list,MainActivity.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placeName = place_name.getText().toString();
                if (placeName.equals("")){
                    Toast.makeText(MainActivity.this,"Nhập vị trí",Toast.LENGTH_SHORT).show();
                }else {
                    product p = new product();
                    p.place = placeName;
                    pDao.insertP(p);

                    list.clear();

                    products = pDao.getAll();
                    list.addAll(products);
                    place_name.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place_name.setText("");
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}