package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.lcd.GraphicsLCD;

@Author("Alain Bailleul")      
@ShortName("ABLGraphicsLCD")
public class ABLGraphicsLCD {
	protected GraphicsLCD inner;
	
	public static final int TRANS_MIRROR = 2;
	public static final int TRANS_MIRROR_ROT180 = 1;
	public static final int TRANS_MIRROR_ROT270 = 4;
	public static final int TRANS_MIRROR_ROT90 = 7;
	public static final int TRANS_NONE = 0;
	public static final int TRANS_ROT180 = 3;
	public static final int TRANS_ROT270 = 6;
	public static final int TRANS_ROT90 = 5;
		
	public static final int HCENTER = 1;
	public static final int VCENTER = 2;
	public static final int LEFT = 4;
	public static final int RIGHT = 8;
	public static final int TOP = 16;
	public static final int BOTTOM = 32;
	public static final int BASELINE = 64;
	public static final int SOLID = 0;
	public static final int DOTTED = 1;
	public static final int BLACK = 0;
	public static final int WHITE = 0xffffff;
	
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
    
    public ABLGraphicsLCD(GraphicsLCD graphicsLCD) {
    	inner = graphicsLCD;    	
    }
	
	/**
     * Method to set a pixel on the screen.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param color the pixel color (0 = white, 1 = black)
     */
    public void SetPixel(int x, int y, int color) {
    	inner.setPixel(x, y, color);
    }
    
    /**
     * Method to get a pixel from the screen.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the pixel color (0 = white, 1 = black)
     */
    public int GetPixel(int x, int y) {
    	return inner.getPixel(x, y);
    }
    
    /**
     * Draws the specified String using the current font and color. x and y
     * give the location of the anchor point. Additional method to allow for
     * the easy use of inverted text. In this case the area below the string
     * is drawn in the current color, before drawing the text in the "inverted"
     * color.
     * <br><b>Note</b>: This is a non standard method.
     * @param str the String to be drawn
     * @param x the x coordinate of the anchor point
     * @param y the y coordinate of the anchor point
     * @param anchor the anchor point for positioning the text
     * @param inverted true to invert the text display.
     */
    public void DrawString2(String str, int x, int y, int anchor, boolean inverted) {
    	inner.drawString(str, x, y, anchor, inverted);
    }
    
    /**
     * Draws the specified String using the current font and color. x and y
     * give the location of the anchor point.
     * @param str the String to be drawn
     * @param x the x coordinate of the anchor point
     * @param y the y coordinate of the anchor point
     * @param anchor the anchor point for positioning the text
     */
    public void DrawString(String str, int x, int y, int anchor) {
    	inner.drawString(str, x, y, anchor);
    }
    
    /**
     * Draw a substring to the graphics surface using the current color.
     * @param str the base string
     * @param offset the start of the sub string
     * @param len the length of the sub string
     * @param x the x coordinate of the anchor point
     * @param y the x coordinate of the anchor point
     * @param anchor the anchor point used to position the text.
     */
    public void DrawSubstring(String str, int offset, int len, int x, int y, int anchor) {
    	inner.drawSubstring(str, offset, len, x, y, anchor);
    }
    
    /**
     * Draw a single character to the graphics surface using the current color.
     * @param character the character to draw
     * @param x the x coordinate of the anchor point
     * @param y the x coordinate of the anchor point
     * @param anchor the anchor point used to position the text.
     */
    public void DrawChar(char character, int x, int y, int anchor) {
    	inner.drawChar(character, x, y, anchor);
    }
    
    /**
     * Draw a series of characters to the graphics surface using the current color.
     * @param data the characters
     * @param offset the start of the characters to be drawn
     * @param length the length of the character string to draw
     * @param x the x coordinate of the anchor point
     * @param y the x coordinate of the anchor point
     * @param anchor the anchor point used to position the text.
     */
    public void DrawChars(char[] data, int offset, int length, int x, int y, int anchor) {
    	inner.drawChars(data, offset, length, x, y, anchor);
    }
    
    /**
     * Return the current stroke style.
     * @return current style.
     */
    public int GetStrokeStyle() {
    	return inner.getStrokeStyle();
    }

    /**
     * Set the stroke style to be used for drawing operations.
     * @param style new style.
     */
    public void SetStrokeStyle(int style) {
    	inner.setStrokeStyle(style);
    }
    
    /**
     * Draw the specified image to the graphics surface, using the supplied rop.
     * <br><b>Note</b>: This is a non standard method.
     * Added because without it, it is very
     * hard to invert/manipulate an image, or screen region
     * @param src image to draw (may be null for ops that do not require input.
     * @param sx x offset in the source
     * @param sy y offset in the source
     * @param w width of area to draw
     * @param h height of area to draw.
     * @param x destination
     * @param y destination
     * @param anchor location of the anchor point
     * @param rop drawing operation.
     * @see Image
     */
    public void DrawRegionRop2(ABLImage src, int sx, int sy, int w, int h, int x, int y, int anchor, int rop) {
    	inner.drawRegionRop(src.inner, sx, sy, w, h, x, y, anchor, rop);
    }
    
