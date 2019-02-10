package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByAccountNumberStartsWithIgnoreCase(String accountNumber);

        void saveAll(List<Account> accounts);



}
//
//package hello;
//
//import org.springframework.data.repository.Repository;
//
//
//
//
//public interface AccountRepository extends Repository<Account, String> {
//

//
//    Account save(Account account);
//}
//
//
//
//
