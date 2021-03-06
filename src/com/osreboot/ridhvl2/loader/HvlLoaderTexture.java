package com.osreboot.ridhvl2.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.Log;

/**
 * A standard HvlLoader implementation designed to handle images in the form of 
 * {@linkplain org.newdawn.slick.opengl.Texture Texture} objects.
 * 
 * @author os_reboot
 *
 */
public class HvlLoaderTexture extends HvlLoader<Texture>{

	/**
	 * Constructs an HvlLoaderTexture instance with the default path being "res".
	 */
	public HvlLoaderTexture(){
		this("res");
	}

	/**
	 * Constructs an HvlLoaderTexture instance with a user-specified default path.
	 * 
	 * @param defaultPathArg the default path for the HvlLoaderTexture
	 */
	public HvlLoaderTexture(String defaultPathArg){
		super(defaultPathArg, HvlLoader.TYPELABEL_TEXTURE, "PNG", "JPG", "JPEG");
		Log.setVerbose(false);
	}

	@Override
	public boolean load(String basePathArg, String pathArg){
		try{
			//TODO find a better way to handle this
			if(pathArg.toUpperCase().endsWith("PNG")){
				resources.add(TextureLoader.getTexture("PNG", new FileInputStream(basePathArg + File.separator + pathArg)));
				return true;
			}else if(pathArg.toUpperCase().endsWith("JPG")){
				resources.add(TextureLoader.getTexture("JPG", new FileInputStream(basePathArg + File.separator + pathArg)));
				return true;
			}else if(pathArg.toUpperCase().endsWith("JPEG")){
				resources.add(TextureLoader.getTexture("JPEG", new FileInputStream(basePathArg + File.separator + pathArg)));
				return true;
			}else return false;
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}

}
