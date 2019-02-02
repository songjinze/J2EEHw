package service;

import beans.ProductBean;
import dao.DaoFactory;
import dao.ProductDaoService;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class ProductBusinessServiceImpl implements ProductBusinessService {

    private ProductDaoService productDaoService=DaoFactory.getProductDaoService();
    @Override
    public List<ProductBean> getProducts(String category) {
        return productDaoService.getProductsByCategory(category);
    }

}
