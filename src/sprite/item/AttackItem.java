package sprite.item;

import resource.ImageHolder;
import game.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.character.Penguin;

public class AttackItem extends Item{
	
	private int attackBuff;
	
	public AttackItem(double x, double y) {
		super();
		attackBuff = 10;
		this.setPosition(new Point2D(x,y));
	}
	@Override
	public void pick(Penguin penguin) {
		Player.getInstance().addItemAttack(attackBuff);
		penguin.buffAttack(attackBuff);
	}

	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).attackItem;
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
