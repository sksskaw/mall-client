package mall.client.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mall.client.model.CartDao;
import mall.client.vo.Client;

@WebServlet("/CartListController")
public class CartListController extends HttpServlet {

	private CartDao cartDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�α��� �˻�
		HttpSession session = request.getSession();
		if(session.getAttribute("loginClient") == null) { //�α��� ������ ������ IndexController�� �̵�
			response.sendRedirect(request.getContextPath()+"/IndexController");
			return;
		}
		
		// ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// ���ǿ� �ִ� �α�������(clientMail)�� ���´�.
		// �޼ҵ� ���� ����ϴ� �Ű������� �Ѱ��ֱ� ���� �ʿ��� ���� �����´�.
		Client client = new Client();
		client = (Client)session.getAttribute("loginClient");
		String clientMail = client.getClientMail();
		
		
		// dao ȣ��
		cartDao = new CartDao();
		List<Map<String, Object>> cartList = cartDao.selectCartList(clientMail);
		
		request.setAttribute("cartList", cartList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cart/cartList.jsp");
		rd.forward(request, response);
		
	}

}
