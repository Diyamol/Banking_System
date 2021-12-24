package com.grpG.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grpG.Dao.MemberDaoClass_groupG;
import com.grpG.Model.MemberClass_GroupG;

/**
 * 
 * @author diyaa bhavya nithin pardeep
 *
 */

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDaoClass_groupG memdao;

	public void init() {
		memdao = new MemberDaoClass_groupG();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("member");
		try {
			if (action != null) {
				switch (action) {
				case "Add":
					insertMember(request, response);
					break;
				case "Update":
					updateMember(request, response);
					break;
				case "Delete":
					deleteMember(request, response);
					break;
				}
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Member.jsp");
	}

	/**
	 * deleteMember method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void deleteMember(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_mem_Id_del");
		int memb_id = Integer.parseInt(id);
		MemberClass_GroupG mb = new MemberClass_GroupG(memb_id);
		mb.setMemb_id(memb_id);
		memdao.deleteMember(mb);
	}
	/**
	 * update member method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	private void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException, ParseException {
		String id = request.getParameter("txt_mem_Id");
		int memb_id = Integer.parseInt(id);
		String name = request.getParameter("txt_mem_name");
		String address = request.getParameter("txt_mem_address");
		String memb_type = request.getParameter("mem_type");
		String m_date = (request.getParameter("txt_mem_date"));
		Date memb_date = Date.valueOf(m_date);
		String e_date = (request.getParameter("txt_mem_exp_date"));
		Date expiry_date = Date.valueOf(e_date);
		MemberClass_GroupG mb = new MemberClass_GroupG(memb_id, name, address, memb_type, memb_date, expiry_date);
		mb.setMemb_id(memb_id);
		mb.setName(name);
		mb.setAddress(address);
		mb.setMemb_type(memb_type);
		mb.setMemb_date(memb_date);
		mb.setExpiry_date(expiry_date);
		memdao.updateMember(mb);
	}
	private void insertMember(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		/**
		 * insert member method
		 */
		String id = request.getParameter("txt_mem_Id");
		int memb_id = Integer.parseInt(id);
		String name = request.getParameter("txt_mem_name");
		String address = request.getParameter("txt_mem_address");
		String memb_type = request.getParameter("mem_type");
		String m_date = (request.getParameter("txt_mem_date"));
		Date memb_date = Date.valueOf(m_date);
		String e_date = (request.getParameter("txt_mem_exp_date"));
		Date expiry_date = Date.valueOf(e_date);
		MemberClass_GroupG mb = new MemberClass_GroupG(memb_id, name, address, memb_type, memb_date, expiry_date);
		mb.setMemb_id(memb_id);
		mb.setName(name);
		mb.setAddress(address);
		mb.setMemb_type(memb_type);
		mb.setMemb_date(memb_date);
		mb.setExpiry_date(expiry_date);
		memdao.addMember(mb);
	}
}
