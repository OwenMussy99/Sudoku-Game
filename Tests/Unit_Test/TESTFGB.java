//Author 100655244
import static org.junit.Assert.*;

import org.junit.Test;

public class TESTFGB {

	@Test
	public void test() {
		FinalGameBoard test = new FinalGameBoard();
		int[][] output = test.numbers;
		assertEquals(9,output);
	}

}
