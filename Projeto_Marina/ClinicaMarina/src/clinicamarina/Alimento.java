package clinicamarina;
import java.util.HashMap;

public class Alimento {
    private HashMap<String, Double> comidas;

    public Alimento() {
        this.comidas = new HashMap<>();
    }

    public HashMap<String, Double> getComidas() {
        return comidas;
    }

    public void setComidas(HashMap<String, Double> comidas) {
        this.comidas = comidas;
    }
    
    public void adicionarComida(String nome, Double caloria){
        this.comidas.put(nome, caloria);
    }
}
