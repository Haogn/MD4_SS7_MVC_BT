package rikkei.academy.model.dao;

import rikkei.academy.model.entity.Student;
import rikkei.academy.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO_IMPL implements IGenericDAO<Student, Integer>{
    @Override
    public List<Student> findAll() {
        Connection connection = null;
        List<Student> list = new ArrayList<>();

        try {
            // mở kêt kết
            connection = ConnectionDB.openConnection();
            // chuẩn bị câu truy vấn
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student");
            // thực thi câu truy vấn
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setStudentCode(rs.getInt("studentCode"));
                student.setStudentName(rs.getString("studentName"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getBoolean("gender"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // đóng kết nối
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    @Override
    public Boolean save(Student student) {
        Connection connection = null;

        try {
            // mở kết nối
            connection = ConnectionDB.openConnection();
            // xây dựng câu truy vấn
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO student( studentName, age, gender) VALUES (?,?,?)");
            //
            pstm.setString(1,student.getStudentName());
            pstm.setInt(2,student.getAge());
            pstm.setBoolean(3,student.isGender());
            // thực thi
            int check =  pstm.executeUpdate();
            if (check >1 ) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public Student findById(Integer id) {
       Connection connection = null ;
       Student student = new Student();
        try {
            // mở luồng
            connection = ConnectionDB.openConnection();
            // xây dựng câu lệnh truy vấn
            PreparedStatement prsm = connection.prepareStatement("SELECT * FROM student WHERE studentCode=?");
            prsm.setInt(1,id);
            // thực thi
            ResultSet rs =  prsm.executeQuery();
            while (rs.next()){
                student.setStudentCode(rs.getInt("studentCode"));
                student.setStudentName(rs.getString("studentName"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getBoolean("gender"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // đóng luồng
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return student;
    }

    @Override
    public Boolean update(Student student, Integer id) {
        Connection connection = null;

        try {
            // mở kết nối
            connection = ConnectionDB.openConnection();
            // xây dựng câu truy vấn
            PreparedStatement pstm = connection.prepareStatement("UPDATE student SET studentName= ?, age=?, gender =? WHERE studentCode = ?");
            //
            pstm.setString(1,student.getStudentName());
            pstm.setInt(2,student.getAge());
            pstm.setBoolean(3,student.isGender());
            pstm.setInt(4,id);
            // thực thi
            int check =  pstm.executeUpdate();
            if (check >1 ) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        try {
            // mở kết nối
            connection = ConnectionDB.openConnection();
            // xây dựng câu lệnh truy vấn
            PreparedStatement prsm = connection.prepareStatement("DELETE FROM student WHERE studentCode=?");
            prsm.setInt(1,integer);
            int check = prsm.executeUpdate();
            if (check > 0) {
                System.out.println("Đã xoá sinh viên với id = "+integer );
            } else {
                System.err.println("Không tìm thấy sinh viên với id = " + integer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
