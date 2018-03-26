import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ColorSwatch {
	public int width;
	public int height;
	public static BufferedImage MakeBuffered(int height, int width) {
		return new BufferedImage(height,width,BufferedImage.TYPE_INT_RGB);
	}
	public static BufferedImage MakeSwatch(int height, int width, String hex) {
		BufferedImage buf=MakeBuffered(height,width);
		Graphics2D g2d = (Graphics2D)buf.createGraphics();
		g2d.setColor(ColorSwatch.hex2Rgb(hex));
		g2d.fillRect(0, 0, height, width);
		return buf;

	}
	public static BufferedImage MakeSwatch(int height, int width, String hex, String hex2) {
		BufferedImage buf=MakeBuffered(height,width);
		Graphics2D g2d = (Graphics2D)buf.createGraphics();
		g2d.setColor(ColorSwatch.hex2Rgb(hex));
		g2d.fillRect(0, 0, height/2, width);
		g2d.setColor(ColorSwatch.hex2Rgb(hex2));
		g2d.fillRect(height/2, 0, height/2, width);
		return buf;

	}
	public static BufferedImage MakeSwatch(int height, int width, String hex, String hex2, String hex3) {
		BufferedImage buf=MakeBuffered(height,width);
		Graphics2D g2d = (Graphics2D)buf.createGraphics();
		g2d.setColor(ColorSwatch.hex2Rgb(hex));
		g2d.fillRect(0, 0, height/3, width);
		g2d.setColor(ColorSwatch.hex2Rgb(hex2));
		g2d.fillRect(height/3, 0, height/3, width);
		g2d.setColor(ColorSwatch.hex2Rgb(hex3));
		g2d.fillRect((height/3)*2, 0, height/3, width);
		return buf;

	}
	public static Color hex2Rgb(String hex) {
		String colorStr=null;
		if(hex.contains("#")) {
			colorStr=hex;
		}
		else {
			colorStr="#"+hex;
		}
		return new Color(
				Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
				Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
				Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
}
