package ma.ensa.digitalebanck.service;

import lombok.extern.slf4j.Slf4j;
import ma.ensa.digitalebanck.dto.CustomerDTO;
import ma.ensa.digitalebanck.entities.*;
import ma.ensa.digitalebanck.entities.enums.EnumAccount;
import ma.ensa.digitalebanck.entities.enums.Enumtype;
import ma.ensa.digitalebanck.exeptions.BalanceNotSufisanteExeption;
import ma.ensa.digitalebanck.exeptions.BanckAcoutNotFoundExeption;
import ma.ensa.digitalebanck.exeptions.CustomerAlreadyExiste;
import ma.ensa.digitalebanck.exeptions.CustomernotfoundException;
import ma.ensa.digitalebanck.mapers.BankMaper;
import ma.ensa.digitalebanck.repos.AcountRepo;
import ma.ensa.digitalebanck.repos.CustomerRepo;
import ma.ensa.digitalebanck.repos.OperationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
//@Log4j
@Slf4j
public class BanckAccountServiceImpl implements BanckAccountService {
    private final BankMaper bankMaper;
    AcountRepo acountRepo ;
    CustomerRepo customerRepo;
    OperationRepo operationRepo ;

    public BanckAccountServiceImpl(AcountRepo acountRepo, CustomerRepo customerRepo, OperationRepo operationRepo, BankMaper bankMaper) {
        this.acountRepo = acountRepo;
        this.customerRepo = customerRepo;
        this.operationRepo = operationRepo;
        this.bankMaper = bankMaper;
    }

    @Override
    public CustomerDTO saceCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExiste {
        log.info("account   ");
        Customer customer = bankMaper.ToCustomer(customerDTO);
        customer.setId(UUID.randomUUID().toString());
        Customer customer1 =  customerRepo.findById(customer.getId()).orElse(null);
        if (customer1!=null) throw new CustomerAlreadyExiste("custumer already existe ");
        customerRepo.save(customer);
        customerDTO=bankMaper.ToDTO(customer);
       return customerDTO;
    }
    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExiste, CustomernotfoundException {
        log.info("account updating  ");
        Customer customer= bankMaper.ToCustomer(customerDTO);
        customerRepo.findById(customer.getId()).orElseThrow(() -> new CustomernotfoundException("Not Found"));
        customerRepo.save(customer);
        return customerDTO;
    }
    @Override
    public  void deleteCustomer(String id) throws CustomerAlreadyExiste, CustomernotfoundException {
        log.info("account deleting  ");
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomernotfoundException("Not Found"));
        customerRepo.delete(customer);
    }

    @Override
    public SavingAcount saveSavingAcount(double initilaeBalance,  double InterestRate , String CustomerID) throws CustomernotfoundException {
        SavingAcount acount = new SavingAcount();
        acount.setId(UUID.randomUUID().toString());
        acount.setCreationdate(new Date());
        acount.setBalance(200);
        acount.setCuurency("DH");
        acount.setSatatus(EnumAccount.ACTIVETED);
        acount.setInterestRate(InterestRate);
        Customer customer = customerRepo.findById(CustomerID).orElse(null);
        if (customer==null) throw new CustomernotfoundException(" Customer not found");
        acount.setCustomer(customer);
        acountRepo.save(acount);
        return acount;
    }

    @Override
    public CurrentAcount saveCurrentAcount(double initilaeBalance,double  overDaft, String CustomerID) throws CustomernotfoundException {
        CurrentAcount acount = new CurrentAcount();
        acount.setCreationdate(new Date());
        acount.setId(UUID.randomUUID().toString());
        acount.setBalance(200);
        acount.setCuurency("DH");
        acount.setSatatus(EnumAccount.ACTIVETED);
        acount.setOverDaft(overDaft);
        Customer customer = customerRepo.findById(CustomerID).orElse(null);
        if (customer==null) throw new CustomernotfoundException(" Customer not found");
        acount.setCustomer(customer);
        acountRepo.save(acount);
        return acount;
    }



    @Override
    public List<CustomerDTO> CUSTOMERS() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customersDto = customers.stream()
                .map(customer -> bankMaper.ToDTO(customer))
                .collect(Collectors.toList());
        return customersDto ;
    }

    @Override
    public Acount getBnmckAcount(String ID) throws BanckAcoutNotFoundExeption {
        Acount acount;
        acount=acountRepo.findById(ID).orElseThrow(() -> new BanckAcoutNotFoundExeption("Account Not Found"));
        return acount;
    }

    @Override
    public void debit(double amount, String acountID) throws BanckAcoutNotFoundExeption, BalanceNotSufisanteExeption {
        Operation operation = new Operation();
        operation.setAmount(amount);
        operation.setOperationDate(new Date());
        operation.setType(Enumtype.DEBIT);
        Acount acount = acountRepo.findById(acountID).orElseThrow(() -> new BanckAcoutNotFoundExeption("Account Not Found"));
        if(acount.getBalance() < amount) {
            throw new BalanceNotSufisanteExeption("Balance not sufisante");
        }
        operation.setAcount(acount);
        operationRepo.save(operation);
        acount.setBalance(acount.getBalance()-amount);
        acountRepo.save(acount);
    }

    @Override
    public void credit(double amount, String acountID) throws BanckAcoutNotFoundExeption, BalanceNotSufisanteExeption {
        Acount acount = acountRepo.findById(acountID).orElseThrow(() -> new BanckAcoutNotFoundExeption("Account Not Found"));
        Operation operation = new Operation();
        operation.setAmount(amount);
        operation.setOperationDate(new Date());
        operation.setType(Enumtype.CREDET);
        operation.setAcount(acount);
        operationRepo.save(operation);
        acount.setBalance(acount.getBalance()+amount);
        acountRepo.save(acount);
    }

    @Override
    public void Verment(double amount, String accountSource, String accountFinale) throws BalanceNotSufisanteExeption, BanckAcoutNotFoundExeption {
        debit(amount, accountSource);
        credit(amount,accountFinale);
    }
    @Override
    public List<Acount> acounts(){
        return acountRepo.findAll();
    }
    @Override
    public  CustomerDTO getcustomer(String id) throws CustomernotfoundException {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomernotfoundException("Customer not found") );
        CustomerDTO customerDTO = bankMaper.ToDTO(customer);
        return customerDTO;
    }
}
