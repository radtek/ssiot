package com.ssiot.remote;

import java.util.HashMap;

public class CacheManager{
    private static CacheManager cacheManager;
    private HashMap<String, Object> datas = new HashMap<String, Object>();
    
    public CacheManager(){
        
    }
    
    public static CacheManager getInstance(){
        if (null == cacheManager){
            cacheManager = new CacheManager();
        }
        return cacheManager;
    }
    
    public void setCache(String key, Object value){
        if (datas.size() < 30){//最多缓存多少条
            datas.put(key, value);
        } else {
            datas.clear();//TODO remove最早的10条
        }
        
    }
    
    public Object getCache(String key){
        return datas.get(key);
    }
}