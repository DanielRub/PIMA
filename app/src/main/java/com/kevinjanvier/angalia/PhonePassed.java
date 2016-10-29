package com.kevinjanvier.angalia;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.lang.reflect.Field;

public class PhonePassed extends AppCompatActivity {

    String PhoneModel;
    String Manufacturer, Serial, device, display;
    TextView serial_n, model,os_Name,version;
    int version_sdk = 0;
    ImageView share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_passed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Phone Checker");
        share = (ImageView) findViewById(R.id.share);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               ShareLink();
            }
        });

        CheckPhoneDetails();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        this.setIntent(intent);
    }

    private void ShareLink() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Text");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Download the 'Explosion Test' app to check whether your mobile will explode or not.\n" + "\n\n" + getResources().getText(R.string.shared_via));
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, "Share this article with..."));
    }

    private void CheckPhoneDetails() {

        PhoneModel = Build.MODEL;
        Manufacturer = Build.MANUFACTURER;
        Serial = Build.SERIAL;
        device = Build.DEVICE;
        display = Build.DISPLAY;
        version_sdk = Build.VERSION.SDK_INT;
        Field[] fields = Build.VERSION_CODES.class.getFields();
        String osName = fields[Build.VERSION.SDK_INT + 1].getName();
        Log.d("Android OsName:",osName);

        serial_n = (TextView) findViewById(R.id.serial_number);
        serial_n.setText(Serial);
        model = (TextView) findViewById(R.id.model);
        model.setText(PhoneModel);
        os_Name = (TextView) findViewById(R.id.manufacturer);
        os_Name.setText(osName);
        version = (TextView) findViewById(R.id.version);
        version.setText(device);

        log("Phone Model " + PhoneModel);
        log("Serial : " + Serial);
        log("Device : " + device);
        log("Display : " +display);

    }

    /**
     *
     * @param msg
     */
    private void log(String msg){
        Log.v(this.getClass().getSimpleName(), msg);
    }


}
