package yumin.contactSys_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yumin.contactSys_web.dao.ContactDao;
import yumin.contactSys_web.dao.impl.ContactDaoImpl;
import yumin.contactSys_web.entity.Contact;

public class UpdateContactServlet extends HttpServlet {

	/**
	 * �޸���ϵ���߼�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	      	 String id = request.getParameter("id"); 
		//1.���ղ���
             String name = request.getParameter("name");
             String gender = request.getParameter("gender");
             String age = request.getParameter("age");
             String phone = request.getParameter("phone");
             String email = request.getParameter("email");
             String qq= request.getParameter("qq");
	    //��װ��Contact����
             Contact contact = new Contact();
             contact.setAge(Integer.parseInt(age));
             contact.setName(name);
             contact.setEmail(email);
             contact.setGender(gender);
             contact.setPhone(phone);
             contact.setQq(qq);
             
             contact.setId(id);
         //2.����Dao����޸���ϵ�˵ķ���
             ContactDao dao = new ContactDaoImpl();
             dao.updateContact(contact);
             
         //3.��ת����ҳ�棨��ѯ��ϵ�ˣ�
             response.sendRedirect(request.getContextPath()+"/ListContactServlet");
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
