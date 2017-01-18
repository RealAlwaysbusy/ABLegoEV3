package com.ab.ablegoev3;

import java.io.IOException;
import java.util.ArrayList;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.remote.ev3.RemoteRequestEV3;

@Author("Alain Bailleul")      
@ShortName("ABLColorSensor")  
public class ABLColorSensor {	
	protected EV3ColorSensor inner;
	
	public void Initialize(String port) {	
		//inner = new EV3ColorSensor(BrickFinder.getDefault().getPort(port));
		BrickInfo [] ev3s = BrickFinder.discover();
			      
		RemoteRequestEV3 ev3request;
		try {
			ev3request = new RemoteRequestEV3(ev3s[0].getIPAddress());
			Port p = ev3request.getPort(port);  //ev3.getPort("S4");
		    inner = new EV3ColorSensor(p);
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
	
    public int getColorID()
    {
        return inner.getColorID();
    }

    public void setFloodlight(boolean floodlight)
    {
    	inner.setFloodlight(floodlight);
    }
    
    public boolean isFloodlightOn()
    {
        return inner.isFloodlightOn();
    }

    public int getFloodlight()
    {
         return inner.getFloodlight();
    }

    public boolean setFloodlight2(int color)
    {
    	return inner.setFloodlight(color);
    }

    
    /**
     * <b>EV3 color sensor, Color ID mode</b><br>
     * Measures the color ID of a surface. The sensor can identify 8 unique colors (NONE, BLACK, BLUE, GREEN, YELLOW, RED, WHITE, BROWN).
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains one element containing the ID (0-7) of the detected color.
     * 
     * <p>
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     */
    public ABLSensorMode getColorIDMode()
    {
        return new ABLSensorMode(inner.getMode(0));
    }
    
 
    /**
     * <b>EV3 color sensor, Red mode</b><br>
     * Measures the level of reflected light from the sensors RED LED. 
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains one element containing the intensity level (Normalized between 0 and 1) of reflected light.
     * 
     * <p>
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     */
    public ABLSensorMode getRedMode()
    {
        return new ABLSensorMode(inner.getMode(1));
    }


    /**
     * <b>EV3 color sensor, Ambient mode</b><br>
     * Measures the level of ambient light while the sensors lights are off. 
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains one element containing the intensity level (Normalized between 0 and 1) of ambient light.
     * 
     * <p>
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     */
    public ABLSensorMode getAmbientMode()
    {
       return new ABLSensorMode(inner.getMode(3));
    }
    
    /**
     * get a sample provider that returns the light values (RGB) when illuminated by a
     * white light source.
     * @return the sample provider
     */
    /**
     * <b>EV3 color sensor, RGB mode</b><br>
     * Measures the level of red, green and blue light when illuminated by a white light source.. 
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains 3 elements containing the intensity level (Normalized between 0 and 1) of red, green and blue light respectivily.
     * 
     * <p>
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     */
    public ABLSensorMode getRGBMode()
    {
        //TODO: Should this return 3 or 4 values, 4 values would require an extra mode switch to get ambient value.
        return new ABLSensorMode(inner.getMode(2));
    }
}
