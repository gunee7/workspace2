package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {
	
    private java.sql.Connection conn = null;
	
	
	public DaoAuth(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public int getCount(ModelAuth auth) throws SQLException {
		//sql쿼리문 작성
		
		

          int result = -1;
		
			String sql = "select count(*) total from auth";
			try {

			//무장 객체 생성
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			// 문장 객체 실행 : executeQuery() or executeUpdate()
			ResultSet rs =stmt.executeQuery();
			
			// 커서를 다음 row로 이동
			rs.next(); //커서를 다음 row로 이동
			rs.first(); //커서를 첫번째row로 이동
			
			
			// 컬럼명을 이용하여 값을 추출.
			result = rs.getInt("total");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int getMaxAuthid() throws SQLException {
		
        int result = -1;
		try {
			//sql쿼리문 작성
			String sql = " select max(authid) authid from auth ";
					
			//무장 객체 생성
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			// 문장 객체 실행 : executeQuery() or executeUpdate()
			ResultSet rs =stmt.executeQuery();
						
			 
			
			// 커서를 이동
			rs.next(); //커서를 다음 row로 이동
			
			// 컬럼명을 이용하여 값을 추출.
			result = rs.getInt("authid"); //커서를 첫번째row로 이동
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					

		
		return result;
		
		
		
	}

	@Override
	public ResultSet selectAll() throws SQLException {
		
		// 문장 객체 실행 : executeQuery() or executeUpdate()
		ResultSet rs = null;
		try {
			//sql쿼리문 작성
			String sql = " select *from auth ";
					
			//무장 객체 생성
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return rs;
	}

	@Override
	public ResultSet selectLike(ModelAuth auth) throws SQLException {
		ResultSet rs = null ;
		try {
			//sql쿼리문 작성
			String sql = " select *from auth where name like ? " ; 
					
			//무장 객체 생성
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			
			// ?자리에 값을 넣기
			stmt.setString(1, "%" +auth.getName()+ "%" );
			
			rs = stmt.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
				// 문장 객체 실행 : executeQuery() or executeUpdate()
		return rs;
	}

	@Override
	public ResultSet selectEqual(ModelAuth auth) throws SQLException {
		
		ResultSet rs = null;
		
		//sql쿼리문 작성
		String sql = " select *from auth where name =?"; 
				
		//무장 객체 생성
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		stmt.setString(1, auth.getName());
		
		
		rs = stmt.executeQuery();
		return null;
	}

	
	
	
	
	
	@Override
	public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
		//sql쿼리문 작성
				//무장 객체 생성
				// 문장 객체 실행 : executeQuery() or executeUpdate()
		return null;
	}

	@Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            String query = "INSERT INTO ";
            query += "auth(authid, name, birth) ";
            query += "VALUES(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt (1, auth.getAuthid());
            stmt.setString (2, auth.getName());
            stmt.setString (3, auth.getBirth());
            
            
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }

	@Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth)
            throws SQLException {
        
        int rs = -1;
        
        try {
            // SQL 문장 생성
            String query = "UPDATE auth                        \n";
            query       += "   SET birth     = ? , authid = ?    \n";
            query       += " WHERE Name = ?                \n";
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setauth.getBirth());
            stmt.setInt   (2, setauth.getAuthid());
            stmt.setString(3, whereauth.getName());
            // 문장 객체 실행
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }


	 @Override
	    public int deleteAuth(ModelAuth auth) throws SQLException {
	        int rs = -1;
	        
	        try {
	            // SQL 문장 생성
	            String query = "delete from auth where Name = ? ";
	            
	            // 문장 객체 생성
	            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, auth.getName());
	            
	            // 문장 객체 실행
	            rs = stmt.executeUpdate();
	        } catch (java.sql.SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            
	        }
	        return rs;
	    }
	    
	}


