package sprite.item;

import game.Player;
import gui.shop.ShopManager;
import resource.ImageHolder;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.character.Penguin;

public class Fish extends Item{
	int fish;
	public Fish(double x, double y, int fish) {
		super();
		this.fish = fish;
		this.setPosition(new Point2D(x,y));
	}
	
	@Override
	public void pick(Penguin penguin) {
		ShopManager.getInstance().addFish(fish);
	}

	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).fish01;
		if(isDestroyed()) {
			image = (ImageHolder.getInstance()).floor;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void update() {}
}
