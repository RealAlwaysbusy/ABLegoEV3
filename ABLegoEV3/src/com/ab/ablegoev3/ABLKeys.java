package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.Keys;

@Author("Alain Bailleul")      
@ShortName("ABLKeys")  
public class ABLKeys {
	protected Keys inner;
	
	public static final int ID_UP = 0x1;
	public static final int ID_ENTER = 0x2;
	public static final int ID_DOWN = 0x4;
	public static final int ID_RIGHT = 0x8;
	public static final int ID_LEFT = 0x10;
	public static final int ID_ESCAPE = 0x20;
	public static final int ID_ALL = 0x3f;
	
	public static int NUM_KEYS = 6;

	public static final String VOL_SETTING = "lejos.keyclick_volume";
	public static final String LEN_SETTING = "lejos.keyclick_length";
	public static final String FREQ_SETTING = "lejos.keyclick_frequency";
	
	public ABLKeys(Keys keys) {
		inner = keys;
	}
	
	public void DiscardEvents() {
		inner.discardEvents();
	}
	
	public int WaitForAnyEvent() {
		return inner.waitForAnyEvent();
	}
	
	public int WaitForAnyEvent2(int timeout) {
		return inner.waitForAnyEvent(timeout);
	}
	
	public int WaitForAnyPress() {
		return inner.waitForAnyPress();
	}
	
	public int WaitForAnyPress2(int timeout) {
		return inner.waitForAnyPress(timeout);
	}
	
		
	public int getButtons() {
		return inner.getButtons();
	}
	
	public int ReadButtons() {
		return inner.readButtons();
	}
	
	public void setKeyClickVolume(int vol) {
		inner.setKeyClickVolume(vol);		
	}
	
	public int getKeyClickVolume() {
		return inner.getKeyClickVolume();
	}
	
	public void setKeyClickLength(int len) {
		inner.setKeyClickLength(len);
	}
	
	public int getKeyClickLength() {
		return inner.getKeyClickLength();
	}
	
	public void setKeyClickTone(int key, int freq) {
		inner.setKeyClickTone(key, freq);
	}
	
	public int getKeyClickTone(int key) {
		return inner.getKeyClickTone(key);
	}
}
