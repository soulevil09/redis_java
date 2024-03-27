package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:jCtFo5hZqkAFEKj3R9PDjB7K4R7SrSj6@redis-10830.c308.sa-east-1-1.ec2.cloud.redislabs.com:10830");
        Connection connection = jedis.getConnection();
        Scanner scan = new Scanner(System.in);

        connection.connect();

        System.out.println("Adicionar uma tarefa: ");
        System.out.println("Digite o numero da tarefa: ");
        String id = scan.nextLine();
        System.out.println("Digite a tarefa: ");
        String Tarefa = scan.nextLine();
        System.out.println("Digite o status");
        String Status = scan.nextLine();

        String user1 = "{Tarefa:1 '" + Tarefa + "' ,Descricao:'" + Status + "',id:'" + id + "'}";
        jedis.set("Tarefa:1", user1);
        System.out.println(jedis.get("Tarefa:1"));

        System.out.println("Deseja atualizar os status?, sim:1 , não:2 : ");
        String escolha = scan.nextLine();

        if (escolha.equals("a")) {

            System.out.println("Digite o novo status: ");
            String status2 = scan.nextLine();
            String user2 = "{Tarefa:1 '" + Tarefa + "' ,Descricao:'" + status2 + "',id:'" + id + "'}";
            jedis.set("Tarefa:1", user2);
            System.out.println("fugiu");

        } else {

            System.out.println("o que você deseja");
            System.out.println("listar: 1");
            System.out.println("Deletar: 2");

            int opcao = scan.nextInt();
            if (opcao == 1) {

                System.out.println(jedis.keys("Tarefa:*"));

            } else if (opcao == 2) {
                jedis.del("Tarefa1:");
                System.out.println(jedis.get("Tarefa:1"));
            }

            jedis.close();



        }

    }
}
