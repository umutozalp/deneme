package com.realestate.demo.Controller;
import com.realestate.demo.Entity.Tenant;
import com.realestate.demo.Repository.TenantRepository;
import com.realestate.demo.Service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final TenantRepository tenantRepository;
    Tenant tenant;
    TenantService tenantService;
    public TenantController(TenantService tenantService, TenantRepository tenantRepository) {
        this.tenantService = tenantService;
        this.tenantRepository = tenantRepository;
    }
    //Tek bir kullanıcının bilgisi.
    @GetMapping("{id}")
   public Tenant getTenant(@PathVariable Integer id)
    {
        return tenantService.getTenant(id);
    }

    //Tüm kullanıcıların bilgisi
    @GetMapping()
    public List<Tenant> getAllTenant(Tenant tenant)
    {
       return tenantService.getAllTenants();
    }

    @PostMapping
    public Tenant createTenant(@RequestBody Tenant tenant)
    {
        tenantService.createTenant(tenant);

        return tenantService.getTenant(tenant.getId());
    }
    @PutMapping
    public String updateTenant(@RequestBody Tenant tenant)
    {
        tenantService.updateTenant(tenant);
        return "Updated tenant Seccessfully";
    }
    @DeleteMapping("{id}")
    public String deleteTenant(@PathVariable Integer id)
    {
        tenantService.deleteTenant(id);
        return "Deleted tenant Seccessfully";
    }





}
