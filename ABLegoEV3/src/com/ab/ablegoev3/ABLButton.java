package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;

@Author("Alain Bailleul")      
@ShortName("ABLButton")   
public class ABLButton{		
	public static final int ID_UP = 0x1;
	public static final int ID_ENTER = 0x2;
	public static final int ID_DOWN = 0x4;
	public static final int ID_RIGHT = 0x8;
	public static final int ID_LEFT = 0x10;
	public static final int ID_ESCAPE = 0x20;
	public static final int ID_ALL = 0x3f;

	public static final String VOL_SETTING = "lejos.keyclick_volume";
	public static final String LEN_SETTING = "lejos.keyclick_length";
	public static final String FREQ_SETTING = "lejos.keyclick_frequency";
	
	public ABLButton() {
		
	}
	
	public ABLKey ENTER() {
		return new ABLKey(Button.ENTER);
	}
	
	public ABLKey LEFT() {
		return new ABLKey(Button.LEFT);
	}
	
	public ABLKey RIGHT() {
		return new ABLKey(Button.RIGHT);
	}
	
	public ABLKey ESCAPE() {
		return new ABLKey(Button.ESCAPE);
	}
	
	public ABLKey UP() {
		return new ABLKey(Button.UP);
	}
	
	public ABLKey DOWN() {
		return new ABLKey(Button.DOWN);
	}
	
	public ABLKeys Keys() {
		return new ABLKeys(Button.keys);
	}
	
	/**
	 * This method discards any events. In contrast to {@link #readButtons()},
	 * this method doesn't beep if a button is pressed.
	 */
	public static void DiscardEvents() {
		Button.keys.discardEvents();
	}
	/**
	 * Waits for some button to be pressed or released. Which buttons have been
	 * released or pressed is returned as a bitmask. The lower eight bits (bits
	 * 0 to 7) indicate, which buttons have been pressed. Bits 8 to 15 indicate
	 * which buttons have been released.
	 * 
	 * @return the bitmask
	 * @see #ID_ENTER
	 * @see #ID_LEFT
	 * @see #ID_RIGHT
	 * @see #ID_ESCAPE
	 */
	public static int WaitForAnyEvent() {
		return Button.keys.waitForAnyEvent();
	}

	/**
	 * Waits for some button to be pressed or released. Which buttons have been
	 * released or pressed is returned as a bitmask. The lower eight bits (bits
	 * 0 to 7) indicate, which buttons have been pressed. Bits 8 to 15 indicate
	 * which buttons have been released.
	 * 
	 * @param timeout
	 *            The maximum number of milliseconds to wait
	 * @return the bitmask
	 * @see #ID_ENTER
	 * @see #ID_LEFT
	 * @see #ID_RIGHT
	 * @see #ID_ESCAPE
	 */
	public static int WaitForAnyEvent2(int timeout) {
		return Button.keys.waitForAnyEvent(timeout);
	}

	/**
	 * Waits for some button to be pressed. If a button is already pressed, it
	 * must be released and pressed again.
	 * 
	 * @param timeout
	 *            The maximum number of milliseconds to wait
	 * @return the ID of the button that has been pressed or in rare cases a
	 *         bitmask of button IDs, 0 if the given timeout is reached
	 */
	public static int WaitForAnyPress2(int timeout) {
		return Button.keys.waitForAnyPress(timeout);
	}

	/**
	 * Waits for some button to be pressed. If a button is already pressed, it
	 * must be released and pressed again.
	 * 
	 * @return the ID of the button that has been pressed or in rare cases a
	 *         bitmask of button IDs
	 */
	public static int WaitForAnyPress() {
		return WaitForAnyPress2(0);
	}

	/**
	 * <i>Low-level API</i> that reads status of buttons.
	 * 
	 * @return An integer with possibly some bits set: {@link #ID_ENTER} (ENTER
	 *         button pressed) {@link #ID_LEFT} (LEFT button pressed),
	 *         {@link #ID_RIGHT} (RIGHT button pressed), {@link #ID_ESCAPE}
	 *         (ESCAPE button pressed). If all buttons are released, this method
	 *         returns 0.
	 */
	public static int Buttons() {
		return Button.keys.getButtons();
	}

	/**
	 * <i>Low-level API</i> that reads status of buttons.
	 * 
	 * @return An integer with possibly some bits set: {@link #ID_ENTER} (ENTER
	 *         button pressed) {@link #ID_LEFT} (LEFT button pressed),
	 *         {@link #ID_RIGHT} (RIGHT button pressed), {@link #ID_ESCAPE}
	 *         (ESCAPE button pressed). If all buttons are released, this method
	 *         returns 0.
	 */
	public static int ReadButtons() {
		return Button.keys.readButtons();
	}

	/**
	 * Set the volume used for key clicks
	 * 
	 * @param vol
	 */
	public static void setKeyClickVolume(int vol) {
		Button.keys.setKeyClickVolume(vol);
	}

	/**
	 * Return the current key click volume.
	 * 
	 * @return current click volume
	 */
	public static synchronized int getKeyClickVolume() {
		return Button.keys.getKeyClickVolume();
	}

	/**
	 * Set the len used for key clicks
	 * 
	 * @param len
	 *            the click duration
	 */
	public static synchronized void setKeyClickLength(int len) {
		Button.keys.setKeyClickLength(len);
	}

	/**
	 * Return the current key click length.
	 * 
	 * @return key click duration
	 */
	public static synchronized int getKeyClickLength() {
		return Button.keys.getKeyClickLength();
	}

	/**
	 * Set the frequency used for a particular key. Setting this to 0 disables
	 * the click. Note that key may also be a corded set of keys.
	 * 
	 * @param key
	 *            the NXT key
	 * @param freq
	 *            the frequency
	 */
	public static synchronized void setKeyClickTone(int key, int freq) {
		Button.keys.setKeyClickTone(key, freq);
	}

	/**
	 * Return the click freq for a particular key.
	 * 
	 * @param key
	 *            The key to obtain the tone for
	 * @return key click duration
	 */
	public static synchronized int getKeyClickTone(int key) {
		return Button.keys.getKeyClickTone(key);
	}

	public static void LEDPattern(int pattern) {
		BrickFinder.getDefault().getLED().setPattern(pattern);
	}
}

