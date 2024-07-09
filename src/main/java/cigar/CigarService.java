package cigar;

import java.util.List;

public interface CigarService {
	boolean regist(Cigar cigar);
	boolean edit(Cigar cigar, String name, String tar, String nico, int oldPrice);
	boolean remove(int cagarId);
	List<Cigar> listAll();
	Cigar read(int cigarId);
}
