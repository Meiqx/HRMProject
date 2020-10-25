package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import cn.tedu.entity.Job;
import cn.tedu.utils.DBUtils;
import cn.tedu.utils.DateUtils;

public class JobDao {

	/**
	 * 应聘人员信息查看
	 * @return
	 */
	public List<Job> getJob(){
		ArrayList<Job> list = new ArrayList<Job>();
		//获取连接
		try(Connection conn = DBUtils.getConn()){
			//创建查询语句
			String sql = "select id,name,sex,age,job,specialty,experience,studyeffort,school,tel,email,createtime,text,isstock from job";
			//创建执行sql语句对象
			Statement state = conn.createStatement();
			//调用executeQuery方法执行sql并把查询结果存入rs结果集
			ResultSet rs = state.executeQuery(sql);
			//遍历结果并存入job对象
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sex = rs.getInt(3);
				int age = rs.getInt(4);
				String job = rs.getString(5);//应聘职位
				String spe = rs.getString(6);//所学专业
				String exp = rs.getString(7);//工作经验
				String stu = rs.getString(8);//学历
				String school = rs.getString(9);//毕业学校
				String tel = rs.getString(10);//电话号码
				String email = rs.getString(11);//电子邮箱
				Date time = rs.getDate(12);//创建时间
				String content = rs.getString(13);//详情信息
				int iss = rs.getInt(14);//是否入库

				//将查询到的应聘人员信息放入Job 信息对象
				Job j = new Job(id,name,sex,age,job,spe,exp,stu,school,tel,email,time,content,iss);
				//将对象存入集合
				list.add(j);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 保存录入数据
	 * @param j
	 */
	public void save(Job j) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "insert into job values(0,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getName());
			ps.setInt(2, Integer.valueOf(j.getSex()));
			ps.setInt(3, j.getAge());
			ps.setString(4, j.getJob());
			ps.setString(5, j.getSpecialty());
			ps.setString(6, j.getExperience());
			ps.setString(7, j.getStudyeffort());
			ps.setString(8, j.getSchool());
			ps.setString(9,j.getTel());
			ps.setString(10, j.getEmail());
			ps.setDate(11,new DateUtils().changeDate(j.getCreatetime()));			
			ps.setString(12, j.getContent());
			ps.setInt(13, j.getIsstock());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 删除人员信息
	 * @param id
	 */
	public void delete(int id) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "delete from job where id="+id+"";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 获取要修改人员的信息
	 * @param id
	 * @return
	 */
	public Job editorQuery(int id) {
		Job j = null;
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select * from job where id="+id+"";
			Statement state = conn.createStatement();
			//调用executeQuery方法执行sql并把查询结果存入rs结果集
			ResultSet rs = state.executeQuery(sql);
			//遍历结果并存入job对象
			while(rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				int sex = rs.getInt(3);
				int age = rs.getInt(4);
				String job = rs.getString(5);//应聘职位
				String spe = rs.getString(6);//所学专业
				String exp = rs.getString(7);//工作经验
				String stu = rs.getString(8);//学历
				String school = rs.getString(9);//毕业学校
				String tel = rs.getString(10);//电话号码
				String email = rs.getString(11);//电子邮箱
				Date time = rs.getDate(12);//创建时间
				String content = rs.getString(13);//详情信息
				int iss = rs.getInt(14);//是否入库


				//将查询到的应聘人员信息放入Job 信息对象			
				j = new Job(id1,name,sex,age,job,spe,exp,stu,school,tel,email,time,content,iss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}
	/**
	 * 修改人员信息
	 * @param j
	 */
	public void jobEditorUpdate(Job j) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "update job set name=?,age=?,sex=?,job=?,specialty=?,experience=?,studyeffort=?,school=?,tel=?,email=?,createtime=?,text=?,isstock=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getName());
			ps.setInt(2, j.getAge());
			ps.setInt(3,Integer.valueOf(j.getSex()));
			ps.setString(4, j.getJob());
			ps.setString(5, j.getSpecialty());
			ps.setString(6, j.getExperience());
			ps.setString(7, j.getStudyeffort());
			ps.setString(8, j.getSchool());
			ps.setString(9,j.getTel());
			ps.setString(10, j.getEmail());
			new DateUtils();
			ps.setDate(11,DateUtils.changeDate(j.getCreatetime()));			
			ps.setString(12, j.getContent());
			ps.setInt(13, j.getIsstock());
			ps.setInt(14, j.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取入库人员信息
	 * @return
	 */
	public List<Job> getTalentPool() {
		ArrayList<Job> list = new ArrayList<Job>();		
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select * from job where isstock=1";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sex = rs.getInt(3);
				int age = rs.getInt(4);
				String job = rs.getString(5);//应聘职位
				String spe = rs.getString(6);//所学专业
				String exp = rs.getString(7);//工作经验
				String stu = rs.getString(8);//学历
				String school = rs.getString(9);//毕业学校
				String tel = rs.getString(10);//电话号码
				String email = rs.getString(11);//电子邮箱
				Date time = rs.getDate(12);//创建时间
				String content = rs.getString(13);//详情信息
				int iss = rs.getInt(14);//是否入库

				//将查询到的应聘人员信息放入Job 信息对象
				Job j = new Job(id,name,sex,age,job,spe,exp,stu,school,tel,email,time,content,iss);
				System.out.println(j);
				list.add(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 将人员添加到人才库
	 * @param id
	 */
	public void inPool(int id) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "update job set isstock=1 where id="+id+"";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 将应聘人员移除人才库
	 * @param id
	 */
	public void outPool(int id) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "update job set isstock=0 where id="+id+"";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





}


