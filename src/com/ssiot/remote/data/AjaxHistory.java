package com.ssiot.remote.data;

import com.ssiot.remote.data.business.CompanyContent;
import com.ssiot.remote.data.business.ProfilesContent;
import com.ssiot.remote.data.business.TraceCertification;
import com.ssiot.remote.data.business.TraceFertilizer;
import com.ssiot.remote.data.business.TraceImages;
import com.ssiot.remote.data.business.TracePesticides;
import com.ssiot.remote.data.business.TraceProfiles;
import com.ssiot.remote.data.model.CompanyContentModel;
import com.ssiot.remote.data.model.ProfilesContentModel;
import com.ssiot.remote.data.model.TraceCertificationModel;
import com.ssiot.remote.data.model.TraceFertilizerModel;
import com.ssiot.remote.data.model.TraceImagesModel;
import com.ssiot.remote.data.model.TracePesticidesModel;
import com.ssiot.remote.data.model.TraceProfileModel;

import java.util.List;

public class AjaxHistory{
    private TraceProfiles traceProfilesBll = new TraceProfiles();
    private ProfilesContent proContentBll = new ProfilesContent();
    private CompanyContent mCompanyContentBll = new CompanyContent();
    private TraceImages mTraceImagesBll = new TraceImages();
    private TraceFertilizer mFertilizerBll = new TraceFertilizer();
    private TracePesticides mPesticidesBll = new TracePesticides();
    private TraceCertification mCertificationBll = new TraceCertification();
    
    public TraceProfileModel getTraceProfile(String code){
        List<TraceProfileModel> models = traceProfilesBll.GetModelList(" ProCode='" + code +"'");
        if (null != models && models.size() > 0){
            return models.get(0);
        }
        return null;
    }
    
    public List<TraceProfileModel> getUserTraceProfiles(int parentID){
        return traceProfilesBll.GetModelList(" ProParentID=" + parentID +"");
    }
    
    public String getProfileContentStr(int profileContentID){//商品的描述信息
        List<ProfilesContentModel> models = proContentBll.GetModelList(" ProfilesContentID=" + profileContentID);
        if (null != models && models.size() > 0){
            return models.get(0)._profilecontent;
        }
        return null;
    }
    
    public CompanyContentModel getCompanyInfo(int companyId){//公司的描述信息
        List<CompanyContentModel> models = mCompanyContentBll.GetModelList(" CompanyContentID=" + companyId);
        if (null != models && models.size() > 0){
            return models.get(0);
        }
        return null;
    }
    
    public List<TraceImagesModel> geTraceImagesModels(int imgProID){//生长期图像
        return mTraceImagesBll.GetModelList(" ImgProID=" + imgProID +" ");
    }
    
    public List<TraceFertilizerModel> getFertilizerModels(int ferProID){//肥料
        return mFertilizerBll.GetModelList(" FerProID=" + ferProID +" ");
    }
    
    public List<TracePesticidesModel> getPesticidesModels(int pesProID){//农药
        return mPesticidesBll.GetModelList(" PesProID=" + pesProID +" ");
    }
    
    public List<TraceCertificationModel> getCertificationModels(int certProID){//认证
        return mCertificationBll.GetModelList(" CertProID=" + certProID +" ");
    }
}