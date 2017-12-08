import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class filechoser {
	//Declare Var
	String userhome = System.getProperty("user.home");
	JFileChooser fileChooser = new JFileChooser(userhome +"\\Desktop");
	ArrayList<String> words = new ArrayList<String>();
	java.io.File file;
	
	public String PickMe() throws Exception{
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
			
			System.out.println(file);
			
			input.close();
			return file.toString();
		}
		else{
			System.out.println("ERROR : FILE NOT CHOSEN");
		}
		return file.toString();
	}
}