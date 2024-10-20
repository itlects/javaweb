import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library.my.DBUtil;

public class DBUtilTest {

	public static void main(String[] args) {
		connectionTest();
		jdbcTest();
		jdbc_array_Test();
		createTest();
		insertTest(); //- 한개의 데이터 입력
		scan_insertTest();
		selectTest(); //- 한개의 항목을 출력
		selectsTest(); //- 한번에 반환되는 여러개의 항목 출력
		selectnTest(); //- 여러개의 데이터로부터 하나의 항목 출력
		selectnsTest(); //- 여러개의 데이터로부터 여러 항목 출력
		selectbyscanTest(); //- 여러개의 데이터로부터 여러 항목 출력
		
		pstmtSelectBySeqTest(6);
		pstmtSelectAllTest(4, 10);
		pstmtInsertTest();
		pstmtUpdateTest(7, "서울시 용산구 용산로 100");
		pstmtDeleteTest(10);
		pstmtDeleteByMaxSeqTest();
	}

	private static void pstmtDeleteByMaxSeqTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();		
		
		String sqlmax = "select max(seq) as seq from telbook";
		sql.append("delete from telbook ");
		sql.append(" where seq = ? ");
		int seq = 0;
		
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");

			pstmt = conn.prepareStatement(sqlmax);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seq = Integer.parseInt(rs.getString("seq"));
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			cnt = pstmt.executeUpdate();
			System.out.println("delete seq: " + seq);
			System.out.println("update: " + cnt);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}			
	}

	private static void pstmtDeleteTest(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();		
		
		sql.append("delete from telbook ");
		sql.append(" where seq = ? ");
		
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			cnt = pstmt.executeUpdate();
			System.out.println("update: " + cnt);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}	
	}

	private static void pstmtUpdateTest(int seq, String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();		
		
		sql.append("update telbook ");
		sql.append(" set address=?");
		sql.append(" where seq = ? ");
		
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, address);
			pstmt.setInt(2, seq);
			cnt = pstmt.executeUpdate();
			System.out.println("update: " + cnt);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}			
	}

	private static void pstmtInsertTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
		TelBookDto dto = new TelBookDto("홍길동", 23, "m", "010-1234-1235", "서울시 서초구 서초 200");		
		
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			sql.append("insert into telbook(seq, name, age, gender, tel, address, regdate) "
					+ "values(telbook_seq.NEXTVAL,?,?,?,?,?,default) " );
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddress());
			cnt = pstmt.executeUpdate();
			System.out.println("update: " + cnt);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}			
	}

	private static void pstmtSelectAllTest(int min, int max) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TelBookDto> list = new ArrayList<TelBookDto>();
		
		StringBuilder sql = new StringBuilder();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			sql.append("select * from telbook where seq>=? and seq<? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);

			rs = pstmt.executeQuery();
			
			TelBookDto dto = null;
			while(rs.next()) {
				dto = new TelBookDto();
				
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}

			for(int i=0;i<list.size();i++) {
				String result = String.format("%d %d %s %d %s", i+1, 
						list.get(i).getSeq(), list.get(i).getName(), 
						list.get(i).getAge(), list.get(i).getAddress());
				System.out.println(result);	
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}			
	}

	private static void pstmtSelectBySeqTest(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			sql.append("select * from telbook where seq=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);

			rs = pstmt.executeQuery();
			
			ArrayList<TelBookDto> list = new ArrayList<TelBookDto>();
			
			while(rs.next()) {
				TelBookDto dto = new TelBookDto();
				
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}

			for(int i=0;i<list.size();i++) {
				String result = String.format("%d %d %s %d %s", i+1, 
						list.get(i).getSeq(), list.get(i).getName(), 
						list.get(i).getAge(), list.get(i).getAddress());
				System.out.println(result);	
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}				
	}

	private static void jdbc_array_Test() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			stmt = conn.createStatement();
			String sql = "select * from telbook ";
			rs = stmt.executeQuery(sql);
			
			ArrayList<TelBookDto> list = new ArrayList<TelBookDto>();
			
			while(rs.next()) {
				TelBookDto dto = new TelBookDto();
				
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}

			for(int i=0;i<list.size();i++) {
				String result = String.format("%d %d %s %d %s", i+1, 
						list.get(i).getSeq(), list.get(i).getName(), 
						list.get(i).getAge(), list.get(i).getAddress());
				System.out.println(result);	
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt !=null) {
					stmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}		
	}

	private static void connectionTest() {
		Connection conn = DBUtil.open("localhost", "dev", "pass");
		//Connection conn = DBUtil.open();

		try {
			System.out.println(conn.isClosed());
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static void jdbcTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "dev";
			String pw = "pass";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle db 연결되었습니다.");
			
			stmt = conn.createStatement();
			String sql = "select * from telbook ";
			rs = stmt.executeQuery(sql);
			
			int i=0;
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				String result = String.format("%d %d %s %d %s", ++i, seq, name, age, address);
				System.out.println(result);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt !=null) {
					stmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Oracle 데이터베이스 종료중에 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}
	}

	private static void selectbyscanTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from telbook where gender='%s'";
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("검색성별(m, f): ");
			String gender = scan.nextLine();
			sql = String.format(sql,  gender);			
			System.out.println("sql: "+sql);
			
			conn = DBUtil.open();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("    \t이름\t나이\t주소  " + rs.getString("name"));
			int i = 0;
			while(rs.next()) {
				System.out.printf("%d\t%s\t%s\t%s\n",++i, 
						rs.getString("name"),rs.getString("age"),rs.getString("address"));		
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void selectnsTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from telbook where seq>=4 and seq <7 order by name";
		System.out.println("sql: "+sql);
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //- resultset은 실행결과를 한줄씩 읽어오는 커서가된다.
			System.out.println("    \t이름\t나이\t주소  " + rs.getString("name"));
			int i = 0;
			while(rs.next()) {
				System.out.printf("%d\t%s\t%s\t%s\n",++i, 
						rs.getString("name"),rs.getString("age"),rs.getString("address"));		
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void selectnTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select name from telbook where seq>=4 and seq <7 order by name";
		System.out.println("sql: "+sql);
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //- resultset은 실행결과를 한줄씩 읽어오는 커서가된다.
			while(rs.next()) {
				System.out.println("이름: " + rs.getString("name"));
				
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void selectsTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select name, age, address from telbook where seq = 6";
		System.out.println("sql: "+sql);
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //- resultset은 실행결과를 한줄씩 읽어오는 커서가된다.
			if(rs.next()) {
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("나이: " + rs.getString("age"));
				System.out.println("주소: " + rs.getString("address"));
			}else {
				System.out.println("데이터가 없음");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void selectTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
//		String sql = "select count(*) as cnt from telbook";
		String sql = "select * from telbook ";
		System.out.println("sql: "+sql);
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //- resultset은 실행결과를 한줄씩 읽어오는 커서가된다.
			rs.next();
//			int count = rs.getInt("cnt");
//			System.out.println("등록수: " + count); 
			String seq = rs.getString("seq");
			System.out.println("seq: " + seq); 
			String name = rs.getString("name");
			System.out.println("이름: " + name); 
			String address = rs.getString("address");
			System.out.println("이름: " + address); 
			
			rs.next();
			seq = rs.getString("seq");
			System.out.println("seq: " + seq); 
			name = rs.getString("name");
			System.out.println("이름: " + name);
			address = rs.getString("address");
			System.out.println("이름: " + address); 
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void scan_insertTest() {
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into telbook(seq, name, age, gender, tel, address, regdate) "
				+ "values (telbook_seq.nextVal, '%s', '%s', '%s', '%s', '%s', default)";
				
		Scanner scan = new Scanner(System.in);
				
		System.out.print("이름: ");
		String name= scan.nextLine();
		System.out.print("나이: ");
		String age= scan.nextLine();			
		System.out.print("성별(m, f): ");
		String gender= scan.nextLine();			
		System.out.print("전화번호: ");
		String tel= scan.nextLine();			
		System.out.print("주소: ");
		String address= scan.nextLine();		
		
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			sql = String.format(sql, name, age, gender, tel, address);
			System.out.println("sql: "+sql);
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
			
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void createTest() {
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "create table telbook ("
				+ "seq number primary key, "
				+ "name varchar2(10) not null, "
				+ "age number(3) not null check(age between 1 and 99), "
				+ "gender char(1) not null check(gender in ('m', 'f')), "
				+ "tel varchar2(15) not null, "
				+ "address varchar2(300) not null, "
				+ "regdate date  default sysdate not null"
				+ ")";
		System.out.println("sql: "+sql);
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
			
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertTest() {
		Connection conn = null;
		Statement stmt = null;
		
		//- insert query
		String sql = "insert into telbook(seq, name, age, gender, tel, address, regdate) "
				+ "values(telbook_seq.nextVal, '홍길동', '24', 'm', '010-1234-1234', "
				+ "'서울시 용산구 용산로 1', default )";
		
		System.out.println("sql: "+sql);
		
		try {
			//- 1. Connection을 가져온다
			conn = DBUtil.open();
			if(! conn.isClosed()){
				//- 2. statement sql을 실행할 문장으로 생성
				stmt = conn.createStatement();
				
				int result = stmt.executeUpdate(sql);
				
				if(result==1) {
					System.out.println("SQL 실행 성공");
				}else {
					System.out.println("SQL 실행 실패");
				}
			} else {
				System.out.println("SQL 실행 실패");
			}
			//- 3. close 
			conn.close();
			stmt.close();
		} 
		catch(Exception e) {e.printStackTrace();}
	}
}
