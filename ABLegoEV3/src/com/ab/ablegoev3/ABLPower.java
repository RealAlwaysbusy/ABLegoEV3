package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.Power;

@Author("Alain Bailleul")      
@ShortName("ABLPower")  
public class ABLPower {
	protected Power inner;
	
	ABLPower(Power power) {
		inner = power;
	}
	
	public int getVoltageMilliVolt() {
		return inner.getVoltageMilliVolt();
	}

	/**
	 * The NXT uses 6 batteries of 1.5 V each.
	 * @return Battery voltage in Volt. ~9V = full.
	 */
	public float getVoltage() {
		return inner.getVoltage();
	}

	/**
	 * Return the current draw from the battery
	 * @return current in Amps
	 */
	public float getBatteryCurrent() {
		return inner.getBatteryCurrent();
	}

	/**
	 * return the motor current draw
	 * @return current in Amps
	 */
	public float getMotorCurrent() {
		return inner.getMotorCurrent();
	}
}
