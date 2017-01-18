package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.RemoteBTDevice;

@Author("Alain Bailleul")      
@ShortName("ABLRemoteBTDevice")
public class ABLRemoteBTDevice {
	protected RemoteBTDevice inner;
	
	ABLRemoteBTDevice(RemoteBTDevice remoteBTDevice) {
		inner = remoteBTDevice;
	}
	
	public void Initialize(String name, byte[] address, int cod) {
		inner = new RemoteBTDevice(name, address, cod);		
	}
	
	public String getName() {
		return inner.getName();
	}
	
	public byte[] getDeviceAddress() {
		return inner.getDeviceAddress();
	}
	
	public int getDeviceClass() {
		return inner.getDeviceClass();
	}
	
	public String getAddress() {
	    return inner.getAddress();
	}
	
	public void authenticate(String pin) {
		inner.authenticate(pin);
	}
}
