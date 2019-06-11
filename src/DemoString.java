import com.model.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@MyAnno1()
public class DemoString {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        char[] arrry = {'S','t','r','i','n','g'};
        String str = new String(arrry);
        System.out.println(str);
        Class clazz = Class.forName("com.model.Person");
        Constructor cs = clazz.getConstructor(String.class, String.class);
        Person person = (Person) cs.newInstance("zhangsan","12231");
        System.out.println(person.getName()+person.getPassword());
    }

    @Test
    public void test(){
        Class clazz = null;
        try {
            clazz = Class.forName("com.model.Person");
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            Person person = (Person) clazz.newInstance();
            field.set(person, "wangwu");
            System.out.println(field.get(person));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1{
        }