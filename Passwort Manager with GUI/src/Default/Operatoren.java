package Default;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public abstract class Operatoren {

	private static JLabel labelKon;
	
	private static JLabel label2;
	private static JLabel labelPw2;
	private static JTextField txtFieUs2;
	private static JPasswordField pwFiePw2;
	private static JLabel labelKonto;
	private static JLabel labelZweck;
	private static JLabel labelPass;
	private static JTextField txtFieKon;
	private static JTextField txtFieZw;
	private static JPasswordField pwPass;

	static File datei = new File("D://passwortManager.txt"); // Datei Name und Pfad

	static boolean end = false;

	public static void schreibenBenutzer(JFrame frame) // Neuen Benutzer anlegen
	{
		
		JPanel panel3 = new JPanel();
		JFrame frame3 = new JFrame();
		
		frame3.setTitle("Registrierung");
		frame3.setSize(600,500);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Bei Schließung des Fensters wird das Programm beendet
		frame3.setLocationRelativeTo(null); //Der Frame wird in der Mitte des Bildschirms angezeigt
		frame3.add(panel3);
		
		panel3.setLayout(null);

		label2 = new JLabel("Username");//Erstellt Text innerhalb des Fensters
		label2.setBounds(120, 80, 60, 30);
		panel3.add(label2);
		
		labelPw2 = new JLabel("Passwort");
		labelPw2.setBounds(120, 135, 60, 30);
		panel3.add(labelPw2);
		
		labelZweck = new JLabel("Zweck");
		labelZweck.setBounds(120, 190, 60, 30);
		panel3.add(labelZweck);
		
		labelKonto = new JLabel("Benutzer");
		labelKonto.setBounds(120, 245 , 60, 30);
		panel3.add(labelKonto);
		
		labelPass = new JLabel("Benutzer Passwort");
		labelPass.setBounds(120, 300, 130, 30);
		panel3.add(labelPass);
		
		txtFieUs2 = new JTextField();//erstellt ein Feld in das man reinschreiben kann
		txtFieUs2.setBounds(250, 85, 165, 25);
		panel3.add(txtFieUs2);
		
		pwFiePw2 = new JPasswordField(); //erstellt ein Password Feld in welches man rein schreiben kann
		pwFiePw2.setBounds(250, 140, 165, 25);
		panel3.add(pwFiePw2);
		
		txtFieZw = new JTextField();
		txtFieZw.setBounds(250, 195, 165, 25);
		panel3.add(txtFieZw);
		
		txtFieKon = new JTextField();
		txtFieKon.setBounds(250, 250, 165, 25);
		panel3.add(txtFieKon);
		
		pwPass = new JPasswordField();
		pwPass.setBounds(250, 305, 165, 25);
		panel3.add(pwPass);
		
		JButton spButton = new JButton("Speichern");
		spButton.setBounds(120, 350, 115, 20);
		panel3.add(spButton);
		frame3.setVisible(true);
		spButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String user2 = txtFieUs2.getText();
				String pw2 = pwFiePw2.getText();
				String zweck = txtFieZw.getText();
				String benutzer = txtFieKon.getText();
				String pass2 = pwPass.getText();
				FileWriter writer; // Schreibt in die Datei

			try
				{
					writer = new FileWriter(datei, true); // Writer schreibt ans Ende der Datei(true)
					if(datei.length() == 0)//Tritt auf wenn noch nichts in der Datei steht
					{
						
						writer.write(user2);// Benutzereingabe wird in Dokument abgespeichert
						writer.write("  ");
						writer.write(Operatoren.verschlüsseln(pw2) + " ");
						writer.write("Zweck:" + zweck + "  ");
						writer.write("Konto:" + benutzer + " ");
						writer.write("Nutzer Passwort:" + pass2 + "  ");

						writer.flush(); // Entleert Zwischenspeicher
						writer.close();// Schließt den Writer
					}
			
					else if(datei.length() > 0) //Wenn bereits Text in der Datei vorhanden ist 
					{
						writer.write("\n" + user2);// Benutzereingabe wird in Dokument abgespeichert
						writer.write("  ");
						writer.write(Operatoren.verschlüsseln(pw2) + " ");
						writer.write("Zweck:" + zweck + "  ");
						writer.write("Konto:" + benutzer + " ");
						writer.write("Nutzer Passwort:" + pass2 + "  ");

						writer.flush(); // Entleert Zwischenspeicher
						writer.close();// Schließt den Writer
					}
				}

				catch (IOException a)
				{
					a.printStackTrace();
				}
			
			frame3.setVisible(false);
			frame.setVisible(true);
			
			}
			
		});
	}

	public static void weiteresKonto(JFrame frame, JFrame frame2Kon) // Für vorhandenen Nutzer ein weiter Konto
	{
		JPanel panel4 = new JPanel();
		JFrame frame4 = new JFrame();
		
		frame.setVisible(false);
		frame4.setTitle("Registrierung");
		frame4.setSize(600,500);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setLocationRelativeTo(null);
		frame4.add(panel4);
		
		panel4.setLayout(null);
		
		labelZweck = new JLabel("Zweck");
		labelZweck.setBounds(120, 80, 60, 30);
		panel4.add(labelZweck);
		
		labelKonto = new JLabel("Benutzer");
		labelKonto.setBounds(120, 135 , 60, 30);
		panel4.add(labelKonto);
		
		labelPass = new JLabel("Benutzer Passwort");
		labelPass.setBounds(120, 190, 130, 30);
		panel4.add(labelPass);
		
		txtFieZw = new JTextField();
		txtFieZw.setBounds(250, 85, 165, 25);
		panel4.add(txtFieZw);
		
		txtFieKon = new JTextField();
		txtFieKon.setBounds(250, 135, 165, 25);
		panel4.add(txtFieKon);
		
		pwPass = new JPasswordField();
		pwPass.setBounds(250, 190, 165, 25);
		panel4.add(pwPass);
		
		JButton spButton = new JButton("Speichern");
		spButton.setBounds(120, 250, 115, 20);
		spButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String zweck = txtFieZw.getText();
				String benutzer = txtFieKon.getText();
				String pass2 = pwPass.getText();
				FileWriter writer2;

				try
				{
					writer2 = new FileWriter(datei,true);
					writer2.write("Zweck:" + zweck + "  ");
					writer2.write("Konto:" + benutzer + " ");
					writer2.write("Nutzer Passwort:" + pass2 + " ");
			
					writer2.flush();
					writer2.close();

				}
		
				catch (IOException x) 
				{
					x.printStackTrace();
				}
				frame2Kon.setVisible(true);
			}		
		});
		panel4.add(spButton);
		frame4.setVisible(true);
	
	}

	public static String verschlüsseln(String passwort)
	{
		char[] stringTOArray = passwort.toCharArray();
	
		String key = "xhzKEMDYFY2fNduKur3P&y]VV&c]}e*l)t,y?v.g'Ix[aYIe,YlIeGT";
		char[] keyArray = key.toCharArray();
		int[] endErgebnis = new int[passwort.length()];
		
		for(int i = 0; i < passwort.length();i++)
		{
			endErgebnis[i] =  keyArray[i] + stringTOArray[i];
		}
	
		return Arrays.toString(endErgebnis);
	}
	
	
	public static void lesen(String user, String pw, JFrame frame) 
	{
		try 
		{
			JPanel panel2 = new JPanel();
			JFrame frame2 = new JFrame(); 
			
			Scanner scanner2 = new Scanner(datei); // Scanner der die Datei liest

			frame2.setTitle("Konten");
			frame2.setSize(1000,800);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setLocationRelativeTo(null);
			
			frame2.add(panel2);
			
			panel2.setLayout(null);
			
			while (scanner2.hasNextLine())// Überprüfung ob das Dokument überhaupt Inhalt hat
			{
				
				String line = scanner2.nextLine();//Datei wird Zeilenweise gelesen
				if (line.contains(user))// Wenn eingabe und User übereinstimmen
				{
					
					if (line.contains(Operatoren.verschlüsseln(pw)))// Wenn User und Passwort übereinstimmen
					{	frame.setVisible(false);
						labelKon = new JLabel(line);
						labelKon.setBounds(20, 5, 1100, 150);
						panel2.add(labelKon);
						
						JButton neuesKonto = new JButton("Weiteres Konto");
						neuesKonto.setBounds(20, 160, 150, 20);
						neuesKonto.addActionListener(new ActionListener() 
						{

							@Override
							public void actionPerformed(ActionEvent e)
							{
								Operatoren.weiteresKonto(frame, frame2);
								frame2.setVisible(false);
							}
						});
						panel2.add(neuesKonto);
						frame2.setVisible(true);
						break;
					
					}
					
					else if(!line.contains(Operatoren.verschlüsseln(pw)))
					{
						JOptionPane.showMessageDialog(panel2, "Falsches Passwort, versuchen Sie es erneut", "Fehler", JOptionPane.ERROR_MESSAGE);
						frame.setVisible(true);
					}
				}
				
				else if(!line.contains(user))
				{
					JOptionPane.showMessageDialog(panel2, "Falscher Username, versuchen Sie es erneut", "Fehler", JOptionPane.ERROR_MESSAGE);//Extra Fenster mit einer Feh
					frame.setVisible(true);
				}
				
			}
			
			scanner2.close();
			
		} 
		
		catch (FileNotFoundException e) 
			{
				
				e.printStackTrace();
			}
	}

}
