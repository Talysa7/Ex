package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.LogonDBBean;

public class DeleteProHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String id=(String)request.getSession().getAttribute("memid");
		String passwd=request.getParameter("passwd");
		LogonDBBean memberDao=LogonDBBean.getInstance();
		int resultCheck=memberDao.passcheck(id, passwd);
		request.setAttribute("resultCheck", resultCheck);
		if(resultCheck==1) {
			//비밀번호가 같다
			int result=memberDao.deleteMember(id);
			request.setAttribute("result", result);
		}
		
		return "/member/deletePro.jsp";
	}
}
