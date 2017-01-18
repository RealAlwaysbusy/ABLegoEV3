package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.video.Video;
import lejos.hardware.video.VideoUtils;

@Author("Alain Bailleul")      
@ShortName("ABLVideo")  
public class ABLVideo {
	protected Video inner;
	
	// We only provide the most common formats and definitions
    public static final int PIX_FMT_MJPEG = VideoUtils.fourcc('M', 'J', 'P', 'G'); /* Motion-JPEG   */
    public static final int PIX_FMT_JPEG  = VideoUtils.fourcc('J', 'P', 'E', 'G'); /* JFIF JPEG     */
    public static final int PIX_FMT_YUYV  = VideoUtils.fourcc('Y', 'U', 'Y', 'V'); /* 16  YUV 4:2:2 */
    
    public static final int FIELD_ANY = 0;
    public static final int FIELD_NONE = 1;
    public static final int FIELD_INTERLACED = 4;
	
	ABLVideo(Video video) {
		inner = video;
	}
	
    /**
     * Open the device and make it available for use, specify the desired frame size. Note that the actual
     * frame size may be adjusted to conform to the capabilities of the device.
     * @param w the desired frame width
     * @param h the desired frame height
     * @param format desired pixel format
     * @param field desired field layout
     * @param fps the desired frame rate
     * @throws java.io.IOException
     */
    public void Open2(int w, int h, int format, int field, int fps) throws java.io.IOException {
    	inner.open(w, h, format, field, fps);
    }

    /**
     * Open the device and make it available for use, specify the desired frame size. Note that the actual
     * frame size may be adjusted to conform to the capabilities of the device.
     * @param w the desired frame width
     * @param h the desired frame height
     * @throws java.io.IOException
     */
    public void Open(int w, int h) throws java.io.IOException {
    	inner.open(w, h);
    }

    /**
     * Grab a single frame from the device and store the image into the supplied array
     * @param frame array to store the frame
     * @return the size of the frame grabbed (in bytes)
     * @throws java.io.IOException
     */
    public int GrabFrame(byte[] frame) throws java.io.IOException {
    	return inner.grabFrame(frame);
    }
  
    /**
     * Close the webcam, the device will not be available after this call  
     * @throws java.io.IOException
     */
    public void Close() throws java.io.IOException {
    	inner.close();
    }
      
  

    /**
     * Create a byte array suitable for holding a single video frame
     * @return the frame array
     */
    public byte[] CreateFrame() {
    	return inner.createFrame();
    }
  
    /**
     * Return the frame width
     * @return width in pixels
     */
    public int getWidth() {
    	return inner.getWidth();
    }

    /**
     * return the frame height
     * @return height in pixels
     */
    public int getHeight() {
    	return inner.getHeight();
    }
}
