package sprite.block;

import resource.ImageHolder;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.base.Sprite;

public class Floor extends Sprite{

	public Floor(double x, double y) {
		super();
		this.setPosition(new Point2D(x*getWidth(),y*getHeight()));
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image image = (ImageHolder.getInstance()).floor;
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());	

	}

	@Override
	public void update() {}



}
