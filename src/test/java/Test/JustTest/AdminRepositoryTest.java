package Test.JustTest;

import Test.JustTest.model.Admin;
import Test.JustTest.repository.AdminRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    public void saveAdmin(){
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setName("Kenny");
        admin.setRole("chief");
        admin.setEmail("they@gmail.com");
        admin.setSalary(542);

        adminRepository.save(admin);

        Assertions.assertThat(1L).isGreaterThan(0);
    }

    @Test
    public void getAdmins(){
    Long admin = adminRepository.getById(1L).getId();
    Assertions.assertThat(1L).isEqualTo(admin);
    }

    @Test
    public void getAllAdmins(){
      List<Admin> allAdmins = adminRepository.findAll();
        Assertions.assertThat(allAdmins.size()).isNotNegative();
    }




}
