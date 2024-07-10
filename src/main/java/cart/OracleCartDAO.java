package cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnection;

public class OracleCartDAO implements CartDAO {

	@Override
	public int insert(CartItem item) {
		int result =0;
		JDBConnection jdbc = new JDBConnection();
		
		String sql =new StringBuilder("insert into cigar_cart (id, member_no, cigar_id, quantity, regdate ) ")
							  .append("values(cart_seq.nextval, ?,?,?,sysdate )")
							  .toString();
		
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, item.getMemberNo());
			jdbc.pstmt.setInt(2, item.getCigarId());
			jdbc.pstmt.setInt(3, item.getQuantity());
			
			result = jdbc.pstmt.executeUpdate();
			System.out.println("Insert : "+result + "За");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public CartItem select(int memberNo, int cartId) {
		CartItem item = null;
		JDBConnection jdbc = new JDBConnection();
		
		String sql = "select * from cigar_cart where id = ? and member_no = ?";
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartId);
			jdbc.pstmt.setInt(2, memberNo);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if(jdbc.rs.next()) {
						item = new CartItem(
											jdbc.rs.getInt("id"),
											jdbc.rs.getInt("member_no"),
											jdbc.rs.getInt("cigar_id"),
											jdbc.rs.getInt("quantity")
											);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	@Override
	public CartItem selectByCigarId(int memberNo, int cigarId) {
		CartItem item = null;
		JDBConnection jdbc = new JDBConnection();
		
		String sql = "select * from cigar_cart where member_no = ? and cigar_id = ? ";
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, memberNo);
			jdbc.pstmt.setInt(2, cigarId);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if(jdbc.rs.next()) {
						item = new CartItem(
											jdbc.rs.getInt("id"),
											jdbc.rs.getInt("member_no"),
											jdbc.rs.getInt("cigar_id"),
											jdbc.rs.getInt("quantity")
											);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	@Override
	public List<CartItem> selectByCigarId(int cigarId) {
		List<CartItem> itemList = new ArrayList<>();
		JDBConnection jdbc = new JDBConnection();
		
		String sql = "select * from cigar_cart where cigar_id = ? ";
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cigarId);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if(jdbc.rs.next()) {
						CartItem item = new CartItem(
											jdbc.rs.getInt("id"),
											jdbc.rs.getInt("member_no"),
											jdbc.rs.getInt("cigar_id"),
											jdbc.rs.getInt("quantity")
											);
						itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	@Override
	public List<CartItem> selectAll(int memberNo) {
		List<CartItem> itemList = new ArrayList<>();
		JDBConnection jdbc = new JDBConnection();
		
		String sql = "select * from cigar_cart where member_no = ?";
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, memberNo);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			while(jdbc.rs.next()) {
				CartItem item = new CartItem(
											jdbc.rs.getInt("id"),
											jdbc.rs.getInt("member_no"),
											jdbc.rs.getInt("cigar_id"),
											jdbc.rs.getInt("quantity")
											);
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

	@Override
	public int update(int cartId, int memberNo, int quantity) {
		int result =0;
		
		JDBConnection jdbc = new JDBConnection();
		String sql = new StringBuilder()
								.append("update cigar_cart ")
								.append("set quantity = ? ")
								.append("where id = ? and member_no = ? ")
								.toString();
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, quantity);
			jdbc.pstmt.setInt(2, cartId);
			jdbc.pstmt.setInt(3, memberNo);
			
			result = jdbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int memberNo, int cartId) {
		int result = 0;
		
		JDBConnection jdbc = new JDBConnection();
		String sql = "delete cigar_cart where member_no = ? and id = ?";
		
		
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, memberNo);
			jdbc.pstmt.setInt(2, cartId);
			
			result = jdbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(int memberNo) {
			int result = 0;
		
		JDBConnection jdbc = new JDBConnection();
		String sql = "delete cigar_cart where member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, memberNo);
			
			result = jdbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteByCigarId(int cigarId) {
	int result = 0;
		
		JDBConnection jdbc = new JDBConnection();
		String sql = "delete cigar_cart where cigar_id = ?";
		
		try {
			jdbc.pstmt = jdbc.con.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cigarId);
			
			result = jdbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
