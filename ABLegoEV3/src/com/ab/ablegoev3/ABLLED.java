package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.LED;

@Author("Alain Bailleul")      
@ShortName("ABLLED")  
public class ABLLED {
	protected LED inner;
	
	public ABLLED(LED led) {
		inner = led;
	}
	
	public void setPattern(int pattern) {
		inner.setPattern(pattern);
	}
}
