package com.example.sonal.canvas;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sonal on 05-05-2018.
 */

public class Stringspan1 extends AppCompatActivity {
 TextView tread;
     EditText ewrite;
     Button bstyle,bbold,bunderline,bstrike,burl,bspanned;
    String s; int l;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringspan);
        bstyle=(Button)findViewById(R.id.style);
        bbold=(Button)findViewById(R.id.bold);
        bunderline=(Button)findViewById(R.id.underline);
        bstrike=(Button)findViewById(R.id.strike);
        burl=(Button)findViewById(R.id.url1);
        bspanned=(Button)findViewById(R.id.sb1);
        ewrite=(EditText)findViewById(R.id.write);
        tread=(TextView)findViewById(R.id.read);


        bstrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 s=ewrite.getText().toString();
                 l=s.length();
                SpannableString ss=new SpannableString(s);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                ss.setSpan(strikethroughSpan, 0, l, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tread.setText(ss);
            }
        });
        bunderline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ewrite.getText().toString();
                l=s.length();
                final SpannableString ss=new SpannableString(s);
                UnderlineSpan underlineSpan = new UnderlineSpan();
                ss.setSpan(underlineSpan, 0, l, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tread.setText(ss);
            }
        });
        bbold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ewrite.getText().toString();
                l=s.length();
                final SpannableString ss=new SpannableString(s);
                StyleSpan styleSpanBold  = new StyleSpan(Typeface.BOLD);
                ss.setSpan(styleSpanBold, 0, l, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tread.setText(ss);
            }
        });
        burl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ewrite.getText().toString();
                l=s.length();
                final SpannableString ss=new SpannableString(s);
                URLSpan urlSpan = new URLSpan("http://www.google.com");
                ss.setSpan(urlSpan, 0, l, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tread.setText(ss);
            }
        });
        bstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ewrite.getText().toString();
                l=s.length();
                final SpannableString ss=new SpannableString(s);
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                drawable.setBounds(0, 0, 100, 100);
                ImageSpan imageSpan = new ImageSpan(drawable);
                ss.setSpan(imageSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tread.setText(ss);
            }
        });

        bspanned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ewrite.getText().toString();

                SpannableStringBuilder builder= new SpannableStringBuilder();
                ForegroundColorSpan colorSpan=new ForegroundColorSpan(Color.MAGENTA);
                builder.append(s,colorSpan,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tread.setText(builder);

            }
        });


    }
}
