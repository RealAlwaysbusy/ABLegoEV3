package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.utility.Delay;

@Author("Alain Bailleul")      
@ShortName("ABLDelay")   
public class ABLDelay {
	
	public ABLDelay() {
		
	}
	
	public static void msDelay(long period) {
       Delay.msDelay(period);
    }

    /**
     * Wait for the specified number of microseconds.
     * Delays the current thread for the specified period of time. Can not
     * be interrupted.
     * @param period time to wait in us
     */
    public static void usDelay(long period) {
    	 Delay.usDelay(period);
    }

    /**
     * Wait for the specified number of nanoseconds.
     * Delays the current thread for the specified period of time. Can not
     * be interrupted.
     * @param period time to wait in ns
     */
    public static void nsDelay(long period) {
    	 Delay.nsDelay(period);
    }
}
