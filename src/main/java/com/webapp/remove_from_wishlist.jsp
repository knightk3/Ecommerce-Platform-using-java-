<%@page import="java.util.List"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.WIshlist"%>
<% 
	WIshlist w=new WIshlist();
	w.setPid(Integer.parseInt(request.getParameter("pid")));
	w.setUid(Integer.parseInt(request.getParameter("uid")));
	WishlistDao.RemoveFromWishlist(w);
	List<WIshlist> list=WishlistDao.getWishlistByUser(w.getUid());
	session.setAttribute("wishlist_count", list.size()); 
	response.sendRedirect("wishlist.jsp");


%>