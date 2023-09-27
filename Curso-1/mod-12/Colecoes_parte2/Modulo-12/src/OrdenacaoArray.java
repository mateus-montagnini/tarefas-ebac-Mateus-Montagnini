import java.util.Collections;
import java.util.List;

public class OrdenacaoArray {

    public void arrayOrdenado(String[] array, List<String> arrayM, List<String> arrayF) {
        for(int i = 0; i < array.length; i++) {
            String[] result = array[i].split("-");
            if(result[1].contains("M")) {
                arrayM.add(result[0]);
            } else if(result[1].contains("F")) {
                arrayF.add(result[0]);
            }
        }
        Collections.sort(arrayM);
        Collections.sort(arrayF);
    }
}
