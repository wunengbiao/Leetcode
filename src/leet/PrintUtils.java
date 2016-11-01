package leet;

import ChinaMobile.Solution;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wunengbiao on 2016/10/22.
 */
public class PrintUtils<E>{

//    Class clazz=null;

    public PrintUtils() {
//        clazz= (Class) ((ParameterizedType)PrintUtils.class.getGenericSuperclass()).getActualTypeArguments()[0];
        Type type=PrintUtils.class.getGenericSuperclass();
        System.out.println(type);
        Class clazz= (Class) ((ParameterizedType)type).getActualTypeArguments()[0];
        System.out.println(clazz);
        System.out.println(clazz);
    }

//    public void print(clazz[] array){
//        for(int i=0;i<array.length;i++){
//            System.out.print(array[i]);
//            System.out.print(" ");
//        }
//        System.out.print('\n');
//    }

    public static void main(String[] args){
        PrintUtils<Solution> p=new PrintUtils<>();
//        System.out.println(p.getClass().getName());
    }

}
