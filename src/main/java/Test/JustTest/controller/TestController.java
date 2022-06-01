package Test.JustTest.controller;

import Test.JustTest.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Test.JustTest.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class TestController {


    private final AdminService adminService;


    public TestController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping
    public List<Admin> getAdmin(){
    return adminService.getAllAdmins();
    }

    @PostMapping
    public void addTodos(@RequestBody Admin admin){
    adminService.AddAdmin(admin);
    }

    @DeleteMapping(path = "{adminId}")
    public void deleteMapping(@PathVariable("adminId") Long id){
    adminService.deleteAdmins(id);
    }

    @PutMapping(path = "{adminId}")
  public void updateStudent(@PathVariable ("adminId") Long id,@RequestParam (required = false)String name,
                            @RequestParam String role,@RequestParam String email,@RequestParam int salary){
      adminService.updateAdmins(id,name,role,email,salary);
    }

}
