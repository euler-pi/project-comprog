package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable
{
	//screen settings
	final int OriginalTilesize = 16; //16x16 tile
	final int scale = 3;
	
	public final int tilesize = OriginalTilesize * scale; // (16x16)*3 tile size	
	public final int maxscreenX_axis = 15; //screen size at x-axis
	public final int maxscreenY_axis = 15; //screen size at y-axis
	public final int screen_width = maxscreenX_axis * tilesize; // 768 pixels
	public final int screen_height = maxscreenY_axis * tilesize; // 576 pixels
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screen_width, screen_height));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() 
	{
		
		double drawInterval = 1000000000/FPS; // 0.01666 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime; 
		
		while(gameThread != null)
		{
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) /drawInterval;
			lastTime = currentTime;
			if(delta >= 1)
			{
				update();
				repaint();
				delta--;
				if(delta < 0)
                {
                  delta = 0;
                }        
			}
			
			
			// UPDATE
			update();
			//DRAW
			repaint();
			

         this.requestFocusInWindow();
		}
		
	}
	
	public void update()
	{
		player.update();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
	    tileM.draw(g2);
	    
		player.draw(g2);
		
		g2.dispose();
	}
}
