INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jppetCat', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Publish Cat</property>
<property key="it">Pubblica Cat</property>
</properties>', '<config>
	<parameter name="id">id</parameter>
	<action name="jppetCatConfig"/>
</config>','jppet', NULL, NULL, 1, 'free');

INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jppetCat_list_form', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Cat List and Form</property>
<property key="it">Lista e Form Cat</property>
</properties>', NULL, 'jppet', 'formAction', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="actionPath">/ExtStr2/do/FrontEnd/jppet/Cat/list.action</property>
</properties>', 1, 'free');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_ID', 'en', 'id');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_ID', 'it', 'id');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_NAME', 'en', 'name');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_NAME', 'it', 'name');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_AGE', 'en', 'age');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_AGE', 'it', 'age');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_WEIGHT', 'en', 'weight');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_WEIGHT', 'it', 'weight');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_CREATEDATSTART', 'en', 'createdat start');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_CREATEDATSTART', 'it', 'createdat start');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_CREATEDATEND', 'en', 'createdat end');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_CREATEDATEND', 'it', 'createdat end');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_CREATEDAT', 'en', 'createdat');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_CREATEDAT', 'it', 'createdat');


INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_ACTIONS', 'it', 'Actions');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_ACTIONS', 'en', 'Actions');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_NEW', 'it', 'Cat New');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_NEW', 'en', 'Cat New');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_EDIT', 'it', 'Cat Edit');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_EDIT', 'en', 'Cat Edit');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_TRASH', 'it', 'Cat Trash');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_TRASH', 'en', 'Cat Trash');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_TRASH_CONFIRM', 'it', 'Cat Trash confirm');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_TRASH_CONFIRM', 'en', 'Cat Trash confirm');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_SEARCH_CAT', 'it', 'Cat search');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_SEARCH_CAT', 'en', 'Cat search');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_NOT_FOUND', 'it', 'Cat not found');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jppet_CAT_NOT_FOUND', 'en', 'Cat not found');

