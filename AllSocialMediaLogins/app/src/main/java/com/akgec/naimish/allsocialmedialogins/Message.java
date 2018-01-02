package com.akgec.naimish.allsocialmedialogins;

import android.content.Context;
import android.widget.Toast;

public class Message {
    Context context;

    public Message(Context context) {
        this.context = context;
    }

    public void L(String m) {
        Toast.makeText(context, m + "", Toast.LENGTH_SHORT).show();
    }
}
