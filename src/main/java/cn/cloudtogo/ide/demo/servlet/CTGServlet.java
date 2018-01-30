package cn.cloudtogo.ide.demo.servlet;


import cn.cloudtogo.ide.demo.db.DBHelper;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CTGServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","application/json;charset=utf8");
        JSONObject jsonObject = new JSONObject();

        DBHelper dbHelper =  new DBHelper("show variables");
        ResultSet rs = null;
        try {
            rs = dbHelper.pst.executeQuery();
            while (rs.next()){
                jsonObject.put(rs.getString(1),rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbHelper.close();
        }

//        System.getenv().forEach((k, y) -> System.out.println(k + "=" + y));
        System.out.println(System.getProperty("java.version"));

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(jsonObject.toString());
    }
}
