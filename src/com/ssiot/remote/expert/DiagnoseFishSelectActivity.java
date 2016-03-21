package com.ssiot.remote.expert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ssiot.remote.BrowserActivity;
import com.ssiot.remote.HeadActivity;
import com.ssiot.remote.R;

public class DiagnoseFishSelectActivity extends HeadActivity{
    private static final String tag = "DiagnoseFishSelectActivity";
    String[] mItems;
    int[] mIntItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_select);
        mItems = getResources().getStringArray(R.array.fishes);
        mIntItems = getResources().getIntArray(R.array.fishes_int);
        initList();
    }
    
    private void initList(){
        ListView listView = (ListView) findViewById(R.id.fish_select_list);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mItems));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(DiagnoseFishSelectActivity.this, BrowserActivity.class);
//                i.putExtra("dieaseextra", "/GetContent/"+ mIntItems[position]);
                i.putExtra("url", "http://www.adds.org.cn/SelfDiagnosis/GetContent/" + mIntItems[position]);
                startActivity(i);
            }
        });
    }
    
}