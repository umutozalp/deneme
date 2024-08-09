package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;

import java.util.List;

public interface ContractService {

    public Contract getContract(Integer id);

    public String createContract(Contract contract);

    public String updateContract(Contract contract);

    public String deleteContract(Integer id);

    public List<Contract> getAllContract();
    
    
}
