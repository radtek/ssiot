package com.ssiot.remote.expert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.ssiot.remote.R;

public class DiagnoseFishSelectActivity extends ActionBarActivity{
    private static final String tag = "DiagnoseFishSelectActivity";
    Spinner mFishSelectSpin;
    TextView mFishSelectText;
    String[] mItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_select);
        mItems = getResources().getStringArray(R.array.fishes);
        mFishSelectSpin = (Spinner) findViewById(R.id.fish_select);
        
        mFishSelectText = (TextView) findViewById(R.id.fish_select_text);
        
        mFishSelectText.setText(mItems[0]);
        registerForContextMenu(mFishSelectText);
        mFishSelectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(mFishSelectText);
            }
        });
        initSpinner();
//        registerForContextMenu(mFishSelectSpin);
        
        TextView btn = (TextView) findViewById(R.id.btn_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DiagnoseFishSelectActivity.this, DiagnoseFishActivity.class);
                startActivity(i);
            }
        });
    }
    
    private void initSpinner(){
        String[] mItems = getResources().getStringArray(R.array.fishes);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
        mFishSelectSpin.setAdapter(typeAdapter);
        mFishSelectSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        
        menu.setHeaderTitle("选择水生动物");
        for (int i = 0 ;i < mItems.length; i ++){
            menu.add(0, i+1, Menu.NONE, mItems[i]);
        }
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        mFishSelectText.setText(item.getTitle());
        return super.onContextItemSelected(item);
    }
    
}