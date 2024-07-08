package cart;

import java.util.ArrayList;

import cigar.Cigar;


public class Cart {
    private ArrayList<CartItem> itemList = new ArrayList<>();
    
    public boolean isEmpty() {
        return itemList.isEmpty();
    }
    
    public int getNumItems() {
        return itemList.size();
    }
    
    public String getItemInfo(int i) {
        return itemList.get(i).toString();
        // String a = itemList.get(i).getCigar().toString();
        // a += " " + itemList.get(i).getQuantity() + "媛�";
        // return a;
    }
    
    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    public void resetCart() {
        itemList.clear();
    }
    
    public void deleteItem(int cigarId) {
        CartItem item = getCartItem(cigarId);
        itemList.remove(item);
    }
    
    private CartItem getCartItem(int cigarId) {
        for (CartItem item : itemList) {
            if (item.cigarId == cigarId) return item;
        }
        return null;
    }
    
    public boolean isValidItem(int cigarId) {
        System.out.println("�옣諛붽뎄�땲�뿉 �엳�뒗 �긽�뭹�엯�땲�떎.");
        System.out.println("itemList size: " + itemList.size());
        for (CartItem item : itemList) {
            System.out.println("�솗�씤 以�");

            if (item.cigarId == cigarId) {
                return true;
            }
        }
        return false;
    }
    
    public void updateQuantity(int cigarId, int quantity) {
        if (quantity == 0) {
            deleteItem(cigarId);
        } else {
            CartItem item = getCartItem(cigarId);
            item.setQuantity(quantity);
        }
    }
    
    public void addItem(Cigar cigar) {
        CartItem item = getCartItem(cigar);
        if (item == null) {
            itemList.add(new CartItem(cigar));
        } else {
            item.addQuantity(1);
        }
    }
    
    private CartItem getCartItem(Cigar cigar) {
        for (CartItem item : itemList) {
            if (item.getCigar() == cigar) return item;
        }
        return null;
    }
}
