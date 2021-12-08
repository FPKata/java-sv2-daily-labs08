package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    void testCreateByName()
    {
        Recipe recipe = new Recipe("Palacsinta");

        assertEquals("Palacsinta", recipe.getName());
        assertNull(recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testCreateByNameAndDescription()
    {
        Recipe recipe = new Recipe("Palacsinta", "Desszert");

        assertEquals("Palacsinta", recipe.getName());
        assertEquals("Desszert", recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testAddOneIngredient(){
        Recipe recipe = new Recipe("Palacsinta", "Desszert");
        recipe.addIngredient("liszt");

        assertEquals("liszt", recipe.getIngredients().get(0));
    }

    @Test
    void testAddMoreIngredients(){
        Recipe recipe = new Recipe("Palacsinta", "Desszert");
        recipe.addIngredient("liszt", "tojás", "tej");

        assertEquals(3, recipe.getIngredients().size());
        assertArrayEquals(new String[] {"liszt", "tojás", "tej"}, recipe.getIngredients().toArray());
    }
}