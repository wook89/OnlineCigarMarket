package cigar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnection;

public class OracleCigarDAO implements CigarDAO {

	@Override
	public Cigar selectCigar(int cigarId) {
		Cigar cigar = null;
		JDBConnection jdbc = new JDBConnection();
		String sql = new StringBuilder()
				.append("select * from cigar where id = ? ")
				.toString();
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cigarId);
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if(jdbc.rs.next()) {
				cigar = new Cigar(jdbc.rs.getInt("id"),
								  jdbc.rs.getString("name"),
								  jdbc.rs.getString("tar"),
								  jdbc.rs.getString("nico"),
								  jdbc.rs.getInt("price")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return cigar;
	}

	@Override
	public List<Cigar> selectCigarAll() {
		List<Cigar> cigarList = new ArrayList<>();
		
		JDBConnection jdbc = new JDBConnection();
		String sql = "select * from cigar";
		
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.rs = jdbc.pstmt.executeQuery();
			while(jdbc.rs.next()) {
				Cigar cigar = new Cigar(
						jdbc.rs.getInt("id"),
						jdbc.rs.getString("name"),
						jdbc.rs.getString("tar"),
						jdbc.rs.getString("nico"),
						jdbc.rs.getInt("price")
										);
				cigarList.add(cigar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return cigarList;
	}

	@Override
	public int insertCigar(Cigar cigar) {
		JDBConnection jdbc = new JDBConnection();
		// create SQL
		String sql = new StringBuilder()
				.append("insert into cigar(id,name,tar,nico,price)")
				.append("values(cigar_num_seq.nextval, ? , ? , ? , ? )").toString();
		int result = 0;
		
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setString(1, cigar.getName());
			jdbc.pstmt.setString(2, cigar.getTar());
			jdbc.pstmt.setString(3, cigar.getNicotine());
			jdbc.pstmt.setInt(4, cigar.getPrice());
			result = jdbc.pstmt.executeUpdate();
			if(result==1) {
				System.out.println("상품추가 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}

	@Override
	public int updateCigar(Cigar cigar) {
		JDBConnection jdbc = new JDBConnection();
		int result = 0;
		String sql = new StringBuilder()
				.append("update cigar ")
				.append("set name = ?, tar = ? , nico = ? , price = ? ")
				.append("where id= ? ").toString();
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setString(1, cigar.getName());
			jdbc.pstmt.setString(2, cigar.getTar());
			jdbc.pstmt.setString(3, cigar.getNicotine());
			jdbc.pstmt.setInt(4, cigar.getPrice());
			jdbc.pstmt.setInt(5, cigar.getCigarId());

			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}

	@Override
	public int deleteCigar(int cigarId) {
		
		int result = 0;
		JDBConnection jdbc = new JDBConnection();
		String sql = "delete cigar where id = ? ";

		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cigarId);
			result = jdbc.pstmt.executeUpdate();

			System.out.println(result + "행이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}
}
