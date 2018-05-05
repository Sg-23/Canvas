package com.example.sonal.canvas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arr = {"Canvas", "Spannable String", "OpenGL SurfaceView"};
        ListView l = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arr);
        l.setAdapter(ad);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                    {
                        Intent in = new Intent(MainActivity.this, Canvas1.class);
                        startActivity(in);
                        break;
                    }
                    case 1:
                    {
                        Intent in = new Intent(MainActivity.this, Stringspan1.class);
                        startActivity(in);
                        break;
                    }
                    case 2:
                    {
                        Intent in = new Intent(MainActivity.this, Opengl1.class);
                        startActivity(in);
                        break;
                    }
                }
            }
        });
    }
}
