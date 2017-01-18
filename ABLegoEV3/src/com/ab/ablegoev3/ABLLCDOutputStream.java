package com.ab.ablegoev3;

import java.io.OutputStream;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.LCDOutputStream;

@Author("Alain Bailleul")      
@ShortName("ABLLCDOutputStream")
public class ABLLCDOutputStream extends OutputStream {
	protected LCDOutputStream inner;
	
	public void Initialize2(ABLTextLCD lcd) {
	    inner = new LCDOutputStream(lcd.inner);
	}
	
	public void Initialize()
	{
		inner = new LCDOutputStream(BrickFinder.getDefault().getTextLCD());
	}
	
	@Override
	public void write(int c) {
		inner.write(c);		
	}	
}
