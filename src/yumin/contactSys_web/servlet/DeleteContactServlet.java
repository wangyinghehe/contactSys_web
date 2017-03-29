package yumin.contactSys_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yumin.contactSys_web.dao.ContactDao;
import yumin.contactSys_web.dao.impl.ContactDaoImpl;

public class DeleteContactServlet extends HttpServlet {

	/**
	 *  删除联系人逻辑
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.接收id
		 String id = request.getParameter("id"); 
		// 2.调用dao删除联系人的方法
		 ContactDao dao = new ContactDaoImpl();
		 dao.deleteContact(id);
		    
         //3.跳转到主页面（查询联系人）
           response.sendRedirect(request.getContextPath()+"/ListContactServlet");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    doGet(request, response);
	}

}
