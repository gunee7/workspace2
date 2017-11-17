package java23.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAuth implements IAuth {

	private java.sql.Connection conn = null;
	
	
	
	public ServiceAuth(Connection conn) {
		super();
		this.conn = DBConnect.makeConnection();
		
	}

	public ServiceAuth() {
		super();
	}

	@Override
	public int getCount(ModelAuth auth) throws SQLException {
		// 트랜잭션 시작
		
		int rs = -1;
	try {
		this.conn.setAutoCommit(false);
			
		
		//DAO의 SQL메서드 실행.
			DaoAuth dao = new DaoAuth(conn);
			rs = dao.getCount(auth);
			//트랜잭션 커밋
		
		this.conn.commit();
		
			//트랜잭션 롤백
		this.conn.rollback();
	} catch (Exception e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return rs;
	}

	@Override
	public int getMaxAuthid() throws SQLException {
		
		int rs = -1;
		try {
			// 트랜잭션 시작
			this.conn.setAutoCommit(false);
			//트랜잭션 커밋
			DaoAuth dao = new DaoAuth(conn);
			rs = dao.getMaxAuthid();
			this.conn.commit();
			//트랜잭션 롤
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//트랜잭션 롤백
			this.conn.rollback();
		}				
		return rs;
	}

	@Override
	public ResultSet selectAll() throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return null;
	}

	@Override
	public ResultSet selectLike(ModelAuth auth) throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return null;
	}

	@Override
	public ResultSet selectEqual(ModelAuth auth) throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return null;
	}

	@Override
	public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return null;
	}

	@Override
	public int insertAuth(ModelAuth auth) throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return 0;
	}

	@Override
	public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return 0;
	}

	@Override
	public int deleteAuth(ModelAuth auth) throws SQLException {
		// 트랜잭션 시작
		
		//트랜잭션 커밋
		
		//트랜잭션 롤백
		return 0;
	}

}
