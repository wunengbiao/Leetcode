package Base;

import java.lang.reflect.ParameterizedType;

/**
 * Created by wunengbiao on 2016/10/22.
 */
public class PrintUtil<T> {

//    Class clazz=null;
//    public PrintUtil() {
//        clazz=(Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }

    public void print(T[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.print('\n');
    }
}
