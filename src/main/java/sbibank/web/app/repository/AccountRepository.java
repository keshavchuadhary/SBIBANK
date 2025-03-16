package sbibank.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbibank.web.app.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}