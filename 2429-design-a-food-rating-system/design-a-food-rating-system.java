class FoodRatings {

    Map<String, TreeSet<Pair<String, Integer>>> cuisineMap;
    Map<String, Integer> foodMap;
    Map<String, String> foodToCuisine;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();
        foodToCuisine = new HashMap<>();
        int n = foods.length;
        for(int i=0; i<n; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodMap.put(foods[i], ratings[i]);
            Pair<String, Integer> p = new Pair<>(foods[i], ratings[i]);
            cuisineMap.computeIfAbsent(cuisines[i], c -> new TreeSet<>((a,b) -> Integer.compare(b.getValue(), a.getValue()) == 0 ? a.getKey().compareTo(b.getKey()) : Integer.compare(b.getValue(), a.getValue()))).add(p);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int rating = foodMap.get(food);
        var p = new Pair<String, Integer>(food, rating);
        String cuisine = foodToCuisine.get(food);
        cuisineMap.get(cuisine).remove(p);
        p = new Pair<String, Integer>(food, newRating);
        foodMap.put(food, newRating);
        cuisineMap.get(cuisine).add(p);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().getKey();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */