package service;

import beans.ProductBean;
import dao.ProductDaoService;

import java.util.List;


public class ProductBusinessServiceImpl implements ProductBusinessService {

    private ProductDaoService productDaoService;
    @Override
    public List<ProductBean> getProducts(String category) {
        if(category.equals("")){
            return productDaoService.getAllProducts();
        }else {
            return productDaoService.getProductsByCategory(category);
        }
    }

    public void setProductDaoService(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
    }
}
