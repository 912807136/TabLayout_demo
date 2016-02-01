package com.gavin.demo_tablayout;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private TabPageIndicatorAdapter adapter;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView2();
	}

	private void initView2() {
		tabLayout = (TabLayout) findViewById(R.id.tablayout);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setOffscreenPageLimit(5);
		adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
		adapter.setData(getCategories());
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
		
//		tabLayout.setBackgroundColor(0xffeeeeee);
//		tabLayout.setTabTextColors(Color.BLACK, Color.RED);// 设置文本在选中和为选中时候的颜色
//		tabLayout.addTab(tabLayout.newTab().setText("第一个"), true);// 添加 Tab,默认选中
//		tabLayout.addTab(tabLayout.newTab().setText("第二个"), false);// 添加Tab,默认不选中
//		// 添加 Tab,默认不选中
//		tabLayout.addTab(tabLayout.newTab().setText("第三个"), false);
//		tabLayout.addTab(tabLayout.newTab().setText("第四个"), false);
	}

	private List<Category> getCategories() {
		ArrayList<Category> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Category category = new Category();
			category.setName("item "+i);
			if (i==2) {
				category.setName("item "+20000);
			}
			category.setId(i);
			list.add(category);
		}
		return list;
	}

}
