package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity
{
	GamePanel gp;
	KeyHandler keyH;
	
	
	
	public Player(GamePanel gp, KeyHandler keyH)
	{
		this.gp = gp;
		this.keyH = keyH;
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues()
	{
		 x = 350.0f;
		 y = 350.0f; 
		 speed = 0.05f;
		 direction = "down";
	}
	public void getPlayerImage()
	{
		try
		{
			front = ImageIO.read(getClass().getResourceAsStream("/player/bianca_front.png"));
			front_step_right = ImageIO.read(getClass().getResourceAsStream("/player/bianca_front_Rs.png"));
			front_step_left = ImageIO.read(getClass().getResourceAsStream("/player/bianca_front_Ls.png"));
			back = ImageIO.read(getClass().getResourceAsStream("/player/bianca_back.png"));
			back_step_right = ImageIO.read(getClass().getResourceAsStream("/player/bianca_back_Rs.png"));
			back_step_left = ImageIO.read(getClass().getResourceAsStream("/player/bianca_back_Ls.png"));
			rightside = ImageIO.read(getClass().getResourceAsStream("/player/bianca_righside.png"));
			rightside_step = ImageIO.read(getClass().getResourceAsStream("/player/bianca_righside_step.png"));
			leftside = ImageIO.read(getClass().getResourceAsStream("/player/bianca_leftside.png"));
			leftside_step = ImageIO.read(getClass().getResourceAsStream("/player/bianca_leftside_step.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		if(keyH.upPressed == true || keyH.downPressed == true || 
		  keyH.rightPressed == true || keyH.leftPressed == true)
		{
			if(keyH.upPressed == true)
			{
				direction = "up";
				y -= speed; 
			}
			else if(keyH.downPressed == true)
			{
				direction = "down";
				y += speed;
			}
			else if(keyH.leftPressed == true)
			{
				direction = "left";
				x -= speed;
			}
			else if(keyH.rightPressed == true)
			{
				direction = "right";
				x += speed;
			}
			
			{
				switch(direction)
				{
				case "up":
					y -= speed; 
					break;
					
				case "down":
					y += speed;
					break;
					
				case "left":
					x -= speed;
					break;
					
				case "right":
					x += speed;
					break;
				}
			}
			spriteCounter++;
			if(spriteCounter > 10)
			{
				if(spriteNum == 1)
				{
					spriteNum = 2;
				}
				else if(spriteNum == 2)
				{
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
		
	}
	public void draw(Graphics2D g2)
	{

		
		BufferedImage image = null;
		
		switch(direction) 
		{
		case "up":
			if(spriteNum == 1)
			{
				image = back_step_left;
			}
			if(spriteNum == 2)
			{
				image = back_step_right;
			}
			
			break;
		case "down":
			if(spriteNum == 1)
			{
				image = front_step_left;
			}
			if(spriteNum == 2)
			{
				image = front_step_right;
			}
			
			break;
		case "right":
			if(spriteNum == 1)
			{
				image = rightside;
			}
			if(spriteNum == 2)
			{
				image = rightside_step;
			}
			
			break;
		case "left":
			if(spriteNum == 1)
			{
				image = leftside;
			}
			if(spriteNum == 2)
			{
				image = leftside_step;
			}
		
			break;
		}
		g2.drawImage(image, (int)x, (int)y, gp.tilesize, gp.tilesize, null);
		
	}
}
