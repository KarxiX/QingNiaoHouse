package com.cssl.servlet;

import com.alibaba.fastjson.JSON;
import com.cssl.pojo.House;
import com.cssl.service.HouseService;
import com.cssl.service.impl.HouseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if ("AddHouse".equals(opr)) {
            Integer street_id = Integer.valueOf(req.getParameter("street_id"));
            Integer user_id = Integer.valueOf(req.getParameter("uid"));
            Integer type_id = Integer.valueOf(req.getParameter("type_id"));
            String title = req.getParameter("title");
            String descript = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));
            String InDate = req.getParameter("houseDate");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate;
            try {
                if (InDate == null || InDate.isEmpty()) {
                    // 处理日期为空的情况
                    InDate = "2100-11-11";
                }
                parsedDate = format.parse(InDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            java.sql.Date pubdate = new java.sql.Date(parsedDate.getTime());
            Integer floorage = Integer.valueOf(req.getParameter("floorage"));
            String contant = req.getParameter("contact");
            House house = new House(null, street_id, user_id, type_id, title, descript, price, pubdate, floorage, contant);
            int rows = HS.AddHouse(house);
            if (rows > 0) {
                res.getWriter().write("房屋添加成功");
            } else {
                res.getWriter().write("房屋添加失败");
            }
        }
        if ("Update".equals(opr)) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            Integer street_id = Integer.valueOf(req.getParameter("street_id"));
            Integer type_id = Integer.valueOf(req.getParameter("type_id"));
            String title = req.getParameter("title");
            String descript = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));
            String InDate = req.getParameter("houseDate");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate;
            try {
                if (InDate == null || InDate.isEmpty()) {
                    // 处理日期为空的情况
                    InDate = "2100-11-11";
                }
                parsedDate = format.parse(InDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            java.sql.Date pubdate = new java.sql.Date(parsedDate.getTime());
            Integer floorage = Integer.valueOf(req.getParameter("floorage"));
            String contant = req.getParameter("contact");
            House house = new House(id, street_id, null, type_id, title, descript, price, pubdate, floorage, contant);
            int rows = HS.UpdateHouse(house);
            if (rows > 0) {
                res.getWriter().write("房屋修改成功");
            } else {
                res.getWriter().write("房屋修改成功");
            }
        }
        if ("Delete".equals(opr)) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            int rows = HS.DeleteHouse(id);
            if (rows > 0) {
                req.getRequestDispatcher("guanli.html").forward(req, res);
                System.out.println("删除成功!");
            } else {
                res.sendRedirect("gunali.html");
                System.out.println("删除失败!");
            }
        }
        if ("Search".equals(opr)){
            String street_id = req.getParameter("street");
            String type_id = req.getParameter("type_id");
            String price = req.getParameter("price");
            String floorage = req.getParameter("floorage");
            String title = req.getParameter("title");
            String[] prices = new String[2];//数组存储两个参数
            String[] floorages = new String[2];//数组存储两个参数
            String price1 = null;
            String price2 = null;
            String floorage1 = null;
            String floorage2 = null;
            try {
                splitRange(price, prices);
                price1 = prices[0];
                price2 = prices[1];
                splitRange(floorage, floorages);
                floorage1 = floorages[0];
                floorage2 = floorages[1];
                System.out.println("price最小值：" + price1);
                System.out.println("price最大值：" + price2);
                System.out.println("floorage最小值：" + floorage1);
                System.out.println("floorage最大值：" + floorage2);
            } catch (IllegalArgumentException e) {
                System.err.println("错误信息：" + e.getMessage());
            }
            List<House> list = HS.FindOneHouse(title,street_id,type_id,price1,price2,floorage1,floorage2);
            String json = JSON.toJSONString(list);
            writer.print(json);
            writer.flush();
            writer.close();
        }

    }

    //获取下拉框参数分割作为两个参数
    public static void splitRange(String range, String[] result) {
        String[] parts = range.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("范围格式无效：" + range);
        }
        try {
            result[0] = (parts[0]);
            result[1] = (parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("范围中的格式无效：" + range);
        }
    }

//    public static void main(String[] args) {
//        String[] result = new String[2];
//        String price = "4000-6000";
//        String floorage = "0-1000";
//        splitRange(price,result);
//        try {
//            splitRange(floorage, result);
//            String minValue = result[0];
//            String maxValue = result[1];
//            System.out.println("最小值：" + minValue);
//            System.out.println("最大值：" + maxValue);
//        } catch (IllegalArgumentException e) {
//            System.err.println("错误信息：" + e.getMessage());
//        }
//    }
}
