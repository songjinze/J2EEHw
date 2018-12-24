package dao;

import beans.ProductBean;

import java.util.List;

public interface ProductDaoService {
    /**
     * 得到所有商品
     * @return
     */
    List<ProductBean> getAllProducts();

    /**
     * 根据分类获得商品
     * @param category
     * @return
     */
    List<ProductBean> getProductsByCategory(String category);
}
