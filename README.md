# Edo

![](edo-logo-350.png)

Edo is the official code generator tool for Entando, started with love by Stefano Puddu <s.puddu@entando.com> and maintained with pride by the Entando dev team.

Use it to generate the following parts of Entando Components with a single command:

* Pojo
* DAO, Manager, events
* Entando component descriptor and related files
* REST API
* Backoffice actions, validations, tiles and JSPs
* A basic set of utility classes for JUnit tests
* Widgets, custom tags
* InternalServlet widget
* Final report

## Tentative Roadmap

* Permit to pick what's to be generated

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
$ java -jar <PATH_TO_YOUR_JAR>/edo-x.y.z.jar [options] beanName field#1 field#2 ... field#n
```

**Example:**  
```
$ java -jar <PATH_TO_YOUR_JAR>/edo-x.y.z.jar [options] Zombie name:string-r deathDate:date
```

### OS X / Unix with the `edo` alias

```
$ edo [options] beanName field#1 field#2 ... field#n
```

**Example:**  
```
$ edo [options] Zombie name:string-r deathDate:date
```

### Options (must be set BEFORE any argument):

* **--baseDir**  
  The path of the main directory, the root folder of your project. If not specified, will be used the current directory.  
  A `pom.xml` file must exist in the same directory.
* **--permission**  
  The `code` of an existing Entando permission.  
  If not specified, default value is *superuser*
* **--package**  
  The package that will be used.  
  If not specified, Edo will create a package following the *Entando Plugin Pattern*

#### Option Examples

```
$ edo --baseDir=/tmp Foo name:string

$ edo --baseDir=/tmp --package=org.entando.entando.plugins.jppet Cat name:string

$ edo --baseDir=/tmp --package=com.mycompany -permission=manage_pet Dog name:string
```

### Arguments

* **bean name**:  
  The name of the bean
* **field definition**:  
  The field name, followed by the field data type and field options

#### Field Data Types

* **string**
* **int**
* **date**
* **bigdecimal**
* **primary_key**

#### Field Options

* **-**:  
  The separator between field data type and field options
* **r**:  
  Flags a field as *required*
* **{1...n}** (i.e. an integer)  
  Available only for the `string` data type, forces the max lentgh up to this value

**Examples:**

```
$ edo Foo name:string

$ edo Foo name:string-8

$ edo Foo name:string-8r

$ edo Foo name:string-r8
```

#### Primary Key

By default Edo creates a `id:int` field and uses it as the primary key. 

If you want to specify a different name for the primary key, declare it as first field using the `primary_key` field data type.

**Example:**
```
$ edo Foo fooid:primary_key name:string
```

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

In a project named `myportal`, given the following command line

```
$ edo --package=org.mycompany Foo name:string-r10
```

Edo will create these files:

```
├── edo_YYYYMMdd_HHmmss_Foo-report.txt
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── mycompany
    │   │           ├── aps
    │   │           │   ├── internalservlet
    │   │           │   │   └── foo
    │   │           │   │       ├── FooFinderFrontEndAction.java
    │   │           │   │       ├── FooFrontEndAction.java
    │   │           │   │       └── fooFront.xml
    │   │           │   ├── system
    │   │           │   │   ├── init
    │   │           │   │   │   └── servdb
    │   │           │   │   │       └── Foo.java
    │   │           │   │   └── services
    │   │           │   │       └── foo
    │   │           │   │           ├── api
    │   │           │   │           │   ├── FooListResponse.java
    │   │           │   │           │   ├── FooListResponseResult.java
    │   │           │   │           │   ├── FooResponse.java
    │   │           │   │           │   ├── FooResponseResult.java
    │   │           │   │           │   └── JAXBFoo.java
    │   │           │   │           ├── event
    │   │           │   │           │   ├── FooChangedEvent.java
    │   │           │   │           │   └── FooChangedObserver.java
    │   │           │   │           ├── FooDAO.java
    │   │           │   │           ├── Foo.java
    │   │           │   │           ├── FooManager.java
    │   │           │   │           ├── IFooDAO.java
    │   │           │   │           └── IFooManager.java
    │   │           │   └── tags
    │   │           │       ├── FooListTag.java
    │   │           │       └── FooTag.java
    │   │           └── apsadmin
    │   │               ├── foo
    │   │               │   ├── FooAction.java
    │   │               │   ├── FooAction-validation.xml
    │   │               │   ├── FooFinderAction.java
    │   │               │   ├── foo.xml
    │   │               │   ├── package_en.properties
    │   │               │   └── package_it.properties
    │   │               └── portal
    │   │                   └── specialwidget
    │   │                       └── foo
    │   │                           ├── FooConfigAction.java
    │   │                           ├── fooSpecialWidget.xml
    │   │                           ├── package_en.properties
    │   │                           └── package_it.properties
    │   ├── resources
    │   │   ├── api
    │   │   │   └── myportal
    │   │   │       └── aps
    │   │   │           └── apiMethods.xml
    │   │   ├── component
    │   │   │   └── myportal
    │   │   │       └── component.xml
    │   │   ├── entando-struts-plugin.xml
    │   │   ├── shortcuts
    │   │   │   └── apsadmin
    │   │   │       └── shortcuts.xml
    │   │   ├── spring
    │   │   │   └── myportal
    │   │   │       ├── aps
    │   │   │       │   └── managers
    │   │   │       │       └── myportalFooManagersConfig.xml
    │   │   │       └── apsadmin
    │   │   │           └── myportalFooActionsConfig.xml
    │   │   └── sql
    │   │       └── misc
    │   │           └── myportal_foo
    │   │               ├── port_data_production.sql
    │   │               └── serv_data_production.sql
    │   ├── tld
    │   │   └── myportal
    │   │       └── myportal-core.tld
    │   └── webapp
    │       └── WEB-INF
    │           ├── aps
    │           │   └── jsp
    │           │       ├── internalservlet
    │           │       │   └── foo
    │           │       │       ├── frontend-foo-entry.jsp
    │           │       │       ├── frontend-foo-error.jsp
    │           │       │       ├── frontend-foo-list.jsp
    │           │       │       └── frontend-foo-trash.jsp
    │           │       └── widgets
    │           │           └── Foo.jsp
    │           └── myportal
    │               └── apsadmin
    │                   ├── jsp
    │                   │   ├── common
    │                   │   │   └── layouts
    │                   │   │       └── assets-more
    │                   │   │           ├── foo-entry-extras.jsp
    │                   │   │           ├── foo-list-extras.jsp
    │                   │   │           └── foo-trash-extras.jsp
    │                   │   ├── foo
    │                   │   │   ├── foo-entry.jsp
    │                   │   │   ├── foo-list.jsp
    │                   │   │   └── foo-trash.jsp
    │                   │   └── portal
    │                   │       └── specialwidget
    │                   │           └── foo
    │                   │               └── foo-config.jsp
    │                   └── myportal-tiles.xml
    └── test
        ├── java
        │   └── org
        │       └── mycompany
        │           ├── aps
        │           │   ├── MyportalBaseTestCase.java
        │           │   └── system
        │           │       └── services
        │           │           └── TestFooManager.java
        │           ├── apsadmin
        │           │   ├── foo
        │           │   │   ├── TestFooAction.java
        │           │   │   └── TestFooFinderAction.java
        │           │   └── MyportalApsAdminBaseTestCase.java
        │           └── MyportalConfigTestUtils.java
        └── resources
            └── sql
                └── misc
                    └── myportal_foo
                        ├── port_data_test.sql
                        └── serv_data_test.sql
```

## Issues

A lot :D
