package clinicamarina;

import java.util.ArrayList;
import java.util.HashMap;

public class Consulta {
    private String data;
    private String horario;
    private double peso;
    private double gordura;
    private String sensacao;
    private String restricoes;
    private HashMap<String, Double> dieta;
    
    public Consulta() {
        this.data = "";
        this.horario = "";
        this.peso = 0.0;
        this.gordura = 0.0;
        this.sensacao = "";
        this.restricoes = "";
        this.dieta = new HashMap<>();
    }

    public Consulta(String data, String horario, double peso, 
            double gordura, String sensacao, String restricoes) {
        this.data = data;
        this.horario = horario;
        this.peso = peso;
        this.gordura = gordura;
        this.sensacao = sensacao;
        this.restricoes = restricoes;
        this.dieta = new HashMap<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public String getSensacao() {
        return sensacao;
    }

    public void setSensacao(String sensacao) {
        this.sensacao = sensacao;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }

    public HashMap<String, Double> getDieta() {
        return dieta;
    }

    public void setDieta(HashMap<String, Double> dieta) {
        this.dieta = dieta;
    }
    
    public ArrayList criarDieta(Alimento carboidrato, 
        Alimento proteina, Alimento fruta, 
        double quantidadeCalorica){
        
        ArrayList<HashMap> opcoes=new ArrayList<>();

        int y=1;
        for(String i: carboidrato.getComidas().keySet()){
            for(String j: proteina.getComidas().keySet()){
                for(String k: fruta.getComidas().keySet()){
                    if(fruta.getComidas().get(k) +
                            proteina.getComidas().get(j) +  
                            carboidrato.getComidas().get(i) < quantidadeCalorica){
                        HashMap<String, Double> auxiliar=new HashMap<>();
                        auxiliar.put(k, fruta.getComidas().get(k));
                        auxiliar.put(j, proteina.getComidas().get(j));
                        auxiliar.put(i, carboidrato.getComidas().get(i));
                        opcoes.add(auxiliar);
                    }
                }
            }
        }
        return opcoes;
    }
    
    public void criarDietaTeste(Alimento carboidrato, 
        Alimento proteina, Alimento fruta, 
        double quantidadeCalorica){
        for(String i: carboidrato.getComidas().keySet()){
            for(String j: proteina.getComidas().keySet()){
                for(String k: fruta.getComidas().keySet()){
                    if(fruta.getComidas().get(k) +
                            proteina.getComidas().get(j) +  
                            carboidrato.getComidas().get(i) < quantidadeCalorica){
                        HashMap<String, Double> auxiliar=new HashMap<>();
                        auxiliar.put(k, fruta.getComidas().get(k));
                        auxiliar.put(j, proteina.getComidas().get(j));
                        auxiliar.put(i, carboidrato.getComidas().get(i));
                        setDieta(auxiliar);
                    }
                }
            }
        }
    }
}
