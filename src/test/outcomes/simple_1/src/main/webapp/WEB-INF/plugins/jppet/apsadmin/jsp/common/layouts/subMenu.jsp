<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wp" uri="/aps-core" %>

<wp:ifauthorized permission="superuser">
	<li><a href="<s:url namespace="/do/jppet/Cat" action="list" />" ><s:text name="jppet.title.catManagement" /></a></li>
</wp:ifauthorized>
