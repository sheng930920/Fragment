package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private ViewPager mPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragment;

	private LinearLayout tab1;
	private LinearLayout tab2;
	private LinearLayout tab3;
	private LinearLayout tab4;

	private ImageButton img1;
	private ImageButton img2;
	private ImageButton img3;
	private ImageButton img4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		init();
		setSelet(0);
	}

	private void init() {

		mPager = (ViewPager) findViewById(R.id.viewpager);

		tab1 = (LinearLayout) findViewById(R.id.tab1);
		tab2 = (LinearLayout) findViewById(R.id.tab2);
		tab3 = (LinearLayout) findViewById(R.id.tab3);
		tab4 = (LinearLayout) findViewById(R.id.tab4);

		img1 = (ImageButton) findViewById(R.id.img1);
		img2 = (ImageButton) findViewById(R.id.img2);
		img3 = (ImageButton) findViewById(R.id.img3);
		img4 = (ImageButton) findViewById(R.id.img4);

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		tab4.setOnClickListener(this);

		mFragment = new ArrayList<Fragment>();
		Fragment mTab1 = new Tab1();
		Fragment mTab2 = new Tab2();
		Fragment mTab3 = new Tab3();
		Fragment mTab4 = new Tab4();
		mFragment.add(mTab1);
		mFragment.add(mTab2);
		mFragment.add(mTab3);
		mFragment.add(mTab4);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mFragment.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return mFragment.get(arg0);
			}
		};
		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			public void onPageSelected(int arg0) {
				int Item =mPager.getCurrentItem();
				setTab(Item);
			}
			
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onClick(View v) {
		resetImage();
		switch (v.getId()) {
		case R.id.tab1:
			setSelet(0);
			break;
		case R.id.tab2:
			setSelet(1);
			break;
		case R.id.tab3:
			setSelet(2);
			break;
		case R.id.tab4:
			setSelet(3);
			break;

		default:
			break;
		}
	}

	/**
	 * 把图片、文字换成亮色，切换内容
	 */
	private void setSelet(int i) {
		setTab(i);
		mPager.setCurrentItem(i);

	}

	private void setTab(int i) {
		resetImage();
		switch (i) {
		case 0:
			img1.setImageResource(R.drawable.b1);

			break;
		case 1:
			img2.setImageResource(R.drawable.b2);
			break;
		case 2:
			img3.setImageResource(R.drawable.b3);
			break;
		case 3:
			img4.setImageResource(R.drawable.b4);
			break;

		}
	}

	/**
	 * 重置图片，把所有图片、文字换成暗色
	 * 
	 */

	private void resetImage() {
		img1.setImageResource(R.drawable.a1);
		img2.setImageResource(R.drawable.a2);
		img3.setImageResource(R.drawable.a3);
		img4.setImageResource(R.drawable.a4);

	}

}
