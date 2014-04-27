<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wp" uri="/aps-core" %>
<%@ taglib prefix="wpsa" uri="/apsadmin-core" %>

<%--CAL START --%>

<wp:info key="currentLang" var="currentLang" />

<c:set var="js_for_datepicker">
/* Italian initialisation for the jQuery UI date picker plugin. */
/* Written by Antonello Pasella (antonello.pasella@gmail.com). */
jQuery(function($){
$.datepicker.regional['it'] = {
closeText: 'Chiudi',
prevText: '&#x3c;Prec',
nextText: 'Succ&#x3e;',
currentText: 'Oggi',
monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno',
'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu',
'Lug','Ago','Set','Ott','Nov','Dic'],
dayNames: ['Domenica','Luned&#236','Marted&#236','Mercoled&#236','Gioved&#236','Venerd&#236','Sabato'],
dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],
dayNamesMin: ['Do','Lu','Ma','Me','Gi','Ve','Sa'],
weekHeader: 'Sm',
dateFormat: 'dd/mm/yy',
firstDay: 1,
isRTL: false,
showMonthAfterYear: false,
yearSuffix: ''};
});

jQuery(function($){
if (Modernizr.touch && Modernizr.inputtypes.date) {
$.each( $("input[data-isdate=true]"), function(index, item) {
item.type = 'date';
});
} else {
$.datepicker.setDefaults( $.datepicker.regional[ "<c:out value="${currentLang}" />" ] );
$("input[data-isdate=true]").datepicker({
       changeMonth: true,
       changeYear: true,
       dateFormat: "dd/mm/yy"
     });
}
});
</c:set>
<wp:headInfo type="JS" info="entando-misc-html5-essentials/modernizr-2.5.3-full.js" />
<wp:headInfo type="JS_EXT" info="http://code.jquery.com/ui/1.10.1/jquery-ui.js" />
<wp:headInfo type="CSS_EXT" info="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<wp:headInfo type="JS_RAW" info="${js_for_datepicker}" />

<%--CAL END --%>

<%--
optional CSS
<wp:headInfo type="CSS" info="widgets/cat_list.css" />
--%>

<section class="cat_list">

<h1><wp:i18n key="CAT_SEARCH_CAT" /></h1>

<form action="<wp:action path="/ExtStr2/do/FrontEnd/sandbox/Cat/search.action" />" method="post" >

  <fieldset>
		<label for="cat_id"><wp:i18n key="CAT_ID" /></label>
		<input type="text" name="id" id="cat_id" value="<s:property value="id" />" />
		<label for="cat_name"><wp:i18n key="CAT_NAME" /></label>
		<input type="text" name="name" id="cat_name" value="<s:property value="name" />" />
		<label for="cat_age"><wp:i18n key="CAT_AGE" /></label>
		<input type="text" name="age" id="cat_age" value="<s:property value="age" />" />
		<label for="cat_weight"><wp:i18n key="CAT_WEIGHT" /></label>
		<input type="text" name="weight" id="cat_weight" value="<s:property value="weight" />" />
		<label for="cat_createdatStart_cal"><wp:i18n key="CAT_CREATEDATSTART" /></label>
		<input type="text" name="createdatStart" id="cat_createdatStart_cal" data-isdate="true" value="<s:property value="createdatStart" />" />
		<label for="cat_createdatEnd_cal"><wp:i18n key="CAT_CREATEDATEND" /></label>
		<input type="text" name="createdatEnd" id="cat_createdatEnd_cal" data-isdate="true" value="<s:property value="createdatEnd" />" />
  </fieldset>

  <button type="submit" class="btn btn-primary">
    <wp:i18n key="SEARCH" />
  </button>

<wpsa:subset source="catsId" count="10" objectName="groupCat" advanced="true" offset="5">
<s:set name="group" value="#groupCat" />

<div class="margin-medium-vertical text-center">
	<s:include value="/WEB-INF/apsadmin/jsp/common/inc/pagerInfo.jsp" />
	<s:include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
</div>

<p>
  <a href="<wp:action path="/ExtStr2/do/FrontEnd/sandbox/Cat/new.action"></wp:action>" title="<wp:i18n key="NEW" />" class="btn btn-info">
    <span class="icon-plus-sign icon-white"></span>&#32;
    <wp:i18n key="NEW" />
  </a>
</p>

<table class="table table-bordered table-condensed table-striped">
<thead>
<tr>
  <th class="text-right">
    <wp:i18n key="CAT_ID" />
  </th>
	<th
                 class="text-left"><wp:i18n key="CAT_NAME" /></th>
	<th
         class="text-right"        ><wp:i18n key="CAT_AGE" /></th>
	<th
             class="text-right"    ><wp:i18n key="CAT_WEIGHT" /></th>
	<th
     class="text-center"            ><wp:i18n key="CAT_CREATEDAT" /></th>
	<th>
    <wp:i18n key="CAT_ACTIONS" />
  </th>
</tr>
</thead>
<tbody>
<s:iterator id="catId">
<tr>
	<s:set var="cat" value="%{getCat(#catId)}" />
	<td class="text-right">
    <a
      href="<wp:action path="/ExtStr2/do/FrontEnd/sandbox/Cat/edit.action"><wp:parameter name="id"><s:property value="#cat.id" /></wp:parameter></wp:action>"
      title="<wp:i18n key="EDIT" />: <s:property value="#cat.id" />"
      class="label label-info display-block">
    <s:property value="#cat.id" />&#32;
    <span class="icon-edit icon-white"></span>
    </a>
  </td>
	<td
            >
    <s:property value="#cat.name" />  </td>
	<td
         class="text-right"    >
    <s:property value="#cat.age" />  </td>
	<td
             class="text-right">
    <s:property value="#cat.weight" />  </td>
	<td
     class="text-center"        >
    <code><s:date name="#cat.createdat" format="dd/MM/yyyy" /></code>  </td>
	<td class="text-center">
    <a
      href="<wp:action path="/ExtStr2/do/FrontEnd/sandbox/Cat/trash.action"><wp:parameter name="id"><s:property value="#cat.id" /></wp:parameter></wp:action>"
      title="<wp:i18n key="TRASH" />: <s:property value="#cat.id" />"
      class="btn btn-warning btn-small">
      <span class="icon-trash icon-white"></span>&#32;
      <wp:i18n key="TRASH" />
    </a>
  </td>
</tr>
</s:iterator>
</tbody>
</table>

<div class="margin-medium-vertical text-center">
	<s:include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
</div>

</wpsa:subset>

</form>
</section>