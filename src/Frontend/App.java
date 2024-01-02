package Frontend;
import Backend.Rede;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
    public class App {
        public static void main(String[] args){
            Scanner teclado = new Scanner(System.in);
            Map<String,Rede> redes = new HashMap<String, Rede>();
            int opcao;
            do{
                menu();
                opcao = teclado.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o seu MAC: ");
                        String mac = teclado.next();
                        System.out.print("Digite o seu IP: ");
                        String ip = teclado.next();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        break;
                }
            }while (opcao != 0);
        }
        public static void menu(){
            System.out.println("=== Simulador de Rede ===");
            System.out.println("1. Configurar Rede");
            System.out.println("2. Enviar Dados");
            System.out.println("3. Gravar Configuração da Rede");
            System.out.println("4. Gravar Registro de Envio de Dados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
        }
    }


