import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorSwatch c=new ColorSwatch();
		
		try {
			if (ImageIO.write(ColorSwatch.MakeSwatch(90, 90, "#FFFFFF", "#000000", "#FFFFFF"), "png", new File("./output_image.png")))
			{
				System.out.println("-- saved");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void SaveSwatch(String location, BufferedImage swatch) {
		
			try {
				if (ImageIO.write(swatch, "png", new File(location)))
				{
					System.out.println("-- saved");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public List<BufferedImage> LoadSwatchFile(int height, int width, String location) {
		File zipsfile=new File(location);
		FileReader fileReader;
		ArrayList<BufferedImage> swatches=new ArrayList<BufferedImage>();
		try {

			fileReader=new FileReader(zipsfile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] swatchlist=line.split(",");
				BufferedImage img;
				if(swatchlist.length==1) {
					img=ColorSwatch.MakeSwatch(height, width, swatchlist[0]);
				}
				else if (swatchlist.length==2) {
					img=ColorSwatch.MakeSwatch(height, width, swatchlist[0], swatchlist[1]);
				}
				else {
					img=ColorSwatch.MakeSwatch(height, width, swatchlist[0], swatchlist[1], swatchlist[2]);
				}
				swatches.add(img);


			}
			fileReader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return swatches;
	}

}
