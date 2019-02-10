package service;

import beans.ProductBean;
import dao.DaoFactory;
import dao.ProductDaoService;

import java.util.List;


public class ProductBusinessServiceImpl implements ProductBusinessService {

    private ProductDaoService productDaoService= DaoFactory.getProductDaoService();
    @Override
    public List<ProductBean> getProducts(String category) {
        if(category.equals("")){
            return productDaoService.getAllProducts();
        }else {
            return productDaoService.getProductsByCategory(category);
        }
    }
}
