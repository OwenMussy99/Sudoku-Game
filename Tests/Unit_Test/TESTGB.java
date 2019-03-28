//Author 100655244
import static org.junit.Assert.*;

import org.junit.Test;

public class TESTGB {

	@Test
	public void test() {
		GameBoard test2 = new GameBoard();
		int[][] output2 = test2.numbers;
		assertEquals(9,output2);
	}

}
