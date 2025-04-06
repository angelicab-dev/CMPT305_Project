# Home Finder JavaFX Application
### Description
The aim for his app is to help people looking to move to Edmonton. Providing them with a map and a list of different assessed properties with an option to get their estimated property tax, as well as providing any schools (Public or Catholic) nearby and different types of attractions. The user can search for properties based on their needs and preferences. The app will also provide information about the homes, schools, and attractions in the area.
### Authors
Kamil Malkowski  
Angelica Billiones  
Jheaney Perico
### Technologies Used
- Java (OpenJDK 23)
- JavaFX (17.0.2)
### How to Run
1. Have Oracle OpenJDK 23.0.2 
2. Download JavaFX 17.0.2 from https://gluonhq.com/products/javafx/
3. Unzip the JavaFX SDK
4. Go to **Edit Configurations…**
5. Click on **Add New Configuration** and select **Application**
6. Set the Main class to **MainApp**
7. Go to **Modify options** and select **Add VM options**
8. Set the VM options to the path of the JavaFX SDK lib folder. For example:
   - **Windows**: `--module-path "C:\path\to\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml`
   - **Mac**: `--module-path /path/to/javafx-sdk-17.0.2/lib --add-modules javafx.controls,javafx.fxml`
9. Click **Apply** and **OK** to save the configuration
10. Run the application
