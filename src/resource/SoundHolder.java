package resource;

import javafx.scene.media.AudioClip;

public class SoundHolder {
  private static final String WAV = "wav";
  
  private static final SoundHolder instance = new SoundHolder();
  
  public static AudioClip use;
  public static AudioClip failedToBuy;
  public static AudioClip clickOnBtn;
  public static AudioClip buyBtn;
  
  public static AudioClip freezing;
  public static AudioClip healing;
  public static AudioClip next;
  public static AudioClip shooting;
  public static AudioClip breaking;






  public static SoundHolder getInstance() {
    return instance;
  }
  
  public SoundHolder() {
    use = loadSound("SoundUseButton", "wav");
    failedToBuy = loadSound("SoundFailedToBuy", "wav");
    buyBtn = loadSound("SoundBuying", "wav");
    clickOnBtn = loadSound("SoundClicking", "wav");
    freezing = loadSound("SoundFreezing", "mp3");
    healing = loadSound("SoundHealing", "wav");
    next = loadSound("SoundNextLevel", "wav");
    shooting = loadSound("SoundShoot", "wav");
    breaking = loadSound("SoundBlockBreaking", "wav");

  
  }
  
  public AudioClip loadSound(String prefixName, String fileType) {
    return new AudioClip(ClassLoader.getSystemResource( prefixName + '.' + fileType).toString());
  }
}