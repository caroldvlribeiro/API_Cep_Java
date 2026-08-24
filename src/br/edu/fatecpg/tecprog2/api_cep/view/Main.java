package br.edu.fatecpg.tecprog2.api_cep.view;

import br.edu.fatecpg.tecprog2.api_cep.model.Endereco;
import br.edu.fatecpg.tecprog2.api_cep.service.ConsomeApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);
        ArrayList<Endereco> historico = new ArrayList<>();
        int opcao;
        boolean loop = true;

        while (loop) {
            System.out.println("\n*API DE CONSULTA DE CEP* " +
                    "\n1 - Consultar CEP " +
                    "\n2 - Ver Consultados " +
                    "\n3 - Limpar Histórico " +
                    "\n4 - Sair " +
                    "\nDigite sua opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite seu CEP: ");
                    String cep = sc.nextLine();
                    String endCompleto = ConsomeApi.buscaEndereco(cep);
                    Endereco objEndereco = gson.fromJson(endCompleto, Endereco.class);
                    historico.add(objEndereco);
                    System.out.println("\nCEP: "+objEndereco.getCep()
                            +"\nLogradouro: "+objEndereco.getLogradouro()
                            +"\nBairro: "+ objEndereco.getBairro()
                            +"\nLocalidade: "+ objEndereco.getLocalidade()
                            +"\nEstado: "+ objEndereco.getEstado());
                    System.out.println("\n"+objEndereco);
                    break;
                case 2:
                    System.out.println("\nHISTÓRICO");
                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma consulta realizada!");
                    } else {
                        for (Endereco endereco : historico) {
                            System.out.println(endereco);
                        }
                    }
                    break;
                case 3:
                    if (historico.isEmpty()) {
                        System.out.println("Você não tem histórico para limpar!");
                    } else {
                        historico.clear();
                        System.out.println("Histórico limpo!");
                    }
                    break;
                case 4:
                    loop = false;
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}