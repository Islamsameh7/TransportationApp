package com.company.App.control;

import com.company.App.model.Admin;
import com.company.App.model.Driver;
import com.company.App.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminControl {
    AdminService adminService;

    @Autowired
    public AdminControl(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/adminControl/getAdmin")
    public Admin getAdmin() {
        return adminService.getAdmin();
    }

    @PostMapping("/adminControl/addDiscountArea")
    public void addDiscountArea(){
        adminService.addDiscountArea();
    }

    @PutMapping("/adminControl/verify")
    public void verify(Driver driver){
        adminService.verify(driver);
    }

    @GetMapping("/adminControl/listDriversRequests")
    public void listDriversRequests(){
        adminService.listDriversRequests();
    }

    @DeleteMapping("/adminControl/suspendUser")
    public void suspendUser(){
        adminService.suspendUser();
    }

    @GetMapping("/adminControl/listEvents")
    public void listEvents() {
        adminService.listEvents();
    }
}
