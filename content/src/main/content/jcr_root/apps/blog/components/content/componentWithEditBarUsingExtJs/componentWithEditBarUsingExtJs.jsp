<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false" %>

<%
    String path= resource.getPath();
    String resourceType= resource.getResourceType();
    String dialogPath = resource.getResourceResolver().getResource(resourceType).getPath() + "/dialog";
%>

<script type="text/javascript">
        CQ.WCM.edit({
            "path":"<%= path %>",
            "dialog":"<%= dialogPath %>",
            "type":"<%= resourceType %>",
            "editConfig":{
                "xtype":"editbar",
                "listeners":{
                    "afteredit":"REFRESH_PAGE"
                },
                "inlineEditing":CQ.wcm.EditBase.INLINE_MODE_NEVER,
                "disableTargeting": true,
                "actions":[
                    CQ.I18n.getMessage("Configuration Tab Using Ext-JS"),
                    {
                        "xtype": "tbseparator"
                    },
                    CQ.wcm.EditBase.EDIT,
                    {
                        "xtype": "tbseparator"
                    },
                    CQ.wcm.EditBase.DELETE

                ]
            }
        });
</script> 
<br/>
<h3>Example for showing component with a configuration edit bar using Ext Js.</h3>
<br/><br/>