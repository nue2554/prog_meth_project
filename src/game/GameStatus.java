package game;

public class GameStatus {

	private int level;
	private boolean inGame;
	private double monsterMultiplier;
	private int targetKilled;
	private int Goal;
	
	private static GameStatus single_instance = null;
	
	public GameStatus() {
		
		this.level = 0;
		inGame = false;
		monsterMultiplier = 1;
		targetKilled = 0;
		Goal = 1;
	}
	
	public void nextLevel() {
		
		level = level +1;
		GameLogic.getInstance().drawMap(level);
		inGame = true;
		Goal = 0;
		monsterMultiplier = 1+(level/2);
		targetKilled = 0;
		for(int i = 0; i<GameLogic.getInstance().getEnemyType().length; i ++) {
			Goal = Goal + GameLogic.getInstance().getEnemyType()[i];
		}
		
	}
	
	public void defeat() {
		GameLogic.getInstance().clear();
		level = 0;
		inGame = false;
		monsterMultiplier = 1;
		targetKilled = 0;
		Player.getInstance().setCurrentHealth(Player.getInstance().getMaxHealth());
		Player.getInstance().setItemAttack(0);
	}
	
	public void win() {
		GameLogic.getInstance().clear();
		level = 0;
		inGame = false;
		monsterMultiplier = 1;
		targetKilled = 0;
		Player.getInstance().setCurrentHealth(Player.getInstance().getMaxHealth());
		Player.getInstance().setItemAttack(0);
	}

	public int getTargetKilled() {
		return targetKilled;
	}

	public void setTargetKilled(int targetKilled) {
		this.targetKilled = targetKilled;
	}

	public int getGoal() {
		return Goal;
	}

	public void setGoal(int goal) {
		Goal = goal;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public double getMonsterMultiplier() {
		return monsterMultiplier;
	}

	public void setMonsterMultiplier(int monsterMultiplier) {
		this.monsterMultiplier = monsterMultiplier;
	}
	
	public static GameStatus getInstance(){
        if (single_instance == null)
            single_instance = new GameStatus();
 
        return single_instance;
    }
}
