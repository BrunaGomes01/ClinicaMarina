package clinicamarina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Teste {
    public void Grupos(Alimento carboidratos, 
            Alimento proteinas, Alimento frutasVerduras ){
        
        carboidratos.adicionarComida("Arroz", 160.0);
        carboidratos.adicionarComida("Macarrão", 230.0);
        carboidratos.adicionarComida("Biscoito", 80.0);
        carboidratos.adicionarComida("Cereal", 30.0);
        carboidratos.adicionarComida("Batata", 100.0);
        
        proteinas.adicionarComida("Iorgute", 130.0);
        proteinas.adicionarComida("Carne", 300.0);
        proteinas.adicionarComida("Leite", 150.0);
        proteinas.adicionarComida("Queijo", 50.0);
        proteinas.adicionarComida("Ovo", 40.0);
        
        frutasVerduras.adicionarComida("Mamão", 50.0);
        frutasVerduras.adicionarComida("Pera", 140.0);
        frutasVerduras.adicionarComida("Melancia", 380.0);
        frutasVerduras.adicionarComida("Maça", 70.0);
        frutasVerduras.adicionarComida("Banana", 10.0);
    }
    
    public void Pacientes(ArrayList <Paciente> pacientesCadastrados){
        Paciente number1 = new Paciente(
                "Bruna Gomes Camilo", 
                "Rua Vereador Orlando Pacheco",
                "33335984", "995489890", 
                "brunagomescamilo@gmail.com", "01/09/2000");
        Paciente number2 = new Paciente(
                "Carlos Moreira Nunes",
                "Rua Erechim",
                "32669044", "895422317",
                "carlosmoreira@gmail.com", "26/03/1958");
                
        Paciente number3 = new Paciente(
                "Gleice Antunes Faria",
                "Rua Holanda",
                "31915322", "994237759", 
                "gleiceafarias@gmail.com", "07/06/1981"); 
        
        pacientesCadastrados.add(number1);
        pacientesCadastrados.add(number2);
        pacientesCadastrados.add(number3);
        
    }
    
    public void Consultas(ArrayList <Paciente> pacientesCadastrados,
        Alimento carboidrato, Alimento proteina, Alimento fruta){
            Random gerador = new Random();
            Consulta novaConsulta = new Consulta();
            //HashMap<String, Double> dieta = new HashMap<>();
            for(Paciente i : pacientesCadastrados){
                HashMap<String, Double> dieta = new HashMap<>();
                novaConsulta = i.adicionarConsuta("02/02/2020", "07:00", 
                        gerador.nextInt(200) + 1, gerador.nextInt(100) + 1, 
                        "Dor de cabeça", "Carne");
                novaConsulta.criarDietaTeste(carboidrato, proteina, fruta, 
                        gerador.nextInt(500) + 100);
                novaConsulta= i.adicionarConsuta("05/06/2020", "08:30", 
                         gerador.nextInt(200) + 1, gerador.nextInt(100) + 1, 
                        "Dor nas costas", "Doce");
                novaConsulta.criarDietaTeste(carboidrato, proteina, fruta, 
                        gerador.nextInt(500) + 100);
                novaConsulta = i.adicionarConsuta("27/12/2020", "09:00", 
                         gerador.nextInt(200) + 1, gerador.nextInt(100) + 1,
                        "Torceu o pé", "Lactose");
                novaConsulta.criarDietaTeste(carboidrato, proteina, fruta, 
                        gerador.nextInt(500) + 100);
            }
    }
    
}
