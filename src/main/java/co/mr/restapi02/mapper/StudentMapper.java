package co.mr.restapi02.mapper;

import co.mr.restapi02.model.Academy;
import co.mr.restapi02.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    // 학생 생성 API 만들기

    @Insert("insert into student(academy_id, student_name, student_tel) values(#{student.academyId}, #{student.name}, #{student.tel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("student") Student student);

    @Select("select * from student")
    @Results(id="studentMap", value={
            @Result(property = "academyId", column = "academy_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "tel", column = "student_tel")
    })
    List<Student> getStudents();

    @ResultMap("studentMap")
    @Select("select * from student where id=#{id}")
    Student getById(int id);
}
