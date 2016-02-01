package com.gavin.demo_tablayout;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private TabPageIndicatorAdapter adapter;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		tabLayout = (TabLayout) findViewById(R.id.tablayout);
		viewPager = (ViewPager) findViewById(R.id.pager);
//		viewPager.setOffscreenPageLimit(5);
		adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
		adapter.setData(getCategories());
		viewPager.setAdapter(adapter);
		//设置TabLayout于ViewPager的关联
		tabLayout.setupWithViewPager(viewPager);
	}

	private List<Category> getCategories() {
		ArrayList<Category> list = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Category category = new Category();
			category.setName("选项 "+i);
			category.setId(i);
			list.add(category);
		}
		return list;
	}

}
