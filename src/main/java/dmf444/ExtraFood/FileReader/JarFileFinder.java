package dmf444.ExtraFood.FileReader;
// This code is complex. dmf444, have a good time not exploding as you try and understand what this does
// For bonus points, ignore the comments

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.client.Minecraft;
import dmf444.ExtraFood.util.EFLog;

public class JarFileFinder {
	
	String jarname = "ExtraFood-1.7.10-0.4b.jar";
	
	// On release set to false. YOU MUST! (I have it set to false because a skeleton jarfile is in my mods folder containing the files
	boolean debug = false;
	
	
	// Gets set to true when mod is loaded and paths are resolved
	
	ZipFile jar = null;
	
	String path = null;
	public JarFileFinder(){
	}
	
	// Call after minecraft is fully initialized, it sets up jarfile stuff
	public void init(){
		if (debug == true){
			return;
		}
		else {
			String jfile = Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
			EFLog.error(jfile);
			jfile = jfile.substring(0, jfile.length() - 1);
			EFLog.error(jfile);
			jfile = jfile.replace('\\', '/');
			EFLog.error(jfile);
			jfile.replace(".", "");
			EFLog.error(jfile);
			path = jfile;
			jfile += "mods/" + jarname;
			EFLog.error(jfile);
			try {
				File f = new File(jfile);
				EFLog.error(f.exists());
				jar = new ZipFile(f);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				EFLog.error("Failed To do jar :( | " + e.getMessage());
				
				return;
			}
			jfile = Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
			jfile = jfile.replace('\\', '/');
			jfile.replace("/.", "");
			path = jfile;
			
			
			
		}
	}
	// Returns a file linked to the extracted file in , the temp directory
	public File extractFile(String path, String tmp){
		
		File testfile = new File(this.path + "/eftemp");
		if (testfile.exists() && testfile.isDirectory()){
			if (debug == false){testfile.deleteOnExit();};
		}
		else {
			testfile.mkdir();
			testfile.deleteOnExit();
		}
		
		
		if (tmp == null){
			tmp = "filefrom_" + path;
		}
		if (debug == true){
			File retval = new File(this.path + "/eftemp/" + tmp);
			return retval;
		}
		else {
		File retval = new File(this.path + "/eftemp/" + tmp);
		if (retval.exists()){
			retval.deleteOnExit();
			return retval;
		}
		else {
			// Hard copy everything (in byte form) to the other file
			try {
				ZipEntry jentry = jar.getEntry(path);
			InputStream istream = jar.getInputStream(jentry);
			FileOutputStream ostream = new FileOutputStream(retval);
			while (istream.available() > 0){
				ostream.write(istream.read());
			} 
			ostream.close();
			istream.close();
			retval.deleteOnExit();
			return retval;
			}
			catch (Exception e){
				EFLog.error("Problem reading jarfile");
				return null;
			}
			
			
		}}
		
		
	}
	// Pass the file from jarreader.extractFile() to this function to delete it when you are done with it
	 public void cleanFile(File jarfilefiletoclean){
		 
	 }
	 
}
