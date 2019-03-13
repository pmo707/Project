package ua.nure.pihnastyi.db.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {

    private Map<String, Goods> bufferGoods;

    private static final String ERROR_PRODUCT_AMOUNT_NEGATIVE_VALUE = "Количество не может быть отрицательным.";

    public Cart() {
        bufferGoods = new HashMap<>();
    }

    public Map<String, Goods> getBufferGoods() {
        return bufferGoods;
    }

    public void setBufferGoods(Map<String, Goods> bufferGoods) {
        this.bufferGoods = bufferGoods;
    }


    /* Добавить товар в корзину. */
    public void addToCart(String goodsId, Goods goods) {
        /* Создаем копию товара */
        bufferGoods.put(goodsId, goods);

    }

    /* Удалить товар из корзины. */
    public void removeGoods(int id) {
        bufferGoods.remove(id);
    }

    public void removeAllBufferGoodss() {
        Iterator<Map.Entry<String, Goods>> iterator = bufferGoods.entrySet().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /*
     * Изменить количество единиц товара в корзине. Метод выполнится, только если
     * новое количество больше нуля.
     */
    public void changeGoodsAmount(int id, int newAmount) {
        if (newAmount > 0) {
            //bufferGoods.get(id).setAmount(newAmount);
        } else {
            throw new NumberFormatException(ERROR_PRODUCT_AMOUNT_NEGATIVE_VALUE);
        }
    }
}
