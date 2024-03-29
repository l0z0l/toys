package com.itlamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;

/**
 * 根据工作单位查詢
 * 
 * @author Fatyu
 * 
 */
public class QueryByCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public QueryByCompanyServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");// 设置字符集编码
		String company = request.getParameter("company");// 获取工作单位
		company = new String(company.getBytes("iso-8859-1"), "gbk");// 字符转换
		PersonDao pd = new PersonDaoImpl();
		List list = null;
		String sql = "select * from dhcx_ryxx where  company=\'" + company
				+ "\' order by company,department";
		list = pd.queryPerson(sql);
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/admin/phoneManage/listPerson.jsp");
		dispatcher.forward(request, response);
	}

	public void init() throws ServletException {
	}

}
