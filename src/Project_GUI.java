import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class Project_GUI {
	Scanner option = new Scanner(System.in);
	String filename = "C:\\Users\\Fabian\\Desktop\\'\\GameSaver\\src\\test.txt";
	String line = "";

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField devTextField;
	private JTextField releaseTextField;
	FileManager fi = new FileManager(filename);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project_GUI window = new Project_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(97, 11, 86, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		devTextField = new JTextField();
		devTextField.setBounds(97, 42, 86, 20);
		panel.add(devTextField);
		devTextField.setColumns(10);
		
		releaseTextField = new JTextField();
		releaseTextField.setBounds(97, 73, 86, 20);
		panel.add(releaseTextField);
		releaseTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 14, 46, 14);
		panel.add(lblName);
		
		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setBounds(21, 45, 66, 14);
		panel.add(lblDeveloper);
		
		JLabel lblReleased = new JLabel("Released");
		lblReleased.setBounds(21, 76, 66, 14);
		panel.add(lblReleased);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(49, 158, 89, 23);
		panel.add(btnSubmit);
		
		JCheckBox chckbxPlayed = new JCheckBox("Played");
		chckbxPlayed.setBounds(60, 110, 97, 23);
		panel.add(chckbxPlayed);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(232, 11, 255, 239);
		panel.add(textPane);
		
		JButton btnReadFile = new JButton("Read File");
		btnReadFile.setBounds(49, 227, 89, 23);
		panel.add(btnReadFile);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name, dev, rel, play = "";
				
				name = nameTextField.getText();
				dev = devTextField.getText();
				rel = releaseTextField.getText();
				
				if(chckbxPlayed.isSelected()) {
					play = "Yes";
				}
				else {
					play = "No";
				}
				
				AddGames add = new AddGames(name, dev, rel, play);
				add.addGame(fi);
				
				
			}
		});
		
		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ShowGames sh = new ShowGames();
				String games = sh.showGame(fi);
				textPane.setText(games);
			}
		});
	}
}
