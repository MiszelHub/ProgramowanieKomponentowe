
import java.util.Comparator;

public class Comparators {
	
	static Comparator<Kontakt> compareNumerTelefonu = new Comparator<Kontakt>() {
		
		@Override
		public int compare(Kontakt o1, Kontakt o2) {
			return o1.getNumer()-o2.getNumer();
			
		
		}
	};
	
	static Comparator<Kontakt> compareNumerDomu = new Comparator<Kontakt>() {
		
		@Override
		public int compare(Kontakt o1, Kontakt o2) {
			return o1.getNumer()-o2.getNumer();
			
		
		}
	};

}
