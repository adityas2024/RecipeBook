package com.pbaumgarten.makeagui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Screen extends JFrame {
    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JList listRecipe;
    private JButton buttonNew;
    private JButton buttonSave;
    private JTextField textName;
    private JTextField textType;
    private JTextField textIngredients;
    private JTextField textInstructions;
    private JPanel panelMain;
    private JButton clearAllButton;
    private JPanel Picture;

    private ArrayList<Recipe> recipes;
    private DefaultListModel listRecipeModel;

    Screen() {
        super("Recipe Book");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        recipes = new ArrayList<Recipe>();
        listRecipeModel = new DefaultListModel<>();
        listRecipe.setModel(listRecipeModel);
        buttonSave.setEnabled(false);


        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recipe p = new Recipe(
                        textName.getText(),
                        textType.getText(),
                        textIngredients.getText(),
                        textInstructions.getText()
                );
                recipes.add(p);
                refreshRecipelist();
            }
        });


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int recipeNumber = listRecipe.getSelectedIndex();
                String empty = "";
                if (recipeNumber >= 0) {
                    Recipe p = recipes.get(recipeNumber);
                    p.setName(textName.getText());
                    p.setType(textType.getText());
                    p.setIngredients(textIngredients.getText());
                    p.setIngredients(textInstructions.getText());
                    refreshRecipelist();
                }
            }
        });
        listRecipe.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int recipeNumber = listRecipe.getSelectedIndex();
                if (recipeNumber >= 0) {
                    Recipe p = recipes.get(recipeNumber);
                    textName.setText(p.getName());
                    textType.setText(p.getType());
                    textIngredients.setText(p.getIngredients());
                    textInstructions.setText(p.getInstructions());
                    buttonSave.setEnabled(true);
                } else {
                    buttonSave.setEnabled(false);
                }
            }
        });
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textName.setText("");
                textType.setText("");
                textIngredients.setText("");
                textInstructions.setText("");

            }
        });
    }

    public void refreshRecipelist() {
        listRecipeModel.removeAllElements();
        System.out.println("Removing all recipes from the list");
        for (Recipe p : recipes) {
            System.out.println("Adding Recipe to the list: " + getName());
            listRecipeModel.addElement(p.getName());
        }
    }

    public void addRecipe(Recipe p) {
        recipes.add(p);
        refreshRecipelist();
    }

    public static void main(String[] args)  {
        Screen screen = new Screen();
        screen.setVisible(true);
    }
}

