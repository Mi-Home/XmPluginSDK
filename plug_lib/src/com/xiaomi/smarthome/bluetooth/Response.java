package com.xiaomi.smarthome.bluetooth;

import java.util.UUID;

/**
 * Created by liwentian on 2015/11/10.
 */
public class Response {

    public interface BleResponse<T> {
        public void onResponse(int code, T data);
    }

    public interface BleConnectResponse extends BleResponse<Void> {

    }

    public interface BleReadResponse extends BleResponse<byte[]> {

    }

    public interface BleWriteResponse extends BleResponse<Void> {

    }

    public interface BleNotifyResponse extends BleResponse<Void> {
        void onNotify(UUID service, UUID character, byte[] data);
    }

    public interface BleConnectNoticeResponse extends BleConnectResponse {

        public static final int STATUS_CONNECTED = 1;
        public static final int STATUS_DISCONNECTED = 2;

        public void onConnectionStateChanged(int status);
    }
}
