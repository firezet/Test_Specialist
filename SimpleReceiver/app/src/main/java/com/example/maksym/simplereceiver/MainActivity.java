package com.example.maksym.simplereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static final String ACTION_SEND_TEXT =
            "com.example.maksym.simplereceiver.intent.action.SEND_TEXT";
    static final String ACTION_SEND_TIMESTAMP =
            "com.example.maksym.simplereceiver.intent.action.SEND_TIMESTAMP";
    static final String KEY_TEXT = "text";
    EditText mEditText;
    TextView mTimeStamp;

    BroadcastReceiver mReceiver = new BroadcastReceiver () {
        @Override
        public void onReceive (Context context, Intent intent) {

            long time = intent.getLongExtra ("timestamp", 0);
            if ( time != 0 ) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                mTimeStamp.setText(sdf.format (time));
            }
        }
    };

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mEditText = (EditText) findViewById (R.id.textView);
        mTimeStamp = (TextView) findViewById (R.id.timestamp);

        registerReceiver (mReceiver, new IntentFilter (ACTION_SEND_TIMESTAMP));
    }

    @Override
    protected void onDestroy () {
        super.onDestroy ();
        unregisterReceiver (mReceiver);
    }

    public void onClick (View view) {
        String text = mEditText.getText ().toString ().trim ();
        if ( text.length () > 0 ) {
            Intent intent = new Intent (ACTION_SEND_TEXT);
            intent.putExtra (KEY_TEXT, text);
            sendBroadcast (intent);
        }
        mEditText.setText (null);
    }
}
