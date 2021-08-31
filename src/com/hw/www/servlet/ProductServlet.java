package com.hw.www.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hw.www.bean.Hz;
import com.hw.www.bean.Product;
import com.hw.www.bean.Sales;
import com.hw.www.service.ProductService;
import com.hw.www.service.imp.ProductServiceImp;
import com.hw.www.util.PageUtil;

@WebServlet("/pro")
public class ProductServlet extends HttpServlet {
	ProductService productServiceImp = new ProductServiceImp();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("find")) {
				find(request, response);
			} else if (action.equals("getsel")) {
				getsel(request, response);
			} else if (action.equals("save")) {
				save(request, response);
			} else if (action.equals("getpname")) {
				getpname(request, response);
			} else if (action.equals("del")) {
				del(request, response);
			} else if (action.equals("getform")) {
				getform(request, response);
			} else if (action.equals("findAllSales")) {
				findAllSales(request, response);
			} else if (action.equals("saveSales")) {
				saveSales(request, response);
			}
		}
	}

	// 添加月销售量数据
	private void saveSales(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		String saledate = request.getParameter("saledate");
		String price = request.getParameter("price");
		String num = request.getParameter("num");
		Map<Object, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("saledate", saledate);
		map.put("price", price);
		map.put("num", num);
		int i = productServiceImp.saveSales(map);
		response.getWriter().print(i);

	}

	// 获取销售表数据
	private void findAllSales(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		Map<Object, Object> map = new HashMap<>();
		map.put("pid", pid);
		String string = "/pro?action=findAllSales";
		int pagesize = 3;
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		PageHelper.startPage(page, pagesize);
		List list = productServiceImp.findAllSales(map);
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		List<Product> list2 = pageInfo.getList();
		int total = Integer.parseInt(pageInfo.getTotal() + "");
		PageUtil.page(request, string, pagesize, list2, total, page, map);
		List<Sales> list1 = productServiceImp.fingHz(map);
		Sales sal = new Sales();
		for (Sales sales : list1) {
			sal.setCountnum(sales.getCountnum());
			sal.setAvgprice(sales.getAvgprice());
			sal.setMsr(sales.getMsr());
			sal.setZcost(sales.getZcost());
			sal.setLr(sales.getLr());
		}
		request.setAttribute("hz", sal);
		request.getRequestDispatcher("xq.jsp").forward(request, response);
	}

	// 回显表单数据
	private void getform(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		Map<Object, Object> map = new HashMap<>();
		map.put("pid", pid);
		Product product = productServiceImp.getform(map);
		response.getWriter().print(JSON.toJSONString(product));
	}

	// 删除
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		Map<Object, Object> map = new HashMap<>();
		map.put("pid", pid);
		int i = productServiceImp.del(map);
		response.getWriter().print(i);
	}

	// 正则校验
	private void getpname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean res = true;
		String pname = request.getParameter("pname");
		Map<Object, Object> map = new HashMap<>();
		map.put("pname", pname);
		Product product = productServiceImp.getpname(map);
		if (product != null) {
			res = false;
		}
		String json = JSON.toJSONString(res);
		response.getWriter().print(json);
	}

	// 添加
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
		String xid = request.getParameter("xid");
		String cost = request.getParameter("cost");
		String startdate = request.getParameter("startdate");
		Map<Object, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("xid", xid);
		map.put("cost", cost);
		map.put("startdate", startdate);
		int i = productServiceImp.save(map);
		response.getWriter().print(i);
	}

	// 查找产品线下拉框
	private void getsel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List list = productServiceImp.getsel();
		String json = JSON.toJSONString(list);
		response.getWriter().print(json);
	}

	// 列表
	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		Map<Object, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("min", min);
		map.put("max", max);
		String string = "/pro?action=find";
		int pagesize = 3;
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		PageHelper.startPage(page, pagesize);
		List<Product> list = productServiceImp.find(map);
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		List<Product> list2 = pageInfo.getList();
		int total = Integer.parseInt(pageInfo.getTotal() + "");
		PageUtil.page(request, string, pagesize, list2, total, page, map);
		List<Hz> list1 = productServiceImp.gethz();
		Hz hzs = new Hz();
		for (Hz hz : list1) {
			hzs.setAvgcost(hz.getAvgcost());
			hzs.setAvgmonth(hz.getAvgmonth());
			hzs.setCot(hz.getCot());
		}
		request.setAttribute("ps", hzs);
		request.setAttribute("map", map);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
