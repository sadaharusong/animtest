package com.example.animtest;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private int[] res = {R.id.imageView_a,R.id.imageView_b,R.id.imageView_c,R.id.imageView_d,
			R.id.imageView_e,R.id.imageView_f,R.id.imageView_g,R.id.imageView_h};
	private List<ImageView> imageViewList = new ArrayList<ImageView>();
	private boolean flag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < res.length; i++) {
			ImageView imageView = (ImageView) findViewById(res[i]);
			imageView.setOnClickListener(this);
			imageViewList.add(imageView);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageView_h:
			if (flag == true) {
				startAnim();
			}
			else {
				closeAnim();
			}
			break;
		default:
			Toast.makeText(MainActivity.this, "别点我，疼", Toast.LENGTH_LONG).show();
			break;
		
		}
	}

	private void closeAnim() {
		// TODO Auto-generated method stub
		for (int i = 0; i < res.length - 1; i++) {
			ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),
					"translationY", i* 150  ,  0F);
			animator.setDuration(500);
			animator.setStartDelay(i*300);
			animator.start();
			flag = true;
		}
	}

	private void startAnim() {
		// TODO Auto-generated method stub
		for (int i = 0; i < res.length - 1; i++) {
			ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),
					"translationY", 0F  ,  i * 150);
			animator.setDuration(500);
			animator.setInterpolator(new BounceInterpolator());   //插值器
			animator.setStartDelay(i*300);
			animator.start();
			flag = false;
		}
	}
	
}
