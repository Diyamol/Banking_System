package com.grpG.Controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grpG.Dao.PublisherDaoClass_groupG;
import com.grpG.Model.PublisherClass_GroupG;

/**
 * 
 * @author diyaa 
 *
 */
@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherDaoClass_groupG pubdao;

	public void init() {
		pubdao = new PublisherDaoClass_groupG();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("publisher");
		try {
			if (action != null) {
				switch (action) {
				case "Add":
					insertPublisher(request, response);
					break;
				case "Update":
					updatePublisher(request, response);
					break;
				case "Delete":
					deletePublisher(request, response);
					break;
				}
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Publisher.jsp");
	}

	/**
	 * delete publisher method
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void deletePublisher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_pub_id_del");
		int pub_id = Integer.parseInt(id);
		PublisherClass_GroupG pb = new PublisherClass_GroupG(pub_id);
		pb.setPub_id(pub_id);
		pubdao.deletePublisher(pb);
	}
	/**
	 * update publisher method
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void updatePublisher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_pub_id");
		int pub_id = Integer.parseInt(id);
		String name = request.getParameter("txt_pub_name");
		String address = request.getParameter("txt_pub_address");
		PublisherClass_GroupG pb = new PublisherClass_GroupG(pub_id, name, address);
		pb.setPub_id(pub_id);
		pb.setName(name);
		pb.setAddress(address);
		pubdao.updatePublisher(pb);
	}

	/**
	 * insert publisher method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void insertPublisher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_pub_id");
		int pub_id = Integer.parseInt(id);
		String name = request.getParameter("txt_pub_name");
		String address = request.getParameter("txt_pub_address");
		PublisherClass_GroupG pb = new PublisherClass_GroupG(pub_id, name, address);
		pb.setPub_id(pub_id);
		pb.setName(name);
		pb.setAddress(address);
		pubdao.addPublisher(pb);
	}

}
