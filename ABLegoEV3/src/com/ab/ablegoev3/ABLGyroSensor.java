package com.ab.ablegoev3;

import java.io.IOException;
import java.util.ArrayList;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.remote.ev3.RemoteRequestEV3;

@Author("Alain Bailleul")      
@ShortName("ABLGyroSensor")  
public class ABLGyroSensor {	
	protected EV3GyroSensor inner;
	
	public void Initialize(String port) {		
		//inner = new EV3GyroSensor(BrickFinder.getDefault().getPort(port));
		BrickInfo [] ev3s = BrickFinder.discover();
		
		RemoteRequestEV3 ev3request;
		try {
			ev3request = new RemoteRequestEV3(ev3s[0].getIPAddress());
			Port p = ev3request.getPort(port);  //ev3.getPort("S4");
		    inner = new EV3GyroSensor(p);
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
	   * <b>EV3 Gyro sensor, Angle mode</b><br>
	   * Measures the orientation of the sensor in respect to its start orientation. 
	   * 
	   * <p>
	   * <b>Size and content of the sample</b><br>
	   * The sample contains one elements representing the orientation (in Degrees) of the sensor in respect to its start position. 
	   * 
	   * <p>
	   * <b>Configuration</b><br>
	   * The start position can be set to the current position using the reset method of the sensor.
	   * 
	   * @return A sampleProvider
	   * See {@link lejos.robotics.SampleProvider leJOS conventions for
	   *      SampleProviders}
	   */
	  public ABLSensorMode getAngleMode() {
	    return new ABLSensorMode(inner.getMode(1));
	  }

	 
	  /**
	   * <b>EV3 Gyro sensor, Rate mode</b><br>
	   * Measures angular velocity of the sensor. 
	   * 
	   * <p>
	   * <b>Size and content of the sample</b><br>
	   * The sample contains one elements representing the angular velocity (in Degrees / second) of the sensor. 
	   * 
	   * <p>
	   * <b>Configuration</b><br>
	   * The sensor can be recalibrated using the reset method of the sensor.
	   * 
	   * @return A sampleProvider
	   * See {@link lejos.robotics.SampleProvider leJOS conventions for
	   *      SampleProviders}
	   */
	  public ABLSensorMode getRateMode() {
		  return new ABLSensorMode(inner.getMode(0));
	  }


	  /**
	   * <b>EV3 Gyro sensor, Rate mode</b><br>
	   * Measures both angle and angular velocity of the sensor. 
	   * 
	   * <p>
	   * <b>Size and content of the sample</b><br>
	   * The sample contains two elements. The first element contains angular velocity (in degrees / second). The second element contain angle (in degrees).  
	   * 
	   * <p>
	   * <b>Configuration</b><br>
	   * The sensor can be recalibrated using the reset method of the sensor.
	   * 
	   * @return A sampleProvider
	   * See {@link lejos.robotics.SampleProvider leJOS conventions for
	   *      SampleProviders}
	   */
	  public ABLSensorMode getAngleAndRateMode() {
	    return new ABLSensorMode(inner.getMode(2));
	  }

	  
	  /**
	   * Hardware calibration of the Gyro sensor and reset off accumulated angle to zero. <br>
	   * The sensor should be motionless during calibration.
	   */
	  public void Reset() {
		  inner.reset();
	  }
}
