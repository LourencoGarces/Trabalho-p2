package Backend;

import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeRede {
        public static List<Equipamentos> construirRede() {
                // Criação de dispositivosDispositivoTerminal computador1 = new DispositivoTerminal("Computador1", "192.168.1.1", "00:1A:2B:3C:4D:5E");
                Terminal computador2 = new Terminal("Computador2", "192.168.1.2", "00:2A:3B:4C:5D:6E");

                Switch switch1 = new Switch("Switch1", "1", 2);
                Router roteador1 = new Router("Roteador1", "1", "00:4A:5B:6C:7D:8E");
                Servidor servidor1 = new Servidor("Servidor", "1", 10);

                // Criação de conexões
                Ligacao conexao2 = new Ligacao(computador2, switch1);
                Ligacao conexao3 = new Ligacao(switch1, roteador1);
                Ligacao conexao4 = new Ligacao(roteador1, servidor1);

                // Construção da lista de dispositivos
                List<Equipamentos> dispositivos = new ArrayList<>();
                dispositivos.add(computador2);
                dispositivos.add(switch1);
                dispositivos.add(roteador1);
                dispositivos.add(servidor1);

                // Adição das conexões entre dispositivos
                List<Ligacao> conexoes = new ArrayList<>();
                conexoes.add(conexao2);
                conexoes.add(conexao3);
                conexoes.add(conexao4);
                return dispositivos;
        }

        private static void imprimirRede(List < Equipamentos > dispositivos, List < Ligacao > conexoes){
                System.out.println("Dispositivos de Rede:");
                for (Equipamentos dispositivo : dispositivos) {
                        System.out.println("- " + dispositivo);
                }

                System.out.println("\nConexões:");
                for (Ligacao conexao : conexoes) {
                        System.out.println("- " + conexao);
                }
        }


}



