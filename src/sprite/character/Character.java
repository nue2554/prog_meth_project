package sprite.character;

import java.awt.Rectangle;
import java.util.ArrayList;

import game.Map;
import interfaces.IDamageable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import render.RenderableHolder;
import sprite.base.Sprite;
import sprite.equipment.bullet.Bullet;
import sprite.equipment.weapon.Weapon;

public abstract class Character extends Sprite implements IDamageable{

	protected double normalSpeed = 0.05D;
    protected String name;
    protected double speed;
	protected int health;
	protected int maxHealth;
	protected int characterAttack;
	protected int weaponAttack;
	protected int itemAttack;
	protected int totalAttack;
	protected Weapon weapon;
	protected int direction;
	protected ArrayList<Bullet> bullets = new ArrayList<>();;
	protected long lastFired = 0;
	protected int cooldown;
	
	public Character() {
		super();
		z = -30;
	}

	public void addItemAttack(int itemAttack) {
		this.itemAttack = this.itemAttack + itemAttack;
		updateTotalAttack();
	}

	public void equipWeapon(Weapon weapon1) {
		weapon = weapon1;
		weaponAttack = weapon1.getWeaponAttack();
		updateTotalAttack();
		weapon.setPosition(new Point2D(this.getPosition().getX(), this.getPosition().getY()));
		RenderableHolder.getInstance().add(weapon);
		System.out.println("Weapon Equiped");
		weapon.setDestroyed(false);
	}	
	
	public void updateTotalAttack() {
		this.totalAttack = characterAttack + weaponAttack + itemAttack;
	}	
	
	@Override
	public void takeDamage(int damage) {
		if(health-damage<0) {
			health=0;
		}else {
			health = health-damage;
		}
		
	}
	
	public void setHealth(int health) {
		if(health> this.maxHealth) {
			this.health = maxHealth;
		}
		if(health<0) {
			this.health = 0;
		}
		this.health = health;
	}
	
    public abstract void move();	
    public abstract void attack();
//--------------getter/setter----------------------------------
	

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public double getSpeed() {
		return speed;
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getCharacterAttack() {
		return characterAttack;
	}

	public void setCharacterAttack(int characterAttack) {
		this.characterAttack = characterAttack;
	}

	public int getWeaponAttack() {
		return weaponAttack;
	}

	public int getItemAttack() {
		return itemAttack;
	}


	public int getTotalAttack() {
		return totalAttack;
	}


	public Weapon getWeapon() {
		return weapon;
	}

}
