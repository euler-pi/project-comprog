package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		GamePanel panel = new GamePanel();
		window.add(panel);
		window.pack();
		
		panel.startGameThread();
	}

}
