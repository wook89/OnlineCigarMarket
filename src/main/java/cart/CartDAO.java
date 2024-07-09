package cart;

import java.util.List;

public interface CartDAO {
	// C
	int insert(CartItem item);

	// R
	CartItem select(int memberNo, int cartId);

	CartItem selectByCigarId(int memberNo, int bookId);

	List<CartItem> selectByCigarId(int bookId);

	List<CartItem> selectAll(int memberNo);

	// U
	int update(int cartId, int memberNo, int quantity);// ��ٱ��� ���� ������Ʈ �� �׸��� ���� ���̶�
	// D

	int delete(int memberNo, int cartId);

	int deleteAll(int memberNo);

	int deleteByCigarId(int loggedMemberNo);

}
