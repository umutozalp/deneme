package com.realestate.demo.Service;


import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Property;
import com.realestate.demo.Entity.Tenant;

import com.realestate.demo.Repository.ContractRepository;
import com.realestate.demo.Repository.PropertyRepository;
import com.realestate.demo.Repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final TenantRepository tenantRepository;
    private final PropertyRepository propertyRepository;


    public ContractServiceImpl(ContractRepository contractRepository, TenantRepository tenantRepository, PropertyRepository propertyRepository) {
        this.contractRepository = contractRepository;
        this.tenantRepository = tenantRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Contract getContract(Integer id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public String createContract(Contract contract) {
        if (contract.getTenant() != null && contract.getTenant().getId() != null) {
            Optional<Tenant> tenantOpt = tenantRepository.findById(contract.getTenant().getId());
            if (tenantOpt.isPresent()) {
                contract.setTenant(tenantOpt.get());
            } else {
                throw new IllegalArgumentException("Tenant not found");
            }
        }
        if (contract.getProperty() != null && contract.getProperty().getId() != null) {
            Optional<Property> propertyOpt = propertyRepository.findById(contract.getProperty().getId());
            if (propertyOpt.isPresent()) {
                contract.setProperty(propertyOpt.get());
            } else {
                throw new IllegalArgumentException("Property  not found");
            }
        }
        contractRepository.save(contract);
        return "Success";
    }


    @Override
    public String updateContract(Contract contract) {

        contractRepository.save(contract);
        return "Success";
    }

    @Override
    public String deleteContract(Integer id) {
        contractRepository.deleteById(id);
        return "Success";
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }
}
