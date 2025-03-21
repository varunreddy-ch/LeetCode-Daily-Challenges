class Solution {
    public boolean checkItems(List<String> ingredients, Set<String> supplySet) {

        while(ingredients.size() != 0){
            // Pop item if available
            if( supplySet.contains( ingredients.get(0) )) {
                ingredients.remove(0);
            } 
            // Doesnt contain the item, Return false
            else {
                return false;
            }
        } 
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        boolean changed = true;

        // First convert supplies into set
        Set<String> supplySet = new HashSet<>();
        for(String s: supplies) {
            supplySet.add(s);
        } 

        List<String> finalAns = new ArrayList<String>();

        while(changed) {
            // Iterate through all the recipes
            changed = false;
            for(int i=0; i< recipes.length; i++) {
                // Check if recipe already added
                if(supplySet.contains(recipes[i])) {
                    continue;
                }
                else {
                    // Iterate through all the ingredients
                    boolean itemsAvailable = checkItems(ingredients.get(i), supplySet);
                    // If item can be prepared
                    if(itemsAvailable) {
                        supplySet.add(recipes[i]);
                        finalAns.add(recipes[i]);
                        changed = true;
                    }
                }
            }
            
        }
        // List<String> finalAns = new ArrayList<>(ans);
        return finalAns;
    }
}
