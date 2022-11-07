/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labyrinth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author sdiazram
 */
public class Labyrinth {

    char[][] labyrinth;
    Position myPosition;
    Position endPosition;
    ArrayDeque<Position> path = new ArrayDeque<Position>();
    HashSet<Position> visited = new HashSet<Position>();

    public Labyrinth(String file, int height, int width, Position startPosition, Position endPosition) throws FileNotFoundException {
        this.labyrinth = new char[height][width];
        this.endPosition = endPosition;
        myPosition = startPosition;
        path.add(new Position(startPosition));
        visited.add(new Position(startPosition));
        
        File doc = new File(file);
        Scanner sc = new Scanner(doc);
        String line;
        int i = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            char[] cLine = line.toCharArray();
            
            int j = 0;
            while(j < line.length()) {
                labyrinth[i][j] = cLine[j];
                j++;
            }
            i++;
        }
    }
    
    public ArrayDeque<Position> solve() {
        boolean solved = false;
        while(!solved) {
            //Si puede ir a la derecha
            Position nextPosition = new Position(myPosition.i, myPosition.j+1);
            if( (!visited.contains(nextPosition) && labyrinth[myPosition.i][myPosition.j+1] == ' ')
                    || labyrinth[myPosition.i][myPosition.j+1] == 'S') {

//                labyrinth[myPosition.i][myPosition.j] = '*';
                myPosition.j = myPosition.j + 1;
                path.add(new Position(myPosition));
                visited.add(new Position(myPosition));
                if(myPosition.equals(endPosition))
                {
                    solved = true;
                }
            }
            //Si puedo ir abajo
            else if( (!visited.contains(new Position(myPosition.i+1, myPosition.j)) && labyrinth[myPosition.i+1][myPosition.j] == ' ')
                    || labyrinth[myPosition.i+1][myPosition.j] == 'S') {
//                labyrinth[myPosition.i][myPosition.j] = '*';
                myPosition.i = myPosition.i + 1;
                path.add(new Position(myPosition));
                visited.add(new Position(myPosition));
                if(myPosition.equals(endPosition))
                {
                    solved = true;
                }
            }
            //Si puedo ir a la izquierda
            else if( (!visited.contains(new Position(myPosition.i, myPosition.j-1)) && labyrinth[myPosition.i][myPosition.j-1] == ' ')
                    || labyrinth[myPosition.i][myPosition.j-1] == 'S') {
//                labyrinth[myPosition.i][myPosition.j] = '*';
                myPosition.j = myPosition.j - 1;
                path.add(new Position(myPosition));
                visited.add(new Position(myPosition));
                if(myPosition.equals(endPosition))
                {
                    solved = true;
                }
            }
            //Si puedo ir arriba
            else if( (!visited.contains(new Position(myPosition.i-1, myPosition.j)) && labyrinth[myPosition.i-1][myPosition.j] == ' ')
                    || labyrinth[myPosition.i-1][myPosition.j] == 'S') {
//                labyrinth[myPosition.i][myPosition.j] = '*';
                myPosition.i = myPosition.i - 1;
                path.add(new Position(myPosition));
                visited.add(new Position(myPosition));
                if(myPosition.equals(endPosition))
                {
                    solved = true;
                }
            }
            //Si no puedo moverme, deshacemos camino
            else {
                path.pollLast(); //posicion en la que nos encontramos
//                visited.remove(myPosition);
                myPosition = new Position(path.peekLast()); //posicion a la que queremos volver
//                visited.remove(myPosition);
//                labyrinth[myPosition.i][myPosition.j] = ' '; //despejamos la posicion para poder volver
            }
        }
        return path;
   
    }

    public void printSolution(ArrayDeque<Position> path) {
        System.out.println("Camino:");
        int i = 0;
        while(!path.isEmpty()) {
            Position position = path.pollFirst();
            System.out.print("("+ position.i +", " + position.j +"); ");
            if(i==10) {
                System.out.println();
                i=0;
            }
            i++;
        } 
    }
    
    public void printPath() {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if(path.contains(new Position(i,j)))
                    System.out.print('*');
                else
                    System.out.print(labyrinth[i][j]);
            }  
            System.out.println();
        }      
    }
    
    public void print() {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                System.out.print(labyrinth[i][j]);
            }  
            System.out.println();
        }
    }
}