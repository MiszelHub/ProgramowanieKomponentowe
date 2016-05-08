import java.io.Serializable;


public interface IAttack {
	
	public String Attack();

}

class MagicAttack implements IAttack, Serializable{


	private static final long serialVersionUID = 1L;

	public String Attack() {
		return "Fireball";
		
	}
	
}

class MeleeAttack implements IAttack, Serializable{


	private static final long serialVersionUID = 1L;

	public String Attack() {
		return "HeroicStrike";
		
	}
	
}