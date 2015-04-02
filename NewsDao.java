package com.mxl.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mxl.connect.HibernateSessionFactory;
import com.mxl.models.News;
public class NewsDao {
	//�����ŵĲ������
	 public void insertNews(News news) { 
	        Session session = null;
	        Transaction tx = null;
	        try {
	        	session = HibernateSessionFactory.getSession();
	            tx = session.beginTransaction();
	            session.save(news);
	            tx.commit();
	        } catch (Exception e) {
	            System.out.println("�������ݳ���" + e);
	        } finally {
	            HibernateSessionFactory.closeSession();
	        }
	    }
	 //ɾ������
    public void deleteNews(int id) {
        Session session = null;
        Transaction tx = null;
        try {
        	session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            News news = (News) session.load(News.class, id);
            session.delete(news);
            tx.commit();
        } catch (Exception e) {
            System.out.println("ɾ�����ݳ���" + e);
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
    //�޸�����
    public void updateNews(News news) {
        Session session = null;
        Transaction tx = null;
        try {
        	session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            News newNews = new News();
            newNews.setId(news.getId());
            newNews.setTitle(news.getTitle());
            newNews.setContent(news.getContent());
            newNews.setCreateTime(news.getCreateTime());
            newNews.setCategory(news.getCategory());
            session.update(newNews);//�޸�������Ϣ
            tx.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("�޸����ݳ���" + e);
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
  //�����ŵĲ�ѯ
    public List<News> selectListByTopId(int topId,int pageNo,int pageSize) {
        Session session = null;
        List<News> list = null;
        String hql = "from News  where category.topId=" + topId +" order by createTime desc";
        try {
        	session = HibernateSessionFactory.getSession(); 
            Query query = session.createQuery(hql);
            query.setFirstResult((pageNo-1)*pageSize);//���ô���һ�м�¼��ʼ��ȡ
            query.setMaxResults(pageSize);//���ö�ȡ�����м�¼
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
        return list;
    }
    //ǰ̨�Ը����������Ž��в�ѯ
    public List<News> selectTopList(int topId){
    	Session session = null;
    	List<News> news = null;
    	String hql="from News where category.topId ="+topId+" order by createTime desc";
    	try {
			session = HibernateSessionFactory.getSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(5);
			news = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
		return news;
    }
    
    //��ȡ��ҳ��
    public int getPageCount(int topId,int pageSize){
    	Session session = null;
    	String hql="select count(id) from News where category.topId="+topId;
    	int count=0;//�ܼ�¼��
    	int pageCount=0;//��ҳ��
    	try {
			session = HibernateSessionFactory.getSession();
			Query query = session.createQuery(hql);
			long temp=(Long)query.uniqueResult();
			count = (int)temp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		HibernateSessionFactory.closeSession();
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		}
		else {
			pageCount = count/pageSize+1;
		}
		return pageCount;
    }
  //�Ա��Ϊ������ѯ����
    public News selectNews(int id) { 
    	Session session = null;
        String hql = "from News where id=" + id;
        News news = null;
        try {
        	session = HibernateSessionFactory.getSession();
            Query query = session.createQuery(hql);
            news = (News) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       HibernateSessionFactory.closeSession();
       return news;
    }
    //��������ѯ����
    public List<News> selectNewsByCid(int cid){
    	Session session = null;
    	List<News> news = null;
    	String hql="from News where category.id ="+cid+" order by createTime desc";
    	try {
			session = HibernateSessionFactory.getSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(5);
			news = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
		return news;
    }
}
