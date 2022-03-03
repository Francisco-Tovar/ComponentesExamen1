package encriptador;

public class Vignere implements Encriptador{

    private static String key = "CENFO";
    private String keyMap = "";
    private static int[][] table = createVigenereTable();

    @Override
    public String encripta(String texto) {
        texto = texto.toUpperCase();
        for (int i = 0, j = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == (char)32){
                //ignoring space
                keyMap += (char)32;

            } else {
                if(j < key.length()){
                    keyMap += key.charAt(j);
                    j++;
                } else {
                    j = 0;
                    keyMap += key.charAt(j);
                    j++;
                }
            } //if-else
        } //for
        int[][] table = createVigenereTable();
        String encryptedText = "";
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == (char)32 && keyMap.charAt(i) == (char)32){
                encryptedText += " ";
            } else {
                encryptedText += (char)table[(int)texto.charAt(i)-65][(int)keyMap.charAt(i)-65];
            }
        }
        return encryptedText;
    }

    @Override
    public String desencripta(String texto) {
        texto = texto.toUpperCase();

        String decryptedText = "";

        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == (char)32 && keyMap.charAt(i) == (char)32){
                decryptedText += " ";
            } else {
                decryptedText += (char)(65 + counter((int)keyMap.charAt(i), (int)texto.charAt(i)));
            }
        }

        return decryptedText;
    }


    private static int[][] createVigenereTable() {

        int[][] tableArr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int temp;
                if((i+65)+j > 90){
                    temp = ((i+65)+j) -26;
                    tableArr[i][j] = temp;
                } else {
                    temp = (i+65)+j;
                    tableArr[i][j] = temp;
                }
            }
        }
        return tableArr;
    }

    private static int counter(int key, int msg) {
        int counter = 0;
        String result = "";
        for (int i = 0; i < 26; i++) {
            if(key+i > 90){
                result += (char)(key+(i-26));
            } else {
                result += (char)(key+i);
            }
        }

        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == msg){
                break;
            } else {
                counter++;
            }
        }
        return counter;
    }
}//end vignere
