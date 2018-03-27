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
		if(hex.toCharArray().length>=6) {
			BufferedImage buf=MakeBuffered(height,width);
			Graphics2D g2d = (Graphics2D)buf.createGraphics();
			Color c=ColorSwatch.hex2Rgb(hex);
			if(c!=null) {
				g2d.setColor(c);
				g2d.fillRect(0, 0, height, width);
				return buf;
			}

		}
		return null;

	}
	public static BufferedImage MakeSwatch(int height, int width, String hex, String hex2) {
		if(hex.toCharArray().length>=5&hex2.toCharArray().length>=6) {
			BufferedImage buf=MakeBuffered(height,width);
			Graphics2D g2d = (Graphics2D)buf.createGraphics();
			Color color=ColorSwatch.hex2Rgb(hex);
			if(color!=null) {
				g2d.setColor(color);
				g2d.fillRect(0, 0, height/2, width);
			}
			else {
				return null;
			}
			color=ColorSwatch.hex2Rgb(hex2);
			if(color!=null) {
				g2d.setColor(color);
				g2d.fillRect(height/2, 0, height/2, width);
				return buf;
			}

		}
		return null;

	}
	public static BufferedImage MakeSwatch(int height, int width, String hex, String hex2, String hex3) {
		BufferedImage buf=MakeBuffered(height,width);
		Graphics2D g2d = (Graphics2D)buf.createGraphics();
		Color color=ColorSwatch.hex2Rgb(hex);
		if(color!=null) {
			g2d.setColor(color);
			g2d.fillRect(0, 0, height/3, width);
		}
		else {
			return null;
		}
		color=ColorSwatch.hex2Rgb(hex2);
		if(color!=null) {
			g2d.setColor(color);
			g2d.fillRect(height/3, 0, height/3, width);
		}
		else {
			return null;
		}
		color=ColorSwatch.hex2Rgb(hex3);
		if(color!=null) {
			g2d.setColor(ColorSwatch.hex2Rgb(hex3));
			g2d.fillRect((height/3)*2, 0, height/3, width);
			return buf;
		}
		return null;

	}
	public static Color hex2Rgb(String hex) {
		String colorStr=null;
		if(hex.contains("#")) {
			colorStr=hex;
		}
		else {
			colorStr="#"+hex;
		}
		if(colorStr.length()==7) {
			return new Color(
					Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
					Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
					Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
		}

		return null;
	}
}
