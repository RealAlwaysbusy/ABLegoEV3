package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.DesignerName;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import lejos.hardware.BrickFinder;

@DesignerName("Build 20161209")                                    
@Version(1.00F)                                
@Author("Alain Bailleul")      
@ShortName("ABLegoEV3")    
@DependsOn(values={"dbusjava", "opencv-2411", "ev3classes", "jna-3.2.7", "ev3tools", "commons-cli", "jcommon", "jfreechart", "jsch-0.1.50"})
public class ABLegoEV3 {
	
	/*
	public void TestRun() {
		RemoteEV3 ev3 = (RemoteEV3) BrickFinder.getDefault();
	    RMIRegulatedMotor motor = ev3.createRegulatedMotor("C", 'L');
	    try {
			motor.setAcceleration(600);
			motor.setSpeed(500);
	        motor.rotate(720);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}*/
	
	public ABLLCD LCD() {
		return new ABLLCD();
	}
	 	
 	/**
     * Return a port object for the request port name. This allows access to the
     * hardware associated with the specified port.
     * @param portName The name of port
     * @return the request port
     */ 	
	public ABLPort Port(String portName) {		
		return new ABLPort(BrickFinder.getDefault().getPort(portName));	        
	}
	
	/**
     * return a battery object which can be used to obtain battery voltage etc.
     * @return A battery object
     */
	public ABLPower Power() {
		return new ABLPower(BrickFinder.getDefault().getPower());
	}
	
	/**
     * Get text access to the LCD using the default font
     * @return the text LCD 
     */
	public ABLTextLCD TextLCD() {
		return new ABLTextLCD(BrickFinder.getDefault().getTextLCD());	        
	}
	
	/**
     * Get text access to the LCD using a specified font
     * @param f the font
     * @return the text LCD
     */
	public ABLTextLCD TextLCD2(ABLFont f) {
		return new ABLTextLCD(BrickFinder.getDefault().getTextLCD(f.inner));
	
	}
	
	 /**
     * Get graphics access to the LCD
     * @return the graphics LCD
     */
	public ABLGraphicsLCD GraphicsLCD() {
		return new ABLGraphicsLCD(BrickFinder.getDefault().getGraphicsLCD());
	}
		
	/**
     * return a Video object which can be used to access the device's video
     * @return A Video device
     */
    public ABLVideo Video() {
    	return new ABLVideo(BrickFinder.getDefault().getVideo());
    }

    /**
     * Test whether the brick is a local one
     * @return true iff brick is local
     */    
    public boolean IsLocal() {
		return BrickFinder.getDefault().isLocal();
	}	

    /**
     * Get the type of brick, e.g. "EV3", "NXT", "BrickPi"
     * @return the brick type
     */
	public String Type()	{
		return BrickFinder.getDefault().getType();
	}

	/**
     * Get he name of the brick
     * @return the name
     */
	public String Name() {		
		return BrickFinder.getDefault().getName();
	}

	/**
     * Get the local Bluetooth device
     * @return the local Bluetooth device
     */
	public ABLLocalBTDevice BluetoothDevice() {
		return new ABLLocalBTDevice(BrickFinder.getDefault().getBluetoothDevice());
	}

	/**
     * Get the local Wifi device
     * @return the local Wifi device
     */
	public ABLLocalWifiDevice WifiDevice() {
		return new ABLLocalWifiDevice(BrickFinder.getDefault().getWifiDevice());
	}

	 /**
     * Set this brick as the default one for static methods
     */
	protected void SetDefault() {
		BrickFinder.getDefault().setDefault();		
	}

	 
	 /**
     * Get access to a specific Key (aka Button)
     * @param name the key name
     * @return an implementation of the Key interface
     */
	public ABLKey Key(String name) {
		return new ABLKey(BrickFinder.getDefault().getKey(name));
	}

	/**
     * Get access to the LED
     * @return an implementation of the LED interface
     */
	public ABLLED LED() {
		return new ABLLED(BrickFinder.getDefault().getLED());
	}

	/**
     * Get access to the keys (buttons)
     * @return an implementation of the Keys interface
     */
	public ABLKeys Keys() {
		return new ABLKeys(BrickFinder.getDefault().getKeys());
	}		
	
	public ABLButton Button() {
		return new ABLButton();
	}
	
	public ABLSound Sound() {
		return new ABLSound();
	}
	
	public ABLDelay Delay() {
		return new ABLDelay();
	}
	
	
}
