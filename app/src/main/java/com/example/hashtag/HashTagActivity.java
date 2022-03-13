package com.example.hashtag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HashTagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hash_tag);
        TextView txt = findViewById(R.id.textView);

        Intent intent = getIntent();
        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            Log.d("태그테스트", "ACTION : " + intent.getAction());

            Uri uri = intent.getData();
            Log.d("태그테스트", "uri : " + uri);
            String srt = uri.toString();
            String tag = srt.substring(srt.indexOf("#")+1);
            Log.d("태그테스트", "tag : " + tag);

            String temp_post_id = uri.getQueryParameter("hashtag");
            Log.d("태그테스트", "태그 : " + temp_post_id);

            txt.setText(tag);
        }

    }
}