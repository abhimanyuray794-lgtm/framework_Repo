package abhi.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int ranInt = random.nextInt(5000);
		return ranInt;
	}
}
