package com.example.crudRestApi.modelRepo;

import com.example.crudRestApi.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long> {

}
