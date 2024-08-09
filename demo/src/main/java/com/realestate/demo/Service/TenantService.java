package com.realestate.demo.Service;

import com.realestate.demo.Entity.Tenant;

import java.util.List;

public interface TenantService {

    public String createTenant(Tenant tenant);
    public String updateTenant(Tenant tenant);
    public String deleteTenant(Integer id);
    public Tenant getTenant(Integer id);
    public List<Tenant> getAllTenants();


}
