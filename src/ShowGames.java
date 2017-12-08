import java.util.ArrayList;

public class ShowGames {
	
	public String showGame(FileManager fi) {
	
	ArrayList<String> values = new ArrayList<String>();
	String str = "";
	String games = "";
	
	fi.connectToFile();
	values = fi.readFile();
	
	str = values.toString();
	
	str = str.replace("[", "");
	str = str.replace("]", "");
	str = str.replace(";", ";\n");
	
	for(String game : values) {
		games += game + "\n";
	}
	
	return games;
	}
	
}
