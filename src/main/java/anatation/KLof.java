package anatation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KLof {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        JomaClass.getSettingFromAntation(Baum.class);


    }
}

class Baum {
    @Joma(lavel = "1", name = "Dilana")
    public void getBaumSetting(String name) {
        System.out.println(name + " like chocolat");
    }

    @Joma(lavel = "2")
    public void getNewSeting() {
        System.out.println("new setting");
    }
}

class JomaClass {
    static public void getSettingFromAntation(Class cl1) throws InvocationTargetException, IllegalAccessException {
        Class class1 = cl1;

        Method ms[] = class1.getMethods();
        for (Method mss : ms) {
            if (mss.getAnnotation(Joma.class).lavel().equals("1")) {
                new Baum().getBaumSetting(mss.getAnnotation(Joma.class).name());
            }
        }
    }


}
