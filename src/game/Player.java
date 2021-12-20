package game;

import sprite.equipment.healthcolor.HealthColor;
import sprite.equipment.weapon.Snowball;
import sprite.equipment.weapon.Stick;
import sprite.equipment.weapon.Weapon;
import javafx.geometry.Point2D;
import render.RenderableHolder;
import resource.ImageHolder;

public class Player {

	int baseAttack;
	Weapon weapon;
	int weaponAttack;
	int itemAttack;
	HealthColor healthColor;
	int currentHealth;
	int maxHealth;
//	int fish;
	int totalAttack;

	private static Player single_instance = null;
	
	public static Player getInstance() {
			if (single_instance == null) {
				single_instance = new Player();
			}
			return single_instance;
		}
	
	private Player() {
		baseAttack = 50;
		equipWeapon(new Stick(50, ImageHolder.upATK0));
		weaponAttack = weapon.getWeaponAttack();
		itemAttack = 0;
		updateTotalAttack();
		healthColor = new HealthColor(500, ImageHolder.upHealth0);
		currentHealth = healthColor.getHealth();
		maxHealth = healthColor.getHealth();

	}

	public int getWeaponAttack() {
		return weaponAttack;
	}

	public int getTotalAttack() {
		return totalAttack;
	}

	public void equipWeapon(Weapon weapon1) {
		// TODO Auto-generated method stub
		weapon = weapon1;
		weaponAttack = weapon.getWeaponAttack();
		updateTotalAttack();

	}
	
	
	
	public void setWeaponAttack(int weaponAttack) {
		this.weaponAttack = weaponAttack;
	}

	public void equipHealthColor(HealthColor healthColor1) {
		healthColor = healthColor1;
		maxHealth = healthColor1.getHealth();
		currentHealth = healthColor1.getHealth(); 
	}

	public void addItemAttack(int itemAttackBuff) {
		itemAttack = itemAttack + itemAttackBuff;
		updateTotalAttack();
	}

	public void updateTotalAttack() {
		totalAttack = baseAttack + weaponAttack + itemAttack;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}


	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getItemAttack() {
		return itemAttack;
	}

	public void setItemAttack(int itemAttack1) {
		itemAttack = itemAttack1;
	}

	public HealthColor getHealthColor() {
		return healthColor;
	}

	public void setHealthColor(HealthColor healthColor) {
		this.healthColor = healthColor;
	}

	

}
