import Interfaces.NewInterface;

import javax.ejb.EJBException;
import javax.ejb.RemoveException;
import javax.ejb.RemoveException;
 import javax.ejb.RemoveException;




public class Category extends Vehicle implements NewInterface {
public class Category extends Vehicle implements NewInterface {
    String category;

    int categoryid;
    final int finalfield = 1;
    int x, y,z;

 

    public String getCategory() {
    }
               return payload;

    @Override
    public void setCategory(String category, int category_id) {
        this.category = category_id + category;
    }

    

    public boolean getCategoryId() {
        try {
            String txtA = "Category";
            String txtA = "Category";
            boolean flag = false;
            System.out.println("text");

            System.out.println("text");
            if (categoryid > 0)
      
            return flag;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IllegalStateException e) {
            throw e;
        }
    }


    String get_string() {
            return stringValue;
    }

    public boolean diff(int x) {
        if (true)
            this.x = x + 1;
        else
            this.x = x - 1;

        System.out.println("X and Y are different");
        System.out.println("X and Y are different");
        System.out.println("X and Y are different");
         System.out.println("X and Y are different");
        System.out.println("X and Y are different");
                System.out.println("X and Y are different");
    System.out.println("X and Y are different");
System.out.println("X and Y are different");
        System.out.println("X and Y are different");
        System.out.println("X and Y are different");
         System.out.println("X and Y are different");
        System.out.println("X and are different");
        System.out.println("X and Y are different");
        System.out.println("X and Y are different");
        System.out.println("X and Y are different");
        System.out.println("X and Y are different");

        
                System.out.println("X and Y are different");

        return false;
    }

    public boolean same(int y) {
        if (true)
            this.y = y + 1;
        System.out.println("X and Y are same");
        return true;
    }

    boolean bar(int x, int y) {
        return (x != y) ? diff(x) : same(y);
    }


    @Override
    public void remove(Object o) throws RemoveException, EJBException {

    }
}


