package cigar;

import java.util.List;

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
	public boolean remove(int cagarId) {
		
		return cigarDao.deletCigar(cagarId) == 1 ? true:false ;
	}

	@Override
	public List<Cigar> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cigar read(int cigarId) {
		// TODO Auto-generated method stub
		return null;
	}

}
