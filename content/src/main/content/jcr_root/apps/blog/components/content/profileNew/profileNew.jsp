<%@include file="/apps/zapts/global/global.jsp"%>
<%@page session="false" %>

<h4>Social profiles component for creating different profiles.</h4> <br>
<%
    String [] profiles = properties.get("profiles",new String[0]);
    for(String profile : profiles){
        out.println(profile+"<br />");
    }
%>
