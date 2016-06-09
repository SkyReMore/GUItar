package com.skyre.guitar;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

/**
 * Created by Avtopalm on 08.06.2016.
 */
public class GtSoundPlayer {
	private SoundPool soundPool;
	public GtSoundPlayer(Activity act) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			soundPool = new SoundPool.Builder().setMaxStreams(6).build();
		}
		else
			soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
		Context cont = act;
		soundPool.load(cont, R.raw.template, 1);
	}

	public void playSound(float vol, float pitch) {

		soundPool.play(1, vol, vol, 0, 0, pitch);
	}
}
