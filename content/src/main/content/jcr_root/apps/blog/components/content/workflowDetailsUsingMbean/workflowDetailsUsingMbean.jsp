<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false"
    contentType="text/html; charset=utf-8"
    import="javax.management.MBeanServerConnection, 
    javax.management.MBeanServer,
	java.lang.management.ManagementFactory,
	javax.management.ObjectName,
	javax.management.openmbean.TabularData,
	java.util.* " %>
<%
    try
	{
        /* 
        	Get MBeanServer Instance for further infor read given link - 
        	https://docs.oracle.com/javase/7/docs/api/javax/management/MBeanServer.html
        */
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        /*
        	QueryNames Method have two parameter one is ObjectName to identify 
            which MBean Service you are looking for & other is QueryExpr which add
            additional conditions to find this object it is similar as database 
            where clauses.For further reading of ObjectName class go through the link - 
            https://docs.oracle.com/javase/7/docs/api/javax/management/ObjectName.html
        */
        Set<ObjectName> names = server.queryNames(new ObjectName("com.adobe.granite.workflow:type=Maintenance,*"), null);

        ObjectName workflowMBean = names.iterator().next();
        /*
            Server invoke method is used to invoke a particular operation on existing MBean instance.
            It's parameter details are as follows - 
            invoke(ObjectName name, String operationName, Object[] params, String[] signature)
        	I am executing stale workflowitems method from AEM.
        */
        Object staleWorkflowCount = server.invoke(workflowMBean, "countStaleWorkflows", new Object[]{null}, new String[] {String.class.getName()});

        int mystaleCount = (Integer)staleWorkflowCount; 
        out.println("<h3>Number of Stale workflow instances are - "+mystaleCount +"</h3>");
        /*
        	Another method execution that returns list of all workflow model present at your instance.
        */
        TabularData modelList = (TabularData) server.invoke(workflowMBean, "fetchModelList", null,null);
        Iterator itr = modelList.keySet().iterator();
        out.println("<h3>List of Workflow Models</h3>");
        while(itr.hasNext()){
        	out.println(itr.next().toString()+"<br>");
        }
    }catch(Exception e){
		out.println(e.getMessage());
    }
%>