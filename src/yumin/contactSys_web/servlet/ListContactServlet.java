package yumin.contactSys_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yumin.contactSys_web.dao.ContactDao;
import yumin.contactSys_web.dao.impl.ContactDaoImpl;
import yumin.contactSys_web.entity.Contact;

public class ListContactServlet extends HttpServlet {

	/**
	 * ��ʾ������ϵ�˵��߼�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      //1.��xml�ж�ȡ��ϵ������
		ContactDao dao = new ContactDaoImpl();
		List<Contact> list = dao.findAll();
		
		//2.��ʾ�������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer= response.getWriter();
		
		String html= "";
		html+="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html+="<html xmlns='http://www.w3.org/1999/xhtml'>";
		html+="<head>";
		html+="<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html+="<title>��ѯ������ϵ��</title>";
		html+="<style type='text/css'>";
		html+="   /*���־���*/";
		html+="  table td{";
		html+="	   text-align:center;";
		html+="	   }";
		html+="   /*�ϲ����߿�*/ ";
		html+="	table{";
		html+="		border-collapse:collapse;";
		html+="		}	   ";
		html+="</style>";
		html+="</head>";
		html+="<body>";
		html+="<center><h3>��ҳ�棺������ϵ����Ϣ--�ڶ���:(html,servlet)+dao+xml</h3></center>";
		html+="<table align='center' border='1' width='900px'>";
		html+="  <tr>";
		html+="    <th>���</th>";
		html+="    <th>����</th>";
		html+="    <th>�Ա�</th>";
		html+="    <th>����</th>";
		html+="    <th>�绰</th>";
		html+="    <th>����</th>";
		html+="   <th>QQ</th>";
		html+="    <th>����</th>";
		html+="  </tr>";
		if(list!=null){
			for (Contact contact : list) {
				html+=" <tr>";
		     	html+="   <td>"+contact.getId()+"</td>";
			    html+="    <td>"+contact.getName()+"</td>";
		    	html+="    <td>"+contact.getGender()+"</td>";
		    	html+="   <td>"+contact.getAge()+"</td>";
			    html+="  <td>"+contact.getPhone()+"</td>";
			    html+="  <td>"+contact.getEmail()+"</td>";
			    html+="   <td>"+contact.getQq()+"</td>";
	            html+="   <td><a href='"+request.getContextPath()+"/QueryContactServlet?id="+contact.getId()+"'>�޸�</a>&nbsp;<a href='"+request.getContextPath()+"/DeleteContactServlet?id="+contact.getId()+"'>ɾ��</a></td>";
			    html+=" </tr>";
			}
			
		}
	
		  html+="</tr>";
		  html+="<tr><td colspan='8' align='center'><a href='"+request.getContextPath()+"/addContact.html'>[�����ϵ��]</a></td>";
		  html+=" </tr>";
		  html+="</table>";
		  html+="</body>";
		  html+="</html>";
	   	 writer.write(html);
     }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       doGet(request, response);
	}

}
