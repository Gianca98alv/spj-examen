package com.mycompany.spj.examen.controller.player;

import com.mycompany.spj.examen.model.Apuesta;
import com.mycompany.spj.examen.model.Sorteo;
import com.mycompany.spj.examen.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PlayerController", urlPatterns = {"/player", "/player/bet"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl;
        switch(request.getServletPath()){
            case "/player": viewUrl = this.show(request); break;
            default: viewUrl = "/pages/Error.jsp"; break;          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    private String show(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        try {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.setLista_apuestas(com.mycompany.spj.examen.data.Model.instance().findApuestasByUsuario(usuario.getCedula()));
            model.setApuesta(null);
            return "/pages/player/View.jsp;";
        } catch (Exception ex) {
            return "/pages/Error.jsp"; 
        }
    }

    private String bet(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        try {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            int numero_sorteo = Integer.getInteger(request.getParameter("numero_sorteo"));
            int numero_juego = Integer.getInteger(request.getParameter("numero_juego"));
            int monto_apuesta = Integer.getInteger(request.getParameter("monto_apuesta"));
            Sorteo sorteo = com.mycompany.spj.examen.data.Model.instance().findSorteo(numero_sorteo);
            Apuesta apuesta = new Apuesta(usuario, sorteo, numero_juego, monto_apuesta, 0);
            return "/player/show";
        } catch(Exception e) {
            return "/pages/Error.jsp"; 
        }
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