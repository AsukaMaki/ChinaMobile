<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table align="center" cellspacing=15>
	<c:forEach items="${pageInfo.list }" var="no">
		<tr>
			<td style="font-size:17px;text-align:center;">
				<input type="radio" name="mobile_numbers" value="${no.mobile_number }" >${no.mobile_number }
			</td>
		</tr>
	</c:forEach>
</table>