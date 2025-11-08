package com.example.redkeepithalal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Button ;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import org.w3c.dom.events.Event;
import java.util.ArrayList;

public class showNextHandler implements EventHandler<ActionEvent> {
    private int index;
    private ArrayList<match> matches;
    private Button showNextButton;
    private Button goBackButton;
    private Button showMatch ;
    private Button menuButton ;
    Stage stage;

    public void handle(ActionEvent e) {
        GridPane layout = new GridPane();
        HBox hbox = new HBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        if(e.getSource() == showMatch)
            index = matches.size()-1 ;
        else if (e.getSource() == showNextButton)
            index--;
        else if (e.getSource() == goBackButton)
            index++;
        else
            index-- ;
        if (index<matches.size() && index>-1) {
            Label l00=new Label("See details:");
            Label l0 = new Label("Name : " + matches.get(index).getPotentialMatch().getName());
            Label l1 = new Label("Age:" + matches.get(index).getPotentialMatch().getAge());
            Label l3 = new Label("Education : " + matches.get(index).getPotentialMatch().getYearsOfEducation());
            Label l2 = new Label("Location :" + matches.get(index).getPotentialMatch().getUserLocation().getCity() + "," + matches.get(index).getPotentialMatch().getUserLocation().getCountry());
            Button detailButton =new Button("SEE DETAILS");
            layout.add(l00,0,0);
            layout.add(l0, 0, 1);
            layout.add(l1, 0, 2);
            layout.add(l2, 0, 3);
            layout.add(l3, 0, 4);
            layout.add(detailButton,0,5) ;
            detailButton.setOnAction(d->{
                Label l4;
                if (matches.get(index).getPotentialMatch().getHafiz() == 'y')
                    l4 = new Label("Hafiz : yes");
                else
                    l4 = new Label("Hafiz: no");
                Label l5 = new Label("Number of family members: " + matches.get(index).getPotentialMatch().getFamilyInfo().getNumOfFamilyMembers());
                Label l6;
                if (matches.get(index).getPotentialMatch().getFamilyInfo().getFamilySystem().equals("joint"))
                    l6 = new Label("Family type: Joint");
                else
                    l6 = new Label("Family type: Nuclear");
                Label l7, l8, l9;
                if (matches.get(index).getPotentialMatch().isWorking()) {
                    l7 = new Label("Works at" + matches.get(index).getPotentialMatch().getIncomeInfo().getCompany());
                    l8 = new Label(matches.get(index).getPotentialMatch().getIncomeInfo().getQualification());
                    l9 = new Label("Monthly income:" + matches.get(index).getPotentialMatch().getIncome());
                } else {
                    l7 = new Label("Unemployed");
                    l8 = null;
                    l9 = null;
                }
                Label l10 = new Label("Height: " + matches.get(index).getPotentialMatch().getHeight());
                Label l11 = new Label("Marital status :" + matches.get(index).getPotentialMatch().getMaritalStatus());
                Label l12 = new Label("Number :" + matches.get(index).getPotentialMatch().getNumber());
                Label l13 = new Label("Hobbies : " + matches.get(index).getPotentialMatch().getHobbies()[0] + ", " + matches.get(index).getPotentialMatch().getHobbies()[1] + ", " + matches.get(index).getPotentialMatch().getHobbies()[2]);
                Label l14, l15, l16, l17, l18, l19;
                if (matches.get(index).getPotentialMatch().getGender() == 'f') {
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork())
                        l14 = new Label("Further work and studies id preferred");
                    else
                        l14 = new Label("further work or studies is not preferred");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isSecondMarriage())
                        l15 = new Label("Second marriage is allowed");
                    else
                        l15 = new Label("Does not support second marriage");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isCanCook())
                        l16 = new Label("Can cook");
                    else
                        l16 = new Label("Cant cook");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isCookPreference())
                        l17 = new Label("Prefers you to cook");
                    else
                        l17 = new Label("Doesnt expect you to cook");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isTakeCareOfFamily())
                        l19 = new Label("Can take care of family");
                    else
                        l19 = new Label("can not take care family");
                } else {
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork())
                        l14 = new Label("Further work and studies is encouraged");
                    else
                        l14 = new Label("further work or studies is not encouraged");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isSecondMarriage())
                        l15 = new Label("Supports second marriage");
                    else
                        l15 = new Label("Does not support second marriage");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isCanCook())
                        l16 = new Label("Can cook");
                    else
                        l16 = new Label("Cant cook");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isCookPreference())
                        l17 = new Label("Prefers you to cook");
                    else
                        l17 = new Label("Doesnt expect you to cook");
                    if (matches.get(index).getPotentialMatch().getPreferences().getQuestionsAndAnswers().isTakeCareOfFamily())
                        l19 = new Label("Prefer you to take care of family");
                    else
                        l19 = new Label("Does not expect you to take care of family");
                }
                layout.add(l4, 0, 6);
                layout.add(l5, 0, 7);
                layout.add(l6, 0, 8);
                layout.add(l7, 0, 9);
                if (l8 != null) {
                    layout.add(l8, 0, 10);
                    layout.add(l9, 0, 11);
                    layout.add(l10, 0, 12);
                    layout.add(l11, 0, 13);
                    layout.add(l12, 0, 14);
                    layout.add(l13, 0, 15);
                    layout.add(l14, 0, 16);
                    layout.add(l15, 0, 17);
                    layout.add(l16, 0, 18);
                    layout.add(l17, 0, 19);
                    layout.add(l19, 0, 20);
                } else {
                    layout.add(l10, 0, 10);
                    layout.add(l11, 0, 11);
                    layout.add(l12, 0, 12);
                    layout.add(l13, 0, 13);
                    layout.add(l14, 0, 14);
                    layout.add(l15, 0, 15);
                    layout.add(l16, 0, 16);
                    layout.add(l17, 0, 17);
                    layout.add(l19, 0, 18);
                }
            });
            layout.add(menuButton,0,21) ;
            layout.setVgap(5);
            if(index == 0 && matches.size()>1)
                hbox.getChildren().addAll(goBackButton, layout);
            else if(index==0 && matches.size()==1)
                hbox.getChildren().add(layout) ;
            else if(index == matches.size()-1)
                hbox.getChildren().addAll(layout, showNextButton);
            else
                hbox.getChildren().addAll(goBackButton,layout, showNextButton);
        }
        else
        {
            Label noMatchLabel = new Label("No Match Currently Found!Try later") ;
            hbox.getChildren().add(noMatchLabel) ;
        }
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        hbox.setBackground(background);
        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public showNextHandler(ArrayList<match> matches, Button button1, Button button2,Button menuButton, Stage stage) {
        this.matches = matches;
        index = matches.size();
        showNextButton = button1;
        this.menuButton = menuButton ;
        goBackButton = button2;
        this.stage = stage;
    }
    public showNextHandler(ArrayList<match> matches, Button button1, Button button2,Button button3 ,Button menuButton, Stage stage) {
        this.matches = matches;
        index = matches.size();
        showNextButton = button1;
        this.menuButton = menuButton ;
        goBackButton = button2;
        this.stage = stage;
        showMatch = button3 ;
    }
}
