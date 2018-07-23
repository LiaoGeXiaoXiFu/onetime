package com.example.wsnbb.view;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wsnbb.MainActivity;
import com.example.wsnbb.MyApp;
import com.example.wsnbb.R;
import com.example.wsnbb.page.login.LoginActivity;
import com.example.wsnbb.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

public class LeftMenuFragment extends Fragment {

	private List<LeftMenu> list = null;
    private ListView lv;
	private ImageView img;
	private TextView tv_name;
	private TextView tv_signature;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();

	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		list = new ArrayList<LeftMenu>();
		list.add(new LeftMenu(R.drawable.raw_1499933216, "我的关注"));
		list.add(new LeftMenu(R.drawable.raw_1499947358, "我的收藏"));
		list.add(new LeftMenu(R.drawable.raw_1499946865, "搜索好友"));
		list.add(new LeftMenu(R.drawable.raw_1499947389, "消息通知"));
		list.add(new LeftMenu(R.drawable.xiangce, "夜间模式"));
		list.add(new LeftMenu(R.drawable.wenjian, "我的文件"));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.left_menu, container, false);
		lv = (ListView) view.findViewById(R.id.left_menu_lv);
		img = view.findViewById(R.id.heart_img);
		tv_name = view.findViewById(R.id.tv_name);
		tv_signature = view.findViewById(R.id.tv_signature);
		//头像的点击事件，跳转到登录
		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyApp.context, LoginActivity.class);
				startActivity(intent);
			}
		});
		String uid = (String) SharedPreferencesUtils.getParam(MyApp.context, "uid", "-1");
		String name = (String) SharedPreferencesUtils.getParam(MyApp.context, "name", "");
		String iconUrl = (String) SharedPreferencesUtils.getParam(MyApp.context, "iconUrl", "");
		if ("-1".equals(uid)){
			//return;
		}else{
			tv_name.setText(name);
			img.setImageURI(Uri.parse(iconUrl));
		}

		LeftMenuAdapter adapter = new LeftMenuAdapter(list);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//根据下标来设置不同的点击事件
				switch (position){
					case 0 :
						Toast.makeText(MyApp.context,"点击了"+position,Toast.LENGTH_SHORT).show();
						break;
					case 1 :
						Toast.makeText(MyApp.context,"点击了"+position,Toast.LENGTH_SHORT).show();
						break;
					case 2 :
						Toast.makeText(MyApp.context,"点击了"+position,Toast.LENGTH_SHORT).show();
						break;
					case 3 :
						Toast.makeText(MyApp.context,"点击了"+position,Toast.LENGTH_SHORT).show();
						break;
					case 4 ://夜间模式
						Toast.makeText(MyApp.context,"夜间模式"+position,Toast.LENGTH_SHORT).show();
						break;
					case 5 ://我的文件
						Toast.makeText(MyApp.context,"点击了"+position,Toast.LENGTH_SHORT).show();
						break;
				}
			}
		});
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}