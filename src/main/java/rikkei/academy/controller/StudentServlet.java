package rikkei.academy.controller;

import rikkei.academy.model.entity.Student;
import rikkei.academy.model.service.StudentService_IPML;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/studentservlet")
public class StudentServlet extends HttpServlet {
private StudentService_IPML studentServiceIpml = null;
    @Override
    public void init() {
        studentServiceIpml = new StudentService_IPML();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // kiểm tra action
        String action = request.getParameter("action");
        if (action == null) {
            // nhận method get
          showListStudent(request,response);
            return;
        }
        switch (action) {
            case "edit" :
                // lấy dữ liệu theo Id
                int id_edit= Integer.parseInt(request.getParameter("id"));
                // Đổ dữ liệu và hiển thị ra from
                Student student_edit = studentServiceIpml.findById(id_edit);
                // hiển thị ra from hoặc view
                request.setAttribute("student_edit", student_edit);
                request.getRequestDispatcher("views/student-edit.jsp").forward(request,response);
                break;
            case "delete" :

                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String studentName = request.getParameter("studentName");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String action = request.getParameter("action");

       if (action == null) {
           studentServiceIpml.save(new Student(studentName,age,gender));
           response.sendRedirect("/studentservlet");
       }

        assert action != null;
        if (action.equals("update")){
           int id = Integer.parseInt(request.getParameter("studentCode"));
           Student student = new Student(studentName,age,gender);
           studentServiceIpml.update(student,id);
           response.sendRedirect("/studentservlet");

       }
    }

    @Override
    public void destroy() {

    }

    public void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Student> list = studentServiceIpml.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("views/student.jsp").forward(request,response);
    }

}