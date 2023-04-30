package ma.enset.bankaccountservice.service;

import ma.enset.bankaccountservice.dto.BankAccountDTO;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;

import java.util.List;

public interface BankAccountService {
    public BankAccountDTO save(BankAccountDTO bankAccountDTO);
    public List<BankAccountDTO> findAll();
    public BankAccountDTO findById(String id);
    public void delete(String id);
    public BankAccountDTO update(String id,BankAccountDTO bankAccountDTO);
}
