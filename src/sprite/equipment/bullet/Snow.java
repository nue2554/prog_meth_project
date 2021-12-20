package sprite.equipment.bullet;


import resource.ImageHolder;
import game.GameScreen;
import interfaces.IDamageable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.base.Sprite;
import sprite.character.bear.Bear;
import sprite.character.Penguin;
import sprite.character.Character;

public class Snow extends Bullet {
	    private final double BULLET_SPEED;
	    private int direction;

	    public Snow(double x, double y, int direction, boolean Enemy, Character character) {
	        super(Enemy, character);
	        BULLET_SPEED = character.getSpeed()*0.4D;  
	        width = 36;
			height = 36;
	        this.direction = direction;
	        this.setPosition(new Point2D(x, y));
	    }

	    public void move() {
		        if (direction == 0) {
		            dy = -BULLET_SPEED;
		        } else if (direction == 1) {
		            dx = BULLET_SPEED;
		        } else if (direction == 2) {
		            dy = BULLET_SPEED;
		        } else if (direction == 3) {
		            dx = -BULLET_SPEED;
		        }

	        setPosition(new Point2D(getPosition().getX() + this.dx, getPosition().getY() + this.dy));
	    }

	    @Override
	    public void draw(GraphicsContext gc) {
			Image image = (ImageHolder.getInstance()).snow;
		    double x = getPosition().getX();
		    double y = getPosition().getY();		
			gc.drawImage(image, x, y, image.getWidth(), image.getHeight());		
	    }

	    @Override
	    public void update(){
			move();
			if(isOutOfBound()) {
				this.destroy();
			}
	    }

	public boolean isOutOfBound(){
		if(getPosition().getX() < 0 || getPosition().getY() <0 || 
				getPosition().getX() > GameScreen.getxBound() ||
				getPosition().getY() > GameScreen.getyBound()) {
			return true;
		}
		return false;	
	}	
}
