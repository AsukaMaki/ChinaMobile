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
          <TD height=25>&nbsp;您现在的位置：配置业务费用</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
 


<h2>收费细项</h2>
    <form method="POST" action="charge.do">
      <p>收费项目：<select size="1" name="chargeCode">
        <option value="A">开户费</option>
        <option value="B">漫游费</option>
        <option value="C">押金</option>
        <option value="D">入网费</option>
        <option value="E">选号费</option>
      </select></p>
   	  <p>收费金额：<input type="text" name="charges" size="20" value=""></p>
      <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <hr>
    <h2>业务收费</h2>
    <form method="POST" action="chargeRule.do">
      <p>业务：<select size="1" name="chargeRule">
        <option value="O">开户业务</option>
      </select></p>
      <p>收费项目：<input type="checkbox" name="codes" value="A">开户费 
      <input type="checkbox" name="codes" value="B">漫游费 <input type="checkbox" name="codes" value="C">押金 
      <input type="checkbox" name="codes" value="D">入网费 <input type="checkbox" name="codes" value="E">选号费</p>
      <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>   
    
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER>
</body>
</html>