package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java11.st4.Oper;

public class TestOper {
	private static Oper op = null;  
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		op = new Oper(3,5);
		
		
		
	}

	@Test
	public void test() {
		int rs = op.add();
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
