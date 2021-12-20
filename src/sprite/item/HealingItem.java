package sprite.item;

import resource.ImageHolder;
import game.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.character.Penguin;

public class HealingItem extends Item{
	
	private int Heal;
	
	public HealingItem(double x, double y) {
		super();
		Heal = 50;
		this.setPosition(new Point2D(x,y));
	}

	@Override
	public void pick(Penguin penguin) {

		System.out.println("Heal"+penguin.getHealth()+" + "+Heal+" > "+ penguin.getMaxHealth());
		System.out.println("Heal"+Player.getInstance().getCurrentHealth()+" + "+Heal+" > "+ Player.getInstance().getMaxHealth());
		if(penguin.getHealth()+Heal>penguin.getMaxHealth()){
			System.out.println("pass");
			penguin.setHealth(penguin.getMaxHealth());
			Player.getInstance().setCurrentHealth(Player.getInstance().getMaxHealth());
		}else {
			System.out.println("nope");
			penguin.setHealth(penguin.getHealth()+Heal) ;
			Player.getInstance().setCurrentHealth(Player.getInstance().getCurrentHealth()+Heal);
		}
		
	}
	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).healItem;
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
