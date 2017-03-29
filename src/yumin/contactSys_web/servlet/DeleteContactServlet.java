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
	 *  ɾ����ϵ���߼�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.����id
		 String id = request.getParameter("id"); 
		// 2.����daoɾ����ϵ�˵ķ���
		 ContactDao dao = new ContactDaoImpl();
		 dao.deleteContact(id);
		    
         //3.��ת����ҳ�棨��ѯ��ϵ�ˣ�
           response.sendRedirect(request.getContextPath()+"/ListContactServlet");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    doGet(request, response);
	}

}
