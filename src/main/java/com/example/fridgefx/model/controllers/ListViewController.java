package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ListViewController implements Initializable {

    @FXML
    ListView<String> listView = new ListView<>();

    @FXML
    Button newRecipeButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private List<Recipe> recipes = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recipes.stream().forEach(recipe -> {
            listView.getItems().add(recipe.getName());
        });
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void AddNewRecipe(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/AddRecipe.fxml"));
            root = loader.load();
            AddRecipeController addRecipeController = loader.getController();

            addRecipeController.sendListToRecipeController(recipes);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RecipeSubmit(List<Recipe> recipes){
        this.recipes = recipes;
        recipes.stream().forEach(recipe -> {
            listView.getItems().add(recipe.getName()+"          "+recipe.getLink());
        });
    }

    public void DeleteRecipe(){
        String killString = listView.getSelectionModel().getSelectedItem();
        String[] components = killString.split("          ");
        Recipe killRecipe;
        if(components.length ==2) {
            killRecipe = recipes.stream().filter(recipe -> recipe.getLink().equals(components[1]) && recipe.getName().equals(components[0])).findFirst().orElse(null);
        }
        else{
            killRecipe = recipes.stream().filter(recipe -> recipe.getName().equals(components[0])).findFirst().orElse(null);
        }
        if(Objects.nonNull(killRecipe)){
            recipes.remove(killRecipe);
            listView.getItems().remove(killString);
        }
        saveData();
    }

    public void ViewRecipe(ActionEvent event){
        String selectedString = listView.getSelectionModel().getSelectedItem();
        String[] components = selectedString.split("          ");
        Recipe selectedRecipe;
        if(components.length ==2) {
            selectedRecipe = recipes.stream().filter(recipe -> recipe.getLink().equals(components[1]) && recipe.getName().equals(components[0])).findFirst().orElse(null);
        }
        else{
            selectedRecipe = recipes.stream().filter(recipe -> recipe.getName().equals(components[0])).findFirst().orElse(null);
        }
        if(Objects.nonNull(selectedRecipe)){
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/RecipePage.fxml"));
        root = loader.load();

        RecipePageController recipePageController = loader.getController();
        recipePageController.SendRecipesToPage(recipes, selectedRecipe);
        recipePageController.SetUp();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch (Exception e) {
        e.printStackTrace();
        }}
    }

    public void saveData(){
        JSONArray dataArray = new JSONArray();
        JSONObject data = new JSONObject();
        recipes.stream().forEach(recipe -> {
            JSONArray ingredientArray = new JSONArray();
            recipe.getIngredients().stream().forEach(ingredient -> {
                JSONObject object = new JSONObject();
                object.put("name", ingredient.getName());
                object.put("quantity", ingredient.getQuantity());
                object.put("unit", ingredient.getUnit());
                ingredientArray.add(object);
            });
            JSONObject jsonRecipe = new JSONObject();
            jsonRecipe.put("id", recipe.getId());
            jsonRecipe.put("name", recipe.getName());
            jsonRecipe.put("ingredients", ingredientArray);
            jsonRecipe.put("link", recipe.getLink());

            dataArray.add(jsonRecipe);
            data.put("data", dataArray);
        });
        try{
            FileWriter file = new FileWriter("data.json");
            file.write(data.toJSONString());
            file.flush();
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
