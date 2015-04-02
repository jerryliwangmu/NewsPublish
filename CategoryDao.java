package com.mxl.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mxl.connect.HibernateSessionFactory;
import com.mxl.models.Category;
import com.sun.org.apache.regexp.internal.recompile;
public class CategoryDao {
	// ��������ϸ���Ĳ������
	public void insertCategory(Category category) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(category);
			tx.commit();
		} catch (Exception e) {
			System.out.println("�������ݳ���" + e);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	// �޸�������ϸ���
	public void updateCategory(Category category) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Category newCategory = new Category();
			newCategory.setId(category.getId());
			newCategory.setName(category.getName());
			newCategory.setTopId(category.getTopId());
			session.update(newCategory);
			tx.commit();
		} catch (Exception e) {
			System.out.println("�޸����ݳ���" + e);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	// ɾ��������ϸ��������
	public void deleteCategory(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Category category = (Category) session.load(Category.class, id);
			session.delete(category);
			tx.commit();
		} catch (Exception e) {
			System.out.println("ɾ�����ݳ���" + e);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	//�����ϼ��������������в�ѯ����
	public List<Category> selectListByTopId(int topId) { 
        Session session = null;
        String hql = "from Category where topId=" + topId + " order by id desc";
        List<Category> list = null;
        try {
        	session = HibernateSessionFactory.getSession();
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        HibernateSessionFactory.closeSession();
        return list;
    }
	//�������ͱ�Ż�ȡ��������
	public String selectName(int id){
		Session session = null;
		String hql="select name from Category where id = "+id;
		String name = "";
		try {
			session = HibernateSessionFactory.getSession();
			Query query = session.createQuery(hql);
			name = (String)query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		HibernateSessionFactory.closeSession();
		return name;
	}
	//���ݱ�Ż�ȡ�ض��������Ϣ
	public Category selectCategory(int id){
		Session session = null;
		Category category = null;
		try {
			session = HibernateSessionFactory.getSession();
			category = (Category)session.get(Category.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		HibernateSessionFactory.closeSession();
		return category;
	}
	public static void main(String args[])
	{
		
		try
		{
			CategoryDao dao=new CategoryDao();
			Category cc=dao.selectCategory(2);
			System.out.println(cc.getName());
			
			
			List<Category> list=dao.selectListByTopId(1);
			if(list!=null)
			{
				for(Category ca:list)
				{
					System.out.println(ca.getName());
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
	}
}
