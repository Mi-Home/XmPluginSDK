package com.example.bluetoothdemo;

import android.app.Application;

import com.xiaomi.smarthome.bluetooth.BluetoothManager;

/**
 * Created by liwentian on 2016/1/18.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        BluetoothManager.initial(this);
    }
}
