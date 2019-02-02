package dao;

import beans.ProductBean;
import util.ExceptionHandler;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class ProductDAO implements ProductDaoService {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<ProductBean> getProductsByCategory(String category) {
        List list=new LinkedList();
        try{
            Query query= em.createQuery("from product p where p.catetory="+category);
            list=(List<ProductBean>)query.getResultList();
            em.clear();
        }catch(Exception e){
            ExceptionHandler.handleException(e);
        }
        return list;
    }
}
