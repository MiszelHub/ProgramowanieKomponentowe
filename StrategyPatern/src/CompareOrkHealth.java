import java.util.Comparator;

public class CompareOrkHealth implements Comparator<Ork>{

	@Override
	public int compare(Ork o1, Ork o2) {
		if(o1 == null || o2 == null)
			throw new NullPointerException();
		
		if(o1.getHealth() > o2.getHealth())
			return 1;
		if(o1.getHealth() < o2.getHealth())
			return -1;
		else
			return 0;
	}
	

}
