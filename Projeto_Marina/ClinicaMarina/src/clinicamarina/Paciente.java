package clinicamarina;

import java.util.ArrayList;

public class Paciente {
    private String nome;
    private String endereco;
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;
    private String dataNascimento;
    private ArrayList <Consulta> consulta;
    
    public Paciente() {
        this.nome = "";
        this.endereco = "";
        this.telefoneFixo = "";
        this.telefoneCelular = "";
        this.email = "";
        this.dataNascimento = "";
        this.consulta = new ArrayList <>();
    }

    public Paciente(String nome, String endereco, String telefoneFixo, 
            String telefoneCelular, String email, String dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.consulta = new ArrayList <>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(ArrayList<Consulta> consulta) {
        this.consulta = consulta;
    }
    
    public Consulta adicionarConsuta(
            String data, String hora, 
            double peso, double gordura, 
            String sencacoes, String restricoes){
        Consulta novaConsulta = new Consulta(data,hora,peso,
                gordura,sencacoes,restricoes);
        consulta.add(novaConsulta);
        return novaConsulta;
        
       
    }
    
    public void listarConsultas(){
        int indice=1;
        for(Consulta i: consulta){
            System.out.println("Consulta " +indice+"º");
            System.out.println("Data: " + i.getData());
            System.out.println("Hora: "  + i.getPeso() + "kg");
            System.out.println("Porcentagem de gordura: " + i.getGordura() + "%");
            System.out.println("Sensações: " + i.getSensacao());
            System.out.println("Restrições: " + i.getRestricoes());
            System.out.println("Dieta: ");
            for(String j: i.getDieta().keySet()){
                System.out.println(j + " - " + i.getDieta().get(j));
            }
            System.out.println("\n");
            indice++;
        }
    }
    
}
