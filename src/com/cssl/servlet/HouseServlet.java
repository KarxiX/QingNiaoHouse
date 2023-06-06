package com.cssl.servlet;

import com.alibaba.fastjson.JSON;
import com.cssl.mapper.HouseMapper;
import com.cssl.mapper.impl.HouseMapperImpl;
import com.cssl.pojo.House;
import com.cssl.service.HouseService;
import com.cssl.service.impl.HouseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HouseServlet", value = "/HouseServlet")
public class HouseServlet extends HttpServlet {
    private final HouseService HS = new HouseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        String opr = req.getParameter("opr");
        PrintWriter writer = res.getWriter();
        if ("FindAll".equals(opr)) {
            List<House> list = HS.FindAllHouse();
            String json = JSON.toJSONString(list);
            writer.print(json);
            //System.out.println(json);
            writer.flush();
            writer.close();
        }
        if ("Details".equals(opr)) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            House house = HS.FindDetailHouse(id);
            String json = JSON.toJSONString(house);
            writer.print(json);
            writer.flush();
            writer.close();
        }

    }
}
