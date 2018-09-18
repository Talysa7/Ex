package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.LogonDBBean;
import member.LogonDataBean;

public class ModifyViewHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String id=(String) request.getSession().getAttribute("memid");
		String passwd=request.getParameter("passwd");
		LogonDBBean memberDao=LogonDBBean.getInstance();
		int result=memberDao.passcheck(id, passwd);
		if(result==1) {
			LogonDataBean memberDto=memberDao.getMember(id);
			request.setAttribute("memberDto", memberDto);
		}
		request.setAttribute("result", result);
		
		return "/member/modifyView.jsp";
	}
}
