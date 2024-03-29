package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {
	public static final int ITEM0 = Menu.FIRST;
	public static final int ITEM1 = Menu.FIRST + 1;
	Button button1;
	Button button2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button1 = (Button) findViewById(R.id.button);
		button2 = (Button) findViewById(R.id.button_02);
		button1.setVisibility(View.INVISIBLE);
		button2.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, ITEM0, 0, "按钮01");
		menu.add(0, ITEM1, 1, "按钮02");
		menu.add(0, ITEM1, 1, "按钮03");
		menu.add(0, ITEM1, 1, "按钮04");
		menu.add(1, ITEM1, 1, "按钮05");
		menu.add(1, ITEM1, 1, "按钮06");
		menu.add(1, ITEM1, 1, "按钮07");
		menu.findItem(ITEM1);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ITEM0:
			actionClickMenuItem1();
			break;
		case ITEM1:
			actionClickMenuItem2();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void actionClickMenuItem1() {
		setTitle("button1 可见");
		button1.setVisibility(View.VISIBLE);
		button2.setVisibility(View.INVISIBLE);
	}

	/*
	 * 点击第二个个menu的第一个按钮执行的动作
	 */
	private void actionClickMenuItem2() {
		setTitle("button2 可见");
		button1.setVisibility(View.INVISIBLE);
		button2.setVisibility(View.VISIBLE);
	}

}