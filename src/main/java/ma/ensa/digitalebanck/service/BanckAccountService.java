package ma.ensa.digitalebanck.service;

import ma.ensa.digitalebanck.dto.CustomerDTO;
import ma.ensa.digitalebanck.entities.Acount;
import ma.ensa.digitalebanck.entities.Customer;
import ma.ensa.digitalebanck.entities.SavingAcount;
import ma.ensa.digitalebanck.entities.enums.EnumAccount;
import ma.ensa.digitalebanck.exeptions.BalanceNotSufisanteExeption;
import ma.ensa.digitalebanck.exeptions.BanckAcoutNotFoundExeption;
import ma.ensa.digitalebanck.exeptions.CustomerAlreadyExiste;
import ma.ensa.digitalebanck.exeptions.CustomernotfoundException;

import java.util.List;

public interface BanckAccountService {
    CustomerDTO saceCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExiste;

    CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExiste, CustomernotfoundException;

    void deleteCustomer(String id) throws CustomerAlreadyExiste, CustomernotfoundException;

    SavingAcount saveSavingAcount(double initilaeBalance , double InterestRate , String CustomerID)  throws CustomernotfoundException;
    Acount saveCurrentAcount(double initilaeBalance , double  overDaft , String CustomerID)  throws CustomernotfoundException;

    List<CustomerDTO> CUSTOMERS();
    Acount getBnmckAcount(String ID) throws BanckAcoutNotFoundExeption;
    void debit(double amount , String acountID) throws BanckAcoutNotFoundExeption, BalanceNotSufisanteExeption;
    void credit(double amount , String acountID) throws BanckAcoutNotFoundExeption, BalanceNotSufisanteExeption;
    void Verment(double amount , String accountSource , String accountFinale ) throws BalanceNotSufisanteExeption, BanckAcoutNotFoundExeption;

    List<Acount> acounts();

    CustomerDTO getcustomer(String id) throws CustomernotfoundException;
}
