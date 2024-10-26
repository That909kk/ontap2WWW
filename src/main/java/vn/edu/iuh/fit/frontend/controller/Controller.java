package vn.edu.iuh.fit.frontend.controller;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.frontend.dto.HangXeDTO;
import vn.edu.iuh.fit.frontend.dto.XeDTO;
import vn.edu.iuh.fit.frontend.models.XeModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private XeModel xeModel ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action.toLowerCase()){
            case "list_xe":
                List<XeDTO> xeDTOS = xeModel.getAllXe();
                req.setAttribute("xes", xeDTOS);
                req.getRequestDispatcher("views/list_xe.jsp").forward(req, resp);
                break;
//            case "add_xe":
//
//                req.getRequestDispatcher("views/addXe.jsp").forward(req, resp);
//                break;
            case "search_xe":
                String tenxe = req.getParameter("timkiem");
                double giaXe = Double.parseDouble(req.getParameter("timkiem"));
                List<XeDTO> searchResults = xeModel.searchXe(tenxe, giaXe);
                req.setAttribute("xes", searchResults);
                req.getRequestDispatcher("views/list_xe.jsp").forward(req, resp);
                break;
        }
        }
    }





