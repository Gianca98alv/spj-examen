package com.mycompany.spj.examen.controller.admin;

import com.mycompany.spj.examen.controller.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminController", urlPatterns = {"/admin", "/admin/update/sort"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl;
        switch(request.getServletPath()){
            case "/admin": viewUrl = this.show(request); break;
            case "/admin/update/sort": viewUrl = this.updateSort(request); break;
            default: viewUrl = "/pages/Error.jsp"; break;          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    private String show(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        try{
            model.setSorteos_terminados(com.mycompany.spj.examen.data.Model.instance().getListaSorteosTerminados());
        } catch(Exception e) {
            System.out.println(e);
        }
        return "/pages/admin.jsp";
    }
    
    private String updateSort(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        String numero_sorteo = request.getParameter("numero_sorteo");
        String numero_ganador = request.getParameter("numero_ganador");
        try {
            com.mycompany.spj.examen.data.Model.instance().updateSort(Integer.valueOf(numero_sorteo), Integer.valueOf(numero_ganador));
        } catch(Exception e) {
            System.out.println(e);
        }
        return "/pages/admin.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}