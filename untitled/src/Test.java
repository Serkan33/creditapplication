import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Deneme deneme = new Deneme("dew");
        try {
            deneme.getClass().getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
