package com.example.hashtag;

import android.content.Context;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class HashTag extends ClickableSpan {

    public interface ClickEventListener {
        void onClickEvent(String data);
    }

    private ClickEventListener clickEventListener = null;
    private Context context;
    private TextPaint textPaint;

    public HashTag(Context context) {
        this.context = context;
    }

    public void setOnClickEventListener(ClickEventListener listener) {
        this.clickEventListener = listener;
    }

    public void updateDrawState(TextPaint txt) {
        textPaint = txt;
        txt.setColor(txt.linkColor);
        txt.setARGB(255, 30, 144, 255);
    }

    @Override
    public void onClick(View view) {
        TextView textView = (TextView) view;
        Spanned s = (Spanned) textView.getText();
        int start = s.getSpanStart(this);
        int end = s.getSpanEnd(this);
        String theWord = s.subSequence(start + 1 , end).toString();
        clickEventListener.onClickEvent(theWord);
    }
}
