package com.realestate.demo.Service;

import com.realestate.demo.Entity.Tenant;
import com.realestate.demo.Repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public String createTenant(Tenant tenant) {
        tenantRepository.save(tenant);
        return "Succes";
    }

    @Override
    public String updateTenant(Tenant tenant) {

        tenantRepository.save(tenant);
        return "Succes";
    }

    @Override
    public String deleteTenant(Integer id) {
        tenantRepository.deleteById(id);
        return "Succes";

    }

    @Override
    public Tenant getTenant(Integer id) {

        return tenantRepository.findById(id).get();
    }

    @Override
    public List<Tenant> getAllTenants() {

        return tenantRepository.findAll();
    }
}
