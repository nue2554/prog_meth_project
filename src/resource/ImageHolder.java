package resource;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
public class ImageHolder {
	
	//field
	private static final String PNG = "png";
	private static final ImageHolder instance = new ImageHolder();

	public static Image welcomeScene;
	public static Image playButton;
	public static Image exitButton;
	public static Image	exitButtonRed;
	public static Image howButton;
	public static Image shopButton;
	public static Image icon;
	public static Image how;
	public static Image bgShop;
	public static Image bgShopMain;
	public static Image fish1;
	public static Image nextLevel;
	public static Image	nextButton;
	public static Image backButton;
	public static Image okButton;
	


	public static Image upATK0;
	public static Image upATK1;
	public static Image upATK2;
	public static Image upATK3;

	public static Image upHealth0;
	public static Image upHealth1;
	public static Image upHealth2;
	public static Image upHealth3;

	public static Image penguin;	  
	public static Image floor;	  
	public static Image ice;	  
	public static Image rock;  
	public static Image water;
	public static Image snow;
	public static Image edge1;
	public static Image edge2;
	
	public static Image attackItem;
	public static Image freezeItem;
	public static Image healItem;
	public static Image snowItem;
	
	public static Image fish01;
	
	public static Image wood;
	public static Image polarBearLeft;
	public static Image polarBearRight;
	public static Image pandaBearLeft;
	public static Image pandaBearRight;
	public static Image brownBearLeft;
	public static Image brownBearRight;
	public static Image runnerBearLeft;
	public static Image runnerBearRight;
	
	public static ImageHolder getInstance() {
		return instance;
	}
  
  public ImageHolder() {
	
	  //scene
	welcomeScene = loadImage("welcomeScene", "jpg");
	bgShop = loadImage("bgShop", "png");
	how = loadImage("how", "png");
	icon = loadImage("icon","png");
    bgShopMain = loadImage("bgShopMain", "png");
    nextLevel = loadImage("nextLevel", "png");
    //Button
    fish1 = loadImage("fish1", "png");
    okButton = loadImage("okButton","png");
    backButton = loadImage("backButton","png");
    nextButton= loadImage("nextButton", "png");
    exitButtonRed= loadImage("exitButtonRed", "png");
    exitButton = loadImage("exitButton","png");
    shopButton = loadImage("shopButton","png");
    playButton = loadImage("playButton","png");
    howButton = loadImage("howButton","png");
    //item in shop
    upATK0 = loadImage("upATK0", "png");
    upATK1 = loadImage("upATK1", "png");
    upATK2 = loadImage("upATK2", "png");
    upATK3 = loadImage("upATK3", "png");
    upHealth0 = loadImage("upHealth0", "png");
    upHealth1 = loadImage("upHealth1", "png");
    upHealth2 = loadImage("upHealth2", "png");
    upHealth3 = loadImage("upHealth3", "png");
    
    
    //Block
    floor = loadImage("floor", "png", 36, 36);
    edge1 = loadImage("edge1", "png", 36, 36);
    edge2 = loadImage("edge2", "png", 36, 36);
    ice = loadImage("ice", "png", 36, 36);
    rock = loadImage("rock", "png", 36, 36);
    water = loadImage("water", "png", 36, 36);
 
    penguin = loadImage("penguin", "png", 36, 36); 
    
    //Item
    attackItem = loadImage("attackItem", "png", 36, 36); 
    freezeItem = loadImage("freezeItem", "png", 36, 36); 
    healItem = loadImage("healItem", "png", 36, 36); 
    snowItem = loadImage("snowItem", "png", 36, 36);
    fish01 = loadImage("fish01", "png", 36, 36);
    
    //bullet
    wood = loadImage("wood", "png", 36, 36);
    snow = loadImage("snow", "png", 28, 28);
    
    
    //Bear
    polarBearLeft= loadImage("polarBearLeft", "png", 36, 36);
	polarBearRight= loadImage("polarBearRight", "png", 36, 36);
	pandaBearLeft= loadImage("pandaBearLeft", "png", 36, 36);
	pandaBearRight= loadImage("pandaBearRight", "png", 36, 36);
	brownBearLeft= loadImage("brownBearLeft", "png", 36, 36);
	brownBearRight= loadImage("brownBearRight", "png", 36, 36);
	runnerBearLeft= loadImage("runnerBearLeft", "png", 36, 36);
	runnerBearRight= loadImage("runnerBearRight", "png", 36, 36);
  }
  
  public Image loadImage(String prefixName, String fileType) {
    return new Image(ClassLoader.getSystemResourceAsStream(prefixName + "." + fileType));
  }
  
  
  public Image loadImage(String prefixName, String fileType, double x, double y) {
	  Image image =  new Image(ClassLoader.getSystemResourceAsStream(prefixName + "." + fileType),x, y, true, true);
	  return image;
  }
  
}
