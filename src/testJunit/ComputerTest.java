package testJunit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ComputerTest {
	private int param;
	private int result;
	private static Computer computer = new Computer();

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 2, 2, 4 }, { 0, 0 ,0 }, { -3, 12, 9 }});
	}

	public ComputerTest(int param, int result) {
		 this.param = param;
         this.result = result;
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPlus() {
		computer.plus(2, 3);
		assertEquals(5, computer.getResult());
	}

	@Test(expected = Exception.class)
	public void testCreatException() throws Exception {
		computer.creatException();
	}

	@Test(timeout = 1000)
	public void testForEver() {
		computer.forEver();
	}
}
