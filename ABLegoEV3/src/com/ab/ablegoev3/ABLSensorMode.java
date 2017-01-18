package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.sensor.SensorMode;

@Author("Alain Bailleul")      
@ShortName("ABLSensorMode")  
public class ABLSensorMode {
	protected SensorMode inner;
	
	public ABLSensorMode() {
		
	}
	
	public ABLSensorMode(SensorMode sensorMode) {
		inner = sensorMode;
	}
	
	public int sampleSize() {
		return inner.sampleSize();
	}
	
	/** Fetches a sample from a sensor or filter.
	 * @param sample
	 * The array to store the sample in. 
	 * @param offset
	 * The elements of the sample are stored in the array starting at the offset position.
	 */
	public void fetchSample(float[] sample, int offset) {
		inner.fetchSample(sample, offset);
	}
}
