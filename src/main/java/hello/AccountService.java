package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Service
public class AccountService {
    @PersistenceContext
    @Autowired
    EntityManager me;
    @Autowired
    private AccountService service;

    List<Account> findByReferenceNumberStartsWithIgnoreCase(String referenceNumber) {
        return me.createQuery("select c from Account c where lower(referenceNumber) like ?1 ")
                .setParameter(1, referenceNumber.toLowerCase())
                .getResultList();
    }

    /*public Collection<Account> findByAccountNumberStartsWithIgnoreCase(String accountNumber){
        return me.createQuery("select c from Account c where c.accountNumber = ?1")
                .setParameter(1,accountNumber)
                .getResultList();
    }*/
    @Transactional
    public Account save(Account account) {
        if (account.getId() == null){
            me.persist(account);
    }


    else

    {
        me.merge(account);
    }
        return account;
}

     public Collection<Account> findById() { return me.createQuery("select c  from Account c ").getResultList();}
    /*public Account findById(long accountid) {
        return me.find(Account.class, accountid);
    }
*/




    /*public void delete(Account account) {
    }
    public  void update (Account account){

    }*/
}
