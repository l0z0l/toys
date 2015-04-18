package com.fatyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 主视图——java类
 * 
 * @author Fatyu
 * 
 */
public class ActivityMain extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);// 解析main.xml进行视图的创建
		// 文本视图创建
		// TextView tv = new TextView(this);
		// tv.setText("Hello android");
		// setContentView(tv);
		find_and_modify_button();
	}

	private void find_and_modify_button() {
		// 按钮
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(button_listener);
		// 启动新视图(文本)按钮
		Button text_view_button = (Button) findViewById(R.id.text_view_button);
		text_view_button.setOnClickListener(text_view_button_listener);

		// 启动新视图(可编辑文本)按钮
		Button edittext_view_button = (Button) findViewById(R.id.edittext_view_button);
		edittext_view_button.setOnClickListener(edittext_view_button_listener);

		// 启动新视图(多选框)按钮
		Button checkbox = (Button) findViewById(R.id.checkbox_button);
		checkbox.setOnClickListener(checkbox_button_listener);

		// 启动新视图(单选按钮)按钮
		Button radio = (Button) findViewById(R.id.radio_button);
		radio.setOnClickListener(radio_button_listener);

		// 启动新视图(下拉列表)按钮
		Button select = (Button) findViewById(R.id.select_button);
		select.setOnClickListener(select_view_button_listener);
		// 启动新视图(自动填补文本框)按钮
		Button autocomplete = (Button) findViewById(R.id.autocompletetext_button);
		autocomplete.setOnClickListener(autocomplete_view_button_listener);

		// 启动新视图(日期选择器)按钮
		Button datepicker = (Button) findViewById(R.id.date_picker_button);
		datepicker.setOnClickListener(date_picker_view_button_listener); 
		// 启动新视图(时间选择器)按钮
		Button timepicker = (Button) findViewById(R.id.time_picker_button);
		timepicker.setOnClickListener(time_picker_view_button_listener);
	}

	private Button.OnClickListener button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			setTitle("HL_ZHANGYU");
		}
	};
	private Button.OnClickListener text_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, TextViewActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener edittext_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, EditTextActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener checkbox_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, CheckboxActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener radio_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, RadioActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener select_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, SpinnerViewActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener autocomplete_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this,
					AutoCompleteTextViewActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener date_picker_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, DatePickerViewActivity.class);
			startActivity(intent);
		}
	};
	private Button.OnClickListener time_picker_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, TimePickerViewActivity.class);
			startActivity(intent);
		}
	};
}