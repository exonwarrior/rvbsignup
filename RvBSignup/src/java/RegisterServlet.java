/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * This class contains methods which manages connection and 
 * data exchange between register.jsp and database.
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    //@EJB PersonDOA personDOA;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //personDOA = new PersonDOA();
         String temp_name = request.getParameter("first_name") + " " + request.getParameter("last_name");
         String temp_email = request.getParameter("email");
         String temp_password = request.getParameter("password");
         String formError =" ";
         
         //checks if email already exists in database
         /*if(personDOA.lookForEmail(temp_email)){
          * formError ="Email address is already in the system";
          * request.setAttribute("error", formError);
          * request.getRequestDispatcher("/register.jsp").forward(request, response);
          * }
          * else{
          * formError ="Sucessfully Registered!";
          * request.setAttribute("message", formError);
          * this.personDOA.persist(new Person(temp_name, temp_password, temp_email));
          * 
          * request.getRequestDispatcher("/login.jsp").forward(request, response);
          * response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
          * response.setHeader("Location", "http://localhost:8080/MonsterGame/login.jsp");
          * }*/   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
