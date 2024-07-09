package cart;

import java.util.List;

public interface CartService {
	boolean add(CartItem item);
	List<CartItem> readByCigarId(int cigarId);
	List<CartItem> listAll(int loggedMemberNo);	
	boolean update(int cartId,int loggedMemberNo,int quantity);
	boolean remove(int cartId,int loggedMemberNo);
	boolean removeByCigarId(int loggedMemberNo);
	boolean clear(int loggedMemberNo);
}
