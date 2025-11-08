package com.example.redkeepithalal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle ;

import java.io.File;
import java.util.ArrayList ;
import java.util.InputMismatchException;

public class frontend extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KEEP IT HALAL");
        VBox v=new VBox(10);
        // Load the image
      //  Image image = new Image(getClass().getResourceAsStream("\"D:\\nikkahpic.jpg\""));
        File file = new File("D://nikkahpic.jpg");
        Image image = new Image(file.toURI().toString());
        // Create and configure the ImageView
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(900);  // Set the width to match the scene width
        imageView.setFitHeight(700); // Set the height to match the scene height
        imageView.setPreserveRatio(false); // Allow the image to stretch to fill the entire scene
        Rectangle roundedRectangle = new Rectangle(200, 70);
        roundedRectangle.setArcWidth(60);
        roundedRectangle.setArcHeight(70);
        Button button = new Button("   Register   ");
        button.setStyle("-fx-base: white;");
        //  button.setStyle("-fx-focus-color: black;");
        button.setShape(roundedRectangle);
        button.setFont(Font.font("",30));

        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(imageView,button);
        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, v);
        StackPane.setMargin(button, new javafx.geometry.Insets(0, 50, 0, 0));
        Scene scene = new Scene( root,900, 700);
        scene.setFill(Color.AQUAMARINE);
        primaryStage.setScene(scene);
        primaryStage.show() ;
        button.setOnAction(j->{
            //intro imp data input
            ArrayList<userInfo> data = new ArrayList<>() ;
            Main.inputDataFromFile(data) ;//The inputDataFromFile method is called with data as its argument.
            // This method reads the user information from a file and adds it to the data ArrayList.
            userInfo user = new userInfo() ;
            ArrayList<match> potentials = new ArrayList<>() ;

            GridPane layout = new GridPane();
            layout.setPadding(new Insets(10,10,10,10));

            ToggleGroup toggleGroup1 = new ToggleGroup();
            ToggleGroup toggleGroup2 = new ToggleGroup();
            ToggleGroup toggleGroup3 = new ToggleGroup();
            ToggleGroup toggleGroup4 = new ToggleGroup();

            //USER NAME
            Label label00=new Label("ENTER YOUR DETAILS:");


            Label label0 = new Label("Name");
            TextField tf0 = new TextField();
            tf0.setStyle("-fx-focus-color: black;");
            layout.add(new Label(""),0,0) ;
            layout.add(label00,1,0);
            label00.setAlignment(Pos.CENTER);
            layout.add(label0, 0, 1);
            layout.add(tf0, 1, 1);

            //GENDER
            Label label1 = new Label("Gender");
            RadioButton rb1 = new RadioButton("Male");
            RadioButton rb2 = new RadioButton("Female");
            rb1.setStyle("-fx-focus-color: black;");
            rb2.setStyle("-fx-focus-color: black;");
            rb1.setToggleGroup(toggleGroup1);
            rb2.setToggleGroup(toggleGroup1);
            layout.add(label1, 0, 2);
            layout.add(rb1, 1, 2);
            layout.add(rb2, 2, 2);
            //AGE
            Label label2 = new Label("Age");
            TextField tf2 = new TextField();
            tf2.setStyle("-fx-focus-color: black;");
            layout.add(label2, 0, 3);
            layout.add(tf2, 1, 3);

            //HEIGHT
            Label label3 = new Label("Height(cm)");
            TextField tf3 = new TextField();
            tf3.setStyle("-fx-focus-color: black;");
            layout.add(label3, 0, 4);
            layout.add(tf3, 1, 4);

            //HAFIZ
            //radio button for hafiz
            Label label4 = new Label("Hafiz");
            RadioButton rb3 = new RadioButton("Yes");
            RadioButton rb4 = new RadioButton("No");
            rb3.setToggleGroup(toggleGroup2);
            rb4.setToggleGroup(toggleGroup2);
            rb4.setStyle("-fx-focus-color: black;");
            rb3.setStyle("-fx-focus-color: black;");
            layout.add(label4, 0, 5);
            layout.add(rb3, 1, 5);
            layout.add(rb4, 2, 5);

            //years of education
            Label label5 = new Label("Year Of Education");
            RadioButton rb9 = new RadioButton("12");
            RadioButton rb10 = new RadioButton("16");
            RadioButton rb11 = new RadioButton("18");
            rb9.setStyle("-fx-focus-color: black;");
            rb10.setStyle("-fx-focus-color: black;");
            rb11.setStyle("-fx-focus-color: black;");
            rb9.setToggleGroup(toggleGroup3);
            rb10.setToggleGroup(toggleGroup3);
            rb11.setToggleGroup(toggleGroup3);
            layout.add(label5, 0, 6);
            layout.add(rb9, 1, 6);
            layout.add(rb10, 2, 6);
            layout.add(rb11, 3, 6);

            //FAMILY MEMBERS
            Label label6 = new Label("Number of Family Members");
            TextField tf6 = new TextField();
            tf6.setStyle("-fx-focus-color: black;");
            layout.add(label6, 0, 7);
            layout.add(tf6, 1, 7);

            //FAMILY TYPE
            //radio button for family type
            Label label7 = new Label("Family Type");
            RadioButton rb5 = new RadioButton("Joint");
            rb5.setStyle("-fx-focus-color: black;");
            RadioButton rb6 = new RadioButton("Nuclear");
            rb6.setStyle("-fx-focus-color: black;");
            rb5.setToggleGroup(toggleGroup4);
            rb6.setToggleGroup(toggleGroup4);
            layout.add(label7, 0, 8);
            layout.add(rb5, 1, 8);
            layout.add(rb6, 2, 8);

            //radiobutton for asking if user earns or not
            Label label8 = new Label("Do you earn? ") ;
            RadioButton rb7 = new RadioButton("Yes") ;
            rb7.setStyle("-fx-focus-color: black;");
            RadioButton rb8 = new RadioButton("No") ;
            rb8.setStyle("-fx-focus-color: black;");
            ToggleGroup tg5 = new ToggleGroup() ;
            rb7.setToggleGroup(tg5);
            rb8.setToggleGroup(tg5);
            layout.add(label8,0,9) ;
            layout.add(rb7,1,9) ;
            layout.add(rb8,2,9) ;
            Label label9 = new Label("Qualification");
            TextField tf8 = new TextField();
            tf8.setStyle("-fx-focus-color: black;");
            Label label10 = new Label("Company");
            TextField tf9 = new TextField();
            tf9.setStyle("-fx-focus-color: black;");
            Label label11 = new Label("Monthly Income");
            TextField tf10 = new TextField();
            tf10.setStyle("-fx-focus-color: black;");//do you earn rb7=yes
            rb7.setOnAction(e->{
                //QUALIFICATION
                layout.add(label9, 0, 10);
                layout.add(tf8, 1, 10);

                //COMPANY

                layout.add(label10, 0, 11);
                layout.add(tf9, 1, 11);

                //MONTHLY INCOME

                layout.add(label11, 0, 12);
                layout.add(tf10, 1, 12);

            });

            //COUNTRY
            Label label12 = new Label("Country");
            TextField tf11 = new TextField();
            tf11.setStyle("-fx-focus-color: black;");
            layout.add(label12, 0, 13);
            layout.add(tf11, 1, 13);

            //CITY
            Label label13 = new Label("City");
            TextField tf12 = new TextField();
            tf12.setStyle("-fx-focus-color: black;");
            layout.add(label13, 0, 14);
            layout.add(tf12, 1, 14);

            //MARTIAL STATUS
            //  radio button for martial status
            Label label14 = new Label("Martial Status");
            ArrayList<String> status = new ArrayList<>() ;
            status.add("Single") ;
            status.add("Married") ;
            status.add("Previously married") ;
            ComboBox<String> maritalStatus = new ComboBox<>() ;
            maritalStatus.setStyle("-fx-focus-color: black;");

            maritalStatus.setPromptText("Select");
            maritalStatus.setItems(FXCollections.observableList(status));
            layout.add(label14, 0, 15);
            layout.add(maritalStatus,1,15) ;


            //RELIGION
            Label label15 = new Label("Religion");
            RadioButton rb12 = new RadioButton("Islam");
            rb12.setStyle("-fx-focus-color: black;");
            RadioButton rb13 = new RadioButton("Other");
            rb13.setStyle("-fx-focus-color: black;");
            ToggleGroup toggleGroup6 = new ToggleGroup() ;
            rb12.setToggleGroup(toggleGroup6);
            rb13.setToggleGroup(toggleGroup6);
            layout.add(label15, 0, 16);
            layout.add(rb12, 1, 16);
            layout.add(rb13, 2, 16);

            //PHONE NUMBER
            Label label16 = new Label("phone Number");
            TextField tf16 = new TextField();
            tf16.setStyle("-fx-focus-color: black;");
            layout.add(label16, 0, 17);
            layout.add(tf16, 1, 17);

            //INTEREST ANY THREE
            Label label17 = new Label("Interests : ");
            TextField tf17 = new TextField();
            tf17.setStyle("-fx-focus-color: black;");
            TextField tf18 = new TextField();
            tf18.setStyle("-fx-focus-color: black;");
            TextField tf19 = new TextField();
            tf19.setStyle("-fx-focus-color: black;");
            layout.add(label17, 0, 18);
            layout.add(tf17, 1, 18);
            layout.add(tf18, 2, 18);
            layout.add(tf19, 3, 18);
            Button button1 = new Button("Submit");
            button1.setStyle("-fx-base: black;");
            button1.setAlignment(Pos.CENTER);
            button1.setShape(roundedRectangle);
            layout.add(new Label(""), 1, 17); //for spacing
            layout.add(button1, 1, 19);
            layout.setHgap(10);
            layout.setVgap(5);
            BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(backgroundFill);
            layout.setBackground(background);
            Scene scene2 = new Scene(layout, 800, 700);
            primaryStage.setScene(scene2);
            primaryStage.show();
            button1.setOnAction(e -> {
                        String name = tf0.getText();
                        user.setName(name);
                        if (toggleGroup1.getSelectedToggle() == rb1) {
                            user.setGender('m');
                        } else {
                            user.setGender('f');
                        }
                        try{
                            int age = Integer.parseInt(tf2.getText());
                            if(age<18)
                                throw new illegalAgeException(age) ;
                            user.setAge(age) ;
                }catch(IllegalArgumentException | InputMismatchException ex)
                {
                    GridPane AgeErrorLayout = new GridPane() ;
                    Label ageError = new Label("Age is supposed to be a number") ;
                    Label tryAgain = new Label("Age") ;
                    TextField ageField = new TextField() ;
                    ageField.setStyle("-fx-focus-color: black;");
                    Button ageErrorButton = new Button("Submit") ;
                    ageErrorButton.setStyle("-fx-focus-color: black;");
                    AgeErrorLayout.add(ageError,0,0) ;
                    AgeErrorLayout.add(tryAgain,0,1) ;
                    AgeErrorLayout.add(ageField,1,1) ;
                    AgeErrorLayout.add(ageErrorButton,1,2) ;
                    Scene AgeErrorScene = new Scene(AgeErrorLayout,400,400) ;
                    Stage AgeErrorStage = new Stage() ;
                    AgeErrorStage.setScene(AgeErrorScene);
                    AgeErrorStage.show() ;
                    ageErrorButton.setOnAction(g->{
                        int age = Integer.parseInt(ageField.getText());
                        user.setAge(age);
                        System.out.println(age);
                        AgeErrorStage.close();
                    });
                }
                catch(illegalAgeException ex)
                {
                    Label illegalAgeLabel = new Label(ex.getMessage()) ;
                    Scene illegalAgeScene = new Scene(illegalAgeLabel,500,100) ;
                    primaryStage.setScene(illegalAgeScene);
                    primaryStage.show() ;
                }


                try{
                        int height = Integer.parseInt(tf3.getText());
                        user.setHeight(height);
                }catch(IllegalArgumentException | InputMismatchException ex)
                {
                    GridPane HeightErrorLayout = new GridPane() ;
                    Label HeightError = new Label("Height should be a number greater than 0") ;
                    Label tryAgain = new Label("Height") ;
                    TextField HeightField = new TextField() ;
                    HeightField.setStyle("-fx-focus-color: black;");
                    Button ageErrorButton = new Button("Submit") ;
                    ageErrorButton.setStyle("-fx-focus-color: black;");
                    HeightErrorLayout.add(HeightError,0,0) ;
                    HeightErrorLayout.add(tryAgain,0,1) ;
                    HeightErrorLayout.add(HeightField,1,1) ;
                    HeightErrorLayout.add(ageErrorButton,1,2) ;
                    Scene HeightErrorScene = new Scene(HeightErrorLayout,400,400) ;
                    Stage HeightErrorStage = new Stage() ;
                    HeightErrorStage.setScene(HeightErrorScene);
                    HeightErrorStage.show() ;
                    ageErrorButton.setOnAction(g->{
                        int height = Integer.parseInt(HeightField.getText());
                        user.setHeight(height);
                        HeightErrorStage.close();
                    });
                }
                if (toggleGroup1.getSelectedToggle() == rb3)
                    user.setHafiz('y');
                else
                    user.setHafiz('n');
                int yearOfEducation;
                if (toggleGroup1.getSelectedToggle() == rb9)
                    yearOfEducation = 12;
                else if (toggleGroup1.getSelectedToggle() == rb10)
                    yearOfEducation = 16;
                else
                    yearOfEducation = 18;
                user.setYearsOfEducation(yearOfEducation);

                int familymembers = Integer.parseInt(tf6.getText());
                String familyType;
                if (toggleGroup1.getSelectedToggle() == rb5)
                    familyType = "joint";
                else
                    familyType = "nuclear";
                user.setFamilyInfo(new family(familymembers, familyType));
                String qualification , company ;
                int monthlyIncome ;
                if(tg5.getSelectedToggle() == rb7)
                {
                    qualification = tf8.getText();
                    company = tf9.getText();
                    monthlyIncome = Integer.parseInt(tf10.getText());
                }
                else
                {
                    qualification = "" ;
                    company = "" ;
                    monthlyIncome = 0 ;
                }
                user.setIncome(monthlyIncome);
                user.setIncomeInfo(new sourceOfIncome(qualification, company));
                String country = tf11.getText();
                String city = tf12.getText();
                user.setUserLocation(new location(country, city));
                String martialStatus;
                if(maritalStatus.getSelectionModel().isSelected(0))
                    martialStatus = "single" ;
                else if(maritalStatus.getSelectionModel().isSelected(1))
                    martialStatus = "married" ;
                else
                    martialStatus = "previously married" ;
                user.setMaritalStatus(martialStatus);
                String religion ;
                if(toggleGroup6.getSelectedToggle() == rb12)
                    religion = "islam" ;
                else
                    religion = "other" ;
                user.setReligion(religion);
                long phoneNumber = Long.parseLong(tf16.getText());
                user.setNumber(phoneNumber);
                String interest1 = tf17.getText();
                String interest2 = tf18.getText();
                String interest3 = tf19.getText();
                String[] interests = new String[]{interest1, interest2, interest3};
                user.setHobbies(interests);
                //user preferences are set

                GridPane layout2 = new GridPane();
                layout2.setPadding(new Insets(10,10,10,10));

                ToggleGroup toggleGroup20 = new ToggleGroup();
                ToggleGroup toggleGroup7 = new ToggleGroup();
                ToggleGroup toggleGroup8 = new ToggleGroup();
                ToggleGroup toggleGroup9 = new ToggleGroup();
                Label label000=new Label("ENTER YOU PREFERENCES FOR THE PARTNER:");
                label000.setAlignment(Pos.CENTER);

                //HAFIZ
                //radio button for hafiz
                ToggleGroup toggleForHafiz = new ToggleGroup() ;
                Label l0 = new Label("Hafiz");

                RadioButton radiobutton3 = new RadioButton("Yes");
                radiobutton3.setStyle("-fx-focus-color: black;");
                RadioButton radiobutton4 = new RadioButton("No");
                radiobutton4.setStyle("-fx-focus-color: black;");
                radiobutton3.setToggleGroup(toggleForHafiz);
                radiobutton4.setToggleGroup(toggleForHafiz);
                layout2.add(label000,0,0);
                layout2.add(l0, 0, 4);
                layout2.add(radiobutton3, 1, 4);
                layout2.add(radiobutton4, 2, 4);


                //years of education
                Label l5 = new Label("Year Of Education");
                RadioButton radiob9 = new RadioButton("12");
                radiob9.setStyle("-fx-focus-color: black;");
                RadioButton radiob10 = new RadioButton("16");
                radiob10.setStyle("-fx-focus-color: black;");
                RadioButton radiob11 = new RadioButton("18");
                radiob11.setStyle("-fx-focus-color: black;");
                radiob9.setToggleGroup(toggleGroup7);
                radiob10.setToggleGroup(toggleGroup7);
                radiob11.setToggleGroup(toggleGroup7);
                layout2.add(l5, 0, 5);
                layout2.add(radiob9, 1, 5);
                layout2.add(radiob10, 2, 5);
                layout2.add(radiob11, 3, 5);

                //FAMILY MEMBERS
                Label l6 = new Label("Number of Family Members");
                TextField textf6 = new TextField();
                textf6.setStyle("-fx-focus-color: black;");
                layout2.add(l6, 0, 6);
                layout2.add(textf6, 1, 6);

                Label earnLabel = new Label("Do you want a partner who earns :") ;
                RadioButton yesButton = new RadioButton("yes") ;
                yesButton.setStyle("-fx-focus-color: black;");
                RadioButton noButton = new RadioButton("no") ;
                noButton.setStyle("-fx-focus-color: black;");
                ToggleGroup earningToggleGroup = new ToggleGroup() ;
                yesButton.setToggleGroup(earningToggleGroup);
                noButton.setToggleGroup(earningToggleGroup);
                layout2.add(earnLabel,0,7) ;
                layout2.add(yesButton,1,7) ;
                layout2.add(noButton,2,7) ;

                //QUALIFICATION
                Label l8 = new Label("Qualification");
                TextField textf8 = new TextField();
                textf8.setStyle("-fx-focus-color: black;");
                //MONTHLY INCOME
                Label l10 = new Label("Monthly Income");
                TextField textf10 = new TextField();
                textf10.setStyle("-fx-focus-color: black;");
                yesButton.setOnAction(earn->{
                    layout2.add(l8, 0, 8);
                    layout2.add(textf8, 1, 8);

                    layout2.add(l10, 0, 10);
                    layout2.add(textf10, 1, 10);
                });

                //Location
                Label l11 = new Label("Location:");
                RadioButton radiob12 = new RadioButton("Near me");
                radiob12.setStyle("-fx-focus-color: black;");
                RadioButton radiob13 = new RadioButton("Does'nt matter");
                radiob13.setStyle("-fx-focus-color: black;");
                radiob12.setToggleGroup(toggleGroup8);
                radiob13.setToggleGroup(toggleGroup8);
                layout2.add(l11, 0, 11);
                layout2.add(radiob12, 1, 11);
                layout2.add(radiob13, 2, 11);
                //QNA starts
                Label l12 = new Label("QNAs:");
                Label l13 ;
                if(user.getGender() == 'f')
                    l13 = new Label("Will you take care of my family:");
                else
                    l13 = new Label("Do you expect your partner to care of your family?") ;
                RadioButton radiob14 = new RadioButton("Yes");radiob14.setStyle("-fx-focus-color: black;");
                RadioButton radiob15 = new RadioButton("No");radiob15.setStyle("-fx-focus-color: black;");
                radiob14.setToggleGroup(toggleGroup9);
                radiob15.setToggleGroup(toggleGroup9);
                layout2.add(l12, 0, 12);
                layout2.add(l13, 0, 13);
                layout2.add(radiob14, 1, 13);
                layout2.add(radiob15, 2, 13);


                Label l14;
                if (user.getGender() == 'f')
                    l14 = new Label("Are you comfortable with second marriage:");
                else
                    l14 = new Label("Do you have any intentions of second marriage:");
                RadioButton radiob16 = new RadioButton("Yes");
                radiob16.setStyle("-fx-focus-color: black;");
                RadioButton radiob17 = new RadioButton("No");
                radiob17.setStyle("-fx-focus-color: black;");
                ToggleGroup toggleGroup10 = new ToggleGroup();
                radiob16.setToggleGroup(toggleGroup10);
                radiob17.setToggleGroup(toggleGroup10);
                layout2.add(l14, 0, 14);
                layout2.add(radiob16, 1, 14);
                layout2.add(radiob17, 2, 14);

                Label l15;
                if (user.getGender() == 'f')
                    l15 = new Label("Are you gonna continue your studies further:");
                else
                    l15 = new Label("Are you comfortable with your partner pursuing further studies:");
                RadioButton radiob18 = new RadioButton("Yes");radiob18.setStyle("-fx-focus-color: black;");
                RadioButton radiob19 = new RadioButton("No");radiob19.setStyle("-fx-focus-color: black;");
                ToggleGroup toggleGroup11 = new ToggleGroup();
                radiob18.setToggleGroup(toggleGroup11);
                radiob19.setToggleGroup(toggleGroup11);
                layout2.add(l15, 0, 15);
                layout2.add(radiob18, 1, 15);
                layout2.add(radiob19, 2, 15);

                Label l17 = new Label("Can you cook:");
                RadioButton radiob22 = new RadioButton("Yes");
                radiob22.setStyle("-fx-focus-color: black;");
                RadioButton radiob23 = new RadioButton("No");
                radiob23.setStyle("-fx-focus-color: black;");
                ToggleGroup toggleGroup13 = new ToggleGroup();
                radiob22.setToggleGroup(toggleGroup13);
                radiob23.setToggleGroup(toggleGroup13);
                layout2.add(l17, 0, 17);
                layout2.add(radiob22, 1, 17);
                layout2.add(radiob23, 2, 17);

                Label l18 = new Label("Do you wanna consider cooking as preference:");
                RadioButton radiob24 = new RadioButton("Yes");
                radiob24.setStyle("-fx-focus-color: black;");
                RadioButton radiob25 = new RadioButton("No");
                radiob25.setStyle("-fx-focus-color: black;");
                ToggleGroup toggleGroup14 = new ToggleGroup();
                radiob24.setToggleGroup(toggleGroup14);
                radiob25.setToggleGroup(toggleGroup14);
                layout2.add(l18, 0, 18);
                layout2.add(radiob24, 1, 18);
                layout2.add(radiob25, 2, 18);
                Button button2 = new Button("Submit Preferences");
                button2.setStyle("-fx-base: black;");
                layout2.add(button2,1, 25);
                button2.setAlignment(Pos.CENTER);
                layout2.setVgap(5);
                layout2.setHgap(5);
                layout2.setBackground(background);
                Scene scene3 = new Scene(layout2, 800, 600);
                scene3.setFill(Color.AQUAMARINE);
                primaryStage.setScene(scene3);
                primaryStage.show() ;
                button2.setOnAction(f -> {
                    char hafizPreference ;
                    if (toggleForHafiz.getSelectedToggle() == radiobutton3)
                        hafizPreference = 'y';
                    else
                        hafizPreference = 'n';
                    int educationYears;
                    if (toggleGroup7.getSelectedToggle() == radiob9)
                        educationYears = 12;
                    else if (toggleGroup7.getSelectedToggle() == radiob10)
                        educationYears = 16;
                    else
                        educationYears = 18;
                    String location = null;
                    if (toggleGroup8.getSelectedToggle()==radiob12)
                        location="near me";
                    if (toggleGroup8.getSelectedToggle()==radiob13)
                        location="does not matter";


                    int members = Integer.parseInt(textf6.getText());
                    String qualification2 ;
                    int Income ;
                    if(earningToggleGroup.getSelectedToggle() == yesButton)
                    {
                        qualification2 = textf8.getText();
                        Income = Integer.parseInt(textf10.getText());
                    }
                    else {
                        qualification2 = "" ;
                        Income = 0 ;
                    }

                    boolean takeCareOfFamily;
                    if (toggleGroup9.getSelectedToggle() == radiob14)
                        takeCareOfFamily = true;
                    else {
                        takeCareOfFamily=false;}

                    boolean secondMarriage;
                    if (toggleGroup10.getSelectedToggle() == radiob16)
                        secondMarriage = true;
                    else{
                        secondMarriage=false;}

                    boolean furtherStudiesOrWork;
                    if (toggleGroup11.getSelectedToggle() == radiob18)
                        furtherStudiesOrWork = true;
                    else
                        furtherStudiesOrWork=false;

                    boolean canCook;
                    if(toggleGroup13.getSelectedToggle() == radiob22)
                        canCook = true;
                    else
                        canCook=false;
                    boolean cookPreference;
                    if(toggleGroup13.getSelectedToggle() == radiob24)
                        cookPreference = true ;
                    else
                        cookPreference = false ;

                    //values are set
                    //Passing to the constructor

                    userPreference pref =new userPreference(hafizPreference,location,Income,educationYears,qualification2,members,new qna(takeCareOfFamily,secondMarriage,furtherStudiesOrWork,canCook,cookPreference));
                    user.setPreferences(pref);
                    Main.writeInFile(user);
                    user.setMatches(potentials);
                    //method of matching is called after user data is input from user
                    Main.matching(user, data, user.getMatches());
                    try {
                        //call to the method that arranges the match array, might throw index out of bound exception if no match is found
                        Main.partnerWithHighestPercentage(user.getMatches());
                    }catch(IndexOutOfBoundsException ex)
                    {
                        Label NoMatchLabel = new Label("No current match found. Please try later") ;
                        Scene NoMatchScene = new Scene(NoMatchLabel,600,100) ;
                        Stage NoMatchStage = new Stage() ;
                        NoMatchStage.setScene(NoMatchScene) ;
                        NoMatchStage.show() ;
                    }
                    Button showMatchButton = new Button("Show Match") ;
                    Button showNextButton = new Button("Show next") ;
                    showMatchButton.setStyle("-fx-focus-color: black;");
                    Button goBackButton = new Button("Go Back") ;
                    goBackButton.setStyle("-fx-focus-color: black;");
                    Button goToMenuButton = new Button("Display Menu") ;
                    goToMenuButton.setStyle("-fx-focus-color: black;");
                    showNextHandler handler = new showNextHandler(user.getMatches(),showNextButton,goBackButton, showMatchButton,goToMenuButton,primaryStage) ;
                    goBackButton.setOnAction(handler);
                    showNextButton.setOnAction(handler);
                    showMatchButton.setOnAction(handler);
                    Button searchByLocation = new Button("Search Location") ;
                    searchByLocation.setStyle("-fx-focus-color: black;");
                    GridPane featuresLayout = new GridPane() ;
                    featuresLayout.setVgap(15);
                    featuresLayout.add(showMatchButton,0,1) ;
                    featuresLayout.add(searchByLocation,0,2) ;
                    showMatchButton.setAlignment(Pos.CENTER);
                    searchByLocation.setAlignment(Pos.CENTER);
                    featuresLayout.setBackground(background);
                    featuresLayout.setAlignment(Pos.CENTER);

                    Scene menu = new Scene(featuresLayout,400,500) ;
                    goToMenuButton.setOnAction(m->{
                        primaryStage.setScene(menu);
                        primaryStage.show() ;
                    });
                    primaryStage.setScene(menu);
                    primaryStage.show() ;
                    searchByLocation.setOnAction(i->
                    {
                        Label Country = new Label("Country:") ;
                        Label City = new Label("City") ;
                        TextField countryField = new TextField() ;
                        countryField.setStyle("-fx-focus-color: black;");
                        TextField cityField = new TextField() ;
                        cityField.setStyle("-fx-focus-color: black;");
                        GridPane searchEngineForLocation = new GridPane() ;
                        searchEngineForLocation.add(Country,0,0) ;
                        searchEngineForLocation.add(countryField,1,0) ;
                        searchEngineForLocation.add(City,0,1) ;
                        searchEngineForLocation.add(cityField,1,1) ;
                        Button SubmitLocation = new Button("Submit") ;
                        SubmitLocation.setStyle("-fx-focus-color: black;");
                        searchEngineForLocation.add(SubmitLocation,1,2) ;
                        searchEngineForLocation.add(goToMenuButton,1,3) ;
                        searchEngineForLocation.setVgap(5);
                        searchEngineForLocation.setHgap(5);
                        searchEngineForLocation.setBackground(background);
                        searchEngineForLocation.setAlignment(Pos.CENTER);
                        Button goBackForLocation = new Button("Go back") ;
                        Button showNextForLocation = new Button("Show next") ;
                        Scene locationSearchEngineScene = new Scene(searchEngineForLocation,400,500) ;
                        primaryStage.setScene(locationSearchEngineScene);
                        primaryStage.show() ;
                        SubmitLocation.setOnAction(s->{
                            location Location = new location(countryField.getText(),cityField.getText()) ;
                            ArrayList<match> usersWithSameLocation = Main.searchByLocation(Location,data,user);
                            showNextHandler SearchHandler = new showNextHandler(usersWithSameLocation,showNextForLocation,goBackForLocation,goToMenuButton,primaryStage) ;
                            SubmitLocation.setOnAction(SearchHandler);
                            showNextForLocation.setOnAction(SearchHandler);
                            goBackForLocation.setOnAction(SearchHandler);
                        });
                    });
                });
            });
        });
    }
}