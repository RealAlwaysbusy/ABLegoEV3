package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.port.IOPort;
import lejos.hardware.port.Port;

@Author("Alain Bailleul")      
@ShortName("ABLPort")
public class ABLPort {
	protected Port inner;
	
	public ABLPort(Port port) {
		inner = port;
	}
	
	/**
     * return the string name used to reference this physical port
     * @return a string representation of the port
     */
    public String getName() {
    	return inner.getName();
    }

    /**
     * Obtain access to a class that can be used to talk to the port hardware
     * @param portclass the required port interface
     * @return a class that implements the requested interface
     */
    public <T extends IOPort> T open(Class<T> portclass) {
    	return inner.open(portclass);
    }
	
}
