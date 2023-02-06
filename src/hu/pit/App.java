package hu.pit;

import hu.pit.controller.PitService;
import hu.pit.model.service.Console;
import hu.pit.model.service.DataApi;
import hu.pit.model.service.DataParser;
import hu.pit.model.service.FileReader;
import hu.pit.model.service.FileWriter;

import java.util.Scanner;

public class App {

    private final PitService service;
    private final Console console;
    private final FileWriter fileWriter;

    private App() {
        console = new Console(new Scanner(System.in));
        fileWriter = new FileWriter("godrok.txt");
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        service = new PitService(dataApi.getData("melyseg.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat");
        System.out.println("A fájl adatainak száma: " + service.getDepthCount());
        System.out.println("2. feladat");
        System.out.print("Adjon meg egy távolságértéket! ");
        int distance = console.read() - 1;
        System.out.println("Ezen a helyen a felszín " +
                service.getDepthAtCertainDistance(distance) +
                " méter mélyen van.");
    }


}
