
package com.ssiot.remote.control;

public class DeviceCheckerData {
    public int deviceNo = 0;
    public String deviceName;
    public boolean isChecked;

    public DeviceCheckerData(int deviceNo, String str, boolean b) {
        this.deviceNo = deviceNo;
        deviceName = str;
        isChecked = b;
    }
}
