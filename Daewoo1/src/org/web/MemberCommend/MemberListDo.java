package org.web.MemberCommend;


import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.web.MemberDTO.MemberDTO;
import org.web.MemberDAO.MemberDAO;


public class MemberListDo implements MemberCommend{


    @Override
    public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ȸ����ȸ");
        
        MemberDAO dao = MemberDAO.getInstance();
        ArrayList<MemberDTO> members = dao.members();
                
        //DB������
        request.setAttribute("members", members);
        
        //URL
        request.setAttribute("url", "memberList.jsp");
        
    }

}