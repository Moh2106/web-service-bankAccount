package ma.enset.bankaccountservice.web;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountDTO;
import ma.enset.bankaccountservice.service.BankAccountServiceImpl;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {

    private BankAccountServiceImpl bankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccountDTO> bankAccounts(){
        return bankAccountService.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountDTO bankAccount(@PathVariable String id){
        return bankAccountService.findById(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountDTO saveAccount(@RequestBody BankAccountDTO bankAccount){
        return bankAccountService.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountDTO updateAccount(@PathVariable String id, @RequestBody BankAccountDTO bankAccount){

        BankAccountDTO account = bankAccountService.update(id,bankAccount);

        return account;
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountService.delete(id);
    }
}
