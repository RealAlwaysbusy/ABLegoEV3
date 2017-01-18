package com.ab.ablegoev3;

import java.io.IOException;
import java.util.ArrayList;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.remote.ev3.RemoteRequestEV3;

@Author("Alain Bailleul")      
@ShortName("ABLTouchSensor")  
public class ABLTouchSensor {	
	protected EV3TouchSensor inner;
	
	public void Initialize(String port) {		
		//inner = new EV3TouchSensor(BrickFinder.getDefault().getPort(port));
		BrickInfo [] ev3s = BrickFinder.discover();
		
		RemoteRequestEV3 ev3request;
		try {
			ev3request = new RemoteRequestEV3(ev3s[0].getIPAddress());
			Port p = ev3request.getPort(port);  //ev3.getPort("S4");
		    inner = new EV3TouchSensor(p);
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
     * <b>Lego EV3 Touch sensor, Touch mode</b><br>
     * Detects when its front button is pressed
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains one element, a value of 0 indicates that the button is not presse, a value of 1 indicates the button is pressed.
     * 
     * <p>
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     */
    public ABLSensorMode getTouchMode()
    {
        return new ABLSensorMode(inner.getMode(0));
    }    
}
