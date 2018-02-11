package cn.cloudtogo.ide.demo.servlet;


import cn.cloudtogo.ide.demo.service.CTGService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CTGServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","application/json;charset=utf8");
        CTGService ctgService = new CTGService();

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(ctgService.getShowParam().toString());
    }
}
