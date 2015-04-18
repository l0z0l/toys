package com.fatyu.activity;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.fatyu.R;
import com.fatyu.handler.XMLHandler;
import com.fatyu.model.Mp3Bean;
import com.fatyu.service.DownloadMp3Service;
import com.fatyu.util.HttpDownloader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * 主页面-->服务器mp3列表
 * 
 * @author Fatyu
 * 
 */
public class Mp3PlayerActivity extends ListActivity {
	private final static String TAG = "Mp3PlayerActivity";
	private List<Mp3Bean> mp3Beans = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remote_mp3_list);
		updateMp3List();
	}

	/**
	 * 重写父类的菜单创建方法
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, R.string.mp3list_update);
		menu.add(0, 2, 2, R.string.mp3list_about);
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * 
	 * 点击按钮出发事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			// Log.i(tag, "更新列表被点击");
			updateMp3List();
		} else {
			Toast.makeText(Mp3PlayerActivity.this,
					R.string.mp3list_about_string, 1).show();
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * @method 下载xml文件转储至string 下载更新列表--xml字符串
	 * 
	 * @param url
	 * @return
	 */
	private String downloadXML(String url) {
		HttpDownloader hd = new HttpDownloader();
		String result = hd.download(url);
		return result;
	}

	/**
	 * @method 解析xml字符串 解析xml字符串<br/>
	 *         调用回调函数进行xml字符串的解析
	 * @param xmlstr
	 */
	@SuppressWarnings("rawtypes")
	private List<Mp3Bean> parse(String xmlstr) {
		List<Mp3Bean> mp3s = new ArrayList<Mp3Bean>();// 实例化一个arraylist存放mp3实体对象
		SAXParserFactory saxParseFactory = SAXParserFactory.newInstance();
		try {
			XMLReader xmlReader = saxParseFactory.newSAXParser().getXMLReader();
			xmlReader.setContentHandler(new XMLHandler(mp3s));
			xmlReader.parse(new InputSource(new StringReader(xmlstr)));
			for (Iterator iterator = mp3s.iterator(); iterator.hasNext();) {
				Mp3Bean mp3Bean = (Mp3Bean) iterator.next();
				Log.i(TAG, mp3Bean.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mp3s;
	}

	/**
	 * ListView 列表被点击触发事件
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// 1.将mp3的信息对象传递给service
		// 2.设置intent的服务类
		// 3.启动service
		Mp3Bean mp3Bean = mp3Beans.get(position);
		// Log.i(TAG, id+"list was selected...");
		// Toast.makeText(Mp3PlayerActivity.this,
		// mp3Beans.get(position).getMp3Name()+" is playing...", 0).show();
		Intent intent = new Intent();
		intent.putExtra("mp3bean", mp3Bean);
		intent.setClass(this, DownloadMp3Service.class);
		startService(intent);
	}

	/**
	 * @refactor 更新mp3列表
	 */
	private void updateMp3List() {
		String xml = downloadXML("http://10.79.76.42:8080/music/resources.xml");// 不能使用127.0.0.1作为ip地址
		Log.i(TAG, xml);
		// 对xml文件进行解析，并将解析的结果放置到Mp3Info对象当中，最后将这些Mp3Info对象放置到List当中
		mp3Beans = parse(xml);
		SimpleAdapter simpleAdapter = buildSimpleAdapter(mp3Beans);
		setListAdapter(simpleAdapter);
	}

	/**
	 * 构建SimpleAdapter
	 * 
	 * @param mp3bean
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private SimpleAdapter buildSimpleAdapter(List<Mp3Bean> mp3bean) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();// 用于存储mp3的名称和大小map
		for (Iterator iterator = mp3bean.iterator(); iterator.hasNext();) {
			Mp3Bean mp3Info = (Mp3Bean) iterator.next();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("mp3_name", mp3Info.getMp3Name());
			map.put("mp3_size", mp3Info.getMp3Size());
			list.add(map);
		}
		SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.mp3info,
				new String[] { "mp3_name", "mp3_size" }, new int[] {
						R.id.mp3_name, R.id.mp3_size });
		return sa;
	}

}
