package entity;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Entity 
{
	public float x, y;
	public float speed; 
	
	public BufferedImage front, front_step_right, front_step_left, back, back_step_right, back_step_left, rightside,rightside_step, leftside, leftside_step;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public boolean collisionOn = false;

}
