/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labyrinth;

import java.util.ArrayDeque;

/**
 *
 * @author sdiazram
 */
public class Main {
    public static void main(String[] args) {
                try {
//            Labyrinth labyrinth = new Labyrinth("C:\\Users\\sdiazram\\Desktop\\laberinto1.txt", 11, 40, 
//                new Position(0,1), new Position(10, 38));
            Labyrinth labyrinth = new Labyrinth("C:\\Users\\sdiazram\\Desktop\\laberinto.txt", 6, 10, 
                new Position(0,2), new Position(5, 1));
            
            labyrinth.print();
            ArrayDeque<Position> path = labyrinth.solve();
            System.out.println();
            labyrinth.print();
            labyrinth.printSolution(path);
            
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
