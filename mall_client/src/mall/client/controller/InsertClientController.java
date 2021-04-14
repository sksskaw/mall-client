package mall.client.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mall.client.model.ClientDao;
import mall.client.vo.Client;

@WebServlet("/InsertClientController")
public class InsertClientController extends HttpServlet {
	
	private ClientDao clientDao;
	
	// mainMenu의 링크를 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginClient") != null) {
			response.sendRedirect(request.getContextPath()+"/IndexController");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/client/insertClient.jsp").forward(request, response);
	}
	
	// <form>의 Action을 통해 받을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.clientDao = new ClientDao();
		
		// 입력 form에서 받은 clientMail,clientPw 수집
		String clientMail = request.getParameter("clientMail");
		String clientPw = request.getParameter("clientPw");
		
		// 메일 중복처리 메소드 호출
		String returnClientMail = clientDao.selectClientMail(clientMail);
		// 메일 중복 시 콜솔 메시지 출력 후 회원가입 페이지로 이동
		if(returnClientMail != null) { // returnClientMail값이 있다면 중복된다는 소리!
			System.out.println("메일이 중복됩니다! 다른 메일을 사용해주세요");
			response.sendRedirect(request.getContextPath()+"/InsertClientController");
			return;
		}
		
		// 회원정보 client vo객체에 저장
		Client client = new Client();
		client.setClientMail(clientMail);
		client.setClientPw(clientPw);
		// insert 메소드 호출
		clientDao.insertClient(client);
		
		
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}

}
