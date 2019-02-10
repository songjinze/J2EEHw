package dao;


import beans.ProductBean;

import java.util.List;

public interface ProductDaoService {
    /**
     * 通过类别获得商品
     * @param category
     * @return
     */
    List<ProductBean> getProductsByCategory(String category);

    /**
     * 得到所有商品
     * @return
     */
    List<ProductBean> getAllProducts();
}
