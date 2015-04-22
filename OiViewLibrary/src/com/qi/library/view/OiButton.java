package com.qi.library.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.qi.library.util.OiPath;


/**
 * Description:OiButton View
 * User: ansion
 * Date: 2015-4-01
 */
public class OiButton extends OiTextView {

	public OiButton(Context context) {
		super(context);
		init();
	}

	public OiButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public OiButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	void init() {
		PraseText();
		super.init();
	}

	void PraseText() {
		if (!TextUtils.isEmpty(content)) {
			OiPath.isButtonModle = true;
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append(OiPath.V_LEFT);
			strBuffer.append(content);
			strBuffer.append(OiPath.V_RIGHT);
			this.content = strBuffer.toString();
		}
	}
}
