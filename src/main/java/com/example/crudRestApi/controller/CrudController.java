package com.example.crudRestApi.controller;

import com.example.crudRestApi.model.Customer;
import com.example.crudRestApi.modelRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;

@RestController
public class CrudController {

    @Autowired
    CustomerRepo repo;

//    Iterable is used for iter multiple objects( to loop through objects)
    @GetMapping("/")
    public Iterable<Customer> getCustomer() {
        System.out.print("Halloo ");
        return  repo.findAll();
    }


    @PostMapping("/customers")
    public @ResponseBody Customer postCustomer(@RequestBody Customer customer){
        return repo.save(customer);

    }

//    @PutMapping("customers/{id}")
//    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer ,@PathVariable Long userId){
//        System.out.println(userId);
//        System.out.println(repo.findById(Math.toIntExact(userId)));
//
//        Customer cus = repo.findById(Math.toIntExact(userId))
//                .orElseThrow(()-> new ResourceAccessException("Not Found"));
//        cus.setName(customer.getName());
//        cus.setAddress(customer.getAddress());
//        cus.setGstin(customer.getGstin());
//        cus.setPhoneNumber(customer.getPhoneNumber());
//        cus.setOutstandingBalance(customer.getOutstandingBalance());
//        repo.save(cus);
//        return new ResponseEntity("200");
//
//    }


    @PutMapping("customers/{customerId}")
    public Customer updateCustomer(@RequestBody Customer newCustomer , @PathVariable Long customerId){
        System.out.println("Customer Id : "+customerId);
        System.out.println("Customer Object : "+newCustomer);
        System.out.println("Find Customer By Id : "+repo.findById(customerId));

        return  repo.findById(customerId)
            .map(customer -> {
                System.out.println(newCustomer.getName());
                customer.setName(newCustomer.getName());
                customer.setGstin(newCustomer.getGstin());
                customer.setPhoneNumber(newCustomer.getPhoneNumber());
                customer.setAddress(newCustomer.getAddress());
                customer.setOutstandingBalance(newCustomer.getOutstandingBalance());
                System.out.println("Updted Customer :"+customer);
               return repo.save(customer);
            })
            .or(()-> {
                return ("Not Found",HttpStatus.NOT_FOUND);
            });

    }


}




