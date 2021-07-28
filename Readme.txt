******************************************************************************************************************
Steps to set up project in intellij:
******************************************************************************************************************

1. Open the project using the Open button present inside File
2. Import all changes (Maven) / Enable auto import
3. Click on File -> Project Structure
4. Select Libraries
5. Select the + button (Left one, above the list of libraries)
6. Select Java from the drop down
7. Navigate to Root/src/main/resources/lib/ and select ojdbc6.jar by pressing "Ok"
8. Select Root module
9. Go to MainClass and run project.

******************************************************************************************************************
Steps to create a new module (Using Intellij IDEA):
******************************************************************************************************************

1. Right click on the base folder (Siemens-Microservices-base)
2. Select New -> Module
3. Select a Maven in the pop up and click on next
4. Give the name of the module inside the "Artifact Id".
5. Click on finish
6. Go inside the newly created module and create a package with the naming convention: com.siemens.logistics.module_name
7. Now go inside the MainClass and mention this package name inside the annotations: componentScan, EntityScan etc.
8. Now go inside the pom file and add the following line:

<packaging>war</packaging>

Also, inside dependencies add the following dependency to use common module:

<dependency>
      <groupId>com.siemens.logistics</groupId>
      <artifactId>Common</artifactId>
      <version>1.0-SNAPSHOT</version>
      <scope>compile</scope>
</dependency>

9. Add newly created module dependency inside root pom.xml
    E.g.

    <dependency>
        <groupId>com.siemens.logistics</groupId>
        <artifactId>UserManagement</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

******************************************************************************************************************
Steps to package the application:
******************************************************************************************************************

1. Make sure each module's pom file has this line:
<packaging>war</packaging>

2. Make sure the Root module's pom file has this line:
<packaging>war</packaging>

3. Run the maven command:
clean install package

4. After completion the respective wars and ear will be present inside the target folders inside each module folder
