package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.tedu.entity.Users;
import cn.tedu.entity.Y_Educate;
import cn.tedu.utils.DBUtils;
import cn.tedu.utils.DateUtils;

/**
 * 
 * 培训操作
 * 
 * @author JAVA
 *
 */
public class TraingDao {

	/**
	 * 培训录入操作
	 * @param student 
	 * @param teacher 
	 * @param datum 
	 * @param endtime 
	 * @param begintime 
	 * @param purpose 
	 * @param name 
	 */
	public void Training(String name, String purpose, String begintime, String endtime, String datum, String teacher, String student) {
		/*
		 * System.out.println("进入TraingDao"); System.out.println("培训名称："+name);
		 * System.out.println("培训目的："+purpose); System.out.println("培训开始时间："+begintime);
		 * System.out.println("培训结束时间："+endtime); System.out.println("培训材料："+datum);
		 * System.out.println("培训讲师："+teacher); System.out.println("培训人员："+student);
		 */


		try (Connection conn = DBUtils.getConn()) {
			String sql = "insert into educatey values(null,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);//培训名称
			ps.setString(2, purpose);//培训目的
			ps.setString(3,  begintime); //培训开始时间
			ps.setString(4,  endtime);//培训结束时间
			ps.setString(5, datum);//培训材料
			ps.setString(6, teacher);//培训讲师
			ps.setString(7, student);//培训人员
			ps.setString(8, DateUtils.getStringDate(new Date()));//创建时间
			ps.setInt(9, 0);//是否培训完成
			ps.setString(10, "无");//培训效果
			ps.setString(11, "无");//培训总结

			ps.executeUpdate(); 

		} catch (Exception e) {
			System.out.println("培训录入插入   报错了");
			e.printStackTrace();
		}
	}




	/**
	 * 培训录入-人员 选填
	 * @return
	 */
	public List<Users> getEname() {
		ArrayList<Users> list = new ArrayList<>();
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select username from user";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				/* System.out.println(name); */
				list.add(new Users(name));
			}
		} catch (Exception e) {
			System.out.println("TraingDao-getEname 报错了");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 培训查看方法
	 * @return
	 */
	public List<Y_Educate> getTts(int i) {
		ArrayList<Y_Educate> list = new ArrayList<>();

		try (Connection conn = DBUtils.getConn()) {
			String sql = "select name,teacher,student,begintime,endtime,id from educatey where educate = "+i;

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				String teacher = rs.getString(2);
				String student = rs.getString(3);
				Date begintime = rs.getDate(4);
				Date endtime = rs.getDate(5);
				Integer id = rs.getInt(6);

				/*
				 * System.out.println("培训名称："+name); System.out.println("讲师："+teacher);
				 * System.out.println("人员："+student); System.out.println("开始时间："+begintime);
				 * System.out.println("结束时间："+endtime);
				 */

				list.add(new Y_Educate(name,teacher,student,begintime,endtime,id));
			}
		} catch (Exception e) {
			System.out.println("培训查看方法：getTts 报错了");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 培训详细
	 * @param id
	 * @return
	 */
	public List<Y_Educate> getInDetailsl(Integer id) {
		ArrayList<Y_Educate> list = new ArrayList<>();

		try (Connection conn = DBUtils.getConn()) {
			String sql = "select * from educatey where id = "+id;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("name");//培训名称
				String purpose = rs.getString("purpose");//培训目的
				Date begintime = rs.getDate("begintime");//培训开始时间
				Date endtime = rs.getDate("endtime");//培训结束时间
				String datum = rs.getString("datum");//培训材料
				String teacher = rs.getString("teacher");//培训讲师
				String student = rs.getString("student");//培训人员
				int ID = rs.getInt("id");//培训编号
				String effect = rs.getString("effect");//培训效果
				String summarize = rs.getString("summarize");//培训总结
				
				System.out.println("培训效果查找："+effect);
				System.out.println("培训总结查找："+summarize);
				/*
				 * System.out.println("培训名称："+name); System.out.println("讲师："+teacher);
				 * System.out.println("人员："+student); System.out.println("开始时间："+begintime);
				 * System.out.println("结束时间："+endtime);
				 */

				list.add(new Y_Educate(name, purpose, begintime, endtime, datum, teacher, student,ID,effect,summarize));
			}
		} catch (Exception e) {
			System.out.println("培训详细：getInDetailsl 报错了");
			e.printStackTrace();
			return null;
		}
		return list;
	}




	/**
	 * 培训-删除
	 * @param id
	 */
	public void setDeletid(Integer id) {

		try (Connection conn = DBUtils.getConn()) {
			String sql = "delete from educatey where id = "+id;
			Statement s = conn.createStatement();
			s.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("培训删除：serDeletid 报错");
			e.printStackTrace();
		}

	}


	
	
	/**
	 * 培训-保存
	 * @param summarize 
	 * @param effect 
	 * @param id 
	 * @return
	 */
	public void setToSave(String effect, String summarize, Integer id) {
		try (Connection conn = DBUtils.getConn()) {
			String sql = "update educatey set effect = ?,summarize = ?,educate = 1 where id = "+id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, effect);
			ps.setString(2, summarize);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("培训保存  setToSave 报错了");
			e.printStackTrace();
		}
	}







	
	




























}
