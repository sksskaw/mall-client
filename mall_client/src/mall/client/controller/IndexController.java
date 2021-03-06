package mall.client.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.client.model.EbookDao;
import mall.client.vo.Ebook;


@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private EbookDao ebookDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 분석
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 15;
		int beginRow = (currentPage-1)*rowPerPage;
		
		// model
		this.ebookDao = new EbookDao();
		List<Ebook> ebookList = this.ebookDao.selectEbookListByPage(beginRow, rowPerPage);
		
		// View forward
		request.setAttribute("ebookList", ebookList); // request객체에 ebookList 정보 넣어주기
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		rd.forward(request, response);
	}

}