package com.example.hashtag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView req;
    private TextView res;
    private Button btn;

    Pattern pattern1;
    Linkify.TransformFilter mFilter;

    String[] srt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        req = findViewById(R.id.editText);
        res = findViewById(R.id.editResult);
        btn = findViewById(R.id.button);

        setEvent();

        srt = new String[4];
        srt[0] = "#해시태그";
        srt[1] = "#해시";
        srt[2] = "#테스트";
        srt[3] = "#태그";

        mFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return "";
            }
        };




        for( int i = 0; i<srt.length; i++ ) {
            Log.d("tag", "--> " + srt[i]);
            pattern1 = Pattern.compile(srt[i]);
            String url ="hash://detail";
            Linkify.addLinks(req, pattern1, url, null, mFilter);
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //startActivity(intent);
        }
    }

    private void setEvent() {
        btn.setOnClickListener(view -> {

        });
    }

}