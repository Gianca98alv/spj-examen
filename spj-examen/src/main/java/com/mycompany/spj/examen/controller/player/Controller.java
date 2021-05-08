package com.mycompany.spj.examen.controller.player;

import com.mycompany.spj.examen.model.Apuesta;
import com.mycompany.spj.examen.model.Sorteo;
import com.mycompany.spj.examen.model.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
             case "/player/bet": viewUrl = this.bet(request); break;
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
            model.setLista_sorteos(com.mycompany.spj.examen.data.Model.instance().getListaSorteosFuturos());
            model.setNumero_juego("");
            model.setMonto_apuesta("");
            model.setApuesta(null);
            return "/pages/player/View.jsp";
        } catch (Exception ex) {
            return "/pages/Error.jsp"; 
        }
    }

    private String bet(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        try {
            this.completeData(request);
            Map<String, String> errors = this.completeData(request);
            if(errors.isEmpty()){
                this.updateData(request);
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                int numero_juego = Integer.valueOf(request.getParameter("numero_juego"));
                int monto_apuesta = Integer.valueOf(request.getParameter("monto_apuesta"));
                int numero_sorteo = Integer.valueOf(request.getParameter("numero_sorteo"));
                Sorteo sorteo = com.mycompany.spj.examen.data.Model.instance().findSorteo(numero_sorteo);
                Apuesta apuesta = new Apuesta(usuario, sorteo, numero_juego, monto_apuesta, 0);
                com.mycompany.spj.examen.data.Model.instance().addBet(apuesta);
            }
            request.setAttribute("errors", errors);
            return "/player";
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return "/pages/Error.jsp";
        }
    }
    
    private Map<String, String> completeData(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (request.getParameter("monto_apuesta").isEmpty()) {
            errors.put("monto_apuesta", "Monto requerida");
        } else {
            int monto = Integer.valueOf(request.getParameter("monto_apuesta"));
            if(monto < 100 || monto > 20000 ){
                errors.put("monto_apuesta", "El monto debe ser entre 100 y 20000");
            }
        }
        if (request.getParameter("numero_juego").isEmpty()) {
            errors.put("numero_juego", "Numero de juego requerido");
        } else {
            int numero = Integer.valueOf(request.getParameter("numero_juego"));
            if(numero < 0 || numero > 99){
                errors.put("numero_juego", "El numero debe ser entre 0 y 99");
            }
        }
        return errors;
    }

    private void updateData(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.setMonto_apuesta(request.getParameter("monto_apuesta"));
        model.setNumero_juego(request.getParameter("numero_juego"));
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