package ua.nure.pihnastyi.controller;

import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.GoodsService;
import ua.nure.pihnastyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/pages/user/cart.jsp").forward(req, resp);


    }
}


