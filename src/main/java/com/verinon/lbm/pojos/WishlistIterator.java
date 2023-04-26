package com.verinon.lbm.pojos;

import java.util.Iterator;
import java.util.List;


public class WishlistIterator<Wishlist> implements Iterator<Wishlist> {
    private List<Wishlist> list;
    private int currentIndex = 0;

    public WishlistIterator(List<Wishlist> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public Wishlist next() {
        return list.get(currentIndex++);
    }

}
