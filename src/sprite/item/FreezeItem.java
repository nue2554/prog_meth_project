package sprite.item;

import resource.ImageHolder;
import game.GameLogic;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.character.Penguin;

public class FreezeItem extends Item{

	public FreezeItem(double x, double y) {
		super();
		this.setPosition(new Point2D(x,y));
	}

	@Override
	public void pick(Penguin penguin) {
		GameLogic.getInstance().setFreeze(true);
		GameLogic.getInstance().setFreezeTime(System.currentTimeMillis());
		
	}
	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).freezeItem;
		if(isDestroyed()) {
			image = (ImageHolder.getInstance()).floor;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void update() {	}
}
