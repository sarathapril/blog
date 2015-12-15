<%@page session="false"%>
<%@page contentType="application/json"
            pageEncoding="utf-8"
            import="java.util.Map,
                    java.util.TreeMap,
                    com.day.cq.commons.TidyJSONWriter" %>
<%@include file="/libs/foundation/global.jsp" %>
<%
    TidyJSONWriter w = new TidyJSONWriter(out);
    w.setTidy(true);
    w.array();
	TreeMap<String, String> options = new TreeMap<String, String>();
	options.put("Page1","Parent Page One");
	options.put("page2","Parent Page Two");
	options.put("page3","Parent Page Three");
    for (Map.Entry<String, String> e: options.entrySet()) {
        w.object();
        w.key("value").value(e.getKey());
        w.key("text").value(e.getValue());
        w.endObject();
    }
    w.endArray();
%>

