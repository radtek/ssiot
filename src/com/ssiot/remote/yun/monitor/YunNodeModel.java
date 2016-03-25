package com.ssiot.remote.yun.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class YunNodeModel implements Serializable{
    public int nodeType = 1;//1 2 3 检测 控制 视频
    public String landStr = "";
    public String facilityStr = "";
    public int mLandID = 0;
    public int mFacilityID = 0;
    public int mNodeID = 0;
    public boolean landVis = true;
    public boolean facilityVis = true;
    
    public String nodeStr = "";
    public List<DeviceBean> list = new ArrayList<DeviceBean>();//传感器列表 or 执行器列表 or 监控列表
    
    
    public YunNodeModel(int nodetype, int landId, String landString, int facilityId, String facility,int nodeId, String nodeString){
        nodeType = nodetype;
        mLandID = landId;
        mFacilityID = facilityId;
        mNodeID = nodeId;
        landStr = landString;
        facilityStr = facility;
        nodeStr = nodeString;
        for (int i = 0; i < 4; i ++){
            list.add(new DeviceBean(nodeType, 770, "温度传感器"));//TODO test
            list.add(new DeviceBean(nodeType, 771, "大气压传感器"));//TODO test
        }
    }
    
//    public YunNodeModel configVisibility(List alreadyExistList){//由于list嵌套问题可能会卡，这种方法控制标题的显示
//        
//        return this;
//    }
    
}