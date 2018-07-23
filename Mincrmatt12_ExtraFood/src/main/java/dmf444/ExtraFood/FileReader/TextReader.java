package dmf444.ExtraFood.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dmf444.ExtraFood.util.EFLog;

public class TextReader {
	// Convinecnce class used to read text files
	
	// The actual class I use for reading files
	BufferedReader buff;
	
	// All the lines, in order
	ArrayList<String> lines;
	
	public TextReader(String path){
		try {
			buff = new BufferedReader(new FileReader(path));
			lines = new ArrayList<String>();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return;
		}
	}
	
	public TextReader(File path){
		try {
			EFLog.error(path.getAbsolutePath());
			EFLog.info(path.exists());
			buff = new BufferedReader(new FileReader(path));
			lines = new ArrayList<String>();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return;
		}
	}
	
	public void parse() throws IOException{
		String line = buff.readLine();
		while (line != null){
			lines.add(line);
			line = buff.readLine();
		}
	}
	public String getLine(int index){
		return lines.get(index);
	}
	public ArrayList<String> allLines(){
		return this.lines;
	}
	

}
