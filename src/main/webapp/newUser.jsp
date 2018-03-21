<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		var count=1;
		$("#list").load("getNumbers.do")
		$("#mobileNumber").click(function(){
			$("#divNumbers").fadeIn();
		})
		$("#btn_close").click(function(){
			$("#divNumbers").fadeOut();
		})
		$("#nextPage").click(function(){
			count++;
			if(count>10){
				count=1;
			}
			$("#list").load("getNumbers.do",{currentPage:count});
		})
		
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
          <TD height=25>&nbsp;您现在的位置：新增用户</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
     
     <form method="POST" action="user.do">
      <p>手机号码：<input type="text" name="mobileNumber" size="20" id="mobileNumber"></p>
      <div id="divNumbers" style="position:absolute; left:350px; top:150px; background-color:gainsboro; width:400px; height:250px; display:none;">
    	<div style="float: right">
			<input type="button" id="btn_close" value="关闭" />
		</div>
		<div style="clear: both" id="list">
			<!-- <table id="tbNumbers" width="100%">
			</table> -->
			<%@ include file="list.jsp" %>
		</div>
		<div style="position:absolute; left:350px; top:220px;">
			<a href="#" id="nextPage">换一批</a>
		</div>
     </div>
      <p>漫游状态：<input type="radio" name="status" value="P">省内漫游 <input type="radio" name="status" value="D">国内漫游 
      <input type="radio" name="status" value="I">国际漫游</p>
      <p>通话级别：<input type="radio" value="L" name="level">本地通话 
      <input type="radio" name="level" value="D">国内长途 <input type="radio" name="level" value="I">国际长途</p>
      <p>客户ID：<input type="text" name="userId" size="20" value="${userId }" readonly></p>
      
      <p><input type="submit" value="完成>>" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>

    
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER>
</body>
</html>