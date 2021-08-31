package com.hw.www.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类
 * 
 * @author LZ
 */

public final class PageUtil {

	public static void page(HttpServletRequest request, String url, Integer pageSize, List<?> list, Integer listCount,
			Integer page, Map<?, ?> searchMap) {
		// 给url之前加上项目名称
		url = request.getContextPath() + url;
		// 通过符合要求的总条数和页面显示数来计算总页数
		int pageCount = listCount / pageSize + (listCount % pageSize == 0 ? 0 : 1);

		// 判断url上是否有?号，如果有，后面通过&符号进行连接，否则通过?进行连接
		String flag = url.indexOf("?") != -1 ? "&" : "?";

		// 将查询条件拼接成字符串，如果查询的值为NULL或者空，不进行字符串拼接。
		String term = "";
		if (!searchMap.isEmpty()) {
			Set<?> set = searchMap.keySet();
			Iterator<?> iterator = set.iterator();
			while (iterator.hasNext()) {
				Object key = iterator.next();
				Object value = searchMap.get(key);
				System.out.println(value);
				if (value != null && !value.equals("")) {
					term += "&" + key + "=" + value;
				}
			}
		}

		// 分页的首页、上一页、下一页、末页
		String first = "";
		String prev = "";
		String next = "";
		String last = "";

		if (page != 1) {
			first = "<a href='" + url + flag + "page=1" + term + "'>首页</a>";
		} else {
			first = "首页";
		}

		if (page > 1) {
			prev = "<a href='" + url + flag + "page=" + (page - 1) + term + "'>上一页</a>";
		} else {
			prev = "上一页";
		}

		if (page < pageCount) {
			next = "<a href='" + url + flag + "page=" + (page + 1) + term + "'>下一页</a>";
		} else {
			next = "下一页";
		}

		if (page != pageCount) {
			last = "<a href='" + url + flag + "page=" + pageCount + term + "'>末页</a>";
		} else {
			last = "末页";
		}

		request.setAttribute("first", first); // 首页
		request.setAttribute("prev", prev); // 上一页
		request.setAttribute("next", next); // 下一页
		request.setAttribute("last", last); // 末页

		request.setAttribute("page", page); // 页码
		request.setAttribute("pageCount", pageCount); // 总页数
		request.setAttribute("listCount", listCount); // 总条数
		request.setAttribute("pageSize", pageSize); // 页面显示个数
		request.setAttribute("list", list); // 分页显示的集合
		request.setAttribute("map", searchMap);
	}
}
