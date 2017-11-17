package java23.jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBook implements IServiceBook {

	private java.sql.Connection conn = null;
	
	
	
	public ServiceBook() {
		super();
		this.conn = DBConnect.makeConnection();
		
	}

	@Override
	public int getCount(ModelBook book) throws SQLException {
		return 0;
		
		
		int rs = -1;
		
		try {
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			
			DaoBook dao= new DaoBook(conn);
			rw = dao.getCount(book);
			rs
			
			conn.commit();// 트랜잭션 종료}
			catch (SQLException e) {
				e.printStackTrack
			}
			
			
		}
	}

	@Override
	public int getMaxBookid() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectLike(ModelBook book) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectEqual(ModelBook book) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectDynamic(ModelBook book) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBook(ModelBook book) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBook(ModelBook book) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int transCommit(ModelBook b1, ModelBook b2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int transRollback(ModelBook b1, ModelBook b2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
