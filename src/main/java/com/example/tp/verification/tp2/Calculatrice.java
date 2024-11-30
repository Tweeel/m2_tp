package com.example.tp.verification.tp2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Calculatrice {
    public static double racineCarree(int x) throws IllegalArgumentException{
        if (x <= 0){
            throw new IllegalArgumentException("Impossible de calculer la racine carree d'un nombre negative");
        } else {
            return sqrt(x);
        }
    }
    public static double diviser(int x, int y) throws IllegalArgumentException{
        if (y==0){
            throw new IllegalArgumentException("impossible de diviser par 0");
        } else {
            return x/y;
        }
    }

    public static List<Double> racineCarreeDansInterval(int a, int b) throws IllegalArgumentException{
        if (a < 0 || b < 0){
            throw new IllegalArgumentException("Impossible de calculer la racine carree d'un nombre negative");
        } else if (a > b){
            throw new IllegalArgumentException("a doit etre inferieur ou egal a b");
        } else {
            List<Double> result = new ArrayList<>();
            for (int i = a; i <= b; i++){
                result.add(racineCarree(i));
            }
            return result;
        }
    }

    public static int[][] matriceAleatoire(int M, int N, int A, int B) throws IllegalArgumentException{
        if (M <= 0 || N <= 0){
            throw new IllegalArgumentException("M et N doivent etre superieur a 0");
        } else if (A > B){
            throw new IllegalArgumentException("A doit etre inferieur ou egal a B");
        } else {
            int[][] result = new int[M][N];
            for (int i = 0; i < M; i++){
                for (int j = 0; j < N; j++){
                    result[i][j] = (int) (Math.random() * (B - A + 1) + A);
                }
            }
            return result;
        }
    }
}