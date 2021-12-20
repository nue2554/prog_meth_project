package sprite.block;

import resource.ImageHolder;
import interfaces.IDamageable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.base.Sprite;

public class Water extends Block{

	public Water(double x, double y) {
		super();
		health = 100;
		this.setPosition(new Point2D(x*getWidth(),y*getHeight()));
	}

	@Override
	public void draw(GraphicsContext gc) {

		Image image = (ImageHolder.getInstance()).water;
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());	
	}

	@Override
	public void update() {}

	@Override
	public void takeDamage(int damage) {}


}
