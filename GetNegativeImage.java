import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.*;

public class GetNegativeImage{
  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    File f = null;

    //read image
    try{
      f = new File("/home/shockwave/Desktop/GRE/g.jpg");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println(e);
    }


//Get Width and Height of Image
int width = img.getWidth();
int height = img.getHeight();

for(int y=0; y< height; y++){
	for(int x = 0; x < width; x++){
	int p = img.getRGB(x,y);
	int a = (p>>24)&0xff;
	int r = (p>>16)&0xff;
	int g = (p>>8)&0xff;
	int b = p&0xff;

	r = Math.abs(255 -r);
	g = Math.abs(255 -g);
	b = Math.abs(255 -b);
	p = (a<<24) | (r<<16) | (g<<8) | b;

        img.setRGB(x, y, p);

	}	
}
//Write Output Image File
try{
      f = new File("/home/shockwave/Desktop/GRE/g_output.jpg");
      ImageIO.write(img, "jpg", f);
    }catch(IOException e){
      System.out.println(e);
    }
  }
}

