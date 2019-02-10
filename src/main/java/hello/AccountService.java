////package hello;
//
//package  hello;
//
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AccountService {
//
//    private AccountRepository accountRepository;
//
//    public AccountService (AccountRepository accountRepository) {this .accountRepository = accountRepository;}
//
//    public Iterable<Account> list() { return accountRepository.findAll();}
//    public Account save(Account account) {return accountRepository.save(account);}
//    public void save(List<Account> accounts){ accountRepository.save((Account) accounts);}
//    }
//
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import javax.persistence.EntityManager;
////import java.util.Collection;
////import java.util.List;
////
////@Service
////public class AccountService {
////
////    @Autowired
////    EntityManager em;
////    @Autowired
////    AccountService accountService;
////
////    List<Account> findByReferenceNumberStartsWithIgnoreCase(String referenceNumber) {
////        return em.createQuery("select c from Account c where lower(referenceNumber) like ?1 ")
////                .setParameter(1, referenceNumber.toLowerCase())
////                .getResultList();
////    }
////
////    public Collection<Account> findAll(String originatorsNumber) {
////        return em.createQuery("select c from Account c where c.originatorsNumber = ?1")
////                .setParameter(1, originatorsNumber)
////                .getResultList();
////    }
////
////  public  void save(Account account) {
////        em.persist(account);
////
////
////    }
////
////    public Collection<Account> findAll() {
////        return em.createQuery("select c from Account c").getResultList();
////    }
////
////    public Account findById(long accountid) {
////        return em.find(Account.class, accountid);
////    }
////
////    public void delete(Account account) {
////    }
////
////    public void update(Account account) {
////        em.persist(account);
////
////    }
////}