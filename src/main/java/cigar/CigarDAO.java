package cigar;

import java.util.List;

public interface CigarDAO {
	
	public Cigar selectCigar(int cigarId);
	public List<Cigar> selectCigarAll();
	public int insertCigar(Cigar cigar);
	public int updateCigar(Cigar cigar);
	public int deleteCigar(int cigarId);
}
