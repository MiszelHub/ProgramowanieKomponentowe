import java.io.Serializable;

public class Ork implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4324174061492890119L;
	protected String name;
	protected int health;
	protected int mana;
	protected int attackValue;
	protected IAttack attackType;
	
	public void setAttackType(IAttack attackType)
	{
		this.attackType = attackType;
	}
	
	public String trytoAttack()
	{
		return this.attackType.Attack();
	}
	
	public Ork(String name, int health, int mana, int attackValue,IAttack attackType) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.attackValue = attackValue;
		this.attackType = attackType;
	}
	public Ork(Object anotherOrk)
	{
		if(anotherOrk instanceof Ork)
		{
			Ork tmp = (Ork) anotherOrk;
			this.name = tmp.name;
			this.health = tmp.health;
			this.mana = tmp.mana;
			this.attackValue = tmp.attackValue;
			this.attackType = tmp.attackType;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getAttackValue() {
		return attackValue;
	}
	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}
	
	
	
	

}
