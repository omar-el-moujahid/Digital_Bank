package ma.ensa.digitalebanck;

import ma.ensa.digitalebanck.entities.*;
import ma.ensa.digitalebanck.entities.enums.EnumAccount;
import ma.ensa.digitalebanck.entities.enums.Enumtype;
import ma.ensa.digitalebanck.exeptions.BalanceNotSufisanteExeption;
import ma.ensa.digitalebanck.exeptions.BanckAcoutNotFoundExeption;
import ma.ensa.digitalebanck.exeptions.CustomerAlreadyExiste;
import ma.ensa.digitalebanck.exeptions.CustomernotfoundException;
import ma.ensa.digitalebanck.repos.AcountRepo;
import ma.ensa.digitalebanck.repos.CustomerRepo;
import ma.ensa.digitalebanck.repos.OperationRepo;
import ma.ensa.digitalebanck.service.BanckAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitaleBanckApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DigitaleBanckApplication.class, args);
    }

//    //@Bean
//    CommandLineRunner commandLineRunner(AcountRepo acountRepo  , OperationRepo operationRepo, CustomerRepo customerRepo){
//        return args -> {
//            Customer customer = new Customer();
//            customer.setName("El Moujahid Omar");
//            customer.setEmail("omarelmoujahid5@gmail.com");
//            customer.setId(UUID.randomUUID().toString());
//            customerRepo.save(customer);
////            Customer customer1 = new Customer();
////            customer1.setName("El  Omar");
////            customer1.setEmail("omarelmoujahid5@gmail.com");
////            customer1.setId(UUID.randomUUID().toString());
////            Customer customer2 = new Customer();
////            customer2.setName("El Moujahid ");
////            customer2.setEmail("omarelmoujahid5@gmail.com");
////            customer2.setId(UUID.randomUUID().toString());
////            customerRepo.save(customer);
////            customerRepo.save(customer2);
////            customerRepo.save(customer1);
//
//            CurrentAcount acount = new CurrentAcount();
//            acount.setId(UUID.randomUUID().toString());
//            acount.setCreationdate(new Date());
//            acount.setBalance(20000);
//            acount.setCuurency("DH");
//            acount.setSatatus(EnumAccount.ACTIVETED);
//            acount.setCustomer(customer);
//            acount.setOverDaft(2000);
//
//            SavingAcount savingAcount = new SavingAcount();
//            savingAcount.setId(UUID.randomUUID().toString());
//            savingAcount.setCreationdate(new Date());
//            savingAcount.setBalance(1000000);
//            savingAcount.setCuurency("DH");
//            savingAcount.setSatatus(EnumAccount.ACTIVETED);
//            savingAcount.setCustomer(customer);
//            savingAcount.setInterestRate(20043770);
//            for (int i = 0; i < 10; i++) {
//                acountRepo.save(acount);
//                acountRepo.save(savingAcount);
//                Operation operation = new Operation();
//                operation.setOperationDate(new Date());
//                operation.setType(  Math.random() > 0.5 ? Enumtype.DEBIT : Enumtype.CREDET);
//                operation.setAmount(Math.random()*1234);
//                operation.setAcount( savingAcount);
//                operationRepo.save(operation);
//
//            }
//
//
//        };
//    }

    //@Bean
//    CommandLineRunner commandLineRunner(BanckAccountService banckAccountService){
//        return args -> {
//            Stream.of("Omar","Bobker","Imane").forEach(name -> {
//                Customer customer = new Customer();
//                customer.setId(UUID.randomUUID().toString());
//                customer.setName(name);
//                customer.setEmail(name+"@gmail.com");
//                try {
//                    banckAccountService.saceCustomer(customer);
//                } catch (CustomerAlreadyExiste e) {
//                    throw new RuntimeException(e);
//                }
//            });
//
//            List<Customer> customers = banckAccountService.CUSTOMERS();
//            customers.forEach(customer -> {
//                try {
//                    banckAccountService.saveSavingAcount(Math.random()*12000,5.4,customer.getId());
//                    banckAccountService.saveCurrentAcount(Math.random()*9000,200,customer.getId());
//                    List<Acount> acounts = banckAccountService.acounts();
//                    for(Acount acount : acounts){
//                        banckAccountService.credit(12000+Math.random()*9000,acount.getId());
//                        banckAccountService.debit(1000+Math.random()*9000,acount.getId());
//                    }
//
//                } catch (CustomernotfoundException e) {
//                    e.printStackTrace();
//                } catch (BalanceNotSufisanteExeption e) {
//                    e.printStackTrace();
//                } catch (BanckAcoutNotFoundExeption e) {
//                    e.printStackTrace();
//                }
//            });
//        };
//    }
}
