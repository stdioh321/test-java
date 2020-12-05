
import net.bytebuddy.implementation.bind.annotation.*;
import net.bytebuddy.matcher.*;
import net.bytebuddy.*;
import net.bytebuddy.implementation.FixedValue;

public class Hello{
    public static void main(String args[]) throws Exception{
Class<?> dynamicType = new ByteBuddy()
  .subclass(Object.class)
  .method(ElementMatchers.named("toString"))
  .intercept(FixedValue.value("Hello World!"))
  .make()
  .load(Tmp.class.getClassLoader())
  .getLoaded();

        System.out.println(dynamicType.newInstance().toString());
        
        Tmp tmp = new Tmp();
        tmp.doSomething("Mane");
        Hello.doReflection(tmp);
    }

    public static void doReflection(Object  object){
         Class<?> clazz = object.getClass();
    if (!clazz.isAnnotationPresent(SomaDez.class)) {
        throw new RuntimeException("The class " 
          + clazz.getSimpleName() 
          + " is not annotated with SomaDez");
    }
    }
    
}