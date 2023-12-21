package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.WIshlist;
import com.util.Projectutil;

public class WishlistDao {
	public static void AddToWishlist(WIshlist w)
	{
		try {
			Connection conn=Projectutil.createConnection();
			String sql="insert into wishlist(pid,uid)value(?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<WIshlist> getWishlistByUser(int uid)
	{
		List<WIshlist> list=new ArrayList<WIshlist>();
		try {
			Connection conn=Projectutil.createConnection();
			String sql="select * from wishlist where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				WIshlist w=new WIshlist();
				w.setWid(rs.getInt("wid"));
				w.setPid(rs.getInt("pid"));
				w.setUid(rs.getInt("uid"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static boolean  CheckWishlist(int uid,int pid)
	{
		boolean wishlist_flag=false;
		try {
			Connection conn=Projectutil.createConnection();
			String sql="select * from wishlist where uid=? and pid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.setInt(2, pid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				wishlist_flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wishlist_flag;
	}
	public static void RemoveFromWishlist(WIshlist w)
	{
		try {
			Connection conn=Projectutil.createConnection();
			String sql="delete from wishlist where pid=? and uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
