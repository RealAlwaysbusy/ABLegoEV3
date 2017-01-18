package com.ab.ablegoev3;

import java.io.IOException;
import java.util.ArrayList;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RemoteRequestEV3;

@Author("Alain Bailleul")      
@ShortName("ABLUltrasonicSensor") 
public class ABLUltrasonicSensor {	
	protected EV3UltrasonicSensor inner;
	
	public void Initialize(String port) {		
		//inner = new EV3UltrasonicSensor(BrickFinder.getDefault().getPort(port));
		BrickInfo [] ev3s = BrickFinder.discover();
		
		RemoteRequestEV3 ev3request;
		try {
			ev3request = new RemoteRequestEV3(ev3s[0].getIPAddress());
			Port p = ev3request.getPort(port);  //ev3.getPort("S4");
		    inner = new EV3UltrasonicSensor(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List getAvailableModes()
    {
		ArrayList<String> mods = inner.getAvailableModes();
		List ret = new List();
		ret.Initialize();
		for (String s: mods) {
			ret.Add(s);
		}
		return ret;
    }
    
			
    public ABLSensorMode getMode(int mode)
    {
        return new ABLSensorMode(inner.getMode(mode));
    }
   
    public ABLSensorMode getMode2(String modeName)
    {
    	return new ABLSensorMode(inner.getMode(modeName));
    }
      
    public String getSensorName() {
    	return inner.getName();
    }
   
    public int sampleSize() {
    	return inner.sampleSize();
    }
    
    public void fetchSample(float[] sample, int offset) {
    	inner.fetchSample(sample, offset);
    }
    
    public void setCurrentMode(int mode) {
    	inner.setCurrentMode(mode);
    }
   
    public void setCurrentMode2(String modeName) {
	    inner.setCurrentMode(modeName);
    }

    public int getCurrentMode() {
      return inner.getCurrentMode();
    }
   
    public int getModeCount() {
      return inner.getModeCount();
    }

	/**
	   * <b>Lego EV3 Ultrasonic sensor, Listen mode</b><br>
	   * Listens for the presence of other ultrasonic sensors. 
	   * 
	   * <p>
	   * <b>Size and content of the sample</b><br>
	   * The sample contains one elements indicating the presence of another ultrasonic sensor. 
	   * A value of 1 indicates that the sensor detects another ultrasonic sensor.
	   * 
	   * @return A sampleProvider
	   */  
	  public ABLSensorMode getListenMode() {
	    return new ABLSensorMode(inner.getMode(1));
	  }

	  /**
	   * <b>Lego EV3 Ultrasonic sensor, Distance mode</b><br>
	   * Measures distance to an object in front of the sensor
	   * 
	   * <p>
	   * <b>Size and content of the sample</b><br>
	   * The sample contains one elements representing the distance (in metres) to an object in front of the sensor.
	   * unit).
	   * 
	   * @return A sampleProvider
	   */
	  public ABLSensorMode getDistanceMode() {
		  return new ABLSensorMode(inner.getMode(0));
	  }

	  /**
	   * Enable the sensor. This puts the indicater LED on.
	   */
	  public void Enable() {
		  inner.enable();
	  }

	  /**
	   * Disable the sensor. This puts the indicater LED off.
	   */
	  public void Disable() {
		  inner.disable();
	  }

	  /**
	   * Indicate that the sensor is enabled.
	   * 
	   * @return True, when the sensor is enabled. <br>
	   *         False, when the sensor is disabled.
	   */
	  public boolean IsEnabled() {
		  return inner.isEnabled();
	  }	
}
