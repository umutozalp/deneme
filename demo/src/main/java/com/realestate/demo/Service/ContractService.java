package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;

import java.util.List;

public interface ContractService {

    Contract getContract(Integer id);

     String createContract(Contract contract);

     String updateContract(Contract contract);

    String deleteContract(Integer id);

     List<Contract> getAllContract();
    
    
}
