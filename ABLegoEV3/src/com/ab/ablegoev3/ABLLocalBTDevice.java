package com.ab.ablegoev3;

import java.util.Collection;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.LocalBTDevice;
import lejos.hardware.RemoteBTDevice;
import lejos.internal.io.NativeHCI;

@Author("Alain Bailleul")      
@ShortName("ABLLocalBTDevice")  
public class ABLLocalBTDevice {
	protected LocalBTDevice inner;
	
	ABLLocalBTDevice(LocalBTDevice localBTDevice) {
		inner = localBTDevice;
	}
	
	/**
	 * Search for and return a list of Bluetooth devices.
	 * @return The found ABLRemoveBTDevice devices.
	 * @throws IOException
	 */
	public anywheresoftware.b4a.objects.collections.List search() {
		Collection<RemoteBTDevice> results = inner.search();
		anywheresoftware.b4a.objects.collections.List ret = new anywheresoftware.b4a.objects.collections.List();
		for(RemoteBTDevice d: results) {
			System.out.println("Found " + d.getName());
			ret.Add(new ABLRemoteBTDevice(d));
		}
		return ret;		
	}

	/**
	 * Return a list of the devices we are paired with
	 * @return the list of paired ABLRemoveBTDevice devices
	 */
    public anywheresoftware.b4a.objects.collections.List getPairedDevices() {        
        Collection<RemoteBTDevice> devices = inner.getPairedDevices();            
        anywheresoftware.b4a.objects.collections.List ret = new anywheresoftware.b4a.objects.collections.List();
        for(RemoteBTDevice d: devices) {
        	ret.Add(d);
        }
        return ret;
    }

    /**
     * Set the visibility state of the device
     * @param visible new visibility state
     */
	public void setVisibility(boolean visible) {
		inner.setVisibility(visible);
	}

	/**
	 * return the current visibility of the device
	 * @return true if the device is visible
	 */
	public boolean getVisibility() {
        return inner.getVisibility();
	}

	/**
	 * Check to see if the device is currently powered on
	 * @return true if the device is on
	 */
	public static boolean IsPowerOn() {
		return true;
	}

	/**
	 * Return the address of the local device
	 * @return A string version of the Bluetooth device address
	 */
	public String getBluetoothAddress() {
        return inner.getBluetoothAddress();
	}

	/**
	 * Return the name of the local device
	 * @return A string containing the device name
	 */
	public String getFriendlyName() {
        return inner.getFriendlyName();
	}

	/**
	 * Return a structure providing information about the local device 
	 * @return local device information
	 */
	public NativeHCI.DeviceInfo getDeviceInfo() {
        return inner.getDeviceInfo();
	}

	/**
	 * return a structure providing local version information
	 * @return local version information
	 */
	public NativeHCI.LocalVersion getLocalVersion() {
        return inner.getLocalVersion();
	    
	}

	/**
	 * Authenticate/pair the local device with the specified device
	 * @param deviceAddress address of the device to pair with
	 * @param pin Pin to use for pairing with the device
	 */
	public void Authenticate(String deviceAddress, String pin) {
		inner.authenticate(deviceAddress, pin);
	}

	/**
	 * Remove the specified device from the known/paired list
	 * @param deviceAddress address of the device to remove
	 */
	public void RemoveDevice(String deviceAddress) {
        inner.removeDevice(deviceAddress);
	}
	
	public void Disconnect() {
	    inner.disconnect();
	}
}
