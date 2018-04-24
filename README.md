# Edo

![](edo-logo-350.png)

Edo is the official code generator tool for Entando, started with love by Stefano Puddu <s.puddu@entando.com> and maintained with pride by the Entando dev team.

Use it to generate the following parts of Entando Components with a single command:

* Pojo
* DAO, Manager, events
* Entando component descriptor and related files
* REST API, CXF and SpringMVC
* Backoffice actions, validations, tiles and JSPs
* A basic set of utility classes for JUnit tests
* Widgets, custom tags
* InternalServlet widget
* Final report

## Tentative Roadmap

* More than one bean at the same time
* admin console UI producers
* Change the template engine


## Installation from binary package

If you obtained Edo as a pre-compiled binary package, follow these easy installation steps:

1. Copy `edo-x.y.z.jar` into a folder of your choice
2. (Optional for OS X and *nix systems) configure a shell alias like so:  
alias edo="java -jar /folder-of-your-choice/edo-x.y.z.jar"

## Installation from sources

The source comes with an Ant script, and **you'll need Ant 1.9+** to make it work.

### Build and Install

#### OS X and Linux / Unix

The `build-and-install` Ant task is the default one, so you just have to run:

```
$ ant
```

#### Windows

1. (Ant bug) Open `build-maven.xml` and replace any occurrency of `executable="mvn"` with `executable="mvn.bat"`
2. Build (see next section)
3. Copy `target/edo-x.y.z.jar` into a folder of your choice

### Build only

```
$ ant build
```

## Usage

### Windows and OS X / Unix without the `edo` alias

```
$ java -jar <PATH_TO_YOUR_JAR>/edo-x.y.z.jar [options]
```

**Example:**  

```
$ java -jar <PATH_TO_YOUR_JAR>/edo-x.y.z.jar -f edoDescriptor.json
```

### OS X / Unix with the `edo` alias

```
$ edo [options] 
```

**Example:**  

```
$ edo -f edoDescriptor.json
```

### Options (must be set BEFORE any argument):

* **--file**  
  The path of the edo _file descriptor_ file.

### File Descriptor:
This file contains the parameters used to build your assets.

```
{
  "baseDir" : "/path/to/my/project/projectName",
  "permission" : "superuser",
  "packageName" : "org.entando.entando.plugins.jpzoo",
  "model" : {
    "name" : "Animal",
    "fields" : [ {
      "name" : "name",
      "type" : "string",
      "required" : true,
      "length" : null,
      "primaryKey" : false
    }, {
      "name" : "weight",
      "type" : "int",
      "required" : false,
      "length" : null,
      "primaryKey" : false
    } ]
  },
  "assets" : {
    "rest" : true,
    "cxf" : true,
    "specialWidget" : true,
    "internalServlet" : true,
    "adminConsole" : true,
    "adminConsoleProducer" : null
  }
}

```

* `baseDir`: The path of the main directory, the root folder of your project. A `pom.xml` file must exist in the same directory.
* `permission`: The `code` of an existing Entando permission. If not specified, default value is *superuser*
* `packageName`: The package that will be used. If not specified, Edo will create a package following the *Entando Plugin Pattern*`
* `model/name`: The name of the bean

* `model/fields`: The bean fields 
* `model/fields/name`: the field name
* `model/fields/type`: the filed type, one of _Field Data Types_
* `model/fields/required`: whether the field is required (optional)
* `model/fields/length`: the field length (optional)
* `model/fields/primaryKey`: whether the field is the primary key (optional)

* `assets/rest`: whether to produce _SpringMVC_ rest endpoints   
* `assets/cxf`: whether to produce _CXF_ rest endpoints   
* `assets/specialWidget`: whether to produce the assets needed for an entando _widget_   
* `assets/internalServlet`: whether to produce the assets needed to expose CRUD operations through entando _internalServlet widget_     
* `assets/adminConsole`: whether to produce the assets needed for _backoffice_ administration UI     
* `assets/adminConsoleProducer`: [TODO] the adminConsole UI producer     




#### Field Data Types

* **string**
* **int**
* **date**
* **bigdecimal**
* **primary_key**


#### Primary Keyy

If no primary key is specified, by default Edo creates a `id:int` field and uses it as the primary key. 

If you want to specify a different name for the primary key, declare it as first field with the property `primaryKey: true`.

### Warning

Edo will overwrite any existing file, so be careful.

Only the following files won't get overwritten, because these files are meant to exist just once per Plugin:

**Note:** `[sub-path]` can be the project name or `plugins/jp[beanName]`

* `src/main/resources/api/[sub-path]/aps/apiMethods.xml`
* `src/main/resources/entando-struts-plugin.xml`
* `src/main/resources/component/[sub-path]/component.xml`
* `src/main/resources/shortcuts/[sub-path]/apsadmin/shortcuts.xml`
* `src/main/resources/sql/[sub-path]/port_data_production.sql`
* `src/main/resources/sql/[sub-path]/serv_data_production.sql`
* `src/main/tld/[sub-path]/name-core.tld`
* `src/main/webapp/WEB-INF/[sub-path]/apsadmin/tiles.xml`
* `src/main/webapp/WEB-INF/[sub-path]/apsadmin/jsp/common/layouts/subMenu.jsp`
* `src/test/resources/sql/[sub-path]/port_data_test.sql`
* `src/test/resources/sql/[sub-path]/serv_data_test.sql`

## A full example

Given this file `/tmp/edo/foo.json` 

```
{
  "packageName" : "org.mycompany",
  "model" : {
    "name" : "Foo",
    "fields" : [ {
      "name" : "name",
      "type" : "string",
      "required" : true,
      "length" : 10,
      "primaryKey" : false
    } ]
  },
  "assets" : {
    "rest" : true,
    "cxf" : true,
    "specialWidget" : true,
    "internalServlet" : true,
    "adminConsole" : true,
    "adminConsoleProducer" : null
  }
}
```

```
$ java -jar edo-<version>.jar -f /tmp/edo/foo.json 
```

Edo will create these files:

```

