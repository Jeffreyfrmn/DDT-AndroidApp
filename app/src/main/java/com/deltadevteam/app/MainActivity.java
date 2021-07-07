package com.deltadevteam.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.st.BlueSTSDK.*;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scanButton(View view) {
        final int SCANNING_TIME = 1500;

        TextView scanResult = findViewById(R.id.scanResult);
        TextView nodeResult = findViewById(R.id.nodeResult);
        Manager mngr = Manager.getSharedInstance();
        Manager.ManagerListener listener = new Manager.ManagerListener() {
            @Override
            public void onDiscoveryChange(
                    @NonNull @NotNull Manager mngr,
                    @NonNull @NotNull boolean enabled ) {
                String res = "Discovery " + (enabled ? "started" : "stopped") + ".\n";
                scanResult.setText(res);
            }

            @Override
            public void onNodeDiscovered(
                    @NonNull @NotNull Manager mngr,
                    @NonNull @NotNull Node node ) {
                String res = "Device Discovered: " + node.getName() + '\n';
                res = nodeResult.getText().toString() + res;
                nodeResult.setText(res);
            }
        };
        mngr.addListener(listener);

        //TODO: handle mngr.startDiscovery w/ Permissions
        //mngr.startDiscovery(SCANNING_TIME);

        List<Node> nodes = mngr.getNodes();

        if (nodes.isEmpty()) {
            scanResult.setText("No devices found.");
        } else {
            //TODO: Launch new Activity (ConnectActivity) which handels device listings.
        }
    }

}