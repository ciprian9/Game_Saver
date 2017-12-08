import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.ArrayList;

public class FileManager {
	
	// attributes 

	private String fileName;
	private File choice;
	private Scanner input;
	private Writer fileWriter = null;
		
	// Constructor
	FileManager (String fileName)
	{
			
		this.fileName = fileName;
			
	}
		
	// Method to get a connection to the file, before reading or writing 
	void connectToFile()
	{
		choice = new File(fileName);
	}
	   	
	// Method to read a  file, returning a string of lines
	ArrayList<String> readFile()
	{
		ArrayList<String> values = new ArrayList<String>();
		try
		{
		    	
			//get a scanner object
			input = new Scanner(choice);
		    	
			//use the scanner to scroll through the lines of the file
			while (input.hasNext())
			{      
				values.add(input.next());
			}
			return values;
				 
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}

		return values;

	}
	    

	// File writing: method to get hold of a Print writer object
	void getFileWriter() throws IOException
	{
		try
		{
	    	fileWriter = new FileWriter(fileName, true);
	    }
	    catch (FileNotFoundException e)
	    {
	    	System.out.println("run time error " + e.getMessage());
	    }
	    	
	}	
	 
	// File writing: method to write a string to the file
    void writeLineToFile(String line) throws IOException
	{
    	System.out.println(line);
	  	fileWriter.write(line);
	}	

	    
	// Method to close a file that was read
	void closeReadFile()
	{
		input.close();
	}

	// Method to close a file that was written to..
	void closeWriteFile() throws IOException
	{
		fileWriter.close();
	}
	
	void checkword(String word){
		//put inside a try
		try{
			//make a scanner obj
			input = new Scanner(choice); 
			//while input has a next line
			while (input.hasNext()){   
				if(input.next().equals(word)){
					continue;
				}
			}
		}
		//if can't
		catch(FileNotFoundException e){
			//print error
			System.out.println("error : " + e.getMessage());
		}
	}
	
	ArrayList<String> readLines(){
		ArrayList<String> file = new ArrayList<String>();
		//put inside a try
		try{
			//make a scanner obj
			input = new Scanner(choice); 
			//while input has a next line
			while (input.hasNextLine())
			{   
				//checkword(null);
				//printing the lines
				file.add(input.nextLine());
			}
			return file;
		}
		//if can't
		catch(FileNotFoundException e){
			//print error
			System.out.println("error : " + e.getMessage());
		}
		return file;
	}
}