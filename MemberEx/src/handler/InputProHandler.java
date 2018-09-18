package handler;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.LogonDBBean;
import member.LogonDataBean;

public class InputProHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		LogonDataBean memberDto=new LogonDataBean();
		memberDto.setId(request.getParameter("id"));
		memberDto.setPasswd(request.getParameter("passwd"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setJumin1(request.getParameter("jumin1"));
		memberDto.setJumin2(request.getParameter("jumin2"));

		//tel
		String tel=null;
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String tel3=request.getParameter("tel3");
		if(!tel1.equals("")&&!tel2.equals("")&&!tel3.equals("")){
				tel=tel1+"-"+tel2+"-"+tel3;
		}
		memberDto.setTel(tel);
		
		//email
		String email=null;
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		if(!email1.equals("")){
			if(email2.equals("0")){
				//직접입력
				email=email1;
			} else {
				//선택입력
				email=email1+"@"+email2;
			}
		}
		memberDto.setEmail(email);
		//reg_date
		memberDto.setReg_date(new Timestamp(System.currentTimeMillis()));
		LogonDBBean memberDao=LogonDBBean.getInstance();
		int result=memberDao.insertMember(memberDto);
		request.setAttribute("result", result);
		
		return "/member/inputPro.jsp";
	}
}