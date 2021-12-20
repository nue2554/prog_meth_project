package game;

import game.utility.InputUtility;
import gui.shop.ShopManager;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import render.IRenderable;
import render.RenderableHolder;
import resource.FontHolder;
import resource.ImageHolder;
import sprite.equipment.weapon.Stick;

public class GameScreen extends Canvas {
	private static double xBound;
	private static double yBound;
	public GameScreen(double x, double y) {
		super(x, y);
		xBound = x;
		yBound = y;
		this.setVisible(true);
		addListerner();
	}

	public static double getxBound() {
		return xBound;
	}



	public static double getyBound() {
		return yBound;
	}



	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});


	}
    public void initHealthBar(GraphicsContext gc) {
    	gc = this.getGraphicsContext2D();
    	double maxHP = Player.getInstance().getMaxHealth();
    	double HP    = Player.getInstance().getCurrentHealth();
    	Image image =  Player.getInstance().getHealthColor().getImage();
    	
		gc.setFill(Color.web("#8F8F8F"));
		gc.fillRect(12, 60, 44, 368);
		
		if(image == (ImageHolder.getInstance()).upHealth0) {
			gc.setFill(Color.web("#2B2F6B"));
			gc.fillRect(16, 64, 36, 360);
	    	gc.setFill(Color.BLUE);
			gc.fillRect(16, 64+((maxHP-HP)/maxHP)*360, 36, 360*((HP)/maxHP));	
		}
		else if(image == (ImageHolder.getInstance()).upHealth1) {
			gc.setFill(Color.web("#014E2E"));
			gc.fillRect(16, 64, 36, 360);
	    	gc.setFill(Color.web("#1AE900"));
			gc.fillRect(16, 64+((maxHP-HP)/maxHP)*360, 36, 360*((HP)/maxHP));	
		}
		else if(image == (ImageHolder.getInstance()).upHealth2) {
			gc.setFill(Color.web("#6E5C00"));
			gc.fillRect(16, 64, 36, 360);
	    	gc.setFill(Color.ORANGE);
			gc.fillRect(16, 64+((maxHP-HP)/maxHP)*360, 36, 360*((HP)/maxHP));
		}
		else if(image == (ImageHolder.getInstance()).upHealth3) {
			gc.setFill(Color.web("#6B0000"));
			gc.fillRect(16, 64, 36, 360);
	    	gc.setFill(Color.RED);
			gc.fillRect(16, 64+((maxHP-HP)/maxHP)*360, 36, 360*((HP)/maxHP));				
		}
				
		gc.drawImage(image, 18, 432, image.getWidth(), image.getHeight());			
    }
    
    public void initAboveBar(GraphicsContext gc) {
    	
    	Image fish =  (ImageHolder.getInstance()).fish1;
    	gc.drawImage(fish, 220, 10, fish.getWidth()/2.3, fish.getHeight()/2.3);
    	Font fish1 = Font.font(36);
    	gc.setFont(fish1);
    	gc.setFill(Color.WHITE);
    	gc.fillText(Integer.toString(ShopManager.getInstance().getUpdatedFish()), 280, 50);
    	
    	Image weapon =  ((Stick) Player.getInstance().getWeapon()).getImage();
    	gc.drawImage(weapon, 470, 10, fish.getWidth()/2.4, fish.getHeight()/2.4);
    	Font Attack = Font.font(36);
    	gc.setFont(Attack);
    	gc.setFill(Color.WHITE);
    	gc.fillText(Integer.toString(Player.getInstance().getBaseAttack()+
    			Player.getInstance().getWeaponAttack()), 550, 50);
    	Font itemAttack = Font.font(36);
    	gc.setFont(itemAttack);
    	gc.setFill(Color.web("#94FF86"));
    	gc.fillText("+" + Integer.toString(Player.getInstance().getItemAttack()), 620, 50);
    	
    	Font level = Font.font(36);
    	gc.setFont(level);
    	gc.setFill(Color.web("#94FF86"));
    	gc.fillText("Level: " + Integer.toString(GameStatus.getInstance().getLevel()), 945, 50);
    }
    
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		for (IRenderable sprite : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.getZ());
			if (sprite.isVisible() && !sprite.isDestroyed()) {
				sprite.draw(gc);
			}
		initHealthBar(gc);
		initAboveBar(gc);
	}


	}

}

