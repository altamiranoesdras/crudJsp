package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import models.User;

public class UserController extends HttpServlet {    
    
	
	private static String INSERT = "/user.jsp";
    private static String Edit = "/edit.jsp";
    private static String UserRecord = "/listUser.jsp";
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String uId = request.getParameter("userid");        
        String action = request.getParameter("action");
        
        if(!((uId)== null) && action.equalsIgnoreCase("insert")){
        	
        	int id = Integer.parseInt(uId);
        	User user = new User();
        	
        	user.setId(id);
            user.setNombres(request.getParameter("firstName"));
            user.setApellidos(request.getParameter("lastName"));
        	dao.addUser(user);
        	redirect = UserRecord;
            request.setAttribute("users", dao.getAllUsers());
            
           	System.out.println("Registro insertado");
        }
        else if (action.equalsIgnoreCase("delete")){
        	
            String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            
            dao.removeUser(uid);
            redirect = UserRecord;
            request.setAttribute("users", dao.getAllUsers());
            
            System.out.println("Registro Eliminados");
            
        }else if (action.equalsIgnoreCase("editform")){     
        	
        	redirect = Edit;
        	
        } else if (action.equalsIgnoreCase("edit")){
        	
        	String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            
            User user = new User();
        	user.setId(uid);
            user.setNombres(request.getParameter("firstName"));
            user.setApellidos(request.getParameter("lastName"));
            dao.editUser(user);
            request.setAttribute("user", user);
            redirect = UserRecord;
            System.out.println("Registro Actualizado");
            
         } else if (action.equalsIgnoreCase("listUser")){
            redirect = UserRecord;
            request.setAttribute("users", dao.getAllUsers());
         } else {
            redirect = INSERT;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}