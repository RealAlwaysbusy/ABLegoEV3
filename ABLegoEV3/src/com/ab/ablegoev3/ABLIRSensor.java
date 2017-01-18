package com.ab.ablegoev3;

import java.io.IOException;
import java.util.ArrayList;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.remote.ev3.RemoteRequestEV3;

@Author("Alain Bailleul")      
@ShortName("ABLIRSensor")  
public class ABLIRSensor {	
	
	public final static int IR_CHANNELS = 4;
	
	protected EV3IRSensor inner;
	
	public void Initialize(String port) {		
		//inner = new EV3IRSensor(BrickFinder.getDefault().getPort(port));
		BrickInfo [] ev3s = BrickFinder.discover();
	      
	    RemoteRequestEV3 ev3request;
		try {
			ev3request = new RemoteRequestEV3(ev3s[0].getIPAddress());
			Port p = ev3request.getPort(port);  //ev3.getPort("S4");
		    inner = new EV3IRSensor(p);
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
     * Return the current remote command from the specified channel. Remote commands
     * are a single numeric value  which represents which button on the Lego IR
     * remote is currently pressed (0 means no buttons pressed). Four channels are
     * supported (0-3) which correspond to 1-4 on the remote. The button values are:<br>
     * 1 TOP-LEFT<br>
     * 2 BOTTOM-LEFT<br>
     * 3 TOP-RIGHT<br>
     * 4 BOTTOM-RIGHT<br>
     * 5 TOP-LEFT + TOP-RIGHT<br>
     * 6 TOP-LEFT + BOTTOM-RIGHT<br>
     * 7 BOTTOM-LEFT + TOP-RIGHT<br>
     * 8 BOTTOM-LEFT + BOTTOM-RIGHT<br>
     * 9 CENTRE/BEACON<br>
     * 10 BOTTOM-LEFT + TOP-LEFT<br>
     * 11 TOP-RIGHT + BOTTOM-RIGHT<br>
     * @param chan channel to obtain the command for
     * @return the current command
     */
    public int getRemoteCommand(int chan)
    {
        return inner.getRemoteCommand(chan);
    }

    /**
     * Obtain the commands associated with one or more channels. Each element of 
     * the array contains the command for the associated channel (0-3).
     * @param cmds the array to store the commands
     * @param offset the offset to start storing
     * @param len the number of commands to store.
     */
    public void getRemoteCommands(byte[] cmds, int offset, int len)
    {
    	inner.getRemoteCommands(cmds, offset, len);
    }
    
    
    /**
     * <b>EV3 Infra Red sensor, Distance mode</b><br>
     * Measures the distance to an object in front of the sensor.
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains one element giving the distance to an object in front of the sensor. The distance provided is very roughly equivalent to meters
     * but needs conversion to give better distance. See product page for details. <br>
     * The effective range of the sensor in Distance mode  is about 5 to 50 centimeters. Outside this range a zero is returned
     * for low values and positive infinity for high values.
     * 
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     * See <a href="http://www.ev-3.net/en/archives/848"> Sensor Product page </a>
     */    
    public ABLSensorMode getDistanceMode()
    {
        return new ABLSensorMode(inner.getMode(0));
    }
    

    
    /**
     * <b>EV3 Infra Red sensor, Seek mode</b><br>
     * In seek mode the sensor locates up to four beacons and provides bearing and distance of each beacon.
     * 
     * <p>
     * <b>Size and content of the sample</b><br>
     * The sample contains four pairs of elements in a single sample. Each pair gives bearing of  and distance to the beacon. 
     * The first pair of elements is associated with a beacon transmitting on channel 0, the second pair with a beacon transmitting on channel 1 etc.<br>
     * The bearing values range from -25 to +25 (with values increasing clockwise
     * when looking from behind the sensor). A bearing of 0 indicates the beacon is
     * directly in front of the sensor. <br>
     * Distance values are not to scale. Al increasing values indicate increasing distance. <br>
     * If no beacon is detected both bearing is set to zero, and distance to positive infinity.
     * 
     * <p>
     * 
     * @return A sampleProvider
     * See {@link lejos.robotics.SampleProvider leJOS conventions for
     *      SampleProviders}
     * See <a href="http://www.ev-3.net/en/archives/848"> Sensor Product page </a>
     */    
    public ABLSensorMode getSeekMode()
    {
        return new ABLSensorMode(inner.getMode(1));
    }
    
}
