package com.oi.oiview;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;

import com.oi.library.util.OiView;
import com.oi.library.view.OiButton;
import com.oi.library.view.OiTextView;
import com.oi.oiview.R;

/**
 * <p>
 * Title: OiDialog.java
 * </p>
 * 
 * @author ansion
 * @version 1.0 创建时间：2015-4-1
 */
public class OiDialog extends DialogFragment {

	public OiDialog() {
	}

	Dialog oiDialog;
	OiTextView oiTextView;
	OiButton oiButton;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		if (oiDialog == null) {
			oiDialog = new Dialog(getActivity(), R.style.cart_dialog);
			oiDialog.setContentView(R.layout.dialog_match);
			oiDialog.setCanceledOnTouchOutside(true);
			oiDialog.getWindow().setGravity(Gravity.CENTER);
			View view = oiDialog.getWindow().getDecorView();
			oiTextView = (OiTextView) view.findViewById(R.id.OiTextView);
			oiTextView.setInTime(0.2f);
			oiTextView.setOutTime(0.2f);
			oiTextView.setTextColor(Color.RED);
			oiTextView.setOiOutListener(new OiView.OiOutListener() {
				@Override
				public void onBegin() {

				}

				@Override
				public void onProgressUpdate(float progress) {
				}

				@Override
				public void onFinish() {
					OiDialog.super.onStop();
				}
			});

			oiButton = (OiButton) view.findViewById(R.id.OiButton);
			oiButton.setInTime(0.2f);
			oiButton.setOutTime(0.2f);
			oiButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					oiButton.hide();
					oiTextView.hide();
				}
			});
		}
		return oiDialog;
	}

}
