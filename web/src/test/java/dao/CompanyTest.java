package dao;

import com.mar.Application;
import com.mar.dao.CompanyDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CompanyTest {

    @Autowired
    private CompanyDao companyDao;

    @Test
    @Rollback
    public void testInsert(){
    }

}