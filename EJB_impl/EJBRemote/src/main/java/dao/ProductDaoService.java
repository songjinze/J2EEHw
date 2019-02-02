package dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductDaoService {
    /**
     * 通过类别获得商品
     * @param category
     * @return
     */
    List getProductsByCategory(String category);
}
