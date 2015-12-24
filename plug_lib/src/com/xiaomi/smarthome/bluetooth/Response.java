package com.xiaomi.smarthome.bluetooth;

import android.os.Bundle;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by liwentian on 2015/11/10.
 */
public class Response {

    /**
     * ApiLevel: 15
     */
    public interface BleResponse<T> {
        public void onResponse(int code, T data);
    }

    /**
     * ApiLevel: 15
     */
    public interface BleConnectResponse extends BleResponse<Bundle> {

    }

    /**
     * ApiLevel: 15
     */
    public interface BleReadResponse extends BleResponse<byte[]> {

    }

    /**
     * ApiLevel: 15
     */
    public interface BleWriteResponse extends BleResponse<Void> {

    }

    /**
     * ApiLevel: 15
     */
    public interface BleNotifyResponse extends BleResponse<Void> {

    }
}
