package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.Card;
import com.bean.Cheque;

public class PaymentDAOImpl {
	
	
	public void saveCard(Card card) {
        SessionFactory factory = HibernateUtil.getInstnce();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(card);
        tx.commit();
        session.close();
        System.out.println("Card Inserted Successfully..");

    }

    public void saveCheque(Cheque cheque) {
        SessionFactory factory = HibernateUtil.getInstnce();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(cheque);
        tx.commit();
        session.close();
        System.out.println("Cheque Inserted Successfully..");
    }

}
