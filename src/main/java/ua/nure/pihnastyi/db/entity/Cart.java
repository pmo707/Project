package ua.nure.pihnastyi.db.entity;

import java.util.HashMap;
import java.util.Map;


public class Cart {

    private Map<String, Goods> bufferGoods;


    public Cart() {
        bufferGoods = new HashMap<>();
    }

    public Map<String, Goods> getBufferGoods() {
        return bufferGoods;
    }


}
