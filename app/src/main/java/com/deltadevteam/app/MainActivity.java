package com.deltadevteam.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.st.BlueSTSDK.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scanButton(View view) {
        TextView scanResult = findViewById(R.id.scanResult);

        if (scanResult.getText().toString().equals("No Devices Found.")) {

        } else {

        }
    }

}