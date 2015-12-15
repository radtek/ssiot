package com.ssiot.remote.data.model;

import net.sourceforge.jtds.jdbc.DateTime;

public class LatestDataModel {

    public int _latestdataid;
    public DateTime _collectiontime;
    public String _uniqueid;
    public int _channel;
    public int _sensorno;
//    public decimal _data;
    public int _islive = 0;
}
