package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ConnD;

/**
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pic=request.getParameter("pic");
		String clazz=request.getParameter("clazz");
		String disc=request.getParameter("disc");
		String pub=request.getParameter("pub");
		String pub_data=request.getParameter("pub_data");
		String editor=request.getParameter("editor");
		String price=request.getParameter("price");
		String count=request.getParameter("count");
		String sql="update  book set"+" id='"+id+"',"+"name='"+name+"',"+"pic='"+pic+"',"+"clazz='"+clazz+"',"+"disc='"+disc+"',"+"pub='"+pub+"',"+"pub_data='"+pub_data+"',"+"editor='"+editor+"',price='"+price+"',count='"+count+"' where id="+id;
		System.out.print(sql);
		ConnD con=new ConnD();
		con.getConnection();
		int x=con.xg(sql);
		if(x>0){
			response.getWriter().print("<script> alert(\"更新成功!\"); </script>");
			response.getWriter().println("<script>window.location.href='admin/list.jsp'</script>");
		}else{
			response.getWriter().print("<script> alert(\"更新失败!\"); </script>");
			response.getWriter().println("<script>window.location.href='admin/update.jsp'</script>");
		}
		con.close();
	}
}
