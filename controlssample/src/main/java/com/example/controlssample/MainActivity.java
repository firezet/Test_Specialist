package com.example.controlssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName = (EditText) findViewById(R.id.user_name);

        userName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int code, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (code == KeyEvent.KEYCODE_ENTER)) {
                    Toast.makeText(getApplicationContext(),
                            userName.getText(),
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }


    public void onSmileButtonClick(View view) {
        Toast.makeText(this, "Smile button is pressed", Toast.LENGTH_SHORT).show();
    }

    public void onCheckBoxClick(View view) {
        if (((CheckBox) view).isChecked()) {
            Toast.makeText(this, "is Checked", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "not Checked", Toast.LENGTH_SHORT).show();
        }
    }

    public void onToggleButtonClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(this, "Checked ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Checked OFF", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRadioButton(View view) {
        RadioButton myRB = (RadioButton) view;
        Toast.makeText(this, "You choose " + myRB.getText(), Toast.LENGTH_SHORT).show();
    }

    public void onClearButton(View view) {
        ((EditText) findViewById(R.id.user_name)).setText(null);
        Toast.makeText(this, "EditText is cleared", Toast.LENGTH_SHORT).show();
    }
}
