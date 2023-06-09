package com.cssl.servlet;

import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import com.cssl.service.impl.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "UsersServlet", value = "/UsersServlet")
public class UsersServlet extends HttpServlet {
    private final UsersService US = new UsersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=UTF-8");
        String opr = req.getParameter("opr");
        //登录
        if ("login".equals(opr)) {
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            Users users = new Users(name, pwd);
            Users users1 = US.Login(users);
            if (users1 != null && users1.getUid() > 0) {
                Cookie cookie = new Cookie("UserName", name);
                Cookie cookie2 = new Cookie("UserUid", users1.getUid().toString());
                res.addCookie(cookie);
                res.addCookie(cookie2);
                req.getRequestDispatcher("list.html").forward(req, res);
            } else {
                res.sendRedirect("login.html");
            }
        }
        if ("Admin".equals(opr)) {
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            Users users = new Users(name, pwd);
            Users users1 = US.Login(users);
            if (users1 != null && users1.getUid() == 1) {
                res.sendRedirect("guanli.html");
            }
        }
        //注册账号
        if ("Regist".equals(opr)) {
            int rows;
            String name = req.getParameter("name");
            //查询是否有已存在用户
            Users user1 = US.IsExit(name);
            if( user1!=null && name.equals(user1.getName())){
                //存在相同用户,终止添加!
                System.out.println("存在相同用户,终止添加!");
                return;
            }
            String password = req.getParameter("password");
            String telephone = req.getParameter("telephone");
            String username = req.getParameter("username");
            Users users = new Users(null, name, password, telephone, username);
            rows = US.Regist(users);
            if (rows > 0) {
                req.getRequestDispatcher("login.html").forward(req, res);
            } else {
                res.sendRedirect("regs.html");
            }
        }
    }
}
