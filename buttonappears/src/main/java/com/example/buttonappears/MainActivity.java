package com.example.buttonappears;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int mButtonNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.mainButton) {
            Button newButton = new Button(this);
            newButton.setOnClickListener(this);
            CharSequence newBtnTxt = String.format(Locale.US,
                    "%s %d", getString(R.string.new_button), mButtonNo++);
            newButton.setText(newBtnTxt);
            ((LinearLayout) view.getParent()).addView(newButton);
        } else {
            ((LinearLayout) view.getParent()).removeView(view);
        }

    }
}
