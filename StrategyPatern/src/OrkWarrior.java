import java.io.Serializable;

public class OrkWarrior extends Ork implements IStance, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4730760661045275021L;
	private String stance;
	public OrkWarrior(String name, int health, int mana, int attackValue,IAttack attackType) {
		super(name, health, mana, attackValue,attackType);
		
	}
	
	public String getStance(){
		return this.stance;
	}

	@Override
	public void defensiveStance() {
		try{
		if(this.stance == "DefensiveStance")
			throw new StanceException();
		
		this.stance = "DefensiveStance";
		this.health+=1;
		this.attackValue-=1;
		}catch(StanceException e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "OrkWarrior [stance=" + stance + ", name=" + name + ", health=" + health + ", mana=" + mana
				+ ", attackValue=" + attackValue + ", attackType=" + attackType + "]";
	}

	@Override
	public void BerserkerStance() {
		try{
			if(this.stance == "BerserkerStance")
				throw new StanceException();
			
		this.stance = "BerserkerStance";
		this.health-=1;
		this.attackValue+=1;
		}catch(StanceException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	

}
