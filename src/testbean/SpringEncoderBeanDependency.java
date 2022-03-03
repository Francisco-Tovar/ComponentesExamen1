package testbean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import encriptador.Encriptador;

public class SpringEncoderBeanDependency {

    private Encriptador encriptador;

    @Autowired
    public void setEncriptador(Encriptador encriptador){
        this.encriptador = encriptador;
    }

    public void run(String test){
        if (test == "")
        test = "Esto es una prueba";
        System.out.println(test);
        test = encriptador.encripta(test);
        System.out.println("Encriptado: "+ test);
        test = encriptador.desencripta(test);
        System.out.println("Desencriptado: "+ test );
    }

}
