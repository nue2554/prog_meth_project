package sprite.base;


import interfaces.IBehaviour;
import javafx.geometry.Point2D;
import render.IRenderable;

public abstract class Sprite implements IRenderable, IBehaviour{
	
	protected double dx = 0.0D;
	protected double dy = 0.0D;
	
	protected Point2D position = new Point2D(0.0D, 0.0D);
	protected int z;
	protected boolean visible,destroyed;
	protected double width = 36D;
	protected double height = 36D;
	protected boolean proceed;

	public Sprite(){
		visible = true;
		destroyed = false;
		z = -50;
	}

	public void destroy() {
	    this.destroyed = true;
	}
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}


	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
	}

	public Point2D getPosition() {
		    return this.position;
	}
		  
	public void setPosition(Point2D position) {
		    this.position = position;
	}
	

	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}


	public boolean isProceed() {
		return proceed;
	}


	public void setProceed(boolean proceed) {
		this.proceed = proceed;
	}


	public double getDx() {
		return dx;
	}


	public void setDx(double dx) {
		this.dx = dx;
	}


	public double getDy() {
		return dy;
	}


	public void setDy(double dy) {
		this.dy = dy;
	}

}
