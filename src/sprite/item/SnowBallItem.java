package sprite.item;

import resource.ImageHolder;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import render.RenderableHolder;
import sprite.character.Penguin;
import sprite.equipment.weapon.Snowball;

public class SnowBallItem extends Item{

	public SnowBallItem(double x, double y) {
		super();
		this.setPosition(new Point2D(x,y));
	}

	@Override
	public void pick(Penguin penguin) {
		penguin.getWeapon().destroy();
		penguin.equipWeapon(
				new Snowball(penguin.getWeapon()));
		penguin.setSnowBallEquipedTime(System.currentTimeMillis());
		RenderableHolder.getInstance().add(penguin.getWeapon());		
	}
	
	
	
	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).snowItem;
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
