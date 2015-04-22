package com.qi.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.qi.library.util.OiView;
import com.qi.oiviewlibrary.R;


/**
 * Description:OiTextView
 * User: ansion
 * Date: 2015-4-01
 */
public class OiTextView extends OiView {

	/**
	 * 内容
	 */
	String content;
	float textSize;
	int textColor;

	public OiTextView(Context context) {
		super(context);
		init();
	}

	public OiTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttrs(attrs);
	}

	public OiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initAttrs(attrs);
	}

	void initAttrs(AttributeSet attrs) {
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.oi);
		// 获取尺寸属性值,默认大小为：25
		textSize = a.getDimension(R.styleable.oi_textSize, 25);
		// 获取颜色属性值,默认颜色为：Color.WHITE
		textColor = a.getColor(R.styleable.oi_textColor, Color.WHITE);
		// 获取内容
		content = a.getString(R.styleable.oi_text);
		init();
	}

	void init() {
		this.setBackgroundColor(Color.TRANSPARENT);
		if (!TextUtils.isEmpty(content)) {
			setTextColor(textColor);
			setTextSize(textSize);
			initWithString(content);
			show();
		}
	}

	public void setText(String text) {
		this.content = text;
		init();
	}

}
