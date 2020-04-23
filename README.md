# JavaFX CRUD - Programmer Notes Application
I am making a desktop application with Java, Maven, and JavaFX. Planning to make this into an interactive POS System or a database rich in GUI. There's two projects in this project:
- `fxcrud` is a project capable of doing CRUD operations (aka the main project),
- `presenting-data` is a simple project made by me to try JavaFX CSS and design elements.

## Architecture / Philosophies
* Object Oriented.
* IBM Programming Style and Techniques
* Model-View-Controller Software Architecture.
* Native Java with Maven for Package Manager.
* Usage of Eclipse IDE.
* Coded in English.

## Design Architecture
In this project, Maven and Java goes hand in hand to make an easy architecture that is favorable towards other programmers. Model Resource (View) Controller Architecture is used for making the code maintainable and easier to read.

## Maven Plguins
- JavaFX from OpenFX (Gluon)
- Maven Compiler Plugin
- Maven Shade Plugin

## Features
- Create a new programmer,
- Reading their name, mastered languages, and favorite IDE in a Table View,
- Update the data of a programmer, and
- Delete a programmer.

TODO:
- Persistent database with XML or MySQL,
- Sign Up System and Login System,
- More details about a programmer,
- POS System to hire a programmer, and
- More stylish UI with CSS.

## Project Structure
The project structure follows the Model Resource (View) Controller Software Architecture, Standard Maven Lifecycle from http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html, and Standard Maven Directory from http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html.

## Installations and Usage (FXCRUD Project)
For Users,
- Make sure that you have the latest version of Java. My Java version is `java 13.0.1 2019-10-15`. I use JDK, download it from their official website (just download the JavaSE, it's an all in one package).
- Use `git pull repo` to fetch the code, or download it by using `git clone`.
- Don't forget to install Maven from their official website.
- Import the project into your Eclipse IDE or IntelliJ IDE.
- `cd project/fxcrud` to switch directory to your project.
- `mvn dependency:resolve` to download all of the dependencies. If you want to run it almost immediately, simply use `mvn install`.
- Then, use `mvn clean javafx:run` to run the project inside your IDE.
- You're done!

For Developers, same as above, but don't forget to follow Maven Standard Lifecycles:
- After resolving dependencies or coding a new feature, use `mvn clean compile` to compile the project.
- `mvn verify` in order to verify the integration tests.
- `mvn javafx:jlink` in order to build your own executable JAR file for deployment.
- Note that you can edit `pom.xml` to set your own directory name, launcher name, etcetera.

If you want to simply create a fat/uber JAR with Shade, then simply do the following:
- `mvn clean package`. The resulting program will be located in the `target/` folder.

## Installations and Usage (Presenting Data Project)
For Users/Developers,
- `git pull repo` or `git clone` to copy the repository.
- Open the `presenting-data` project in Eclipse or Intellij Idea.
- Make sure that you already have JavaFX configured in your IDE.
- Run the project as you used to do, but don't forget to add these extra VM arguments: `--module-info path/to/javafx/sdk/lib --add-modules javafx.controls, javafx.fxml`
- Enjoy!