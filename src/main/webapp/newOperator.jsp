<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>中国移动业务管理系统</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script>
	$(function(){
		
		$("#operatorId").blur(function(){
			$.post("id.do",{operatorId:$("#operatorId").val()},function(data){
				$("#sp_id").html(data);
			});
		});
		$("#isPassword").blur(function(){
			if($("#isPassword").val() != $("#password").val()){
				$("#sp_password").html("两次密码不一致".fontcolor("red"));
			}else{
				$("#sp_password").html("两次密码一致".fontcolor("green"));
			}
		});
		$("#btn_opera").click(function(){
			
			if($("#sp_id").html() == '<font color="red">ID已存在</font>'){
				alert("提交失败");
			}else{
				$("#fom_opera").submit();
			}
		});
	})
</script>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<CENTER>
<TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
  <TBODY>
  <TR>
    <TD width=173><A href="http://www.chinamobile.com/index.asp"><IMG 
      height=74 src="images/logo.gif" width=173 border=0></A></TD>
    <TD vAlign=top align=right>
      <TABLE width="100%" border=0 cellPadding=0 cellSpacing=0>
        <TBODY>
        <TR bgColor=#2650a6>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
        </TR>
        <TR bgColor=#FFFFFF>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
        </TR>
        <TR>
          <TD><img src="images/pic01.gif" width="115" height="55"></TD>
          <TD><img src="images/pic04.gif" width="115" height="55"></TD>
          <TD><img src="images/pic03.gif" width="115" height="55"></TD>
          <TD><img src="images/pic02.gif" width="115" height="55"></TD>
          <TD><img src="images/pic05.gif" width="115" height="55"></TD>
        </TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD height="12" colSpan=2 align=right bgColor=#d4dced>
     

      <img src="images/spacer.gif" width="1" height="1">
      <TABLE cellSpacing=0 cellPadding=0 border=0>
        <TBODY>
        <TR>
          </TR></TBODY></TABLE>
 
    </TD></TR>
  <TR>
  <TD colSpan=2><IMG height=2 src="images\blank(1).gif" width=1></TD></TR></TBODY></TABLE>

	<%@ include file="subPage.jsp" %>
	
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD height=25>&nbsp;您现在的位置：新增操作员</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
    <form method="POST" action="newOperator.do" id="fom_opera">
      <p>登录ID：<input type="text" name="operatorId" id="operatorId" size="20" value=""><span id="sp_id"></span></p>
      <p>姓 名：<input type="text" name="operatorName" size="20" value=""></p>
      <p>密码：<input type="password" name="password" id="password" size="20" value=""></p>
      <p>密码确认：<input type="password" name="isPassword" id="isPassword" size="20" value=""><span id="sp_password"></span></p>
      <p>是否管理员：<input type="radio" value=1 name="isAdmin">是&nbsp;&nbsp;&nbsp; 
      <input type="radio" name="isAdmin" value=0>否</p>
      <p><input type="button" value="提交" name="B1" id="btn_opera"></p>
    </form>
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER>
</body>
</html>