package resource;

import javafx.scene.text.Font;

public class FontHolder {
  
  private static final FontHolder instance = new FontHolder();
  
  public static Font fontBlock60;
  public static Font fontBlock40;
  
  public static Font font8;
  public static Font font10;

  public static Font font12;

  public static Font font18;
  public static Font font20;

  public static Font font24;
  
  public static Font font28;
  

  public static FontHolder getInstance() {
    return instance;
  }
  
  public FontHolder() {
    fontBlock60 = loadFont("Kenney Blocks", "ttf", 60);
    fontBlock40 = loadFont("Kenney Blocks", "ttf", 40);
    font8 = loadFont("Kenney Pixel Square", "ttf", 8);
    font10 = loadFont("Kenney Pixel Square", "ttf", 10);

    font12 = loadFont("Kenney Pixel Square", "ttf", 12);

    font18 = loadFont("Kenney Pixel Square", "ttf", 18);
    font20 = loadFont("Kenney Pixel Square", "ttf", 20);
    font24 = loadFont("Kenney Pixel Square", "ttf", 24);
    font28 = loadFont("Kenney Pixel Square", "ttf", 28);

  }
  
  public Font loadFont(String name, String fontType, double size) {
    return Font.loadFont(ClassLoader.getSystemResourceAsStream(name + "." + fontType), size);
  }
}