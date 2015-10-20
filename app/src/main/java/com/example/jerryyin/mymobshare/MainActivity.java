package com.example.jerryyin.mymobshare;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


public class MainActivity extends ActionBarActivity {

    private Button mbtnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSdk();
        setupViews();
    }

    private void initSdk() {
        //初始化sdk
        ShareSDK.initSDK(getApplicationContext());
    }

    private void setupViews() {
        mbtnShare = (Button) findViewById(R.id.btn_share);
        mbtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare onekeyShare = new OnekeyShare();
                // 分享时Notification的图标和文字
                onekeyShare.setTitle("MymMobShare分享");
                onekeyShare.setText("用我的技术，为我自己代言！");
//                onekeyShare.setImagePath("/Users/JerryYin/Desktop/img.ipg");
                onekeyShare.show(MainActivity.this);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
