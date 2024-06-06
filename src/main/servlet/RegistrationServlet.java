package main.servlet;

import main.dto.CreateStudentDto;
import main.entity.Gender;
import main.entity.Role;
import main.service.StudentService;
import main.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final StudentService studentService = StudentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        CreateStudentDto studentDto = new CreateStudentDto();
        studentDto.setName(req.getParameter("name"));
        studentDto.setPassword(req.getParameter("password"));
        studentDto.setEmail(req.getParameter("email"));
        studentDto.setBirthday(req.getParameter("birthday"));
        studentDto.setGender(req.getParameter("gender"));
        studentDto.setRole(req.getParameter("role"));

        try {
            studentService.create(studentDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            resp.sendRedirect("/login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


