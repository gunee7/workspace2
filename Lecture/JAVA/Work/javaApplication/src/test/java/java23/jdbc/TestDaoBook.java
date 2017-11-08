package java23.jdbc;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoBook {

	static java.sql.Connection conn = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = DBConnect.makeConnection();
	}

	@Test
	public void testGetCount() throws SQLException {
		DaoBook dao = new DaoBook(conn);
		ModelBook model = new ModelBook();
		int result = dao.getCount(model);
		assertEquals(4, result);
	}

	@Test
	public void testGetMaxBookid() throws SQLException {
		DaoBook dao = new DaoBook(conn);
		int result = dao.getMaxBookid();
		assertEquals(4, result);
	}

	@Test
	public void testSelectAll() throws SQLException {
		DaoBook dao = new DaoBook(conn);
		java.sql.ResultSet rs = dao.selectAll();
		rs.next(); // ResultSet에서 다음 row로 커서 이동.
		int bookid = rs.getInt("bookid");
		assertEquals(1, bookid);

		String bookname = rs.getString("bookname");
		assertEquals("operating system", bookname);
	}

	@Test
	public void testSelectLike() throws SQLException {
		DaoBook dao = new DaoBook(conn);
		ModelBook book = new ModelBook();
		book.setBookname("ja");
		java.sql.ResultSet rs = dao.selectLike(book);

		// result을 이용한 검증
		assertNotNull(rs);

		// 값을 이용한 검증
		rs.next();
		String name = rs.getString("bookname"); // java
		assertTrue(name.contains("ja"));
		assertTrue(name.contains(book.getBookname()));
	}

	@Test
	public void testSelectEqual() throws SQLException {
		ModelBook book = new ModelBook();
		book.setBookname("mysql");

		DaoBook dao = new DaoBook(conn);
		java.sql.ResultSet rs = dao.selectEqual(book);

		// 인스턴스 검증
		assertNotNull(rs);

		// 값을 이용한 검증
		rs.next(); // 커서가 첫번째 로우로 이동.
		String name = rs.getString("bookname");
		assertEquals("mysql", name); // 1번 방법
		assertEquals(book.getBookname(), name); // 2번 방법

	}

	@Test
	public void testSelectDynamic() {

	}

	@Test
	public void testInsertBook() {
		
	}

	@Test
	public void testUpdateBook() {

	}

	@Test
	public void testDeleteBook() {

	}

}
