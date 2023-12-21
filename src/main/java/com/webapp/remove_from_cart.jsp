<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.WIshlist"%>
<% 
	Cart c=new Cart();
	c.setPid(Integer.parseInt(request.getParameter("pid")));
	c.setUid(Integer.parseInt(request.getParameter("uid")));
	CartDao.RemoveFromCart(c );
	List<Cart> list=CartDao.getCartByUser(c.getUid());
	session.setAttribute("cart_count", list.size()); 
	response.sendRedirect("cart.jsp");


%>