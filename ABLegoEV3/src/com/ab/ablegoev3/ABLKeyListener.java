package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.KeyListener;

@Author("Alain Bailleul")      
@ShortName("ABLKeyListener")  
public class ABLKeyListener {
	protected KeyListener inner;
	
	public void KeyPressed (ABLKey key) {
		inner.keyPressed(key.inner);
	}
	
	public void KeyReleased (ABLKey key) {
		inner.keyReleased(key.inner);
	}
}
