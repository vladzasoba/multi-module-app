package caching;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheableMethod {
    //CacheStrategy strategy() default CacheStrategy.LRU;
    Class strategy();
    int size() default 10;
}
