package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext
                (ProjectConfig.class);

        Person p = context.getBean(Person.class);

        System.out.println("Person's name: " + p.getName());
        System.out.println("Person's parrot: " + p.getParrot());

        /*
            //Programmatically adding beans

            Parrot x = new Parrot();
            x.setName("Kiki");

            //The purpose of a supplier implementation is to return a value you define without taking parameters
            Supplier<Parrot> parrotSupplier = () -> x;

            context.registerBean("parrot1", Parrot.class, parrotSupplier);

            Parrot p = context.getBean(Parrot.class);
            System.out.println(p.getName());
         */
    }
}
