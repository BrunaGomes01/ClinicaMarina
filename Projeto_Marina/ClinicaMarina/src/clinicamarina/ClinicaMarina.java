package clinicamarina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ClinicaMarina {
    
    public static void inicializarVariaveis(
        ArrayList <Paciente> pacientesCadastrados,
        Alimento carboidratos, Alimento proteinas,
        Alimento frutasVerduras){
        
            Teste variaveis = new Teste();
            variaveis.Grupos(carboidratos, proteinas, frutasVerduras);
            variaveis.Pacientes(pacientesCadastrados);
            variaveis.Consultas(pacientesCadastrados, carboidratos, 
                proteinas, frutasVerduras);
    }
    
    public static int menu(int opcao, Scanner input){
        System.out.println("Digite a opção desejada:\n"
                                + "1. Adicionar paciente\n"
                                + "2. Adicionar consulta \n"
                                + "3. Listar pacientes \n"
                                + "4. Listar consulta dos pacientes \n"
                                + "5. Adicionar alimento \n"
                                + "6. Listar Alimentos \n"
                                + "7. Sair");
        opcao = input.nextInt();
        clearBuffer(input);
        return opcao;   
    }
    
    private static void opcaoEscolhida(int opcao, Scanner input,
        ArrayList <Paciente> pacientesCadastrados,
        Alimento carboidratos, Alimento proteinas,
        Alimento frutasVerduras){
        
        switch(opcao){
            case 1:
                System.out.println("Digite o nome do(a) paciente");
                String nome=input.nextLine();
                System.out.println("Digite o endereço do(a) " + nome);
                String endereco=input.nextLine();
                System.out.println("Digite o telefone fixo do(a) " + nome);
                String telefoneFixo=input.nextLine();
                System.out.println("Digite o telefone celular do(a) " + nome);
                String telefoneCelular=input.nextLine();
                System.out.println("Digite o email do(a) " + nome);
                String email=input.nextLine();
                System.out.println("Digite a data de nascimento do(a) " + nome);
                String dataNascimento=input.nextLine();
                Paciente novoPaciente=new Paciente(nome, endereco, telefoneFixo,
                telefoneCelular, email, dataNascimento);
                pacientesCadastrados.add(novoPaciente);
                break;
            
            case 2:
                int indice=1;
                System.out.println("Pacientes");
                for(Paciente i: pacientesCadastrados){
                    System.out.println(indice + "º - " + i.getNome());
                    indice++;
                }
                System.out.println("Digite o número do(a) paciente");
                int numeroPaciente=input.nextInt();
                clearBuffer(input);
                nome = pacientesCadastrados.get(numeroPaciente-1).getNome();
                System.out.println("Digite a data da consulta");
                String data=input.nextLine();
                System.out.println("Digite a hora da consulta");
                String horario=input.nextLine();
                System.out.println("Digite o peso do(a) " + nome);
                double peso=input.nextDouble();
                clearBuffer(input);
                System.out.println("Digite a porcentagem de gordura corporea do(a) " + nome);
                double gordura=input.nextDouble();
                clearBuffer(input);
                System.out.println("Digite o sensação física do(a) " + nome);
                String sensacao=input.nextLine();        
                System.out.println("Digite as retrições do(a) " + nome);
                String restricao=input.nextLine();
                Consulta novaConsulta = pacientesCadastrados.get(numeroPaciente-1)
                        .adicionarConsuta(data, horario, peso, 
                                gordura, sensacao, restricao);
                System.out.println("Digite a quantidade "
                        + "máxima de calorias que " + nome + " pode consumir" );
                double calorias=input.nextDouble();
                ArrayList<HashMap> dietas = new ArrayList<>();
                dietas = novaConsulta.criarDieta(carboidratos, proteinas,
                        frutasVerduras, calorias);
                indice=1;
                for(HashMap l : dietas ){
                    System.out.println("\n");
                    System.out.println(indice + "º Opção");
                    for(Object m: l.keySet()){
                        System.out.println(m + " - " + l.get(m));
                    }
                    System.out.println("\n");
                    indice++;
                }
                System.out.println("Digite o número da dieta que deseja");
                int dietaEscolhida=input.nextInt();
                clearBuffer(input);
                novaConsulta.setDieta(dietas.get(dietaEscolhida-1));
                break; 
                
            case 3:
                indice=1;
                for(Paciente i: pacientesCadastrados){
                    System.out.println(indice + "º Paciente ");
                    System.out.println("Nome: " + i.getNome());
                    System.out.println("Data de Nascimento: " + i.getDataNascimento());
                    System.out.println("Telefone Fixo: " + i.getTelefoneFixo());
                    System.out.println("Telefone Celular: " + i.getTelefoneCelular());
                    System.out.println("Email: " + i.getEmail());
                    System.out.println("Endereço: " + i.getEndereco());
                    System.out.println("\n");
                    indice++;
                }
                break; 
            
            case 4: 
                indice=1;
                for(Paciente i: pacientesCadastrados){
                    System.out.println(indice +"º Paciente " );
                    System.out.println("Nome: " + i.getNome());
                    System.out.println("\n");
                    i.listarConsultas();
                    indice++;
                }
                break;
                
            case 5:

                System.out.println("Digite nome do alimento");
                String alimento=input.nextLine();
                System.out.println(alimento + " tem quantas calorias?");
                calorias=input.nextDouble();
                clearBuffer(input);
                System.out.println("Digite o número correspondente "
                        + "ao grupo no qual " + alimento + " pertece");
                System.out.println("1º Carboidratos");
                System.out.println("2º Proteinas");
                System.out.println("3º Frutas e Verduras");
                int grupo=input.nextInt();
                clearBuffer(input);
                switch(grupo){
                    case 1:
                        carboidratos.adicionarComida(alimento, calorias);
                        break;
                    case 2:
                        proteinas.adicionarComida(alimento, calorias);
                        break;
                    case 3:
                        frutasVerduras.adicionarComida(alimento, calorias);
                        break;
                } 

                break;
                   
            case 6:
                System.out.println("Carboidratos");
                for(String i: carboidratos.getComidas().keySet()){
                    System.out.println(i + " - " + carboidratos.getComidas().get(i));
                }
                System.out.println("\n");
                System.out.println("Proteinas");
                for(String i: proteinas.getComidas().keySet()){
                    System.out.println(i + " - " + proteinas.getComidas().get(i));
                }
                System.out.println("\n");
                System.out.println("Frutas e Verduras");
                for(String i: frutasVerduras.getComidas().keySet()){
                    System.out.println(i + " - " + frutasVerduras.getComidas().get(i));
                }
                System.out.println("\n");
                break;
            case 7: 
                break;  
                
                
                
                
        }
            
    }
    
    private static void clearBuffer(Scanner scanner) {
      if (scanner.hasNextLine()) {
          scanner.nextLine();
        }
    }
    
    public static void main(String[] args) {
        ArrayList <Paciente> pacientesCadastrados = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        Alimento carboidratos = new Alimento();
        Alimento proteinas = new Alimento();
        Alimento frutasVerduras = new Alimento();
        
        inicializarVariaveis(pacientesCadastrados, carboidratos, 
                proteinas, frutasVerduras);

        int opcao=0;
        do{
            opcao = menu(opcao, input);
            opcaoEscolhida(opcao, input, pacientesCadastrados,
                    carboidratos, proteinas, frutasVerduras);
        }while(opcao != 7);
        
    }
    

    
}
