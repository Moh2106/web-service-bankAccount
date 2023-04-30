package ma.enset.bankaccountservice.service;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountDTO;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.mapper.BankAccountMapper;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BankAccountServiceImpl implements BankAccountService{
    BankAccountRepository bankAccountRepository;
    BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountDTO save(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountMapper.from(bankAccountDTO);
        BankAccount bank = bankAccountRepository.save(bankAccount);
        BankAccountDTO bankAccountResponseDTO = bankAccountMapper.from(bank);
        return bankAccountResponseDTO;

    }

    @Override
    public List<BankAccountDTO> findAll() {
        return bankAccountRepository.findAll().stream().map(bankAccountMapper::from).collect(Collectors.toList());
    }

    @Override
    public BankAccountDTO findById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        return bankAccountMapper.from(bankAccount);
    }

    @Override
    public void delete(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public BankAccountDTO update(String id,BankAccountDTO bankAccountDTO) {
        BankAccountDTO bankAccount = findById(id);
        if(bankAccountDTO.getId() != null)  bankAccount.setId(bankAccountDTO.getId());
        if(bankAccountDTO.getBalance() != null)  bankAccount.setBalance(bankAccountDTO.getBalance());
        if(bankAccountDTO.getAccountType() != null)  bankAccount.setAccountType(bankAccountDTO.getAccountType());
        if(bankAccountDTO.getCreatedAt() != null)  bankAccount.setCreatedAt(new Date());
        if(bankAccountDTO.getCurrency() != null)  bankAccount.setCurrency(bankAccount.getCurrency());

        BankAccount account = bankAccountMapper.from(bankAccountDTO);
        BankAccount bankAccount1 = bankAccountRepository.save(account);
        return bankAccountMapper.from(bankAccount1);
    }
}