    /**
     * Draw the specified region of the source image to the graphics surface
     * after applying the requested transformation, use the supplied rop.
     * <br>NOTE: When calculating the anchor point this method assumes that
     * a transformed version of the source width/height should be used.
     * @param src The source image
     * @param sx x coordinate of the region
     * @param sy y coordinate of the region
     * @param w width of the region
     * @param h height of the region
     * @param transform the required transform
     * @param x x coordinate of the anchor point
     * @param y y coordinate of the anchor point
     * @param anchor type of anchor
     * @param rop raster operation used to draw the output.
     */
    public void DrawRegionRop(ABLImage src, int sx, int sy, int w, int h, int transform, int x, int y, int anchor, int rop) {
    	inner.drawRegionRop(src.inner, sx, sy, w, h, transform, x, y, anchor, rop);
    }
    
    /**
     * Draw the specified region of the supplied image to the graphics surface.
     * NOTE: Transforms are not currently supported.
     * @param src image to draw (may be null for ops that do not require input.
     * @param sx x offset to the region
     * @param sy y offset to the region
     * @param w width of the region
     * @param h height of the region
     * @param transform 
     * @param x destination
     * @param y destination
     * @param anchor location of the anchor point
     * @see Image
     */
    public void DrawRegion(ABLImage src, int sx, int sy, int w, int h, int transform, int x, int y, int anchor) {
    	inner.drawRegion(src.inner, sx, sy, w, h, transform, x, y, anchor);
    }
    
    /**
     * Draw the specified image to the graphics surface, using the supplied rop.
     * @param src image to draw (may be null for ops that do not require input.
     * @param x destination
     * @param y destination
     * @param anchor location of the anchor point
     * @see Image
     */
    public void DrawImage(ABLImage src, int x, int y, int anchor) {
    	inner.drawImage(src.inner, x, y, anchor);
    }
    
    /**
     * Draw a line between the specified points, using the current color and style.
     * @param x0 x start point
     * @param y0 y start point
     * @param x1 x end point
     * @param y1 y end point
     */
    public void DrawLine(int x0, int y0, int x1, int y1) {
    	inner.drawLine(x0, y0, x1, y1);
    }
    
    /**
     * Draw an arc, using the current color and style.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param startAngle
     * @param arcAngle
     */
    public void DrawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    	inner.drawArc(x, y, width, height, startAngle, arcAngle);
    }
    
    /**
     * Draw a filled arc, using the current color.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param startAngle
     * @param arcAngle
     */
    public void FillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    	inner.fillArc(x, y, width, height, startAngle, arcAngle);
    }
    
    /**
     * Draw a rounded rectangle.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param arcWidth
     * @param arcHeight
     */
    public void DrawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
    	inner.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    
    /**
     * Draw a rectangle using the current color and style.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void DrawRect(int x, int y, int width, int height) {
    	inner.drawRect(x, y, width, height);
    }
    
    /**
     * Draw a filled rectangle using the current color.
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public void FillRect(int x, int y, int width, int height) {
    	inner.fillRect(x, y, width, height);
    }
    
    /**
     * Copy one rectangular area of the drawing surface to another.
     * @param sx Source x
     * @param sy Source y
     * @param w Source width
     * @param h Source height
     * @param x Destination x
     * @param y Destination y
     * @param anchor location of the anchor point of the destination.
     */
    public void CopyArea(int sx, int sy, int w, int h, int x, int y, int anchor) {
    	inner.copyArea(sx, sy, w, h,  x, y, anchor);
    }
    
    /**
     * Return the currently selected font object.
     * @return Current font.
     */
    public ABLFont getFont() {
    	return new ABLFont(inner.getFont());    	
    }

    /**
     * Set the current font
     * @param f the font
     */
    public void setFont(ABLFont font) {
    	inner.setFont(font.inner);
    }
    
    /**
     * Translates the origin of the graphics context to the point
     * (x, y) in the current coordinate system. Calls are cumulative.
     *
     * @param x the new translation origin x value
     * @param y new translation origin y value
     * @see #getTranslateX()
     * @see #getTranslateY()
     */
    public void Translate(int x, int y) {
    	inner.translate(x, y);
    }
    
    /**
     * Gets the X coordinate of the translated origin of this graphics context.
     * @return X of current origin
     */
    public int getTranslateX() {
    	return inner.getTranslateX();
    }
    
    /**
     * Gets the Y coordinate of the translated origin of this graphics context.
     * @return Y of current origin
     */
    public int getTranslateY() {
    	return inner.getTranslateY();
    }
    
    /**
     * Set the current drawing color. The value is in the format 0x00RRGGBB.
     * NOTE. Currently only black and white is supported. any non black color
     * is treated as white!
     * @param rgb new color.
     */
    public void SetColor(int rgb) {
    	inner.setColor(rgb);
    }
    
    /**
     * Sets the current color to the specified RGB values.
     * @param red the red component
     * @param green the green component
     * @param blue the blue
     * @throws IllegalArgumentException if any of the color components
     * are outside of range <code>0-255</code>
     */
    public void SetColor2(int red, int green, int blue) {
    	inner.setColor(red, green, blue);
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
