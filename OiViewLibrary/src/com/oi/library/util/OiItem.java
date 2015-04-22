package com.oi.library.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.Random;

/**
 * 字母闪现动画效果
 * @author ansion
 *
 */
public class OiItem extends Animation {

	public PointF midPoint;
	public float translationX;
	public int index;

	private final Paint paint = new Paint();
	private float fromAlpha = 1.0f;
	private float toAlpha = 0.4f;
	private PointF cStartPoint;
	private PointF cEndPoint;

	public OiItem(int index, PointF start, PointF end, int color, int lineWidth) {
		this.index = index;

		midPoint = new PointF((start.x + end.x) / 2, (start.y + end.y) / 2);

		cStartPoint = new PointF(start.x - midPoint.x, start.y - midPoint.y);
		cEndPoint = new PointF(end.x - midPoint.x, end.y - midPoint.y);

		setColor(color);
		setLineWidth(lineWidth);
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.STROKE);
	}

	public void setLineWidth(int width) {
		paint.setStrokeWidth(width);
	}

	public void setColor(int color) {
		paint.setColor(color);
	}

	public void resetPosition(int horizontalRandomness) {
		Random random = new Random();
		int randomNumber = -random.nextInt(horizontalRandomness) + horizontalRandomness;
		translationX = randomNumber;
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		float alpha = fromAlpha;
		alpha = alpha + ((toAlpha - alpha) * interpolatedTime);
		setAlpha(alpha);
	}

	public void start(float fromAlpha, float toAlpha) {
		this.fromAlpha = fromAlpha;
		this.toAlpha = toAlpha;
		super.start();
	}

	public void setAlpha(float alpha) {
		paint.setAlpha((int) (alpha * 255));
	}

	public void draw(Canvas canvas) {
		canvas.drawLine(cStartPoint.x, cStartPoint.y, cEndPoint.x, cEndPoint.y, paint);
	}
}