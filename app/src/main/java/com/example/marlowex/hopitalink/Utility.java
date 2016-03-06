package com.example.marlowex.hopitalink;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by marloweX on 2016/3/6.
 */
public class Utility {
    public static TextView createBasicTextView(Context context,LinearLayout parent, String str, int size){
        TextView aText = new TextView(context);
        aText.setText(str);
        aText.setTextSize(size);
        parent.addView(aText);
        return aText;
    }
}
