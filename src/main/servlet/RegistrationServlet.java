package main.servlet;

import main.dto.CreateStudentDto;
import main.entity.Gender;
import main.entity.Role;
import main.service.StusentService;
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

    private final StusentService stusentService = StusentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        CreateStudentDto userDto = new CreateStudentDto();
        userDto.setName(req.getParameter("name"));
        userDto.setPassword(req.getParameter("password"));
        userDto.setEmail(req.getParameter("email"));
        userDto.setBirthday(req.getParameter("birthday"));
        userDto.setGender(req.getParameter("gender"));
        userDto.setRole(req.getParameter("role"));

        try {
            stusentService.create(userDto);
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


