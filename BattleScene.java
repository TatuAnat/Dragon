public class BattleScene implements Runnable {
  private Entity hero;
  private Entity monster;

  public BattleScene(Entity hero, Entity monster) {
    this.hero = hero;
    this.monster = monster;
  }

  public void fight(){

    int temp = 1;
    boolean isFightEnded = false;
    while (!isFightEnded) {
      if (temp++ % 2 != 0) {
        isFightEnded = makeHit(monster, hero);
      }
      else isFightEnded = makeHit(hero, monster);
    }
    if(temp % 2 != 0)
      System.out.println("Game is over. Hero " + hero.getName() + " is lost.");
    else
    {
      hero.addGold(monster.getGold());
      hero.addExperience(1);
      System.out.println(monster.getName() + " lost. Hero " + hero.getName() + " got " + monster.getGold() + " and 1 experience");
      System.out.println("Hero " + hero.getName() + " has " + hero.getHealth() + " health, " + hero.getGold() + " gold and " + hero.getExperience() + " experience.");
    }
  }

  public Boolean makeHit(Entity defender, Entity attacker) {
    int damage = attacker.attack();
    defender.getAttack(damage);
    if (damage == 0)
      System.out.println(attacker.getName() + " missed");
    else
      System.out.println(attacker.getName() + " has attacked "
              + defender.getName() + " for " + damage + " damage." + defender.getName() + " has " + defender.getHealth() + " health");
    if(defender.getHealth() > 0)
      return false;
    else
      return true;
  }

  @Override
  public void run() {
    fight();
  }
}
