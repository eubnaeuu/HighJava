<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
Integer resultCnt = (Integer) request.getAttribute("resultCnt");
%>
{"resultCnt" : "<%=resultCnt%>"}