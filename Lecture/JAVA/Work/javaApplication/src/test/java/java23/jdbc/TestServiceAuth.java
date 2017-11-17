package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceAuth {

	
	private static ServiceAuth svr = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	     svr = new ServiceAuth();
	
	}

	@Test
	public void testGetCount() throws SQLException {
		ModelAuth auth = null;
		int rs = svr.getCount(auth);
		
		///검증
		//인스턴스 검증
		// 값검증
		
		assertEquals(3, rs);
	}

	@Test
	public void testGetMaxAuthid() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectLike() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectEqual() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectDynamic() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertAuth() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAuth() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAuth() {
		fail("Not yet implemented");
	}

}
