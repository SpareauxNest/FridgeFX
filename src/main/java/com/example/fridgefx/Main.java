package com.example.fridgefx;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import com.example.fridgefx.model.controllers.ListViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Main extends Application{
    Stage window;

    Grids grids = new Grids();
    private List<Recipe> recipes = new ArrayList<>();

    Button enterButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        List<Ingredient> ingredients = new ArrayList<>();
//        ingredients.add(new Ingredient("Garlic", 1, "clove"));
//        ingredients.add(new Ingredient("Butter", 2, "tbs"));
//
//        recipes.add(new Recipe("Garlic Butter", ingredients, "italian.com"));
//        recipes.add(new Recipe("Buttered Garlic", ingredients, "badbreath.net"));

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("data.json");

        Object object = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");

        Iterator i = jsonArray.iterator();
        while(i.hasNext()){
            JSONObject currentObject = (JSONObject) i.next();
            JSONArray array = (JSONArray) currentObject.get("ingredients");
            List<Ingredient> currentIngredients = new ArrayList<>();
            Iterator iterator = array.iterator();
            while(iterator.hasNext()){
                JSONObject ingredientObject = (JSONObject) iterator.next();
                double doubleQuantity = (Double) ingredientObject.get("quantity");
                String unit = (String) ingredientObject.get("unit");
                if (!Objects.nonNull(unit)){
                    unit = "";
                }
                currentIngredients.add(new Ingredient(ingredientObject.get("name").toString(), doubleQuantity, unit));
            }
            Recipe currentRecipe = new Recipe(currentObject.get("name").toString(), currentIngredients, currentObject.get("link").toString());
            recipes.add(currentRecipe);
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/RecipeListView.fxml"));
            Parent root = loader.load();
            ListViewController listViewController = loader.getController();
            listViewController.RecipeSubmit(recipes);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}