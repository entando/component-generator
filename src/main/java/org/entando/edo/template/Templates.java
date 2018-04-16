/*
 * Copyright 2015-Present Entando Inc. (http://www.entando.com) All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package org.entando.edo.template;

public interface Templates {

	// - - START SERVICE LAYER JAVA
	/**
	 * The path of the bean template
	 */
	public static final String BEAN = "templates/java/aps/managers/bean_java.vm";
	
	/**
	 * The path of the DAO interface template
	 */
	public static final String DAO_INTERFACE = "templates/java/aps/managers/DaoInterface_java.vm";
	
	/**
	 * The path of the DAO implementation template
	 */
	public static final String DAO_IMPL = "templates/java/aps/managers/Dao_java.vm";
	
	/**
	 * The path of the service interface template
	 */
	public static final String MANAGER_INTERFACE = "templates/java/aps/managers/ManagerInterface_java.vm";
	
    //--------------------

    public static final String SERVICE_INTERFACE_JAVA = "templates/java/aps/services/ServiceInterface_java.vm";

    public static final String SERVICE_JAVA = "templates/java/aps/services/Service_java.vm";

    public static final String BEAN_DTO = "templates/java/aps/services/dto_java.vm";

    public static final String BEAN_DTO_REQUEST = "templates/java/aps/web/dto_request_java.vm";

    //-------------------------------

	/**
	 * The path of the service implementation template
	 */
	public static final String MANAGER_IMPL = "templates/java/aps/managers/Manager_java.vm";

	/**
	 * The path of the event template
	 */
	public static final String EVENT = "templates/java/aps/managers/Event_java.vm";

	/**
	 * The path of the event observer interface template
	 */
	public static final String EVENT_OBSERVER = "templates/java/aps/managers/EventObserver_java.vm";
	// - - END SERVICE LAYER JAVA


	// - - START SERVICE LAYER - SPRING
	/**
	 * The path of the spring configuration template for the service layer
	 */
	public static final String SPRING_MANAGERS_CONFIG_XML = "templates/resources/spring/manager/managers_xml.vm";
	// - - END SERVICE LAYER - SPRING
	

	// - - START ENTANDO COMPONENT
	/**
	 * The path of the bean template that handles table creation
	 */
	public static final String ENTANDO_INIT_POJO = "templates/java/aps/init/initBean_java.vm";
	
	/**
	 * The path of the component descriptor template
	 */
	public static final String ENTANDO_INIT_COMPONENT_XML = "templates/resources/component/component_xml.vm";

	/**
	 * The path of the component sql file template for the *serv database
	 */
	public static final String ENTANDO_INIT_SERV_DATA_PRODUCTION_SQL = "templates/resources/sql/serv_data_production_sql.vm";

	/**
	 * The path of the component sql file template for the *port database
	 */
	public static final String ENTANDO_INIT_PORT_DATA_PRODUCTION_SQL = "templates/resources/sql/port_data_production_sql.vm";
		
	/**
	 * The path of the component sql file template for the *sert test database
	 */
	public static final String ENTANDO_INIT_SERV_DATA_TEST_SQL = "templates/resources/sql/serv_data_test_sql.vm";

	/**
	 * The path of the component sql file template for the *sert test database
	 */
	public static final String ENTANDO_INIT_PORT_DATA_TEST_SQL = "templates/resources/sql/port_data_test_sql.vm";
	// - - END ENTANDO COMPONENT

	
	// - - START ENTANDO API
	/**
	 * The path of the jaxb-bean template
	 */
	public static final String API_BEAN = "templates/java/aps/api/jaxb-bean_java.vm";
	
	/**
	 * The path of the api response template
	 */
	public static final String API_RESPONSE = "templates/java/aps/api/apiResponse_java.vm";
	
	/**
	 * The path of the api response result template
	 */	
	public static final String API_RESPONSE_RESULT = "templates/java/aps/api/apiResponseResult_java.vm";
	
	/**
	 * The path of the api list response template
	 */
	public static final String API_LIST_RESPONSE = "templates/java/aps/api/apiListResponse_java.vm";
	
	/**
	 * The path of the api list response result template
	 */
	public static final String API_LIST_RESPONSE_RESULT = "templates/java/aps/api/apiListResponseResult_java.vm";

	/**
	 * The path of the api configuration template
	 */
	public static final String API_METHODS_XML = "templates/resources/api/apiMethods_xml.vm";
	// - - END ENTANDO API

	
	// - - START CONTROLLER LAYER JAVA

    public static final String CONTROLLER_JAVA = "templates/java/web/controller_java.vm";

	/**
	 * The path of the action template
	 */
	public static final String ACTION_JAVA = "templates/java/apsadmin/action_java.vm";
		
	/**
	 * The path of the finder action template
	 */
	public static final String ACTION_FINDER_JAVA = "templates/java/apsadmin/finder_action_java.vm";
	
	/**
	 * The path of the struts action configuration xml template
	 */
	public static final String ACTION_XML = "templates/java/apsadmin/action_xml.vm";
	
	/**
	 * The path of the struts validation template
	 */	
	public static final String ACTION_VALIDATION_XML = "templates/java/apsadmin/action-validation_xml.vm";
	
	/**
	 * The path of the struts conversion-properties template
	 */	
	public static final String ACTION_CONVERSION_XML = "templates/java/apsadmin/action-conversion_properties.vm";

	/**
	 * The path of the struts conversion-properties for the finder action template
	 */	
	public static final String ACTION_FINDER_CONVERSION_XML = "templates/java/apsadmin/finder-action-conversion_properties.vm";
		
	/**
	 * The path of the struts properties template
	 */	
	public static final String ACTION_PACKAGE_PROPERTIES = "templates/java/apsadmin/package_properties.vm";
		
	/**
	 * The path of the struts global-messages template
	 */	
	public static final String ACTION_PLUGIN_GLOBAL_MESSAGES_PROPERTIES = "templates/java/apsadmin/plugin_global_properties.vm";
	// - - END CONTROLLER LAYER JAVA

	
	// - - START CONTROLLER SPECIAL-WIDGET JAVA
	/**
	 * The path of the special widget action template
	 */	
	public static final String ACTION_SPECIALWIDGET_JAVA = "templates/java/apsadmin/action_specialwidget_java.vm";

	/**
	 * The path of the special widget properties template
	 */	
	public static final String ACTION_SPECIALWIDGET_PACKAGE_PROPERTIES = "templates/java/apsadmin/specialwidget_package_properties.vm";

	/**
	 * The path of the special widget struts action configuration xml template
	 */
	public static final String SPECIALWIDGET_ACTION_XML = "templates/java/apsadmin/specialwidget_action_xml.vm";
	// - - END CONTROLLER SPECIAL-WIDGET JAVA

	
	// - - START INTERNAL-SERVLET JAVA
	/**
	 * The path of the internalservlet list action template
	 */
	public static final String INTERNAL_SERVLET_ACTION_FINDER = "templates/java/aps/internalservlet/FinderFrontEndAction_java.vm";

	/**
	 * The path of the internalservlet entry action template
	 */
	public static final String INTERNAL_SERVLET_ACTION = "templates/java/aps/internalservlet/FrontEndAction_java.vm";

	/**
	 * The path of the internalservlet configuration template
	 */
	public static final String INTERNAL_SERVLET_XML_ACTION = "templates/java/aps/internalservlet/action_xml.vm";
	// - - END INTERNAL-SERVLET JAVA

	
	// - - START CONTROLLER LAYER - SPRING
	/**
	 * The path of the spring configuration template for the controller layer
	 */
	public static final String ACTION_SPRING = "templates/resources/spring/action/actions_xml.vm";
	// - - END CONTROLLER LAYER - SPRING
	
	
	// - - START BACKOFFICE JSP
	/**
	 * The path of the list jsp template
	 */
	public static final String JSP_APSADMIN_LIST = "templates/jsp/apsadmin/list_jsp.vm";

	/**
	 * The path of the entry jsp template
	 */
	public static final String JSP_APSADMIN_ENTRY = "templates/jsp/apsadmin/entry_jsp.vm";
		
	/**
	 * The path of the trash jsp template
	 */
	public static final String JSP_APSADMIN_TRASH = "templates/jsp/apsadmin/trash_jsp.vm";
		
	/**
	 * The path of the list-extras jsp template
	 */
	public static final String JSP_APSADMIN_LIST_EXTRA_RESOURCES = "templates/jsp/apsadmin/list_extras_jsp.vm";

	/**
	 * The path of the entry-extras jsp template
	 */
	public static final String JSP_APSADMIN_ENTRY_EXTRA_RESOURCES = "templates/jsp/apsadmin/entry_extras_jsp.vm";

	/**
	 * The path of the trash-extras jsp template
	 */
	public static final String JSP_APSADMIN_TRASH_EXTRA_RESOURCES = "templates/jsp/apsadmin/trash_extras_jsp.vm";
		
	/**
	 * The path of the specialwidget jsp template
	 */
	public static final String SPECIALWIDGET_JSP = "templates/jsp/apsadmin/specialwidget_config_jsp.vm";

	/**
	 * The path of the plugun submenu template
	 */
	public static final String JSP_APSADMIN_PLUGINSUBMENU = "templates/jsp/apsadmin/plugin_submenu_jsp.vm";
	// - - END BACKOFFICE JSP
	

	// - - START FRONTEND JSP
	/**
	 * The path of the internalservelet jsp list template
	 */
	public static final String INTERNAL_SERVLET_JSP_LIST = "templates/jsp/aps/internalservlet/list_jsp.vm";

	/**
	 * The path of the internalservelet jsp entry template
	 */
	public static final String INTERNAL_SERVLET_JSP_ENTRY = "templates/jsp/aps/internalservlet/entry_jsp.vm";

	/**
	 * The path of the internalservelet jsp trash template
	 */
	public static final String INTERNAL_SERVLET_JSP_TRASH = "templates/jsp/aps/internalservlet/trash_jsp.vm";

	/**
	 * The path of the internalservelet jsp error template
	 */
	public static final String INTERNAL_SERVLET_JSP_ERROR = "templates/jsp/aps/internalservlet/error_jsp.vm";

	/**
	 * The path of the widget jsp template
	 */
	public static final String WIDGET_JSP = "templates/jsp/aps/widgets/widget.vm";
	// - - END FRONTEND JSP

	
	// - - START STRUTS2 CONFIGURATION
	/**
	 * The path of the struts-plugin configuration xml template
	 */
	public static final String ACTION_STRUTS_PLUGIN = "templates/java/apsadmin/struts_plugin_xml.vm";

	/**
	 * The path of the tiles configuration xml template
	 */
	public static final String ACTION_TILES = "templates/java/apsadmin/action_tiles_xml.vm";
	// - - END STRUTS2 CONFIGURATION
	

	// - - START FRONTEND TAGLIB
	/**
	 * The path of the taglib-getlist template
	 */
	public static final String TAG_LIST_JAVA =   "templates/java/aps/tags/list_tag_java.vm";
	
	/**
	 * The path of the taglib-single template
	 */
	public static final String TAG_SINGLE_JAVA = "templates/java/aps/tags/tag_java.vm";
		
	/**
	 * The path of the taglib configuration template
	 */
	public static final String TLD_APS = "templates/tld/aps-core_tld.vm";
	// - - END FRONTEND TAGLIB

	
	
	// - - START JUNIT TEST
	/**
	 * The path of the ConfigTestUtils template
	 */
	public static final String TEST_CONFIG_TEST_UTILS = "templates/test/java/ConfigTestUtils_java.vm";

	/**
	 * The path of the ApsAdminBaseTestCase template
	 */
	public static final String TEST_ACTION_BASE_TEST_JAVA = "templates/test/java/apsadmin/ApsAdminBaseTestCase_java.vm";

	/**
	 * The path of the test action template
	 */
	public static final String TEST_ACTION_JAVA = "templates/test/java/apsadmin/TestAction_java.vm";

	/**
	 * The path of the test list action template
	 */
	public static final String TEST_ACTION_FINDER_JAVA = "templates/test/java/apsadmin/TestFinderAction_java.vm";
	
	/**
	 * The path of the test BaseTestCase template
	 */
	public static final String TEST_SERVICES_BASE_TEST_JAVA = "templates/test/java/aps/ApsBaseTestCase_java.vm";

	/**
	 * The path of the test service template
	 */
	public static final String TEST_MANAGER_JAVA = "templates/test/java/aps/TestManager_java.vm";

	// - - END JUNIT TEST
	
	
	


	
	//SHORTCUT
	public static final String SHORTCUT= "templates/shortcuts/shortcuts_xml.vm";
	
	public static final String EDO_REPORT = "templates/common/report_txt.vm";








}
