package com.mxl.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mxl.connect.HibernateSessionFactory;
import com.mxl.models.AFNews;



public class AFDao {
	//�Թ��桢����Ĳ������
	public void insertAffiche(AFNews af) { 
        Session session = null;
        Transaction tx = null;
        try {
        	session=HibernateSessionFactory.getSession();//��ȡSession
            tx = session.beginTransaction();//��������
            session.save(af);
            tx.commit();
        } catch (Exception e) {
            System.out.println("�������ݳ���" + e);
        } finally {
            HibernateSessionFactory.closeSession();//�ر�Session
        }
    }
	//���桢���㵼����Ϣ��ɾ��
    public void deleteAffiche(int id) {
        Session session = null;
        Transaction tx=null;
        try {
        	session=HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            AFNews af = (AFNews) session.load(AFNews.class, id);
            session.delete(af);//ɾ������
            tx.commit();
        } catch (Exception e) {
            System.out.println("ɾ�����ݳ���" + e);
        } finally {
        	HibernateSessionFactory.closeSession();//�ر�Session
        }
    }
    //�Թ��桢���㵼����Ϣ���޸�
    public void updateAffiche(AFNews af) {
        Session session = null;
        Transaction tx=null;
        try {
        	session=HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            AFNews newAf=new AFNews();
            newAf.setId(af.getId());
            newAf.setTitle(af.getTitle());
            newAf.setContent(af.getContent());
            newAf.setCreateTime(af.getCreateTime());
            newAf.setSign(af.getSign());
            session.update(newAf);//ִ���޸Ĳ���
            tx.commit();
        } catch (Exception e) {
            System.out.println("�޸����ݳ���" + e);
        } finally {
        	HibernateSessionFactory.closeSession();//�ر�Session
        }
    }
    //��ѯȫ����Ϣ
    public List<AFNews> selectAllList(int sign) {
        Session session = null;
        String hql = "from AFNews where sign="+sign+" order by createTime desc";
        System.out.println(hql);
        List<AFNews> list = null;
        try {
        	session=HibernateSessionFactory.getSession();//��ȡSession
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        HibernateSessionFactory.closeSession();//�ر�Session
        return list;
    }
    //��ѯǰ5������
    public List<AFNews> selectTopList(int sign) {
        Session session = null;
        String hql = "from AFNews where sign="+sign+" order by createTime desc limit 5";
        System.out.println(hql);
        List<AFNews> list = null;
        try {
        	session=HibernateSessionFactory.getSession();//��ȡSession
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        HibernateSessionFactory.closeSession();//�ر�Session
        return list;
    }
    //��ѯ�ض�����Ϣ
    public AFNews selectAf(int id) { 
          Session session = null;
          String hql = "from AFNews where id=" + id;
          AFNews affiche=null;
          try {
        	  session=HibernateSessionFactory.getSession();
              Query query = session.createQuery(hql);
              affiche=(AFNews)query.uniqueResult();//��ȡһ������
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
          HibernateSessionFactory.closeSession();//�ر�Session
          return affiche;
    }

}
