package com.ab.ablegoev3;

import java.rmi.RemoteException;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.BrickFinder;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

@Author("Alain Bailleul")      
@ShortName("ABLMediumRegulatedMotor")  
public class ABLMediumRegulatedMotor {
	protected RMIRegulatedMotor inner;	
	
	public void Initialize(String port) {
		RemoteEV3 ev3 = (RemoteEV3) BrickFinder.getDefault();
	    inner = ev3.createRegulatedMotor(port, 'M');	
	}   
	
	protected final int MAX_SPEED_AT_9V= 175*360/60;
	
    /**
     * Causes motor to stop, pretty much
     * instantaneously. In other words, the
     * motor doesn't just stop; it will resist
     * any further motion.
     * Cancels any rotate() orders in progress
     * @param immediateReturn if true do not wait for the motor to actually stop
     */
    public void Stop(boolean immediateReturn) throws RemoteException {
    	inner.stop(immediateReturn);
    }

    /**
     * Set the motor into float mode. This will stop the motor without braking
     * and the position of the motor will not be maintained.
     * @param immediateReturn If true do not wait for the motor to actually stop
     */
    public void Flt(boolean immediateReturn) throws RemoteException {
    	inner.flt(immediateReturn);
    }

    /**
     * Wait until the current movement operation is complete (this can include
     * the motor stalling).
     */
    public void WaitComplete() throws RemoteException {
    	inner.waitComplete();
    }

	
  /**
   * causes motor to rotate through angle; <br>
   * iff immediateReturn is true, method returns immediately and the motor stops by itself <br>
   * If any motor method is called before the limit is reached, the rotation is canceled. 
   * When the angle is reached, the method isMoving() returns false;<br>
   * 
   * @param  angle through which the motor will rotate
   * @param immediateReturn iff true, method returns immediately, thus allowing monitoring of sensors in the calling thread. 
   * 
   *  @see lejos.robotics.RegulatedMotor#rotate(int, boolean)
   */
  public void Rotate2(int angle, boolean immediateReturn) throws RemoteException {
	  inner.rotate(angle, immediateReturn);
  }

  /**
   * Causes motor to rotate by a specified angle. The resulting tachometer count should be within +- 2 degrees on the NXT.
   * This method does not return until the rotation is completed.
   * 
   * @param angle by which the motor will rotate.
   * 
   */
  public void Rotate(int angle) throws RemoteException {
	  inner.rotate(angle);
  }

  
  /**
   * Causes motor to rotate to limitAngle;  <br>
   * Then getTachoCount should be within +- 2 degrees of the limit angle when the method returns
   * @param  limitAngle to which the motor will rotate, and then stop (in degrees). Includes any positive or negative int, even values &gt; 360.
   */
  public void RotateTo(int limitAngle) throws RemoteException {
	  inner.rotate(limitAngle);
  }
  
  /**
   * causes motor to rotate to limitAngle; <br>
   * if immediateReturn is true, method returns immediately and the motor stops by itself <br> 
   * and getTachoCount should be within +- 2 degrees if the limit angle
   * If any motor method is called before the limit is reached, the rotation is canceled. 
   * When the angle is reached, the method isMoving() returns false;<br>
   * @param  limitAngle to which the motor will rotate, and then stop (in degrees). Includes any positive or negative int, even values &gt; 360. 
   * @param immediateReturn iff true, method returns immediately, thus allowing monitoring of sensors in the calling thread.
   */
  public void RotateTo2(int limitAngle,boolean immediateReturn) throws RemoteException {
	  inner.rotateTo(limitAngle, immediateReturn);
  }

  /**
   * Return the limit angle (if any)
   * @return the current limit angle
   */
  public int getLimitAngle() throws RemoteException {
	  return inner.getLimitAngle();
  }

  /**
   * Set motor speed. As a rule of thumb 100 degrees per second are possible for each volt on an NXT motor. Therefore,
   * disposable alkaline batteries can achieve a top speed of 900 deg/sec, while a rechargable lithium battery pack can achieve
   * 740 deg/sec. 
   * 
   * @param speed in degrees per second.
   */
  public void setSpeed(int speed) throws RemoteException {
	  inner.setSpeed(speed);
  }

  /**
   * Returns the current motor speed.
   * 
   * @return motor speed in degrees per second
   */
  public int getSpeed() throws RemoteException {
	  return inner.getSpeed();
  }
 
  /**
   * Returns the maximim speed of the motor.
   * 
   * @return the maximum speed of the Motor in degrees per second.
   */
  public float getMaxSpeed() throws RemoteException {
	  //return inner.getMaxSpeed();
	  return BrickFinder.getDefault().getPower().getVoltage() * MAX_SPEED_AT_9V/9.0f * 0.9f;
  }
  
  /**
   * returns true if motor is stalled
   * @return true if stalled
   */
   boolean isStalled() throws RemoteException {
	   return inner.isStalled();
   }
   
   /**
    * Set the parameters for detecting a stalled motor. A motor will be recognized as 
    * stalled if the movement error (the amount the motor lags the regulated position) 
    * is greater than error for a period longer than time.
	*
	* @param error The error threshold
    * @param time The time that the error threshold needs to be exceeded for.
    */
   public void setStallThreshold(int error, int time) throws RemoteException {
	   inner.setStallThreshold(error, time);
   }
   
   /**
    * Set the required rate of acceleration degrees/s/s
    * @param acceleration
    */
   public void setAcceleration(int acceleration) throws RemoteException {
	   inner.setAcceleration(acceleration);
   }
   
   public void Close() throws RemoteException {
	   inner.close();
   }
   
   public void Forward() throws RemoteException {
	   inner.forward();
   }
   
   public void Backward() throws RemoteException {
	   inner.backward();
   }
   
   public void ResetTachoCount() throws RemoteException {
	   inner.resetTachoCount();
   }
   
   public int getTachoCount() throws RemoteException {
	   return inner.getTachoCount();
   }
   
   public boolean isMoving() throws RemoteException {
	   return inner.isMoving();
   }
}
