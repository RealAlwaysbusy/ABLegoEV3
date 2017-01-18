package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.lcd.TextLCD;

@Author("Alain Bailleul")      
@ShortName("ABLTextLCD")
public class ABLTextLCD {
	protected TextLCD inner;
	
	public static final int ROP_CLEAR = 0x00000000;
	public static final int ROP_AND = 0xff000000;
	public static final int ROP_ANDREVERSE = 0xff00ff00;
	public static final int ROP_COPY = 0x0000ff00;
	public static final int ROP_ANDINVERTED = 0xffff0000;
	public static final int ROP_NOOP = 0x00ff0000;
	public static final int ROP_XOR = 0x00ffff00;
	public static final int ROP_OR = 0xffffff00;
	public static final int ROP_NOR = 0xffffffff;
	public static final int ROP_EQUIV = 0x00ffffff;
	public static final int ROP_INVERT = 0x00ff00ff;
	public static final int ROP_ORREVERSE = 0xffff00ff;
	public static final int ROP_COPYINVERTED = 0x0000ffff;
	public static final int ROP_ORINVERTED = 0xff00ffff;
	public static final int ROP_NAND = 0xff0000ff;
	public static final int ROP_SET = 0x000000ff;
	    
	public ABLTextLCD(TextLCD textLCD) {
	   inner = textLCD;    	
	}
	
	/**
     * Draw a single char on the LCD at specified x,y co-ordinate.
     * @param c Character to display
     * @param x X location
     * @param y Y location
     */
    public void DrawChar(char c, int x, int y) {
    	inner.drawChar(c, x, y);
    }
    
    /**
     * Display an optionally inverted string on the LCD at specified x,y co-ordinate.
     *
     * @param str The string to be displayed
     * @param x The x character co-ordinate to display at.
     * @param y The y character co-ordinate to display at.
     * @param inverted if true the string is displayed inverted.
     */
    public void DrawString2(String str, int x, int y, boolean inverted) {
    	inner.drawString(str, x, y, inverted);
    }
    
    /**
     * Display a string on the LCD at specified x,y co-ordinate.
     *
     * @param str The string to be displayed
     * @param x The x character co-ordinate to display at.
     * @param y The y character co-ordinate to display at.
     */
    public void DrawString(String str, int x, int y) {
    	inner.drawString(str, x, y);
    }
    
    /**
     * Display an int on the LCD at specified x,y co-ordinate.
     *
     * @param i The value to display.
     * @param x The x character co-ordinate to display at.
     * @param y The y character co-ordinate to display at.
     */
    public void DrawInt(int i, int x, int y) {
    	inner.drawInt(i, x, y);
    }
    
    /**
     * Display an in on the LCD at x,y with leading spaces to occupy at least the number
     * of characters specified by the places parameter.
     *
     * @param i The value to display
     * @param places number of places to use to display the value
     * @param x The x character co-ordinate to display at.
     * @param y The y character co-ordinate to display at.
     */
    public void DrawInt2(int i, int places, int x, int y) {
    	inner.drawInt(i, places, x, y);
    }
    
    /**
     * Clear a contiguous set of characters
     * @param x the x character coordinate
     * @param y the y character coordinate
     * @param n the number of characters
     */
    public void Clear3(int x, int y, int n) {
    	inner.clear(x, y, n);
    }
    
    /**
     * Clear an LCD display row
     * @param y the row to clear
     */
    public void Clear2(int y) {
    	inner.clear(y);
    }
    
    /**
     * Scrolls the screen up one text line
     */
    public void Scroll() {
    	inner.scroll();
    }
    
    /**
     * Get the current font
     */
    public ABLFont getFont() {
    	return new ABLFont(inner.getFont());    	
    }
    
    /**
     * Get the width of the screen in characters
     */
    public int getTextWidth() {
    	return inner.getTextWidth();
    }
    
    /**
     * Get the height of the screen in characters
     */
    public int getTextHeight() {
    	return inner.getTextHeight();
    }
	
	/**
     * Refresh the display. If auto refresh is off, this method will wait until
     * the display refresh has completed. If auto refresh is on it will return
     * immediately.
     */
    public void Refresh() {
    	inner.refresh();
    }
    
    /**
     * Clear the display.
     */
    public void Clear() {
    	inner.clear();
    }
    
    /**
     * Return the width of the associated drawing surface.
     * <br><b>Note</b>: This is a non standard method.
     * @return width of the surface
     */
    public int getWidth() {
    	return inner.getWidth();
    }

    /**
     * Return the height of the associated drawing surface.
     * <br><b>Note</b>: This is a non standard method.
     * @return height of the surface.
     */
    public int getHeight() {
    	return inner.getHeight();
    }
    
    /**
     * Provide access to the LCD display frame buffer. 
     * @return byte array that is the frame buffer.
     */
    public byte[] getDisplay() {
    	return inner.getDisplay();
    }
    
    /**
     * Get access to hardware LCD display.
     * @return byte array that is the frame buffer
     */
    public byte[] getHWDisplay() {
    	return inner.getHWDisplay();
    }
    
    /**
     * Set the LCD contrast.
     * @param contrast 0 blank 0x60 full on
     */
    public void setContrast(int contrast) {
    	inner.setContrast(contrast);
    }
    
    /**
     * Standard two input BitBlt function with the LCD display as the
     * destination. Supports standard raster ops and
     * overlapping images. Images are held in native leJOS/Lego format.
     * @param src byte array containing the source image
     * @param sw Width of the source image
     * @param sh Height of the source image
     * @param sx X position to start the copy from
     * @param sy Y Position to start the copy from
     * @param dx X destination
     * @param dy Y destination
     * @param w width of the area to copy
     * @param h height of the area to copy
     * @param rop raster operation.
     */
    public void BitBlt(byte[] src, int sw, int sh, int sx, int sy, int dx, int dy, int w, int h, int rop) {
    	inner.bitBlt(src, sw, sh, sx, sy, dx, dy, w, h, rop);
    }
    
    /**
     * Standard two input BitBlt function. Supports standard raster ops and
     * overlapping images. Images are held in native leJOS/Lego format.
     * @param src byte array containing the source image
     * @param sw Width of the source image
     * @param sh Height of the source image
     * @param sx X position to start the copy from
     * @param sy Y Position to start the copy from
     * @param dst byte array containing the destination image
     * @param dw Width of the destination image
     * @param dh Height of the destination image
     * @param dx X destination
     * @param dy Y destination
     * @param w width of the area to copy
     * @param h height of the area to copy
     * @param rop raster operation.
     */
    public void BitBlt(byte[] src, int sw, int sh, int sx, int sy, byte dst[], int dw, int dh, int dx, int dy, int w, int h, int rop) {
    	inner.bitBlt(src, sw, sh, sx, sy, dst, dw, dh, dx, dy, w, h, rop);
    }
    
    /**
     * Turn on/off the automatic refresh of the LCD display. At system startup
     * auto refresh is on.
     * @param on true to enable, false to disable
     */
    public void setAutoRefresh(boolean on) {
    	inner.setAutoRefresh(on);
    }
    
    /**
     * Set the period used to perform automatic refreshing of the display.
     * A period of 0 disables the refresh.
     * @param period time in ms
     * @return the previous refresh period.
     */
    public int setAutoRefreshPeriod(int period) {
    	return inner.setAutoRefreshPeriod(period);
    }

}
