package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProductHandler {

    public static void main(String[] args) throws NoSuchMethodException{
        new ProductInfo();
        Class<ProductInfo> infoClass = ProductInfo.class;
        getAnnot(infoClass);
        try {
            Method method = infoClass.getMethod("getData");
            getAnnot(method);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    static void getAnnot(AnnotatedElement element) {

        try  {

            Annotation[] annotations = element.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Product product) {
                    System.out.printf("Product: %s, quota: %d%n",
                            product.name(), product.quota());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
