package Default;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main69 
{
	private static JLabel label;
	private static JLabel labelPw;
	private static JTextField txtFieUs;
	private static JPasswordField pwFiePw;
	private static JButton button;
	private static JButton regButton;
	
	public static void main(String[] args) 
	{
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		
		frame.setTitle("PasswortManger");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		
		panel.setLayout(null); // Layout des Panels
		
		label = new JLabel("Username");//Erstellt Text innerhalb des Fensters
		label.setBounds(150, 80, 60, 30); // Position und größe des Feldes
		panel.add(label);
		
		labelPw = new JLabel("Passwort");
		labelPw.setBounds(150, 135, 60, 30);
		panel.add(labelPw);
		
		txtFieUs = new JTextField();//erstellt ein Feld in das man reinschreiben kann
		txtFieUs.setBounds(250, 85, 165, 25);
		panel.add(txtFieUs);
		
		pwFiePw = new JPasswordField(); //erstellt ein Password Feld in welches man rein schreiben kann
		pwFiePw.setBounds(250, 140, 165, 25);
		panel.add(pwFiePw);
		
		button = new JButton("Login");
		button.setBounds(145, 190, 65,20);
		button.addActionListener(new ActionListener() //Wird für einen Button benötigt, also wenn man auf den Button raufklickt wird das im ActionListener ausgeführt 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				frame.setVisible(false); //Login Fenster wird nicht mehr angezeigt
				
				String user = txtFieUs.getText();
				String pass = pwFiePw.getText();
			
				Operatoren.lesen(user, pass, frame);
				
			}
		});
		
		panel.add(button);
		
		regButton = new JButton("Registrieren");
		regButton.setBounds(300, 190, 110, 21);
		panel.add(regButton);
		frame.setVisible(true);
		regButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				
				Operatoren.schreibenBenutzer(frame);
				frame.setVisible(false);
			}
		});
		
	}

}
