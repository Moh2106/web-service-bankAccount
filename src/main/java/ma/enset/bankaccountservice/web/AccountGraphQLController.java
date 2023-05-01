package ma.enset.bankaccountservice.web;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.entities.Customer;
import ma.enset.bankaccountservice.mapper.BankAccountMapper;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import ma.enset.bankaccountservice.repositories.CustomerRepository;
import ma.enset.bankaccountservice.service.BankAccountServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountGraphQLController {

    private BankAccountRepository bankAccountRepository;
    private BankAccountServiceImpl bankAccountService;
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).get();
    }

    @MutationMapping
    public BankAccountDTO addAccount(@Argument BankAccountDTO bankAccount){
        return bankAccountService.save(bankAccount);
    }

    @QueryMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}
