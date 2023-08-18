package com.tarefa.parte2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja adicionar um nome?");
        String resposta = sc.nextLine();

        List<String> listaM = new ArrayList<>();
        List<String> listaF = new ArrayList<>();

        while (resposta.equalsIgnoreCase("Sim")) {
            System.out.println("Digite o nome e o sexo da pessoa (Mateus-M):");
            String nome = sc.nextLine();
            String[] nomeSplit = nome.split("-");
            if(nomeSplit[1].contains("M")) {
                listaM.add(nome);
            } else if (nomeSplit[1].contains("F")){
                listaF.add(nome);
            }
            System.out.println("Deseja adicionar outro nome?");
            resposta = sc.nextLine();
        }

        Collections.sort(listaM);
        Collections.sort(listaF);

        System.out.println("Lista de pessoas do sexo masculino: " + listaM);
        System.out.println("Lista de pessoas do sexo feminino: " + listaF);

        sc.close();

    }
}
