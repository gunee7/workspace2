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

	public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;
        
        try {
            // SQL 문장 생성
            String query = "delete from book where bookname = ? ";
            
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            // 문장 객체 실행
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }

    @Test
    public void testDeleteBook1() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("test");
        
        DaoBook dao = new DaoBook(conn);
        int result = dao.deleteBook(book); // result == 1

        // 검증 코드
        // 1 이상의 값이 리턴되는 경우 : 성공
        // 0 값이 리턴되는 경우 : 성공
        assertTrue(result>=0);
        
        book.setBookname("test2");
        result = dao.deleteBook(book); // result == 0

        // 검증 코드
        // 1 이상의 값이 리턴되는 경우 : 성공
        // 0 값이 리턴되는 경우 : 성공
        assertTrue(result>=0);
        
    }

    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        java.sql.ResultSet result = null;
        
        try {
            // query 작성
                                            String query  = " select * from book  \n";
                                                   query += " where 1 = 1         \n";
            if( book.getBookid() != null        )  query += "   and bookid    = ? \n";
            if(!book.getBookname().isEmpty()    )  query += "   and bookname  = ? \n";
            
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if( book.getBookid() != null    ) stmt.setInt   (c++, book.getBookid());
            if(!book.getBookname().isEmpty()) stmt.setString(c++, book.getBookname());
            
            // 문장 객체 실행
            result = stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return result;

        @Test
        public void testSelectDynamic() throws SQLException {
            ModelBook book = new ModelBook();
            DaoBook   dao  = new DaoBook(conn);
            
            // 첫번째 검증. select * from book where 1=1;
            //              select count(*) from book where 1=1;
            book.setBookid(null);
            book.setBookname("");
            java.sql.ResultSet rs = dao.selectDynamic(book);
            
            assertNotNull(rs); // 인스턴스 검증
            rs.last(); // 커서의 위치를 마지막 row로 이동.
            int rows = rs.getRow(); // 현재 커서의 index 번호를 가져온다.
            assertEquals(dao.getCount(book), rows);
            // resultset 사용법
            // rs.next(); 커서를 현재 row에서 다음 row로 이동.
            // rs.last(); 마지막 row로 이동.
            // rs.first(); 첫번째 row로 이동.
            // rs.getRow(); 현재 커서의 index 번호
            // rs.getInt("컬럼명"); 
            // rs.getStirng("컬럼명"); 
            // rs.getBoolean("컬럼명"); 
            // rs.getDate("컬럼명"); 
        }

        @Test
        public void testSelectDynamic1() throws SQLException {
            ModelBook book = new ModelBook();
            DaoBook   dao  = new DaoBook(conn);
            
            // 첫번째 검증. select * from book where 1=1;
            //              select count(*) from book where 1=1;
            book.setBookid(null);
            book.setBookname("");
            java.sql.ResultSet rs = dao.selectDynamic(book);
            
            assertNotNull(rs); // 인스턴스 검증
            rs.last(); // 커서의 위치를 마지막 row로 이동.
            int rows = rs.getRow(); // 현재 커서의 index 번호를 가져온다
            assertEquals(dao.getCount(book), rows);
            // resultset 사용법
            // rs.next(); 커서를 현재 row에서 다음 row로 이동.
            // rs.last(); 마지막 row로 이동.
            // rs.first(); 첫번째 row로 이동.
            // rs.getRow(); 현재 커서의 index 번호
            // rs.getInt("컬럼명"); 
            // rs.getStirng("컬럼명"); 
            // rs.getBoolean("컬럼명"); 
            // rs.getDate("컬럼명"); 
            
            // 두번째 검증. 
            book.setBookid(1);
            book.setBookname("");
            rs = dao.selectDynamic(book);
            
            // 인스턴스 검증
            assertNotNull(rs);
            
            
            // 값으로 검증.
            rs.next(); // 커서의 위치를 다음 row로 이동.
            int bookid = rs.getInt("bookid");
            String bookname = rs.getString("bookname");
            
            assertEquals(1, bookid);
            assertSame(book.getBookid(), bookid);
            assertEquals("operating system", bookname);
        }
 
        
        
	@Test
	public void testDeleteBook() {

	}

}
