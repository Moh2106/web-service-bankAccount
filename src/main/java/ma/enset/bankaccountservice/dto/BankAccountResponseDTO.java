package ma.enset.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.bankaccountservice.enumeration.AccountType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType accountType;
}
