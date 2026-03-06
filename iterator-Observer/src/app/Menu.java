package app;

import observable.YouTubeChannel;
import java.util.Scanner;

public class Menu {

    // Objeto que representa el canal de YouTube
    private YouTubeChannel channel;

    // Scanner para leer datos desde la terminal
    private Scanner input;

    /**
     * Constructor de la clase Menu.
     * Inicializa el canal y el lector de datos.
     */
    public Menu() {
        this.channel = new YouTubeChannel();
        this.input = new Scanner(System.in);
    }

    /**
     * Inicia el menú principal del sistema.
     * 
     * Muestra las opciones disponibles y mantiene el programa
     * en ejecución hasta que el usuario seleccione salir.
     */
    public void start() {

        int option;

        do {
            System.out.println("YouTube Channel");
            System.out.println("1. Add Subscriber");
            System.out.println("2. Remove Subscriber");
            System.out.println("3. Show Subscribers");
            System.out.println("4. Publish Video");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            // Lee la opción ingresada por el usuario
            option = input.nextInt();
            input.nextLine();

            // Ejecuta la acción correspondiente
            handleOption(option);

        } while (option != 0);

        System.out.println("End");
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     * 
     * @param option número de opción elegida en el menú
     */
    private void handleOption(int option) {

        switch (option) {

            // Agregar un nuevo suscriptor
            case 1:
                System.out.print("Enter subscriber name: ");
                channel.addSubscriber(input.nextLine());
                System.out.println("Subscriber added!");
                break;

            // Eliminar un suscriptor existente
            case 2:
                System.out.print("Enter subscriber name to remove: ");
                channel.removeSubscriber(input.nextLine());
                break;

            // Mostrar todos los suscriptores
            case 3:
                channel.showSubscribers();
                break;

            // Publicar un nuevo video
            case 4:
                System.out.print("Enter video title: ");
                channel.publishVideo(input.nextLine());
                break;

            // Salir del programa
            case 0:
                break;

            // Opción inválida
            default:
                System.out.println("Invalid option.");
        }
    }
}