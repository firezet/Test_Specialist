package com.example.dialogsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SampleDialogFragment df;
    SampleListDialog ld;

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

    public void onRadioDialog (View view) {
        ld = new SampleListDialog ();
        ld.setContext (this);
        ld.show (getFragmentManager (), "List");
    }

    public void onCheckboxDialog (View view) {
        // TODO
    }
}
