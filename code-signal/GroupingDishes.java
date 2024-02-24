import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

class GroupingDishes {
    String[][] solution(String[][] dishes) {
        TreeMap<String, TreeSet<String>> ingredientDishesMap = new TreeMap<>();

        for (String[] dish : dishes) {
            for (int i = 1; i < dish.length; i++) {
                if (ingredientDishesMap.containsKey(dish[i])) {
                    ingredientDishesMap.get(dish[i]).add(dish[0]);
                } else {
                    TreeSet<String> dishSet = new TreeSet<>();
                    dishSet.add(dish[0]);
                    ingredientDishesMap.put(dish[i], dishSet);
                }
            }
        }

        ArrayList<String[]> ingredientDishesArray = new ArrayList<>();

        for (String ingredient : ingredientDishesMap.keySet()) {
            if (ingredientDishesMap.get(ingredient).size() > 1) {
                ArrayList<String> ingredientDish = new ArrayList<>(ingredientDishesMap.get(ingredient));
                ingredientDish.add(0, ingredient);
                ingredientDishesArray.add(ingredientDish.toArray(new String[0]));
            }
        }

        return ingredientDishesArray.toArray(new String[0][0]);
    }
}