# TabLayout_demo
实现ViewPager的indicator功能<br>
![image](http://img.blog.csdn.net/20160201183000866?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
<br>
下面简单讲讲它的用法：
activity_main:
```java
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${relativePackage}.${activityClass}" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#fff"
        android:orientation="vertical" >

        <android.support.design.widget.TabLayout
            android:id="@+id/tablayout"
            style="@style/MyCustomTabLayout"
            android:layout_width="match_parent"
            android:layout_height="38dp"
            android:background="#eee"
            app:tabGravity="center"
            app:tabIndicatorColor="#FFff0000"
            app:tabMode="scrollable"
            app:tabSelectedTextColor="#FFff0000"
            app:tabTextColor="#FF666666" />

        <android.support.v4.view.ViewPager
            android:id="@+id/pager"
            android:layout_width="fill_parent"
            android:layout_height="match_parent"
            android:layout_marginTop="1dp" />
    </LinearLayout>

</RelativeLayout>
```
这个跟以前ViewPager+ViewPageIndicator布局相似<br>
MainActivity的代码：
```java
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
//		viewPager.setOffscreenPageLimit(5);
		adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
		adapter.setData(getCategories());
		viewPager.setAdapter(adapter);
		```
		
值得注意的是通过 TabLayout.setupWithViewPager(viewPager);来设置TabLayout于ViewPager的关联.<br>
TabPageIndicatorAdapter的代码如下：

```java
package com.gavin.demo_tablayout;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPageIndicatorAdapter extends FragmentPagerAdapter {
	private List<Category> categories;

	public TabPageIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setData(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new MyFragment();
		Bundle args = new Bundle();
		args.putString(MyFragment.NAME, categories.get(position).getName());
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return categories.get(position % categories.size()).getName();
	}

	@Override
	public int getCount() {
		return categories == null ? 0 : categories.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

}
```
