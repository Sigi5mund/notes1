package Discounts;

import Basket.Item;
import java.util.ArrayList;
import java.util.HashMap;


public class Bogof extends Discount {

    Double discountAmount;
    Double discountWithRemainder;


    public Bogof(String name) {
        super(name);
        discountAmount = 0.5;
        discountWithRemainder = 0.66;
    }


    @Override
    public void doDiscount(ArrayList<Item> items) {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();

        for (Item item : items) {
            if (hashMap.get(item) == null) {
                hashMap.put(item, 1);
            } else {
                hashMap.put(item, hashMap.get(item) + 1);
            }
        }

        for (Item item1 : items) {
            if (hashMap.get(item1) % 2 == 0) {
                item1.applyDiscountPrice(discountAmount);
            } else if (hashMap.get(item1) % 2 == 5) {
                item1.applyDiscountPrice(discountWithRemainder);
            }
        }
    }

}
