package com.upchiapas.casopractico2;

import com.upchiapas.casopractico2.models.Participante;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int contador = 0;
    static boolean bandera = false;
    static boolean bandera2 = false;
    //llamamos al constructor vacio
    public Participante individuo = new Participante();


    public static void main(String[] args){
        visualizarRegistro();
    }
    public static void visualizarRegistro(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        LinkedList <String> participantes = new LinkedList<String>();
        LinkedList <Integer> folios = new LinkedList<Integer>();
        LinkedList <Integer> seccionesPlantaAlta = new LinkedList<Integer>();
        LinkedList <Integer> seccionesPlantaBaja = new LinkedList<Integer>();
        do{
            System.out.println("*** Expo Gastronomica ***");
            System.out.println("Seleccione una de las sisguientes opciones: ");
            System.out.println("1. Registrar Participante");
            System.out.println("2. Visualizar Folio y Seccion Asignada");
            System.out.println("3. Salir del Programa");
            opcion=entrada.nextInt();

            switch (opcion) {
                case 1:
                    if (participantes.size()<5){
                        agregar(participantes, folios, seccionesPlantaAlta);
                    }else{
                       if (participantes.size()==5)
                       {
                           bandera = true;
                           contador = 0;
                           agregar(participantes, folios, seccionesPlantaBaja);
                       } else{
                           if(participantes.size() < 8)
                           {
                               agregar(participantes, folios, seccionesPlantaBaja);
                           }else{
                               System.out.println("Cupos llenos");
                           }
                       }

                    }

                    break;
                case 2:
                    visualizar(participantes, folios, seccionesPlantaAlta);
                    visualizar(participantes, folios, seccionesPlantaBaja);
                    break;
                case 3:
                    System.out.println("Usted esta saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion Invalida, Vuelva a Intentarlo");
            }
        }while (opcion!=3);
    }

    public static void agregar(LinkedList<String> participantes, LinkedList<Integer> folios, LinkedList<Integer> secciones){
        Scanner teclado = new Scanner(System.in);
        String Participante;
        String lugarOrigen;
        System.out.println("Ingresa el nombre del participante: ");
        System.out.print("Participante: ");
        Participante = teclado.next();
        participantes.add(Participante);
        System.out.print("Lugar de Origen: ");
        lugarOrigen = teclado.next();
        int numero = (int)(Math.random()*899+100);
        while (folios.contains(numero)){
            numero= (int)(Math.random()*899+100);
        }
        System.out.print("Folio: ");
        System.out.println(numero);
        folios.add(numero);
        int numero2 = ++contador;
        System.out.print("Seccion Asignada: ");
        System.out.println(numero2);
        secciones.add(numero2);
    }

    public static void visualizar(LinkedList<String> participantes, LinkedList<Integer> folios, LinkedList<Integer> secciones){
        int folio = 0;
        System.out.println("*** Participantes Registrados***");
        if(!bandera2)
        {
            for (int i=0; i<5; i++){
                System.out.print("Participante: ");
                System.out.println(participantes.get(i));
                System.out.print("Folio: ");
                System.out.println(folios.get(i));
                System.out.println("** Seccion **");
                System.out.println("Planta Alta: "+ secciones.get(i));
                bandera2 = true;
            }
        }else{

            for (int i=5; i<8; i++){
                int j = i-5;
                System.out.print("Participante: ");
                System.out.println(participantes.get(i));
                System.out.print("Folio: ");
                System.out.println(folios.get(i));
                System.out.println("** Seccion **");
                System.out.println("Planta Baja: "+ secciones.get(j));
            }
        }
    }
}