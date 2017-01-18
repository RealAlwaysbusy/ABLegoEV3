package com.ab.ablegoev3;

import java.io.IOException;
import java.io.InputStream;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.lcd.Image;
import lejos.internal.ev3.EV3GraphicsLCD;

/**
 * Provides support for in memory images.
 * The format of the bitmap is in standard leJOS format (so aligned for use on
 * EV3 LCD display). There is one bit per pixel. The pixels are packed into bytes
 * with each byte spanning 8 scan lines. The least significant bit of each byte
 * is the pixel for the top most scan line, the most significant bit is the
 * 8th scan line. Values of 1 represent black. 0 white. This class implements a
 * sub set of the standard lcdui Image class. Only mutable images are supported
 * and the ARGB methods are not available.
 */
@Author("Alain Bailleul")      
@ShortName("ABLImage")
public class ABLImage {
	protected Image inner;
	/**
     * Create an image using an already existing byte array. The byte array is
     * used to store the image data. The array may already be initialized with
     * image data.
     * <br>Note: This is a non standard constructor.
     * @param width width of the image
     * @param height height of the image
     * @param data The byte array to be used for image store/
     */
    public void Initialize3(int width, int height, byte[] data)
    {
        inner = new Image(width, height, data);
    }
    

    /**
     * Create ablank image of the requested size.
     * @param width
     * @param height
     * @return Returns the new image.
     */
    public void Initialize(int width, int height) {
    	inner = Image.createImage(width, height);        
    }

    /**
     * Read image from file. An image file has the following format:
     * <table border="1">
     * <tr>
     * <th>1st byte - 4th byte</th>
     * <th>5th byte - 8th byte</th>
     * <th>9th byte</th>
     * <th>10th byte ....</th>
     * </tr>
     * <tr>
     * <td><i>image-width (int)</i></td>
     * <td><i>image-height (int)</i></td>
     * <td><code>0x00</code>(<i>image data delimit</i>)</td>
     * <td><i>byte image data</i>....</td>
     * </table>
     * <p>
     * For example:
     * </p>
     * After a file with content
     * <table border="1">
     * <tr>
     * <th>width (int)</th>
     * <th>height (int)</th>
     * <th>delimit</th>
     * <th colspan="3">byte data</th>
     * </tr>
     * <tr>
     * <td>00 00 00 03</td>
     * <td>00 00 00 05</td>
     * <td>00</td>
     * <td>00</td>
     * <td>02</td>
     * <td>1f</td>
     * </tr>
     * </table>
     * was read, this method will return an object which is equivalent to
     * <div style="margin-left:4em;"><code>new Image(3, 5, new byte[] {(byte)0x00, (byte)0x02, (byte)0x1f})</code></div>
     * @param s The input stream for the image file.
     * @return an ev3 image object.
     * @throws IOException if an input or output error occurs or file format is not correct.
     * @see Image
     * @see Image#Image(int, int, byte[])
     */
    public void Initialize2(InputStream s) throws IOException  {
    	inner = Image.createImage(s);    	
    }

    /**
     * Creates a new image based upon the transformed region of another image
     * @param image Source image
     * @param x x co-ordinate of the source region
     * @param y y co-ordinate of the source region
     * @param w width of the source region
     * @param h height of the source region
     * @param transform Transform to be applied
     * @return New image
     */
   
    /**
     * Return the width of the image.
     * @return Image width
     */
    public int getWidth()
    {
        return inner.getWidth();
    }

    /**
     * return the height of the image.
     * @return image height
     */
    public int getHeight()
    {
        return inner.getHeight();


    }

    /**
     * Return the byte array used to hold the image data.
     * <br>Note: This is a non standard method.
     * @return The image byte array.
     */
    public byte[] getData()
    {
        return inner.getData();
    }

    /**
     * Returns a graphics object that can be used to draw to the image.
     * @return graphics object.
     * @see GraphicsLCD
     */
    public ABLGraphicsLCD getGraphics() {
    	return new ABLGraphicsLCD(new EV3GraphicsLCD(getData(), getWidth(), getHeight()));    	
    }
}
