package com.example.dialogsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BrowserCall {

    SampleDialogFragment df;
    SampleListDialog ld;
    SampleRadioButtonDialog rd;
    SampleCheckboxDialog chd;
    SampleCustomDialog custd;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    public void onSimpleDialog (View view) {
        df = new SampleDialogFragment ();
        df.setContext (this);
        df.show(getFragmentManager (), "Simple");
    }

    public void onListDialog (View view) {
        ld = new SampleListDialog ();
        ld.setContext (this);
        ld.show (getFragmentManager (), "List");
    }

    public void onRadioDialog (View view) {
        rd = new SampleRadioButtonDialog ();
        rd.setContext (this);
        rd.show (getFragmentManager (), "Radio");
    }

    public void onCheckboxDialog (View view) {
        chd = new SampleCheckboxDialog ();
        chd.setContext (this);
        chd.show (getFragmentManager (), "Radio");
    }

    public void onCustomDialog (View view) {
        custd = new SampleCustomDialog ();
        custd.show (getFragmentManager (), "Custom");
    }


    // NEW PART FROM SPECIALIST COURSE
    
    final static CharSequence[] ENGINE_NAMES = { "Google", "Yahoo", "Yandex",};
    final static CharSequence[] ENGINE_URLS = { "google.com", "yahoo.com", "yandex.com",};
    final static String URL_PREFIX = "http://";

    public void callBrowser(int idx) {
        if ( idx >= 0 || idx < ENGINE_URLS.length) {
            Uri webpage = Uri.parse (URL_PREFIX + ENGINE_URLS[idx]);
            Intent intent = new Intent (Intent.ACTION_VIEW, webpage);
            if ( intent.resolveActivity (getPackageManager ()) != null) {
                startActivity (intent);
            }
        }
    }

    public void onClick (View view) {
        switch ( view.getId () ) {
            case R.id.selectButton1:
                DialogFragment1 df1 = new DialogFragment1 ();
                df1.show (getSupportFragmentManager (), "Dialog One");
                break;
            case R.id.selectButton2:
                DialogFragment2 df2 = new DialogFragment2 ();
                df2.show (getSupportFragmentManager (), "Dialog Two");
                break;
            default:
                Toast.makeText (this, "OOPS", Toast.LENGTH_SHORT).show ();
        }
    }

}
