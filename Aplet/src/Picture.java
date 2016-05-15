import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Picture {
private Image img ;

public Picture()
{
	img = new Image() {
		
		@Override
		public int getWidth(ImageObserver observer) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public ImageProducer getSource() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getProperty(String name, ImageObserver observer) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getHeight(ImageObserver observer) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Graphics getGraphics() {
			// TODO Auto-generated method stub
			return null;
		}
	};
}
public Image getImg() {
	return img;
}

public void setImg(Image img) {
	this.img = img;
}

	
}
