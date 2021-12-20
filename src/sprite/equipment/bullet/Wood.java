package sprite.equipment.bullet;

import game.GameScreen;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import resource.ImageHolder;
import sprite.base.Sprite;
import sprite.character.Character;

public class Wood extends Bullet{
	    private final double BULLET_SPEED;
	    private int direction;

	    public Wood(double x, double y, int direction, boolean Enemy, Character character) {
	        super(Enemy, character);
	        BULLET_SPEED = character.getSpeed()*0.2D;
	        this.direction = direction;
		    width = 36;
			height = 36;
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
			Image image = (ImageHolder.getInstance()).wood;
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
	        if (direction == 0) {
	    		if(getPosition().getY() < character.getPosition().getY() - 64 ) {
	    			return true;
	    		}
	        } else if (direction == 1) {
	    		if(getPosition().getX() > character.getPosition().getX() + 64 ) {
	    			return true;
	    		}
	
	        } else if (direction == 2) {
	    		if(getPosition().getY() > character.getPosition().getY() + 64  ) {
	    			return true;
	    		}
	
	        } else if (direction == 3) {
	    		if(getPosition().getX() < character.getPosition().getX() - 64 ) {
	    			return true;
	    		}
	
	        }
			return false;
		}
}
