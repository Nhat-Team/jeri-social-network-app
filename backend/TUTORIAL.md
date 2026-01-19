## HOW TO USE COMMON LIBRARY IN THIS PROJECT

### 1. Clone this backend project from repository

<i><b>Notice:</b> you have specified the develop branch to make sure that you have only cloned repository with develop branch, not master branch.</i>

```bash 
git clone -b develop [URL Repository] [Folder name]
```

### 2. Open IDE and direct to the project folder

Open your favorite IDE (in this case, we use Intellij IDEA to tutorialize), and point to the project with the name folder is "backend"

Example: Your folder structure is like below

```text
[Root Project]
   ├── backend
          ├── common-library
                    ├── (Source library)
          ├── (others services)
          ├── TUTORIAL.md
   ├── frontend
          ├── web
          ├── mobile
          ├── desktop
```

You should open the "backend" folder in your IDE. So the path is like below
```text
[Root Project]/backend/
```

### 3. Allowing Intellij IDEA (any editions) to import all Gradle projects

### 4. Publish "library-common-core" to local Maven repository

In order to use the common library in this project, you need to publish the "library-common-core" module to your local Maven repository.

To do that, you can use the Gradle task `publishToMavenLocal`.

To run this task, you can follow these steps:

1. Open the Gradle tool window in your IDE. You can usually find it on the right side of the IDE.
2. In the Gradle tool window, navigate to the `library-common-core` project.
3. Expand the `library-common-core` project to see its tasks.
4. Find the `publishing` section and expand it.
5. Locate the `publishToMavenLocal` task.
6. Double-click on the `publishToMavenLocal` task to run it.
7. Wait for the task to complete. You should see output in the Gradle console indicating that the publication was successful.
8. Once the task is complete, the `library-common-core` module will be published to your local Maven repository, and you can now use it in other projects by adding the appropriate dependency in your `build.gradle` file.
9. Make sure to check the local Maven repository (usually located at `~/.m2/repository/`) to confirm that the `library-common-core` module has been published successfully.
10. You can now add the dependency to your other projects as needed.
11. Remember to update the version number in your dependency declaration if you make changes to the `library-common-core` module and republish it.

After completing these steps, you should re-run the Gradle sync in your IDE to ensure other services can recognize the newly published this library.