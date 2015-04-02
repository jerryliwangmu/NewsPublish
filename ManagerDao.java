package com.mxl.dao;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import com.mxl.connect.HibernateSessionFactory;
import com.mxl.models.Manager;

import java.util.List;
public class ManagerDao {
	//�Թ���Ա�Ĳ������
	public void insertManager(Manager manager) {
	       Session session = null;
	       Transaction tx = null;
	       try {
	    	   session = HibernateSessionFactory.getSession();
	           tx = session.beginTransaction();
	           session.save(manager);
	           tx.commit();
	       } catch (Exception e) {
	           System.out.println("�������ݳ���" + e);
	       } finally {
	           HibernateSessionFactory.closeSession();//�ر�Session
	       }
	   }
   //�޸Ĺ���Ա��Ϣ
   public void updateManager(Manager manager) {
       Session session = null;
       Transaction tx = null;
       try {
    	   session=HibernateSessionFactory.getSession();
           tx = session.beginTransaction();
           Manager newManager=new Manager();
           newManager.setAccount(manager.getAccount());
           newManager.setPassword(manager.getPassword());
           newManager.setName(manager.getName());
           newManager.setNumber(manager.getNumber());
           session.update(manager);//�޸�����
           tx.commit();
       } catch (Exception e) {
           System.err.println("�޸Ĺ���Ա����"+e);
       } finally {
           HibernateSessionFactory.closeSession();
       }
   }
   //ɾ������Ա
   public void deleteManager(int id) {
      Session session = null;
      Transaction tx= null;
        try {
        	session=HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Manager manager=(Manager)session.load(Manager.class,id);
            session.delete(manager);
            tx.commit();
        } catch (Exception e) {
            System.out.println("ɾ�����ݳ���" + e);
        } finally {
        	HibernateSessionFactory.closeSession();
        }
  }
 //����Ա�˺�Ϊ������ѯ����
   public Manager getLogin(String account,String password) { 
      Session session = null;
      String hql = "from Manager where account='" + account + "' and password='"+password+"'";
      Manager manager = null;
      try {
    	  session = HibernateSessionFactory.getSession();
          Query query = session.createQuery(hql);
          manager = (Manager) query.uniqueResult();
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
      HibernateSessionFactory.closeSession();
      return manager;
  }
   //��ѯ���еĹ���Ա
  public List selectAllList() {
    Session session = null;
    String hql = "from Manager order by id desc";
    List list = null;
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
  //���ݱ�Ż�ȡ�û���Ϣ
  public Manager getManager(int id){
	  Session session = null;
	  Manager manager=null;
	  try {
		session = HibernateSessionFactory.getSession();
		manager = (Manager)session.get(Manager.class, id);//��ȡ�û���Ϣ
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	HibernateSessionFactory.closeSession();
	return manager;
  }
  //ÿ��¼һ�Σ����ʴ�����1
  public void addManagerNumber(int id) {
	  Session session = null;
	  Transaction tx = null;
	  try {
		  session=HibernateSessionFactory.getSession();
		  tx = session.beginTransaction();
		  Manager login=(Manager)session.load(Manager.class, id);//��ȡ��ǰ��¼�Ĺ���Ա��Ϣ
		  login.setNumber(login.getNumber()+1);//ʹ���ʴ�����1
		  session.update(login);//�޸�����
		  tx.commit();
     } catch (Exception e) {
         System.out.println("�������ݳ���" + e);
     } finally {
         HibernateSessionFactory.closeSession();
     }
  }



}
