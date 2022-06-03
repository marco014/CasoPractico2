package com.upchiapas.casopractico2;

import com.upchiapas.casopractico2.models.Participante;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    static int contador = 0;
    public static void main(String[] args){
        visualizarRegistro();
    }
    public static void visualizarRegistro(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        LinkedList <Participante> participantes = new LinkedList<Participante>();//ocupar una sola lista para guardar el objeto
        LinkedList <Participante> seccionPlantaBaja = new LinkedList<Participante>();
        do{
            System.out.println("*** Expo Gastronomica ***");
            System.out.println("Seleccione una de las sisguientes opciones: ");
            System.out.println("1. Registrar Participante");
            System.out.println("2. Visualizar Folio y Seccion Asignada");
            System.out.println("3. Salir del Programa");
            opcion=entrada.nextInt();

            switch (opcion) {
                case 1:
                    agregar(participantes, seccionPlantaBaja);//pasar como parametro mis listas
                    break;
                case 2:
                    visualizar(participantes, seccionPlantaBaja);//pasar como parametro mis listas
                    break;
                case 3:
                    System.out.println("Usted esta saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion Invalida, Vuelva a Intentarlo");
            }
        }while (opcion!=3);
    }
    public static void agregar(LinkedList<Participante> participantes, LinkedList<Participante> seccionPlantaBaja){
        Scanner teclado = new Scanner(System.in);
        String Participante;
        String lugarOrigen;
        boolean respuesta;
        String folio;
        System.out.println("Ingresa el nombre del participante: ");
        System.out.print("Participante: ");
        Participante = teclado.next();
        System.out.print("Lugar de Origen: ");
        lugarOrigen = teclado.next();
        do{
            int numero = (int)(Math.random()*899+100);
            folio = Integer.toString(numero);
            respuesta = buscarFolio(participantes, seccionPlantaBaja, folio);
        }while(respuesta == true);//se repetira hasta que encuentre un valor diferente
        System.out.print("Folio: ");
        System.out.println(folio);
        contador = contador+1;
        if (contador==6){
            contador = 1;
        }
        System.out.print("Seccion Asignada: ");
        System.out.println(contador);
        if (participantes.size()<5){
            participantes.add(new Participante(Participante, folio, lugarOrigen, contador));
        }else if (seccionPlantaBaja.size()<3){
            seccionPlantaBaja.add(new Participante(Participante, folio, lugarOrigen, contador));
        } else if (seccionPlantaBaja.size()==3){
            System.out.println("Cupos llenos...");
        } else{
            System.out.println("Cupos llenos...");
        }
    }
    public static void visualizar(LinkedList<Participante> participantes, LinkedList<Participante> seccionPlantaBaja){
        System.out.println("*** Participantes Registrados***");
        System.out.println("-- Planta Alta --");
        for (int i=0; i<participantes.size();i++){
            System.out.println(participantes.get(i));
        }
        System.out.println("-- Planta Baja --");
        for (int i=0; i<seccionPlantaBaja.size();i++){
            System.out.println(seccionPlantaBaja.get(i));
        }
    }
    public static boolean buscarFolio(LinkedList<Participante> participantes, LinkedList<Participante> seccionPlantaBaja, String folio){
        //busca el folio generado, y que no este repetido
        for (Participante folios: participantes){
            if (folios.getFolio().equals(folio)){
                return true;
            }
        }
        return false;
    }
}