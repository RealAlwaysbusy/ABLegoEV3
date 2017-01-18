package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.Key;

@Author("Alain Bailleul")      
@ShortName("ABLKey")  
public class ABLKey {
	protected Key inner;
	
	public static final int UP = 0;
	public static final int ENTER = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int LEFT = 4;
	public static final int ESCAPE = 5;
	
	public static int KEY_RELEASED = 0;
	public static int KEY_PRESSED = 1;
	public static int KEY_PRESSED_AND_RELEASED = 2;
	
	public ABLKey(Key key) {
		inner = key;
	}
	
	public int getId() {
		return inner.getId();
	}
	
	public boolean IsDown() {
		return inner.isDown();
	}
	
	public boolean IsUp() {
		return inner.isUp();
	}
	
	public void WaitForPress() {
		inner.waitForPress();
	}
	
	public void WaitForPressAndRelease() {
		inner.waitForPressAndRelease();
	}
	
	public void AddKeyListener (ABLKeyListener listener) {
		inner.addKeyListener(listener.inner);
	}
	
	public void SimulateEvent(int event) {
		inner.simulateEvent(event);
	}
	
	public String getName() {
		return inner.getName();
	}
}