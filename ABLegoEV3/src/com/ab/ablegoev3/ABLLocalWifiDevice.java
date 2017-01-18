package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.LocalWifiDevice;

@Author("Alain Bailleul")      
@ShortName("ABLLocalWifiDevice")
public class ABLLocalWifiDevice {
	protected LocalWifiDevice inner;
	
	public ABLLocalWifiDevice(LocalWifiDevice localWifiDevice) {
		inner = localWifiDevice;
	}
		
	public String[] getAccessPointNames() {		
		return inner.getAccessPointNames();
	}
	
	public String getAccessPoint() {
		return inner.getAccessPoint();
	}
	
}
