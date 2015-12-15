package com.ssiot.remote.dahuavideo;
import java.io.UnsupportedEncodingException;

import android.util.Log;
import android.widget.Toast;
import android.content.Context;

import com.company.NetSDK.FinalVar;
import com.company.NetSDK.INetSDK;

public class ToolKits {
    public static void showMessage(Context context , String strLog)
    {
    	Toast.makeText(context, strLog, Toast.LENGTH_SHORT).show();
    }

    public static void showErrorMessage(Context context , String strLog)
    {
    	Toast.makeText(context, strLog + 
    		String.format(" [%x]" , INetSDK.GetLastError()),
    		Toast.LENGTH_SHORT).show();
    }

    public static void writeLog(String strLog)
    {
    	Log.d("NetSDK Demo", strLog);
    }
    
    public static void writeErrorLog(String strLog)
    {
    	Log.d("NetSDK Demo", strLog +
    		String.format(" Last Error Code [%x]" , INetSDK.GetLastError()) );
    }
    
    public static boolean SetDevConfig(String strCmd ,  Object cmdObject , long hHandle , int nChn , int nBufferLen )
    {
        boolean result = false;
    	Integer error = new Integer(0);
    	Integer restart = new Integer(0);
        char szBuffer[] = new char[nBufferLen];
        for(int i=0; i<nBufferLen; i++)szBuffer[i]=0;
        
        if(INetSDK.PacketData(strCmd, cmdObject, szBuffer, nBufferLen))
        {
        	if( INetSDK.SetNewDevConfig(hHandle,strCmd , nChn , szBuffer, nBufferLen, error, restart, 10000))
        	{
        		result = true;
        	}
        	else
        	{
        		writeErrorLog("Set " + strCmd + " Config Failed!");
             	result = false;
        	}
        }
        else
        {
        	writeErrorLog("Packet " + strCmd + " Config Failed!");
         	result = false;
        }
        
        return result;
    }
    
    public static boolean GetDevConfig(String strCmd ,  Object cmdObject , long hHandle , int nChn , int nBufferLen)
    {
        boolean result = false;
    	Integer error = new Integer(0);
        char szBuffer[] = new char[nBufferLen];
         
        if(INetSDK.GetNewDevConfig( hHandle, strCmd , nChn, szBuffer,nBufferLen,error,10000) )
        {  
         	if( INetSDK.ParseData(strCmd ,szBuffer , cmdObject , null ) )
         	{
         		result = true;
         	}
         	else
         	{
         		writeErrorLog("Parse " + strCmd + " Config Failed!");
         		result = false;
         	}
         }
         else
         {
        	 writeErrorLog("Get" + strCmd + " Config Failed!");
        	 result = false;
         }
        return result;
    }
    
	public static String CharArrayToString(char[] szIn , String strMode){
		try {		
			byte[] tmpByte = new byte[FinalVar.SDK_USER_NAME_LENGTH_EX];
			for( int i=0 ; i<szIn.length ; i++)
			{
				tmpByte[i] = (byte) szIn[i];
			}
			
			return new String(tmpByte , strMode);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static char[] StringToCharArray(String strIn, String strMode) {
		try {
			byte[] tempByte = strIn.getBytes(strMode);
			char[] cOut = new char[FinalVar.SDK_USER_NAME_LENGTH_EX];
			for (int i = 0; i < tempByte.length; i++) {
				cOut[i] = (char)tempByte[i];
			}
			return cOut;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
}
