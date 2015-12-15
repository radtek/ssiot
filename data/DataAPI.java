package com.ssiot.remote.data;

import com.ssiot.remote.data.business.User;
import com.ssiot.remote.data.model.AreaModel;
import com.ssiot.remote.data.model.UserModel;

import java.util.ArrayList;
import java.util.List;


//仿照 Business/Angel.Extend.Business/API/DataAPI.cs
public class DataAPI {
    public static User mUserService = new User();
    
    public static String GetAreaIDsByUserKey(String userkey) {
        
      UserModel mUserModelr = mUserService.GetModelList(" UniqueID='" + userkey + "'").get(0);//?????? TODO?
//        return GetSelfAndChildrenAreaIDsByAreaID(user.AreaID);//TODO
        return null;
    }
    
//    public static String GetSelfAndChildrenAreaIDsByAreaID(int areaid){
//        String areaids = "";
//        String catchkey = "GetSelfAndChildrenAreaIDsByAreaID_" + areaid.GetHashCode().toString();//获取hashkey为字典ID
//        String objModel = Angel.Common.Web.DataCache.GetCache(catchkey);
//        if (objModel == null){
//            AreaModel area_mdl = new AreaModel();
//            List<AreaModel> area_list = new ArrayList<AreaModel>();
//            area_mdl = bllarea.GetModel(areaid);
//            if (area_mdl != null)
//            {
//                area_list = bllarea.GetSelfAndChildrenAreaByAreaCode(area_mdl.AreaCode);
//            }
//            else
//            {
//                areaids = areaid.toString();
//            }
//            if (area_list.Count > 0) 
//            {
//                foreach (var area in area_list)
//                {
//                    areaids += area.AreaID + ","; 
//                }
//            }
//            if (!string.IsNullOrWhiteSpace(areaids) && areaids.Contains(","))
//            {
//                areaids = areaids.Trim(',');
//            }
//            objModel = areaids;
//            Angel.Common.Web.DataCache.SetCache(catchkey, objModel);
//        }
//
//        return objModel;
//    }
}


