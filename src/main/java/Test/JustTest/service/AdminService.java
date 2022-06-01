package Test.JustTest.service;

import Test.JustTest.model.Admin;
import org.springframework.stereotype.Service;
import Test.JustTest.repository.AdminRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins(){
       return adminRepository.findAll();
    }

    public void AddAdmin(Admin admin){
        Optional<Admin> admins = adminRepository.findByName(admin.getName());
        if (admins.isPresent()){

            throw new IllegalStateException("Admin not saved");
        }
        adminRepository.save(admin);
    }

    public void getAdminByName(String name){
       Optional<Admin> checkAdmin = adminRepository.findByName(name);
       if (checkAdmin.isPresent()){
           adminRepository.findByName(name);
       }
        throw new IllegalStateException("Name does not exist");
    }

    public void deleteAdmins(long id){
        Boolean admins = adminRepository.existsById(id);
         if (!admins){
             throw new IllegalStateException("Admin does not exist");
         }
         adminRepository.deleteById(id);
    }

    @Transactional
    public Void updateAdmins(Long id,String name, String role,String email,int salary) {

        Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "The To-do  with " + id + " does not exist"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(admin.getName(), name)) {
            admin.setName(name);
        }

        if (role != null && role.length() > 0 && !Objects.equals(admin.getRole(),role)){
            admin.setRole(role);
        }


        if (email != null && email.length() > 0 && !Objects.equals(admin.getEmail(),email)){
            admin.setEmail(email);
        }

        if (salary == 0  && !Objects.equals(admin.getSalary(),salary)){
            admin.setSalary(salary);
        }
        throw new IllegalStateException("Empty! Nothing to update");
    }
    }

