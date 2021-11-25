package eda;


import java.io.IOException;
import java.util.HashMap;


public class main {
    public static void main(String[] args) throws IOException{



        boolean finalizar=false;
        while (!finalizar) {



            System.out.println("---------------------------------------------------------------");
            System.out.println("------------------     < Menu principal >     -----------------");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Selecciona una de las siguientes opciones: ");
            System.out.println();
            System.out.println(" n. de opcion - Funcion");
            System.out.println("     ------------------------------------------------------------");
            System.out.println("     -->> 0.-   Cargar los datos");
            System.out.println("     -->> 1.-   Buscar actor/ actriz");
            System.out.println("     -->> 2.-   Anadir actor/ actriz");
            System.out.println("     -->> 3.-   Añadir pelicula a un actor");
            System.out.println("     -->> 4.-   Obtener las peliculas de un actor/ actriz");
            System.out.println("     -->> 5.-   Obtener los actores/ actrices de una pelicula");
            System.out.println("     -->> 6.-   Buscar pelicula");
            System.out.println("     -->> 7.-   Eliminar pelicula");
            System.out.println("     -->> 8.-   Incrementar la recaudacion de una pelicula");
            System.out.println("     -->> 9.-   Eliminar un actor/ actriz");
            System.out.println("     -->> 10.-  Guardar los datos en un fichero");
            System.out.println("     -->> 11.-  Obtener una lista ordenada  de actores");
            System.out.println("     -->> 12.-  Finalizar el programa");
            System.out.println("     __________________________________________________________");
            System.out.println();
            System.out.println();
            System.out.println("---------------------------------------------------------------");


            int option = Teclado.getMiTeclado().leerEntero(0, 12);
            // entrada de una cadena

            switch (option) {
                case 0:
                    Reloj miReloj=new Reloj();
                    ListaActores.getMiLista().cargarLista();
                    System.out.println("fin de la operacion:  "+miReloj.elapsedTime());

                    break;
                case 1:

                    Actor a= ListaActores.getMiLista().buscarActor(Teclado.getMiTeclado().leerString());
                    if (a!=null){
                        System.out.println("Actor encontrado");
                        System.out.print(a.getNombre() + "-->> Peliculas:" );
                        ListaActores.getMiLista().devolverPeliculasDeActor(a.getNombre()).imprimirLista();
                        System.out.println();
                    }
                    else{
                        System.out.println("El actor no se ha encontrado");
                    }
                    break;
                case 2:
                    ListaActores.getMiLista().anadirActor(Teclado.getMiTeclado().leerString());

                    break;

                case 3:
                    ListaActores.getMiLista().anadirPeliculaActor(Teclado.getMiTeclado().leerString(), Teclado.getMiTeclado().leerFloat(),Teclado.getMiTeclado().leerString());
                    System.out.println("se ha añadido la pelicula con su actor correspondiente");
                    break;

                case 4:
                    ListaPeliculas pelisDeActor=ListaActores.getMiLista().devolverPeliculasDeActor(Teclado.getMiTeclado().leerString());
                    if (pelisDeActor==null) {
                        System.out.println("El actor introducido no existe");
                    }else{
                        pelisDeActor.imprimirLista();
                        System.out.println();
                    }
                    break;

                case 5:
                    HashMap<String, Actor> listaActores= ListaActores.getMiLista().devolverActoresDePeli(Teclado.getMiTeclado().leerString());
                    if (listaActores!=null) {
                        for (String key : listaActores.keySet()) {

                            System.out.print(key + "; ");
                        }
                        System.out.println();
                    }else{
                        System.out.println("La pelicula introducida no existe");
                    }

                    break;

                case 6:
                    Pelicula peli = ListaActores.getMiLista().buscarPelicula(Teclado.getMiTeclado().leerString());
                    if(peli!=null){
                        System.out.println("La pelicula "+peli.getTitulo()+" se ha encontrado con exito");
                    }else{
                        System.out.println("La pelicula no se ha encontrado");
                    }
                    break;

                case 7:
                    Pelicula pp=ListaActores.getMiLista().eliminarPeli(Teclado.getMiTeclado().leerString());
                    if (pp!=null) {
                        System.out.println(pp.getTitulo() + " se ha eliminado correctamente");
                    }else{
                        System.out.println("la pelicula no esta en la lista");
                    }
                    break;
                case 8:
                    String tituloPeli=Teclado.getMiTeclado().leerString();
                    ListaActores.getMiLista().incrementarRecaudacion(tituloPeli, Teclado.getMiTeclado().leerFloat());
                    Pelicula p=ListaActores.getMiLista().buscarPelicula(tituloPeli);
                    if (p !=null){
                        System.out.println("La recaudacion de la pelicula "+tituloPeli+" se ha aumentado y ahora es de "+p.getRecaudacion()+" euros.");
                    }else {System.out.println("La pelicula no esta en la lista");}

                    break;

                case 9:
                    Actor actorEliminado = ListaActores.getMiLista().eliminarActor(Teclado.getMiTeclado().leerString());
                    if (actorEliminado!=null){
                        System.out.println("El actor "+ actorEliminado.getNombre()+ " ha sido eliminado correctamente");
                    }else{
                        System.out.println("El actor introducido no existe en la lista");
                    }
                    break;

                case 10:
                    Reloj miReloj2=new Reloj();
                    ListaActores.getMiLista().guardarFichero();
                    System.out.println("Fichero guardado con exito.");
                    System.out.println("La lista ha sido cargada."+miReloj2.elapsedTime());
                    break;

                case 11:
                    Actor[] listaOrdenada=ListaActores.getMiLista().ordenarActores();
                    for (Actor actor1 : listaOrdenada){
                        System.out.println(actor1.getNombre());
                    }
                    break;

                case 12:
                    //Finalizar programa
                    finalizar=true;
                    System.out.println("--------------------------------------------------");
                    System.out.println("------------------Fin del programa----------------");
                    break;


                default:
                    System.out.println("No ha seleccionado ninguna de las operaciones operativas");
            }
        }
    }
}
