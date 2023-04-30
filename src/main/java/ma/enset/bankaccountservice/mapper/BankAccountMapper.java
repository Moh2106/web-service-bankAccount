package ma.enset.bankaccountservice.mapper;

import lombok.NoArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountDTO;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class BankAccountMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public BankAccountDTO from(BankAccount bankAccount){
        return modelMapper.map(bankAccount, BankAccountDTO.class);
    }

    public BankAccount from(BankAccountDTO bankAccountDTO){
        return modelMapper.map(bankAccountDTO, BankAccount.class);
    }

    /*public BankAccountResponseDTO from(BankAccount bankAccount1){
        return modelMapper.map(bankAccount, BankAccountResponseDTO.class);
    }*/
}
