package org.web.MemberDTO;
public class MemberDTO {
     private String userId;
     private String userPw;
     private String userName;
     private String userEmail;
     
     public String getUserId() {
          return userId;
     }
     
     public MemberDTO(String userId, String userPw,  String userName, String userEmail) {
          super();
          this.userId = userId;
          this.userPw = userPw;
          this.userName = userName;
          this.userEmail = userEmail;
     }
     
     public void setUserId(String userId) {
          this.userId = userId;
     }
     public String getUserPw() {
          return userPw;
     }
     public void setUserPw(String userPw) {
          this.userPw = userPw;
     }
     public String getUserName() {
          return userName;
     }
     public void setUserName(String userName) {
          this.userName = userName;
     }
     public String getuserEmail() {
          return userEmail;
     }
     public void setUserEmail(String userEmail) {
          this.userEmail = userEmail;
     }
     
}