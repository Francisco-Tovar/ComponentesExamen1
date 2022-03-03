package main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testbean.SpringEncoderBeanDependency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainApp {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");
        BeanFactory factory = context;
        SpringEncoderBeanDependency test = (SpringEncoderBeanDependency) factory.getBean("SpringEncoderBeanDependency");

        String texto = "";

        while(texto == ""){
            out.println("Ingrese una frase para codificar: ");
            texto = in.readLine();
        }

        test.run(texto);
    }
}
