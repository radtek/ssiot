
package com.ssiot.remote.data.business;

import android.text.TextUtils;
import android.util.Log;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.VLCVideoInfoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VLCVideoInfo {
    private static final String tag = "VLCVideoInfo";

    // 分页获取数据列表
    public List<VLCVideoInfoModel> GetVLCByPage(String strWhere, String orderby, int startIndex,
            int endIndex) {
        List<VLCVideoInfoModel> VLC_list = new ArrayList<VLCVideoInfoModel>();
        SsiotResult sResult = GetListByPage(strWhere, orderby, startIndex, endIndex);
        try {
            if (null != sResult && null != sResult.mRs) {
                while (sResult.mRs.next()) {
                    VLC_list.add(DataRowToModel(sResult.mRs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != sResult){
            sResult.close();
        }
        return VLC_list;
    }
    
    public List<VLCVideoInfoModel> GetVLCmap(String strWhere) {
        List<VLCVideoInfoModel> VLC_list = new ArrayList<VLCVideoInfoModel>();
        SsiotResult sResult = GetList(strWhere);
        try {
            if(null != sResult && sResult.mRs != null) {
                while(sResult.mRs.next()){
                    VLCVideoInfoModel v = DataRowToModel(sResult.mRs);
                    if (null != v){
                        VLC_list.add(v);
                    } else {
                        Log.e(tag, "-------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!VLCVideoInfoModel get null");
                    }
                }
            }
//            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != sResult){
            sResult.close();
        }
        return VLC_list;
    }
    
    public List<VLCVideoInfoModel> GetModelList(String strWhere) {
        SsiotResult sResult = GetList(strWhere);
        List<VLCVideoInfoModel> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    private List<VLCVideoInfoModel> DataTableToList(ResultSet dt) {
        List<VLCVideoInfoModel> modelList = new ArrayList<VLCVideoInfoModel>();
        try {
            while(dt.next()){
                VLCVideoInfoModel modelTmp;
                modelTmp = DataRowToModel(dt);
                if (null != modelTmp){
                    modelList.add(modelTmp);
                }
            }
            dt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelList;
    }

    // ------------------------------
    
    //获得数据列表
    private SsiotResult GetList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select VLCVideoInfoID,AreaID,AreaName,UserName,PassWord,URL,IP,Port,Address,Channel,Subtype,Type,CreateTime,Remark,Longitude,Latitude,TcpPort ");
        strSql.append(" FROM VLCVideoInfo ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        return DbHelperSQL.getInstance().Query(strSql.toString());
    }
    
    // 分页获取数据列表
    private SsiotResult GetListByPage(String strWhere, String orderby, int startIndex, int endIndex) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("SELECT * FROM ( ");
        strSql.append(" SELECT ROW_NUMBER() OVER (");
        if (!TextUtils.isEmpty(orderby.trim())) {
            strSql.append("order by T." + orderby);
        } else {
            strSql.append("order by T.VLCVideoInfoID desc");
        }
        strSql.append(")AS Row, T.*  from VLCVideoInfo T ");
        if (!TextUtils.isEmpty(strWhere.trim())) {
            strSql.append(" WHERE " + strWhere);
        }
        strSql.append(" ) TT");
        strSql.append(" WHERE TT.Row between {" + startIndex+"} and {"+endIndex+"}");
        return DbHelperSQL.getInstance().Query(strSql.toString());
    }

    private VLCVideoInfoModel DataRowToModel(ResultSet c) {// 先.next !!
        VLCVideoInfoModel vModel = new VLCVideoInfoModel();
        try {
            vModel._vlcvideoinfoid = c.getInt("VLCVideoInfoID");
            vModel._areaid = c.getInt("AreaID");
            vModel._username = c.getString("UserName");
            vModel._password = c.getString("PassWord");
            vModel._url = c.getString("URL");
            vModel._ip = c.getString("IP");
            vModel._port = c.getString("Port");
            vModel._address = c.getString("Address");
            vModel._type = c.getString("Type");
            try {
                vModel._tcpport = c.getInt("TcpPort");
            } catch (Exception e) {
                e.printStackTrace();
            }
            vModel._remark = c.getString("Remark");
//            Log.v(tag, "-------tcpport---------------------------------" + vModel._tcpport + vModel._address);
            // TODO
            return vModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
