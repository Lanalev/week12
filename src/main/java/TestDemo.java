
import java.util.Random;
public class TestDemo {



	public int addPositive(int a, int b) {
	if( a<=0 || b<=0 ) {
	throw new IllegalArgumentException("Both parameters must be positive!");
	}
	return a + b;
	}

	
	public int randomNumberSquared() {
	int c = getRandomInt();
	if(c>10) {
	throw new IllegalArgumentException("Both parameters must be less than or equal to " + 10);
	}
	return c*c;
	}

	
	
	int getRandomInt() {
	Random random = new Random();
	return random.nextInt(10) + 1;
	}
}



	
