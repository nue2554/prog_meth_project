package sprite.equipment.weapon;


import resource.ImageHolder;
import game.GameLogic;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.base.Sprite;
import sprite.character.Character;

public class Snowball extends Weapon{

	private Image image;
	
	public Snowball(Weapon oldWeapon){//double x, double y, Weapon oldWeapon) {
		super();
		weaponAttack = oldWeapon.getWeaponAttack();
		image = ((Stick) oldWeapon).getImage();
	}


	
	@Override
	public void draw(GraphicsContext gc) {
		image = (ImageHolder.getInstance()).snow;
		if(isDestroyed()) {
			image = (ImageHolder.getInstance()).floor;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	public void update(double x, double y) {
		setPosition(new Point2D(x+20, y));
	}
	

}
