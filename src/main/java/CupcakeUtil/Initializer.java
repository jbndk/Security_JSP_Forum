package CupcakeUtil;

import FunctionLayer.Bottom;
import FunctionLayer.Category;
import FunctionLayer.LogicFacade;
import FunctionLayer.Topping;

import java.util.List;
import java.util.Locale;

public class Initializer {

    private static List<Bottom> bottomList = null;
    private static List<Topping> topList = null;
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

    public static List<Bottom> getBottomList() {
        if (bottomList == null) {
            try {
                bottomList = LogicFacade.getBottoms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bottomList;
    }

    public static List<Topping> getTopList() {
        if (topList == null) {
            try {
                topList = LogicFacade.getTops();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return topList;
    }
}
