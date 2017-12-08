import java.io.IOException;

public class AddGames {
	private String string;
	private String name, rel, dev, play;
	
	
	public AddGames(String name2, String dev2, String rel2, String play2) {
		this.setName(name2);
		this.setDev(dev2);
		this.setRel(rel2);
		this.setPlay(play2);
	}


	public void addGame(FileManager fi){
		string = name+":"+dev+":"+rel+":"+play+";"+"\n";
		
		fi.connectToFile();
		try {
			fi.getFileWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.writeLineToFile(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.closeWriteFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public String getRel() {
		return rel;
	}


	public void setRel(String rel) {
		this.rel = rel;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDev() {
		return dev;
	}


	public void setDev(String dev) {
		this.dev = dev;
	}


	public String getPlay() {
		return play;
	}


	public void setPlay(String play) {
		this.play = play;
	}
}
