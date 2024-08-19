package com.realestate.demo.Service;

import com.realestate.demo.Entity.Tenant;

import java.util.List;

public interface TenantService {

     String createTenant(Tenant tenant);
     String updateTenant(Tenant tenant);
     String deleteTenant(Integer id);
     Tenant getTenant(Integer id);
     List<Tenant> getAllTenants();


}
