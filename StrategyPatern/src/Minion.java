import java.io.Serializable;

public class Minion implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = -4580048397822852660L;
		private String name;
		private int attack;
		private int life;

		public Minion(String name, int attack, int life) {
			super();
			this.name = name;
			this.attack = attack;
			this.life = life;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAttack() {
			return attack;
		}

		public void setAttack(int attack) {
			this.attack = attack;
		}

		@Override
		public String toString() {
			
			return this.name+"attack value : "+this.attack;
		}

		public int getLife() {
			return life;
		}

		public void setLife(int life) {
			this.life = life;
		}
		
}
