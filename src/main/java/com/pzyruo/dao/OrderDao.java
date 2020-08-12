package com.pzyruo.dao;

import com.pzyruo.domain.Student;

import java.util.List;

public interface OrderDao {

   List<Student> dynamicSQl(Student student);
   List<Student> DynamicWhereSQL(Student student);
   List<Student> SelectStudentForeach(List<Integer> idList);
   List<Student> SelectStudentForeach2(List<Student> student);
}
