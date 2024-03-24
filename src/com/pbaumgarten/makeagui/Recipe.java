package com.pbaumgarten.makeagui;


public class Recipe {
    private String name;
    private String ingredients;
    private String instructions;
    private String type;

    public  Recipe(String name, String type, String ingredients, String instructions){
        this.name= name;
        this.ingredients=ingredients;
        this.instructions= instructions;
        this.type = type;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


}


