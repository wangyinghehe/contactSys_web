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

public class AddContactServlet extends HttpServlet {

	/**
	 * 添加联系人逻辑
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.接收参数
             String name = request.getParameter("name");
             String gender = request.getParameter("gender");
             String age = request.getParameter("age");
             String phone = request.getParameter("phone");
             String email = request.getParameter("email");
             String qq= request.getParameter("qq");
	    //封装成Contact对象
             Contact contact = new Contact();
             contact.setAge(Integer.parseInt(age));
             contact.setName(name);
             contact.setEmail(email);
             contact.setGender(gender);
             contact.setPhone(phone);
             contact.setQq(qq);
         //2.调用Dao类的添加联系人的方法
             ContactDao dao = new ContactDaoImpl();
             dao.addContact(contact);
         //3.跳转到主页面（查询联系人）
             response.sendRedirect(request.getContextPath()+"/ListContactServlet");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                doGet(request, response);
	}

}
