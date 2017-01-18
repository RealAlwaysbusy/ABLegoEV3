package com.ab.ablegoev3;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import lejos.hardware.lcd.Font;

@Author("Alain Bailleul")      
@ShortName("ABLFont")
public class ABLFont {
	
	protected Font inner;
	
	public final static int SIZE_SMALL = 8;
    public final static int SIZE_MEDIUM = 0;
    public final static int SIZE_LARGE = 16;
    
	/**
     * Create a new font for the specified NXT format glyph map
     * @param glyphs the actual bytes of the glyph.
     * @param width The cell width.
     * @param height The cell height.
     * @param glyphWidth The width of the glyph bits.
     */
	
	public ABLFont(Font font) {
		inner = font;
	}
	
	/*
	protected ABLFont(byte[] glyphs, int width, int height, int base, int glyphWidth, int count, int first) {
        inner = new Font(glyphs, width, height, base, glyphWidth, count, first);
    }
    */
    
    /**
     * Return the system font.
     * @return current system font object
     */
    public static ABLFont GetDefaultFont() {
    	return new ABLFont(Font.getDefaultFont());        
    }

    /**
     * return the height of the font in pixels.
     * @return pixel height
     */
    public int getHeight()
    {
        return inner.getHeight();
    }

    /**
     * Return the base line position in pixels. This is the offset from the
     * top of the font.
     * @return base position.
     */
    public int getBaselinePosition()
    {
        return inner.getBaselinePosition();
    }

    /**
     * Return the width of the specified string in pixels
     * @param str
     * @return width of the string
     */
    public int StringWidth(String str)
    {
        return inner.stringWidth(str);
    }

    /**
     * Request a particular type and size of font. Currently only the size
     * parameter is used and it should be one of SIZE_SMALL, SIZE_MEDIUM or
     * SIZE_LARGE.
     * @param face
     * @param style
     * @param size
     * @return The requested Font
     */
    public static ABLFont Font(int face, int style, int size) {
    	if (size == SIZE_SMALL) {
            return SmallFont();        	
    	} else {
    		if (size == SIZE_LARGE) {
    			return LargeFont();    			
    		} else {
    			return GetDefaultFont();    			
    		}
    	}
    }

    // The following non-standard methods can be used to access the additional
    // fonts. Using them requires less memory than getFont.
    /**
     * Return the small font.
     * @return the small font
     */
    public static synchronized ABLFont SmallFont() {
    	return new ABLFont(Font.getSmallFont());    	
    }

    /**
     * Return the large font.
     * @return the large font
     */
    public static synchronized ABLFont LargeFont() {
    	return new ABLFont(Font.getLargeFont());    	
    }
}
