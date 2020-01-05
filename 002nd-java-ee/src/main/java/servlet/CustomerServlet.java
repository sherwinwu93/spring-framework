package servlet;

import org.apache.commons.beanutils.BeanUtils;
import po.Customer;
import service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CustomerServlet extends HttpServlet {
	private CustomerService customerService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			Map<String, String[]> parameterMap = request.getParameterMap();

			Customer customer = new Customer();
			BeanUtils.populate(customer, parameterMap);

			customerService.addCustomer(customer);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("添加成功");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
