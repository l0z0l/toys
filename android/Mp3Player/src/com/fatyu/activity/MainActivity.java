package com.fatyu.activity;

import com.fatyu.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * 主页面
 * @author Fatyu
 */
public class MainActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//本地列表
		Intent local = new Intent();
		local.setClass(this, LocalMp3ListActivity.class);
		//服务器列表
		Intent remote = new Intent();
		remote.setClass(this, Mp3PlayerActivity.class);
		//获得tab页对象
		TabHost tabhost = getTabHost();
		//获取系统的资源
		Resources res = getResources();
		//添加本地mp3listActivity
		TabHost.TabSpec localTabSpec = tabhost.newTabSpec("Local Mp3");
		localTabSpec.setContent(local);
		localTabSpec.setIndicator("Local Mp3", res.getDrawable(android.R.drawable.star_big_on));
		tabhost.addTab(localTabSpec);
		//添加服务器mp3listActivity
		TabHost.TabSpec remoteTabSpec = tabhost.newTabSpec("Remote Mp3");
		remoteTabSpec.setContent(remote);
		remoteTabSpec.setIndicator("Remote Mp3", res.getDrawable(android.R.drawable.star_big_off));
		tabhost.addTab(remoteTabSpec);
	}
}
