package com.newer.web.servlet;

import com.google.gson.Gson;
import com.newer.service.RoomsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet("/rooms")
public class RoomsServlet extends HttpServlet {

    private RoomsService roomsService = new RoomsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型和字符集
        resp.setContentType("application/json;charset=utf-8");
        String action = req.getParameter("action");
        if(Objects.isNull(action)){
            findTypes(resp);
        }else if ("findRoomId".equals(action)){
            findRoomIds(req, resp);
        }

    }

    /**
     * 查询对应房间类型的房间编号
     * @param req
     * @param resp
     * @throws IOException
     */
    private void findRoomIds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String roomtype = req.getParameter("roomtype");
        List<Integer> list = roomsService.findRoomIds(roomtype);
        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        //将集合转换成json数组响应前端
        out.print(gson.toJson(list));
        out.close();
    }

    /**
     * 查询房间类型数据
     * @param resp
     * @throws IOException
     */
    private void findTypes(HttpServletResponse resp) throws IOException {
        List<String> list = roomsService.findTypes();
        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        //将集合转换成json数组响应前端
        out.print(gson.toJson(list));
        out.close();
    }
}
