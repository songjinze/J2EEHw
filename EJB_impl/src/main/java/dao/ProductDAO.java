package dao;

import beans.ProductBean;
import util.ExceptionHandler;
import util.ResourceGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductDaoService {

    private ProductBean createProductBean(String pname,double price,String category,String description){
        ProductBean bean=new ProductBean();
        bean.setCategory(category);
        bean.setDescription(description);
        bean.setPname(pname);
        bean.setPrice(price);
        return bean;
    }

    @Override
    public List<ProductBean> getProducts(String category) {
        List<ProductBean> res=new ArrayList<>();
        try {
            String sqlPath="/getProducts.sql";
            if(!category.equals("")) {
                sqlPath="/getProductsByCategory.sql";
            }
            PreparedStatement preparedStatement = MysqlConnector.getInstance().getConnection().prepareStatement(ResourceGetter.getResourceFileContext("/getProducts.sql"));
            if(!category.equals("")){
                preparedStatement.setString(1,category);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                res.add(createProductBean(
                        resultSet.getString("pname"),
                        Double.parseDouble(resultSet.getString("price")),
                        resultSet.getString("category"),
                        resultSet.getString("description")
                ));
            }
        }catch(SQLException e){
            ExceptionHandler.handleException(e);
        }
        return res;
    }
}
