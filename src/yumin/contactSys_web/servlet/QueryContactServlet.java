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

public class QueryContactServlet extends HttpServlet {

	/**
	 * �޸�ǰ��ѯ��ϵ���߼�
	 *
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //1.����id
		String id = request.getParameter("id");
		    //2.����dao������id��ѯ��ϵ�˵ķ���
		ContactDao  dao = new ContactDaoImpl();
		Contact contact = dao.findById(id); 
		
		
		 // 3.����ϵ����ʾ���������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String html = " ";
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html += "<title>�޸���ϵ��</title>";
		html += "</head>";
		html += "";
		html += "<body>";
		html += "<h3 align='center'>�޸���ϵ��</h3>";
		html += "<form action='"+request.getContextPath()+"/UpdateContactServlet' method='post' id='2'>";
		// ���������
		html += "<tr><input type='hidden' name='id' value='"+contact.getId()+"' </tr>";
	
		html += "<table align='center' border='1' width='229'>";	
		html += "<tr>";
		html += " <th>����</th>";
		html += " <td><input type='text' name='name' value='"+contact.getName()+"'/></td>";
		html += " </tr>";
		html += "  <tr>";
		html += " <th>�Ա�</th>";
		if("��".equals(contact.getGender())){
			html += " <td><input type='radio' name='gender' value='��' checked='checked'/>��";
			html += "        <input type='radio' name='gender' value='Ů' />Ů";
			html += " </td>";
		}else{
			html += " <td><input type='radio' name='gender' value='��' />��";
			html += "        <input type='radio' name='gender' value='Ů' checked='checked'/>Ů";
			html += " </td>";
		}
	
		html += " </tr>";
		html += "  <tr>";
		html += " <th>����</th>";
		html += " <td><input type='text' name='age' value='"+contact.getAge()+"' /></td>";
		html += " </tr>";
		html += "  <tr>";
		html += " <th>�绰</th>";
		html += " <td><input type='text' name='phone'  value='"+contact.getPhone()+"'/></td>";
		html += " </tr>";
		html += "  <tr>";
		html += " <th>����</th>";
		html += " <td><input type='text' name='email'  value='"+contact.getEmail()+"'/></td>";
		html += " </tr>";
		html += "  <tr>";
		html += " <th>QQ</th>";
		html += " <td><input type='text' name='qq'  value='"+contact.getQq()+"'/></td>";
		html += " </tr>";
		html += "  <tr>";
		html += "   <td colspan='2' align='center'>";
		html += "      <input type='submit'  value='����'/> ";
		html += "       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		html += "      <input type='reset'  value='����'/>";
		html += "   </td>";
		html += " </tr>";
		html += "</table>";
		html += "</form>";
		html += "</body>";
		html += "</html>";

		writer.write(html);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               doGet(request, response);
 
	}

}
