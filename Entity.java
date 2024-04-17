import java.util.Random;

public abstract class Entity {
    protected int health;
    protected int power;
    protected int skill;
    protected String name;
    protected int experience;
    protected int gold;

    public Entity(int health, int power, int skill, String name, int experience, int gold) {
        this.health = health;
        this.power = power;
        this.skill = skill;
        this.name = name;
        this.experience = experience;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHealth() {
        return health;
    }
    public void getAttack(int power)
    {
        health -= power;
    }
    public void addGold(int gold)
    {
        this.gold += gold;
    }
    public void addExperience(int experience)
    {
        this.experience += experience;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
    public int attack(){
        Random random = new Random();
        if (skill*3 > random.nextInt(101))
            return power;
        else
            return 0;
    }
}
