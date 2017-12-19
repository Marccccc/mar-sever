package dao;

import com.mar.Application;
import com.mar.entity.Role;
import com.mar.entity.User;
import com.mar.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    //@Rollback
    public void testInsert() {
        User user = new User();
        user.setName("cc13122c");
        user.setAccount("fbvfgreewx");
        user.setPassword("dkkkks23d1d");
        Company company = new Company();
        company.setId(1);
        List<Role> roles = new LinkedList<>();
        Role role = new Role();
        role.setId(1);
        roles.add(role);
        Role role1 = new Role();
        roles.add(role1);
        role.setId(2);
        user.setRoles(roles);
        user.setCompany(company);
        //userService.saveUser(user);
    }

}