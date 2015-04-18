package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * ��Ҫ�����첽��Ϣ����������ʹ��
 * Handler�����´���һ���߳�,������ռ���߳������߳���ִ��.
 * @author Administrator
 *
 */
public class HandlerActivity extends Activity {

	private Button startbutton = null;

	private Button endbutton = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		startbutton = (Button) this.findViewById(R.id.startbutton);
		endbutton = (Button) this.findViewById(R.id.endbutton);
		// Ϊ��ť�ؼ����Ӽ�����
		startbutton.setOnClickListener(new StartButtonListener());
		endbutton.setOnClickListener(new EndButtonListener());

	}

	class StartButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			handler.post(thread);
		}
	}

	class EndButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			handler.removeCallbacks(thread);
		}
	}
	
	
	Handler handler = new Handler(){
		
		
	};
	
	Runnable thread = new Runnable(){

		@Override
		public void run() {
			System.out.println("Handler invoked methods...");
			handler.postDelayed(thread, 3000);//����ǰ�߳����ӵ��̶߳�����,�ӳ�3��ִ��
		}
	};
}














