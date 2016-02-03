package com.ssiot.remote.data.model.view;

import java.sql.Timestamp;

public class CtrLoopConditionModel{
    public int ID;
    public int OnceRunTime = 2;
    public int IntervalTime = 15;
    public Timestamp StartTime;
    public Timestamp EndTime;
}