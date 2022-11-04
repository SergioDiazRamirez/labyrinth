/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labyrinth;

/**
 *
 * @author sdiazram
 */
public class Position {
    public int i, j;
    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Position(Position p) {
        this.i = p.i;
        this.j = p.j;
    }
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Position) {
            return this.equals((Position)o);
        }
        return false;
    }
    public boolean equals(Position p) {
        return (i == p.i && j == p.j);
    }
    
    public String toString() {
        return new String("("+i+", "+j+")");
    }
}
