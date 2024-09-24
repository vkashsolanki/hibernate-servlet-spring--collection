package com.dao;

import com.bean.Card;
import com.bean.Cheque;

public interface PaymentDAO {
	
    public void saveCard(Card card);

    public void saveCheque(Cheque cheque);

}
