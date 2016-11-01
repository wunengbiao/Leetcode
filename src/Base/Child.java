package Base;

/**
 * Created by wunengbiao on 2016/10/30.
 */
public class Child extends Parent{

    @Override
    public void hello()  {
        System.out.println("Hello Child");
    }

    public void cSay(){
        System.out.println("CSAY");
    }

    public static void main(String[] args) {
//        Child c=new Child();
//        c.hello();
//        Parent p=new Child();
//        p.hello();

//        Child child= (Child) new Parent();
//        c.hello();

//        Parent p2=new Parent();
//        Child c2= (Child) p2;
//        c2.hello();

        Parent p=new Child();
        p.hello();//"Hello Child"
        System.out.println(p);
        p.say();

//        Parent p2=new Parent();
//        Child c= (Child) p2;
//        c.hello();

        Child c= (Child) p;
        System.out.println(c);
        c.hello();
        c.cSay();
        c.say();

    }


}
