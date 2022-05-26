package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;




public class TileManager 
{
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][] = null;
	
	public TileManager(GamePanel gp)
	{
		this.gp = gp;		
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage()
	{
		try
		{
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/sand_tile.png"));
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2)
	{
		int column = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(column < gp.maxscreenY_axis && row < gp.maxscreenX_axis)
		{
			g2.drawImage(tile[0].image, x, y, gp.tilesize, gp.tilesize, null);
			column++;
			x += gp.tilesize;
			
			if(column == gp.maxscreenY_axis)
			{
				column = 0; 
				x = 0;
				row++;
				y += gp.tilesize;
			}
		}
		
	}
	
}
