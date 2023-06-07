package test_server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList.DropLocation;

import java.sql.Connection;
public class TestDao_JDBC {
	//JDBC JAVA DATABASE CONNECTION
	//1、引入jar包，mysql连接包
	
	public List<Student> search(){
//		创建了一个存储Student对象的可变大小列表。你可以向该列表中添加、删除和访问Student对象，并使用列表提供的方法对其进行操作
		List<Student> list=new ArrayList<Student>();

		try {//2、利用反射，加载数据库驱动到内存
			Class.forName("com.mysql.jdbc.Driver");
			//3、建立连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot23?characterEncoding=UTF-8","root","123456");
			//4、生成SQL执行器（statement）
			Statement stat=conn.createStatement();
			//5、进行SQL
			ResultSet rs=stat.executeQuery("select * from student");
			//rs拿到的是一个结果集，rs指向第一行的前一个空值，所以需要利用.next不停的挪移到下面的一行，再进行操作
			//6、处理结果
			while(rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
//				System.out.println(stu.getId());
			}
//			// 增删改全部用update，它返回的是int类型的
//			int rs2=stat.executeUpdate("insert into student(name,gender,age) values ('123','男',12)");
//			if (rs2>0) {
//				System.out.print("保存成功");
//			}else {
//				System.out.print("保存失败");
//			}
			//7、关闭连接释放资源
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	return list;
	}
	public static boolean add(Student stu) {
		int rs = 0;
		try {//2、利用反射，加载数据库驱动到内存
			Class.forName("com.mysql.jdbc.Driver");
			//3、建立连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot23?characterEncoding=UTF-8","root","123456");
			//4、生成SQL执行器（statement）
			Statement stat=conn.createStatement();
			//5、进行SQL
			
			// 增删改全部用update，它返回的是int类型的
			rs=stat.executeUpdate("insert into student(name,gender,age) values ('"+stu.getName()+"','"+stu.getGender()+"',"+stu.getAge()+")");
			
			//7、关闭连接释放资源
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs > 0;
		
	}
	
	public static boolean delete(int id) {
		int rs = 0;
		try {//2、利用反射，加载数据库驱动到内存
			Class.forName("com.mysql.jdbc.Driver");
			//3、建立连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot23?characterEncoding=UTF-8","root","123456");
			//4、生成SQL执行器（statement）
			Statement stat=conn.createStatement();
			//5、进行SQL
			
			// 增删改全部用update，它返回的是int类型的
			rs=stat.executeUpdate("DELETE FROM student WHERE id = "+id);
			
			//7、关闭连接释放资源
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs > 0;
		// TODO 自动生成的方法存根
		
	}
	public static Boolean Up(Student stu) {
		int rs = 0;
		try {//2、利用反射，加载数据库驱动到内存
			Class.forName("com.mysql.jdbc.Driver");
			//3、建立连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot23?characterEncoding=UTF-8","root","123456");
			//4、生成SQL执行器（statement）
			Statement stat=conn.createStatement();
			//5、进行SQL
			
			// 增删改全部用update，它返回的是int类型的
			rs = stat.executeUpdate("UPDATE student SET name = '" + stu.getName() + "', gender = '" + stu.getGender() + "', age = " + stu.getAge() + " WHERE `id` = " + stu.getId());

			
			//7、关闭连接释放资源
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs > 0;
		// TODO 自动生成的方法存根
	}
	

}
