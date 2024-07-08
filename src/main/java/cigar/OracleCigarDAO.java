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
				.append("")
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
		return 0;
	}

	@Override
	public int updateCigar(Cigar cigar) {
		return 0;
	}

	@Override
	public int deletCigar(Cigar cigar) {
		return 0;
	}

}
