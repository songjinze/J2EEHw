package dao;

import beans.ProductBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductDaoService {

    @Override
    public List<ProductBean> getProductsByCategory(String category) {
        Transaction t=null;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession()) {
            t = session.beginTransaction();
            String hql = "from ProductBean where category = :category";
            Query query = session.createQuery(hql);
            query.setParameter("category", category);
            List<ProductBean> res = (List<ProductBean>)query.list();
            t.commit();
            return res;
        } catch (Exception e) {
            assert t != null;
            t.rollback();
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductBean> getAllProducts() {
        Transaction t=null;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession()) {
            t = session.beginTransaction();
            String hql = "from ProductBean ";
            Query query = session.createQuery(hql);
            List<ProductBean> res = (List<ProductBean>)query.list();
            t.commit();
            return res;
        } catch (Exception e) {
            assert t != null;
            t.rollback();
            return new ArrayList<>();
        }
    }
}
