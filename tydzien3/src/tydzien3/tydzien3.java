package tydzien3;
import java.util.Vector;

public class tydzien3 {

	public static void main(String[] args) {
	Vector<ksiazkaTelefoniczna> vec = new Vector<ksiazkaTelefoniczna>();
	ksiazkaTelefoniczna k1 = new ksiazkaTelefoniczna("jan",666,"lodz","gdanska",25);
	vec.add(k1);
	System.out.println(vec.get(0).getImie());

	}

}
