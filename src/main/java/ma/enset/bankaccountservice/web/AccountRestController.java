package ma.enset.bankaccountservice.web;

import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;


    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).get();
    }

    @PostMapping("/bankAccounts")
    public BankAccount saveAccount(@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).get();
        if (bankAccount.getId() != null)    account.setId(bankAccount.getId());
        if (bankAccount.getBalance() != null)    account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency() != null)    account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getAccountType() != null)    account.setAccountType(bankAccount.getAccountType());
        if (bankAccount.getCreatedAt() != null)    account.setCreatedAt(new Date());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
