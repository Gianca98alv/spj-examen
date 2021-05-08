package com.mycompany.spj.examen.controller.login;

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

@WebServlet(name = "LoginController", urlPatterns = {"/login/show", "/login/login", "/login/logout"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl;
        switch(request.getServletPath()){
            case "/login/show": viewUrl = this.show(request); break;
            case "/login/login": viewUrl = this.login(request); break;
            case "/login/logout": viewUrl = this.logout(request); break;
            default: viewUrl = "/pages/Error.jsp"; break;          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    private String show(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setClave("");
        return "/pages/login/View.jsp";
    }
    
    private String login(HttpServletRequest request) { 
        Map<String, String> errors = this.completeData(request);
        if(errors.isEmpty()){
            this.updateData(request);
            return this.loginAction(request);
        }
        else{
            request.setAttribute("errors", errors);
            return "/pages/login/View.jsp";
        }        
    }
       
    private Map<String, String> completeData(HttpServletRequest request){
        Map<String, String> errors = new HashMap<>();
        if(request.getParameter("cedula").isEmpty()){
            errors.put("cedula", "Cedula requerida");
        }
        if(request.getParameter("clave").isEmpty()){
            errors.put("clave", "Clave requerida");
        }
        return errors;
    } 
    
    private void updateData(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setCedula(request.getParameter("cedula"));
        model.getCurrent().setClave(request.getParameter("clave"));
    }
    
    private String loginAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        try {
            Usuario db_user = this.validateCredentials(model.getCurrent());
            session.setAttribute("usuario", db_user);
            if(db_user.getAdministrador()){
                return "/admin";
            }
            else {
                return "/player";
            }
        } catch (Exception ex) {
            Map<String, String> errors = new HashMap<>();
            errors.put("cedula", "Cedula o Contraseña Erronea");
            errors.put("clave", "Cedula o Contraseña Erronea");
            request.setAttribute("errors", errors);
            return "/login/show"; 
        }
    }
    
    private Usuario validateCredentials(Usuario user) throws Exception{
        Usuario db_user;
        try {
            String cedula = user.getCedula();
            db_user = com.mycompany.spj.examen.data.Model.instance().findUsuarioByCedula(cedula);
            if(!db_user.getClave().equals(user.getClave())){
                throw new Exception();
            }
        }catch (Exception ex) {
            throw new Exception("Usuario o Contraseña Erroneos");
        }
        return db_user;
    }

    private String logout(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/index";   
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