package cart;

import java.util.ArrayList;
import java.util.List;

public class CigarCartService implements CartService {
	CartDAO cartDao;
	
	public CigarCartService(CartDAO cartDao) {
		this.cartDao = cartDao;
	}
	@Override
	public boolean add(CartItem item) {
		if(item == null)return false;
		
		int result = 0;
		CartItem inItem = cartDao.selectByCigarId(item.getMemberNo(),item.getCigarId());
		if(inItem ==null) {
		result =cartDao.insert(item);
		}else {
			int quantity = item.getQuantity() + inItem.getQuantity();
			
			result = cartDao.update(inItem.getCigarId(),item.getMemberNo(), inItem.getQuantity()+1);
		}
		return result ==1?true:false;
	}
	@Override
	public List<CartItem> readByCigarId(int cigarId) {
		//List<CartItem> itemList = new ArrayList<>();
		return cartDao.selectByCigarId(cigarId);
	}
	@Override
	public List<CartItem> listAll(int loggedMemberNo) {
		return cartDao.selectAll(loggedMemberNo);
	}
	@Override
	public boolean update(int cartId, int loggedMemberNo, int quantity) {
		int result = cartDao.update(cartId,loggedMemberNo, quantity);
		return result==1?true:false;
	}
	@Override
	public boolean remove(int cartId, int loggedMemberNo) {
		int result = cartDao.delete(cartId,loggedMemberNo);
		return result==1?true:false;
	}
	@Override
	public boolean removeByCigarId(int loggedMemberNo) {
		int result = cartDao.deleteByCigarId(loggedMemberNo);
		return result==1?true:false;
	}
	@Override
	public boolean clear(int loggedMemberNo) {
		int result =cartDao.deleteAll(loggedMemberNo);
		return result>0?true:false;
	}

}
