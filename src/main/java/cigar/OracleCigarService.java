package cigar;

import java.util.List;

import cart.CartItem;
import cart.CartService;
import cart.CigarCartService;
import cart.OracleCartDAO;

public class OracleCigarService implements CigarService {
	private CigarDAO cigarDao;
	
	public OracleCigarService(CigarDAO cigarDao) {
		this.cigarDao = cigarDao;
	}
	@Override
	public boolean regist(Cigar cigar) {
		return cigarDao.insertCigar(cigar) == 1;
	}

	@Override
	public boolean edit(Cigar cigar, String name, String tar, String nico, int oldPrice) {
		return cigarDao.updateCigar(cigar) == 1;
	}

	@Override
	public boolean remove(int cigarId) {
		if(cigarDao.selectCigar(cigarId) == null) return false;
		
		CartService cartService = new CigarCartService(new OracleCartDAO());
		List<CartItem> itemList = cartService.readByCigarId(cigarId);
		System.out.println("이 상품을 장바구니에 등록해놓은 유저들의 상품 "+itemList.size()+"항목 삭제");
		if(itemList.size() > 0) {
			 cartService.removeByCigarId(cigarId);
		}
		
		return cigarDao.deleteCigar(cigarId) == 1 ? true:false ;
	}

	@Override
	public List<Cigar> listAll() {
		return cigarDao.selectCigarAll();
	}

	@Override
	public Cigar read(int cigarId) {
		return cigarDao.selectCigar(cigarId);
	}

}
