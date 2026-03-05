/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import observable.YouTubeChannel;
import java.util.Scanner;

public class Menu {

    private YouTubeChannel channel;
    private Scanner input;

    public Menu() {
        this.channel = new YouTubeChannel();
        this.input = new Scanner(System.in);
    }

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

            option = input.nextInt();
            input.nextLine();

            handleOption(option);

        } while (option != 0);

        System.out.println("End");
    }

    private void handleOption(int option) {

        switch (option) {
            case 1:
                System.out.print("Enter subscriber name: ");
                channel.addSubscriber(input.nextLine());
                System.out.println("Subscriber added!");
                break;
            case 2:
                System.out.print("Enter subscriber name to remove: ");
                channel.removeSubscriber(input.nextLine());
                break;

            case 3:
                channel.showSubscribers();
                break;

            case 4:
                System.out.print("Enter video title: ");
                channel.publishVideo(input.nextLine());
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}