├── edo_20180424_135604_Foo-report.txt
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── mycompany
    │   │           ├── aps
    │   │           │   ├── internalservlet
    │   │           │   │   └── foo
    │   │           │   │       ├── FooFinderFrontEndAction.java
    │   │           │   │       ├── FooFrontEndAction.java
    │   │           │   │       └── fooFront.xml
    │   │           │   ├── system
    │   │           │   │   ├── init
    │   │           │   │   │   └── servdb
    │   │           │   │   │       └── Foo.java
    │   │           │   │   └── services
    │   │           │   │       └── foo
    │   │           │   │           ├── api
    │   │           │   │           │   ├── FooListResponse.java
    │   │           │   │           │   ├── FooListResponseResult.java
    │   │           │   │           │   ├── FooResponse.java
    │   │           │   │           │   ├── FooResponseResult.java
    │   │           │   │           │   └── JAXBFoo.java
    │   │           │   │           ├── event
    │   │           │   │           │   ├── FooChangedEvent.java
    │   │           │   │           │   └── FooChangedObserver.java
    │   │           │   │           ├── FooDAO.java
    │   │           │   │           ├── Foo.java
    │   │           │   │           ├── FooManager.java
    │   │           │   │           ├── FooService.java
    │   │           │   │           ├── IFooDAO.java
    │   │           │   │           ├── IFooManager.java
    │   │           │   │           ├── IFooService.java
    │   │           │   │           └── model
    │   │           │   │               └── FooDto.java
    │   │           │   └── tags
    │   │           │       ├── FooListTag.java
    │   │           │       └── FooTag.java
    │   │           ├── apsadmin
    │   │           │   ├── foo
    │   │           │   │   ├── FooAction.java
    │   │           │   │   ├── FooAction-validation.xml
    │   │           │   │   ├── FooFinderAction.java
    │   │           │   │   ├── foo.xml
    │   │           │   │   ├── package_en.properties
    │   │           │   │   └── package_it.properties
    │   │           │   └── portal
    │   │           │       └── specialwidget
    │   │           │           └── foo
    │   │           │               ├── FooConfigAction.java
    │   │           │               ├── fooSpecialWidget.xml
    │   │           │               ├── package_en.properties
    │   │           │               └── package_it.properties
    │   │           └── web
    │   │               └── foo
    │   │                   ├── FooController.java
    │   │                   ├── model
    │   │                   │   └── FooRequest.java
    │   │                   └── validator
    │   │                       └── FooValidator.java
    │   ├── resources
    │   │   ├── api
    │   │   │   └── 1
    │   │   │       └── aps
    │   │   │           └── apiMethods.xml
    │   │   ├── component
    │   │   │   └── 1
    │   │   │       └── component.xml
    │   │   ├── entando-struts-plugin.xml
    │   │   ├── shortcuts
    │   │   │   └── 1
    │   │   │       └── apsadmin
    │   │   │           └── shortcuts.xml
    │   │   ├── spring
    │   │   │   ├── aps
    │   │   │   │   └── managers
    │   │   │   │       └── 1FooManagersConfig.xml
    │   │   │   └── apsadmin
    │   │   │       └── 1FooActionsConfig.xml
    │   │   └── sql
    │   │       └── misc
    │   │           └── 1
    │   │               ├── port_data_production.sql
    │   │               └── serv_data_production.sql
    │   ├── tld
    │   │   └── 1
    │   │       └── 1-core.tld
    │   └── webapp
    │       └── WEB-INF
    │           ├── 1
    │           │   └── apsadmin
    │           │       ├── 1-tiles.xml
    │           │       └── jsp
    │           │           ├── common
    │           │           │   └── layouts
    │           │           │       └── assets-more
    │           │           │           ├── foo-entry-extras.jsp
    │           │           │           ├── foo-list-extras.jsp
    │           │           │           └── foo-trash-extras.jsp
    │           │           ├── foo
    │           │           │   ├── foo-entry.jsp
    │           │           │   ├── foo-list.jsp
    │           │           │   └── foo-trash.jsp
    │           │           └── portal
    │           │               └── specialwidget
    │           │                   └── foo
    │           │                       └── foo-config.jsp
    │           └── aps
    │               └── jsp
    │                   ├── internalservlet
    │                   │   └── foo
    │                   │       ├── frontend-foo-entry.jsp
    │                   │       ├── frontend-foo-error.jsp
    │                   │       ├── frontend-foo-list.jsp
    │                   │       └── frontend-foo-trash.jsp
    │                   └── widgets
    │                       └── Foo.jsp
    └── test
        ├── java
        │   └── org
        │       └── mycompany
        │           ├── 1ConfigTestUtils.java
        │           ├── aps
        │           │   ├── 1BaseTestCase.java
        │           │   └── system
        │           │       └── services
        │           │           └── TestFooManager.java
        │           └── apsadmin
        │               ├── 1ApsAdminBaseTestCase.java
        │               └── foo
        │                   ├── TestFooAction.java
        │                   └── TestFooFinderAction.java
        └── resources
            └── sql
                └── misc
                    └── 1
                        ├── port_data_test.sql
                        └── serv_data_test.sql


```

## Issues

A lot :D
