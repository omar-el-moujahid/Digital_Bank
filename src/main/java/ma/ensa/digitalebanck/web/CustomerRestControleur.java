package ma.ensa.digitalebanck.web;

import ma.ensa.digitalebanck.dto.CustomerDTO;
import ma.ensa.digitalebanck.entities.Customer;
import ma.ensa.digitalebanck.exeptions.CustomerAlreadyExiste;
import ma.ensa.digitalebanck.exeptions.CustomernotfoundException;
import ma.ensa.digitalebanck.service.BanckAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class CustomerRestControleur {
    private  BanckAccountService banckAccountService;
    public CustomerRestControleur(BanckAccountService banckAccountService) {
        this.banckAccountService = banckAccountService;
    }
    @GetMapping("/customer")
    List<CustomerDTO> customers(){
        return banckAccountService.CUSTOMERS();
    }
    @GetMapping("/customer/{id}")
    CustomerDTO getCustpmer(@PathVariable(name = "id") String id) throws CustomernotfoundException {
        return banckAccountService.getcustomer(id);
    }
    @PostMapping("/customer")
    public  CustomerDTO Savecustomer(@RequestBody CustomerDTO customerDTO) throws CustomerAlreadyExiste {
        return banckAccountService.saceCustomer(customerDTO);
    }

    @PutMapping("/customer/{customerid}")
    public CustomerDTO update(@PathVariable(name = "customerid") String id , @RequestBody CustomerDTO customerDTO ) throws CustomernotfoundException, CustomerAlreadyExiste {
        customerDTO.setId(id);
        return banckAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable(name = "id") String id  ) throws CustomernotfoundException, CustomerAlreadyExiste {
         banckAccountService.deleteCustomer(id);
    }

}

