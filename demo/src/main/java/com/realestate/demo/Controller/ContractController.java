package com.realestate.demo.Controller;


import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;


    @GetMapping("/view/{id}")
    public Contract getContract(@PathVariable int id) {
        return contractService.getContract(id);
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContract();
    }

    @PostMapping
    public String createContract(@RequestBody Contract contract) {
        contractService.createContract(contract);
        return "Contract created Successfully";
    }

    @PutMapping
    public String updateContract(@RequestBody Contract contract) {
        contractService.updateContract(contract);
        return "Contract updated Successfully";
    }

    @DeleteMapping("{id}")
    public String deleteContract(@PathVariable int id) {
        contractService.deleteContract(id);
        return "Contract deleted Successfully";
    }


}
