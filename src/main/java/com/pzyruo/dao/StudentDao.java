package com.pzyruo.dao;

import com.pzyruo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

   List<Student> dynamicSQl(Student student);
   List<Student> DynamicWhereSQL(Student student);
   List<Student> SelectStudentForeach(List<Integer> idList);
   List<Student> SelectStudentForeach2(List<Student> student);
   List<Student> SelectAllPageHelp();
}
