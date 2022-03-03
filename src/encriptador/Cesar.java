package encriptador;

public class Cesar implements Encriptador {

    String letras = "ABCDEFGHIJKLMNÑOPKRSTUVWXYZ";

    @Override
    public String encripta(String texto) {
        String textoCodificado = "";
        texto = texto.toUpperCase();
        char caracter;
        for (int i = 0; i < texto.length(); i++){
            caracter = texto.charAt(i);
            int pos = letras.indexOf(caracter);
            if (pos == -1){
                textoCodificado += caracter;
            }else {
                textoCodificado += letras.charAt((pos+3) % letras.length());
            }
        }
        return textoCodificado;
    }

    @Override
    public String desencripta(String texto) {
        String textoDesCodificado = "";
        texto = texto.toUpperCase();
        char caracter;
        for (int i = 0; i < texto.length(); i++){
            caracter = texto.charAt(i);
            int pos = letras.indexOf(caracter);
            if (pos == -1){
                textoDesCodificado += caracter;
            }else {
                if (pos - 3 < 0){
                    textoDesCodificado += letras.charAt((pos-3) + letras.length());
                }else{
                    textoDesCodificado += letras.charAt((pos-3) % letras.length());
                }

            }
        }
        return textoDesCodificado;
    }
}
