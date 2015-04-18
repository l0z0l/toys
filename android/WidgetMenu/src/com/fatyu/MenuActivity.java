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
		menu.add(0, ITEM0, 0, "��ť01");
		menu.add(0, ITEM1, 1, "��ť02");
		menu.add(0, ITEM1, 1, "��ť03");
		menu.add(0, ITEM1, 1, "��ť04");
		menu.add(1, ITEM1, 1, "��ť05");
		menu.add(1, ITEM1, 1, "��ť06");
		menu.add(1, ITEM1, 1, "��ť07");
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
		setTitle("button1 �ɼ�");
		button1.setVisibility(View.VISIBLE);
		button2.setVisibility(View.INVISIBLE);
	}

	/*
	 * ����ڶ�����menu�ĵ�һ����ťִ�еĶ���
	 */
	private void actionClickMenuItem2() {
		setTitle("button2 �ɼ�");
		button1.setVisibility(View.INVISIBLE);
		button2.setVisibility(View.VISIBLE);
	}

}