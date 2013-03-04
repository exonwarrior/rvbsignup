<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <link rel="stylesheet" href="style.css" />
  
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <head>
        <meta content="en-us" http-equiv="Content-Language" />
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
        <title>Home</title>
        <script type="text/javascript" ><!--
            function validate(){
            var emailReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            var passwordReg = /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9@#$%]{6,20})/;
            var nameReg =  /^[A-Za-z]{2,16}$/;
            var pass1 = document.getElementById("password").value;
            var pass2 = document.getElementById("confirm_password").value;
            var email = document.getElementById("email").value;
            var name = document.getElementById("name").value;
            var lastName = document.getElementById("last_name").value;

            if(!nameReg.test(name)){
               alert("name must be between 2 and 16 a-z charaters");
            }
            else if(!nameReg.test(lastName)){
                alert("name must be between 2 and 16 a-z charaters");
            }
            else if(pass1 != pass2){
                alert("passwords do not match");     
            }
            else if(!passwordReg.test(pass1)){
                alert("Password is not valid");
            }
            else if(!emailReg.test(email)){
                alert("Not a valid email");
            }
            else{
                document.forms["paymentForm"].submit();
            }
        }
        --></script>
    </head>
    
    <body>
        <div class="container">
        <div id="header">
                <a href="./home.jsp">
                    <img alt="Monster logo" src="monsterlogo.png" />
                </a>
                <link rel="icon" href="favicon.ico" />
            </div>
        <div id="navbar">
            <jsp:include page="navbar.jsp" />
        </div>

            <section id="content">
                <h1>Registration</h1>
                <br />
                <br />
                <br />
                <form method="POST" name="paymentForm" id="paymentForm" action="register">
                    <p name="name_text">
                        <input type="text" placeholder="First Name" name="first_name" id="name" size="30" /><br /><br />
                        <input type="text" placeholder="Last Name" name="last_name" id="last_name" size="30" /><br /><br />
                    </p>

                    <p name="email_text">
                        <input type="text" placeholder="Email" name="email" id="email" size="30" /><br /><br />
                    </p>
                    
                    <p name="password_text">
                        <input type="password" placeholder="Password" name="password" id="password" size="30" /><br /><br />
                        <input type="password" placeholder="Confirm Password" name="confirm_password" id="confirm_password"  size="30" /><br />
                        Passwords must be between 6 and 20 characters and contain a number and an upper and lower case letter.
                        Special characters are not allowed.<br /><br />
                    </p>
                    
                    <% 
                      String errorMess = (String) request.getAttribute("error");
                        if(errorMess != null){%>
                        <p><%=errorMess %></p><%   
                        }
                        %>           
                    <input type="button" value="submit" onclick="validate();" />
                </form>
            </section>
        </div>
    </body>
</html>