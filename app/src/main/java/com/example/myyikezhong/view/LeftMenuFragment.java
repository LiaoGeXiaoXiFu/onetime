package com.example.myyikezhong.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myyikezhong.R;

import java.util.ArrayList;
import java.util.List;

public class LeftMenuFragment extends Fragment {

	private List<LeftMenu> list = null;
    private ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//根据下标来设置不同的点击事件
				if(position == 0)
				{
					Intent intent = new Intent();
					startActivity(intent);
				}
				if(position == 1)
				{
					Intent intent = new Intent();
					startActivity(intent);
				}
				if(position == 2)
				{
					Intent intent = new Intent();
					startActivity(intent);
				}
				if(position == 3)
				{
					Intent intent = new Intent();
					startActivity(intent);
				}
				if(position == 4)
				{
					Intent intent = new Intent();
					startActivity(intent);
				}
				if(position == 5)
				{
					Intent intent = new Intent();
					startActivity(intent);
				}
			}
		});
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
		View view = inflater.inflate(R.layout.left_menu, container, false);
		lv = (ListView) view.findViewById(R.id.left_menu_lv);
		LeftMenuAdapter adapter = new LeftMenuAdapter(list);
		lv.setAdapter(adapter);
		return view;
	}
}