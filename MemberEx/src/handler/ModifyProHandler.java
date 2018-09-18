package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.LogonDBBean;
import member.LogonDataBean;

public class ModifyProHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		LogonDataBean memberDto=new LogonDataBean();
		memberDto.setPasswd(request.getParameter("passwd"));
		
		String tel=null;
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String tel3=request.getParameter("tel3");
		if(!tel1.equals("")&&!tel2.equals("")&&!tel3.equals("")) {
			tel=tel1+"-"+tel2+"-"+tel3;
		}
		String email=null;
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		if(!email2.equals("")&&!email2.equals("")) {
			email=email1+"@"+email2;
		}
		memberDto.setTel(tel);
		memberDto.setEmail(email);
		memberDto.setId((String)request.getSession().getAttribute("memid"));
		
		LogonDBBean memberDao=LogonDBBean.getInstance();
		int result=memberDao.modifyMember(memberDto);
		request.setAttribute("result", result);
		
		return "/member/modifyPro.jsp";
	}
}
