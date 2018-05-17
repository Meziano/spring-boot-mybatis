package de.meziane.spring.boot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import de.meziane.spring.boot.mapper.StudentBatisRepo;
import de.meziane.spring.boot.model.Student;

// @RunWith(SpringRunner.class) // (SpringJUnit4ClassRunner.class)
// @ContextConfiguration(loader = AnnotationConfigContextLoader.class)
// @SpringBootTest // (classes = ApplicationContext.class)

@RunWith(SpringRunner.class)
@MybatisTest
public class SpringBoot004ApplicationTests {

    @Autowired
    StudentBatisRepo testRepo;

    @Test
    public void testFindAll() {
        assertEquals("Your message: Test not successful", testRepo.findAll().size(), 6);
    }

    @Test
    public void testFindById() {
        assertNotNull("Your message: Test not successful", testRepo.findById(1));
    }

    @Test
    public void testInsert() {
        final Student student = new Student("Yuri", "Ted", LocalDate.of(1990, 5, 10), LocalDate.of(2010, 1, 15), 7);
        final Long id = testRepo.save(student);
        assertNotNull("Your message: Test not successful", id);
    }

}
