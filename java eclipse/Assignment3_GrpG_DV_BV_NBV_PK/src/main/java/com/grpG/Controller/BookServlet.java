package com.grpG.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grpG.Dao.BookDaoClass_groupG;
import com.grpG.Model.BookClass_GroupG;
import com.grpG.Model.BorrowDetailsClass_GroupG;

/**
 * 
 * @author diyaa bhavya nithin pardeep
 *
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDaoClass_groupG bookdao;

	public void init() {
		bookdao = new BookDaoClass_groupG();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("book");
		try {
			if (action != null) {
				switch (action) {
				case "Add":
					insertBook(request, response);
					break;
				case "Update":
					updateBook(request, response);
					break;
				case "Delete":
					deleteBook(request, response);
					break;
				case "Issue":
					issueBook(request, response);
					break;
				default:
					allBooksissued(request, response);
					break;
				}

			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Book.jsp");
	}

	/**
	 * issue book method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void issueBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_issue_book_id");
		int bookId = Integer.parseInt(id);
		String m_id = request.getParameter("txt_issue_memb_id");
		int memb_Id = Integer.parseInt(m_id);
		String issue = request.getParameter("txt_issued_by");
		String d_date = request.getParameter("txt_due_date");
		Date due_date = Date.valueOf(d_date);
		String r_date = request.getParameter("txt_return_date");
		Date return_date = Date.valueOf(r_date);
		BorrowDetailsClass_GroupG bd = new BorrowDetailsClass_GroupG(bookId, memb_Id, issue, due_date, return_date);
		bd.setBookId(bookId);
		bd.setMemb_Id(memb_Id);
		bd.setIssue(issue);
		bd.setDue_date(due_date);
		bd.setReturn_date(return_date);
		bookdao.issueBook(bd);

	}

	/**
	 * delete book method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_book_id_del");
		int book_id = Integer.parseInt(id);
		BookClass_GroupG bk = new BookClass_GroupG(book_id);
		bk.setBookId(book_id);
		bookdao.deleteBook(bk);
	}
	/**
	 * update book method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_book_id");
		int bookId = Integer.parseInt(id);
		String title = request.getParameter("txt_book_title");
		Double price = Double.parseDouble(request.getParameter("txt_price"));
		String Available = request.getParameter("availability");
		String Author = request.getParameter("txt_author");
		BookClass_GroupG bk = new BookClass_GroupG(bookId, title, price, Available, Author);
		bk.setBookId(bookId);
		bk.setTitle(title);
		bk.setPrice(price);
		bk.setAvailable(Available);
		bk.setAuthor(Author);
		bookdao.updateBook(bk);
	}

	/**
	 * insert book method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		String id = request.getParameter("txt_book_id");
		int bookId = Integer.parseInt(id);
		String title = request.getParameter("txt_book_title");
		Double price = Double.parseDouble(request.getParameter("txt_price"));
		String Available = request.getParameter("availability");
		String Author = request.getParameter("txt_author");
		BookClass_GroupG bk = new BookClass_GroupG(bookId, title, price, Available, Author);
		bk.setBookId(bookId);
		bk.setTitle(title);
		bk.setPrice(price);
		bk.setAvailable(Available);
		bk.setAuthor(Author);
		bookdao.addBook(bk);
	}

	/**
	 * view all issued books method
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws ClassNotFoundException
	 */
	private void allBooksissued(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<BorrowDetailsClass_GroupG> allBooksissued = bookdao.selectAllIssuedBooks();
		// request.setAttribute(("allBooksissued"), allBooksissued);
		HttpSession session = request.getSession();
		session.setAttribute(("allBooksissued"), allBooksissued);

		response.sendRedirect("Borrow.jsp");
		// RequestDispatcher dispatcher=request.getRequestDispatcher("Borrow.jsp");
		// dispatcher.forward(request, response);
	}
}
