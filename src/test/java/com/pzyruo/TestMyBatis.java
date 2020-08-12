package com.pzyruo;

import com.pzyruo.dao.StudentDao;
import com.pzyruo.domain.MyStudent;
import com.pzyruo.domain.Student;
import com.pzyruo.util.MyBatisUtils;
import com.pzyruo.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//为什么更新数据比查询先执行？？？？？
public class TestMyBatis {
    @Test
    public void TestDynamicSQl(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("暴君");
        student.setAge(18);
        List<Student> list = dao.dynamicSQl(student);
        for (Student stu:list){
            System.out.println("if==="+stu);
        }
    }
    @Test
    public void TestDynamicWhereSql(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("暴君");
        //student.setAge(18);
        List<Student> list = dao.DynamicWhereSQL(student);
        for (Student student1 :list){
            System.out.println("where==="+student1);
        }
    }

    @Test
    public void testDynamicForeachSql(){
        List<Integer>list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        //String sql = "select * from student where id in(100,1002,1003)";
        String sql = "select * from student where id in";
        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();

        //添加开始的（
        builder.append("(");
        for (Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql = sql+builder.toString();
        System.out.println("sql=="+sql) ;
    }
    @Test
    public void TestSelectStudentForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.SelectStudentForeach(list);
        for (Student stu :students){
            System.out.println("where==="+stu );
        }
    }
    @Test
    public void TestSelectStudentForeach2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        list.add(s1);

        List<Student> students = dao.SelectStudentForeach2(list);
        for (Student stu :students){
            System.out.println("where==="+stu );
        }
    }
@Test
    public void TestSelectAllPageHelp(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入pageHelper的方法，分页
//      pageNum:第几页，从1开始
//      pageSize:一页中有多少数据
       // PageHelper.startPage(2,3);
         List<Student> list = dao.SelectAllPageHelp();
         for (Student student:list){
             System.out.println("foreach-one"+student);
         }


}

    }


