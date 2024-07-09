package cart;
import cigar.Cigar;

public class CartItem {
    
    private Cigar cigar;
    private int cartId;
    private int cigarId;
    private int quantity;
    private int memberNo;
    
    public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public CartItem(Cigar cigar) {
        this.cigar = cigar;
        this.cigarId = cigar.getCigarId();
        this.quantity = 1;
    }
    
    public CartItem(int cartId, int memberNo , int cigarId, int quantity) {
	}

	public Cigar getCigar() {
        return cigar;
    }

    public void setCigar(Cigar cigar) {
        this.cigar = cigar;
    }

    public int getCigarId() {
        return cigarId;
    }

    public void setCigarId(int cigarId) {
        this.cigarId = cigarId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return quantity * cigar.getPrice();
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    @Override
    public String toString() {
        return cigar.getCigarId() + " <" + cigar.getName() + "> [" + quantity + "媛�] " + getPrice() + "�썝";
    }
}
