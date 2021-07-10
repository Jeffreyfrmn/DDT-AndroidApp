package com.deltadevteam.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.st.BlueSTSDK.*;
import com.st.BlueSTSDK.Manager;
import com.st.BlueSTSDK.Node;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int ACCESS_FINE_LOCATION_PERMISSION_CODE = 1;

    final int SCANNING_TIME = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView scanResult = findViewById(R.id.scanResult);

        Button scanButton = findViewById(R.id.scanButton);
        // TODO: If clicked again, mngr.resetDiscovery().
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Manager mngr = Manager.getSharedInstance();

                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(MainActivity.this, "Permission has already been granted.", Toast.LENGTH_SHORT).show();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Manager.ManagerListener listener = new Manager.ManagerListener() {
                                @Override
                                public void onDiscoveryChange(
                                        @NonNull @NotNull Manager mngr,
                                        @NonNull @NotNull boolean enabled) {
                                    String res = "Discovery " + (enabled ? "started" : "stopped") + ".\n";
                                    System.out.println(res);
                                }

                                @Override
                                public void onNodeDiscovered(
                                        @NonNull @NotNull Manager mngr,
                                        @NonNull @NotNull Node node) {
                                    String res = "Device Discovered: " + node.getName() + '\n';
                                    System.out.println(res);
                                }
                            };
                            mngr.addListener(listener);
                        }
                    });

                    System.out.println("Started mngr.startDiscovery()");
                    scanResult.setText("Discovery started:\n");

                    mngr.startDiscovery(5000);

                    if (mngr.getNodes().isEmpty()) {
                        scanResult.setText("No Devices Found.");
                    } else {
                        for (Node node : mngr.getNodes()) {
                            String msg = scanResult.getText().toString() + "Found Node: " + node.getName() + "\n";
                            System.out.println(msg);
                            scanResult.setText(msg);

                            // TODO: Connect to Node...
                        }
                    }
                } else {
                    requestBltPermission();
                }
            }
        });
    }

    private void requestBltPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("In order to connect to Delta Development Team Devices, bluetooth permissions are needed.")
                    .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_FINE_LOCATION_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_FINE_LOCATION_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ACCESS_FINE_LOCATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}