package service;

import beans.ProductBean;

import java.util.List;

public interface ProductBusinessService {
    /**
     * 得到商品
     * category="" 则为获得所有商品
     * @return
     */
    List<ProductBean> getProducts(String category);
}
