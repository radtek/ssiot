package com.ssiot.remote.data.model;

public class AlarmRuleBean {
    public String sensorName = "";
    public int sensorType = 0;
    public int channel = 0;
    public String type = "";// 大于 小于 之间
    public String value = "";// 之间的value只能是string
    public int isOpen = 1;

    public AlarmRuleBean(String sensorName, int sensorType, int chan, String type, String value,
            int isOpen) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.channel = chan;
        this.type = type;
        this.value = value;
        this.isOpen = isOpen;
    }
}
