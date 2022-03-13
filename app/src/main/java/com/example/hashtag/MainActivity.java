package com.example.hashtag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView req;
    private TextView res;
    private Button btn;

    Pattern pattern1;
    Linkify.TransformFilter mFilter;

    String[] srt;
    String url ="hash://detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        req = findViewById(R.id.editText);
        res = findViewById(R.id.editResult);
        btn = findViewById(R.id.button);

        String content = req.getText().toString();

        mFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                System.out.println("태그테스트 " + url+"?hashTag="+s);
                return "";
            }
        };

        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher mat = MY_PATTERN.matcher(content);
        List<String> tags = new ArrayList<>();
        while (mat.find()) {
            String tag = "#"+mat.group(1);
            pattern1 = Pattern.compile(tag);
            System.out.println("태그테스트 " + tag);
            Linkify.addLinks(req, pattern1, url+"?hashTag="+tag, null, mFilter);
        }
    }

    private void hashTagTest() {
        srt = new String[4];
        srt[0] = "#해시태그";
        srt[1] = "#해시";
        srt[2] = "#테스트";
        srt[3] = "#태그";

        mFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return url+"s";
            }
        };

        for( int i = 0; i<srt.length; i++ ) {
            Log.d("tag", "--> " + srt[i]);
            pattern1 = Pattern.compile(srt[i]);

            Linkify.addLinks(req, pattern1, url, null, mFilter);
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //startActivity(intent);
        }
    }

}