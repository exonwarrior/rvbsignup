import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * This class contains methods which manages connection and 
 * data exchange between login.jsp and database.
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


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
     //@EJB PersonDOA personDOA;
     @Override 
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tempEmail = request.getParameter("email");
        String tempPassword = request.getParameter("password");
        String formError =" ";
        
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        String logout = request.getParameter("logout");
        
        //method which allows user to logout
        if(logout!=null && logout.equals("logout")){
            request.getSession().invalidate();
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
           //creates new session and updates database
            if(this.check(tempEmail, tempPassword)){
                
                /*personDOA = new PersonDOA();
                 * HttpSession session = request.getSession(true);
                 * Person user = personDOA.getPersonByEmail(tempEmail);*/

                /*session.setAttribute("user", user);
                 * session.setAttribute("monsters", personDOA.getPersonsMonsters(user));
                 * session.setAttribute("friends", personDOA.getPersonsFriends(user));
                 * session.setAttribute("requestList", personDOA.getPersonsFriendRequests(user));
                 * session.setAttribute("offers", user.getFightOffers() );
                 * session.setAttribute("challenges", user.getFightChallenges() );
                 * session.setAttribute("offers", user.getFightOffers() );
                 * session.setAttribute("challenges", user.getFightChallenges() );
                 * request.getRequestDispatcher("/myMonsters.jsp").forward(request, response);*/

            }
            else{
                //sends error message to the user
                formError ="Incorrect email or password!";
                request.setAttribute("message", formError);
                request.getRequestDispatcher("/login.jsp").forward(request, response); 
                response.setHeader("Location", "http://localhost:8080/MonsterGame/login.jsp");
            }
        }
        
       
    }
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
        
    }
    
    /**
     * Method that validates user input with the existing field in database
     * to log in 
     * @param email , String unique email 
     * @param password , String users password
     * @return , response
     */
    public boolean check(String email, String password){
        boolean response = false;
        /*personDOA = new PersonDOA();
         * if(personDOA.lookForEmail(email) && personDOA.getPersonByEmail(email).getPassword().equals(password)){
         * response = true;
         * }*/
 
        return response;
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
    public String getServletInfo() {
        return "Short description";
    }
}
