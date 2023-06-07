package test_server;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servlet是核心中央区域，当tomcat监听到请求并打包成request后就会传到这里来，servlet负责建立出来JDBC对象
 * 调用JDBC中方法与数据库取得联系并且让JDBC返回所需要的对象，例如这里的一个student对象的列表，每一个元素都是数据库中的一行
 * 获取了JDBC的返回对象后，在servlet中也创建一个相同的对象来进行接受，最后，把这个结果传送给JSP即java server page，最后forward给客户端
 * 
 * @author 26337
 *
 */
@WebServlet(urlPatterns = {"/"})
public class TestController extends HttpServlet{
//利用路由的观念，当浏览器发送request，且携带test信息，tomcat监听并调用该doget方法，处理请求，并执行方法内代码
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		String type=request.getParameter("type");
		TestDao_JDBC jdbc=new TestDao_JDBC();
		try {
			if (type==null){
			
		
			List<Student> list=jdbc.search();
			request.setAttribute("student",list);
			request.getRequestDispatcher("WEB-INF/show.jsp").forward(request, response);
//			调用request访问jsp并且利用forward转发给客户端
			}
			else if(type.equals("showAdd")) {
				
				request.getRequestDispatcher("WEB-INF/add.jsp").forward(request, response);
			}
			else if(type.equals("showDel")) {
				
				request.getRequestDispatcher("WEB-INF/delete.jsp").forward(request, response);
			}
			else if(type.equals("showUp")) {
				
				request.getRequestDispatcher("WEB-INF/update_data.jsp").forward(request, response);
			}
			else if(type.equals("add")){
				String name=request.getParameter("name");
				String gender=request.getParameter("gender");
				int age=Integer.parseInt(request.getParameter("age"));
				Student stu=new Student();
				stu.setAge(age);
				stu.setGender(gender);
				stu.setName(name);
				Boolean flag= TestDao_JDBC.add(stu);
				if(flag) {
					response.sendRedirect("server");
				}
				
				
			}
			else if(type.equals("delete")) {
				int id=Integer.parseInt(request.getParameter("id"));
				Boolean flag= TestDao_JDBC.delete(id);
				if(flag) {
					response.sendRedirect("server");
				}
				else {
					System.out.println("用户删除失败，原因为id输入错误！");
					response.sendRedirect("server");
				}
			}
			else if(type.equals("Up")) {
				String name=request.getParameter("name");
				String gender=request.getParameter("gender");
				int age=Integer.parseInt(request.getParameter("age"));
				int id=Integer.parseInt(request.getParameter("id"));
				Student stu=new Student();
				stu.setAge(age);
				stu.setGender(gender);
				stu.setName(name);
				stu.setId(id);
				Boolean flag= TestDao_JDBC.Up(stu);
				if (flag) {
					response.sendRedirect("server");
				}
				else {
					response.sendRedirect("server");
					System.out.println("更新错误!");
				}
				
			}
			
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
