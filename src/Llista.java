import java.io.Serializable;
import java.util.*;

public class Llista implements Serializable {
    private String nom;
    private List<Integer> numeros;

    public Llista(String nom, List<Integer> numeros) {
        this.nom = nom;
        this.numeros = numeros;
    }

    public void eliminarRepetits() {
        Set<Integer> set = new LinkedHashSet<>(numeros);
        numeros.clear();
        numeros.addAll(set);
    }

    public void ordenarNumeros() {
        Collections.sort(numeros);
    }

    @Override
    public String toString() {
        return "Llista{" +
                "nom='" + nom + '\'' +
                ", numeros=" + numeros +
                '}';
    }
}
