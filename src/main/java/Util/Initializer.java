package Util;

import FunctionLayer.Category;
import FunctionLayer.LogicFacade;
import java.util.List;

public class Initializer {

    private static List<Category> categories = null;

    public static List<Category> getCategories() {
        if (categories == null) {
            try {
                categories = LogicFacade.getCategories();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categories;
    }
}
