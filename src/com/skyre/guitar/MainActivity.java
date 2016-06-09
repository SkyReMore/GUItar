package com.skyre.guitar;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	private TouchScreen tScr;
	private View.OnTouchListener tListener;
	private GtSoundPlayer sPlayer;
	private Display display;
	private Point scrSize;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//LayoutInflater linf = new getLayoutInflater();
		//setContentView(R.layout.main);
		tScr = new TouchScreen(this);
		display = getWindowManager().getDefaultDisplay();
		scrSize = new Point();
		display.getSize(scrSize);
		//tScr.setZOrderOnTop(true);
		setContentView(tScr);
		sPlayer = new GtSoundPlayer(this);
		//addContentView(tScr, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
	}

	@Override
	public boolean onTouchEvent(final MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			float x = event.getX() / scrSize.x;
			float y = event.getY() / scrSize.y;
			Log.v("Sound", x + " " + y);
			sPlayer.playSound(y, 0.5f + x * 1.5f);
			return true;
		}
		return false;
	}
}