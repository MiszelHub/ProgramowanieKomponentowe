import java.io.Serializable;

public class OrkMage extends Ork implements SpellBook, Serializable {



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrkMage other = (OrkMage) obj;
		if (mageMinion == null) {
			if (other.mageMinion != null)
				return false;
		} else if (!mageMinion.equals(other.mageMinion))
			return false;
		return true;
	}

	private Minion mageMinion;
	@Override
	public String toString() {
		return "OrkMage [mageMinion=" + mageMinion + ", name=" + name + ", health=" + health + ", mana=" + mana
				+ ", attackValue=" + attackValue + ", attackType=" + attackType + "]";
	}

	public OrkMage(String name, int health, int mana, int attackValue,IAttack attackType) {
		super(name, health, mana, attackValue,attackType);
		
		
	}

	@Override
	public void summonMinion(Minion minion) {
	try{
		if(minion == null)
			throw new NullPointerException();
		
		this.mageMinion = minion;
		this.mana -=1;
		}catch(NullPointerException e){
			System.out.println("no minion under this name exists using default minion");
		}
	}

	@Override
	public void stealLife(Minion minion){
		try
		{
			if(this.mageMinion.getLife()-1 == 0)
				throw new MinionHealthException();
			
			this.mageMinion.setLife(this.mageMinion.getLife()-1);
			this.mana+=1;
		}catch(MinionHealthException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public Minion getMageMinion() {
		return mageMinion;
	}

}
