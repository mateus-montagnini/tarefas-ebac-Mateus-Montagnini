package com.tarefa.parte1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja adicionar um nome?");
        String resposta = sc.nextLine();

        List<String> lista = new ArrayList<>();

        while (resposta.equalsIgnoreCase("Sim")) {
            System.out.println("Digite o nome da pessoa:");
            String nome = sc.nextLine();
            lista.add(nome);
            System.out.println("Deseja adicionar outro nome?");
            resposta = sc.nextLine();
        }

        Collections.sort(lista);
        System.out.println(lista);

        sc.close();
    }
}
