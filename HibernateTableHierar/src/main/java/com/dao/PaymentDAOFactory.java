package com.dao;

public class PaymentDAOFactory {
	
    public static PaymentDAO getInstance() {
        return new PaymentDAOImpl();
    }

}
