package com.oi.oiview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.SeekBar;

import com.oi.library.view.OiTextView;
import com.oi.oiview.R;

/**
 * <p>
 * Title: MainActivity.java
 * </p>
 * 
 * @author ansion
 * @version 1.0 创建时间：2015-1-4 下午4:18:49
 */
public class MainActivity extends FragmentActivity {
	private SeekBar oiSeekBar;
	private OiTextView oiTextView;
	private OiTextView oiTextView1;
	private OiTextView oiTextView2;
	private OiTextView oiTextView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		oiTextView = (OiTextView) findViewById(R.id.OiTextView);
		oiTextView1 = (OiTextView) findViewById(R.id.OiTextView1);
		oiTextView2 = (OiTextView) findViewById(R.id.OiTextView2);
		oiTextView3 = (OiTextView) findViewById(R.id.OiTextView3);

		oiSeekBar = (SeekBar) findViewById(R.id.OiSeekBar);
		oiSeekBar.setProgress(100);
		oiSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				oiTextView.setProgress(progress * 1f / 100);
				oiTextView1.setProgress(progress * 1f / 100);
				oiTextView2.setProgress(progress * 1f / 100);
				oiTextView3.setProgress(progress * 1f / 100);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		findViewById(R.id.OiButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OiDialog oiDialog = new OiDialog();
				getSupportFragmentManager().beginTransaction().add(oiDialog, "OiDialog").commit();
			}
		});
	}
}
