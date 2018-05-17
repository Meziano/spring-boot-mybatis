package de.meziane.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.PropertySource;

import de.meziane.spring.boot.model.Student;

/**
 * @author M. Kettou
 */
@Mapper
@PropertySource("../test/sources/application.properties")
public interface StudentBatisRepo {

    @Select("select * from student")
    public List<Student> findAll();

    @Select("select * from student where id= #{id}")
    public Student findById(long id);

    @Insert("INSERT INTO student(firstName, lastName, semester, dob, doi) "
            + "VALUES ( #{firstName}, #{lastName}, #{semester},  #{dob}, #{doi})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long save(Student student);

    @Update("Update student set firstName=#{firstName}, lastName=#{lastName}, semester=#{semester}, dob=#{dob}, doi=#{doi} where id=#{id}")
    public Long update(Student student);

    /**
     * @param id
     */
    @Delete("delete from student where id=#{id}")
    public Long delete(Long id);

}
