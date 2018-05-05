package com.example.sonal.canvas;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Sonal on 05-05-2018.
 */

public class Canvas1 extends AppCompatActivity {
private CanvasView cnvs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas1);
         cnvs=(CanvasView) findViewById(R.id.canvas);
    }

    public void clearCanvas(View v) {
                cnvs.clearCanvas();
            }

}
