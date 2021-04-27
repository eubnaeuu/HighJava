<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.music.vo.MusicVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<MusicVO> list = (List<MusicVO>)request.getAttribute("musicList");

for(int i=0; i<list.size(); i++){
	MusicVO iv = list.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"musicId" : "<%=iv.getMusicId()%>",
		"musicTitle" : "<%=iv.getMusicTitle()%>",
		"musicArtist" : "<%=iv.getMusicArtist()%>",
		"lmusicGu" : "<%=iv.getLmusicGu()%>",
		"lmusicGenre" : "<%=iv.getLmusicGenre()%>",
		"musicCost" : "<%=iv.getMusicCost()%>",
		"musicTime" : "<%=iv.getMusicTime()%>"
	}
	<%
}
%>
]
    