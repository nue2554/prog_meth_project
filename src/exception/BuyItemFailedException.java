package exception;

import resource.SoundHolder;

public class BuyItemFailedException extends Exception {
	private String message;

	public BuyItemFailedException(String message) {
	    this.message = message;
	    System.out.println(message);
	    //SoundHolder.failedToBuy.play();
	  }
}
