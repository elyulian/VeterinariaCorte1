package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Perro> listaPerros = new ArrayList<>();
        Perro perro1 = new Perro( "Rex", "Pastor Alemán", 24, true, true, false, "Nulo", Perro.Tamano.GRANDE);
        Perro perro2 = new Perro( "Luna", "Labrador", 18, true, false, false, "Nulo", Perro.Tamano.GRANDE);
        listaPerros.add(perro1);
        listaPerros.add(perro2);
        int opcion = 0;
        int idPerro=0;
        do {
            System.out.println("------ Bienvenido a DogShow!------");
            System.out.println("1. Agregar perro");
            System.out.println("2. Buscar Perros (ID)");
            System.out.println("3. Registrar adopcion");
            System.out.println("4. Vacunar perro");
            System.out.println("5. Esterilizar perro");
            System.out.println("6. Listar perros disponibles para adopcion");
            System.out.println("7. Eliminar perro");
            System.out.println("8. Listar todos los perros");
            System.out.println("0. Salir");
            System.out.println("-----------------------------------");
            System.out.println("Elija una opcion: ");

            opcion = scanner.nextInt();

            int finalIdPerro = idPerro;
            switch (opcion) {
                case 1 -> {
                    Perro perro = new Perro();
                    System.out.println("Ingrese el nombre del perro:");
                    String nombre = scanner.next();
                    perro.setNombre(nombre);
                    System.out.println("Ingrese la raza del perro:");
                    String raza = scanner.next();
                    perro.setRaza(raza);
                    System.out.println("Ingrese la edad del perro en meses:");
                    int edad = scanner.nextInt();
                    perro.setEdadMeses(edad);
                    System.out.println("Ingrese el tamano del perro (PEQUENO, MEDIANO, GRANDE):");
                    String tamanio = scanner.next().toUpperCase();
                    perro.setTamano(Perro.Tamano.valueOf(tamanio));
                    System.out.println("Estado Vacunación (true/false):");
                    boolean vacunado = scanner.nextBoolean();
                    perro.setVacunado(vacunado);
                    System.out.println("Estado Esterilización (true/false):");
                    boolean esterilizado = scanner.nextBoolean();
                    perro.setEsterilizado(esterilizado);
                    perro.setAdoptado(false);
                    perro.setAdoptante("Nulo");
                    System.out.println("Perro agregado exitosamente");
                    listaPerros.add(perro);
                }
                case 2 -> {
                    System.out.println("Ingrese el ID del perro a buscar:");
                    idPerro = scanner.nextInt();
                    boolean encontrado = false;
                    for (Perro p : listaPerros) {
                        if (p.getId() == idPerro) {
                            p.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Perro no existe");
                    }

                }
                case 3 -> {
                    System.out.println("Ingrese el ID del perro a adoptar:");
                     idPerro = scanner.nextInt();
                    for(Perro p : listaPerros){
                        if (p.getId() == idPerro) {
                            if (!p.isAdoptado()) {
                                System.out.println("Ingrese el nombre del adoptante:");
                                String nombreAdoptante = scanner.next();
                                p.setAdoptado(true);
                                p.setAdoptante(nombreAdoptante);
                                System.out.println("Perro adoptado exitosamente");
                            } else {
                                System.out.println("El perro ya ha sido adoptado");
                            }
                        }
                    }
                }
                case 4 -> {
                    for(Perro p : listaPerros){
                        if (p.getId() == idPerro) {
                            if (!p.isVacunado()) {
                                System.out.println("Ingrese el ID del perro a Vacunar:");
                                String nombreAdoptante = scanner.next();
                                p.setAdoptado(true);
                                p.setAdoptante(nombreAdoptante);
                                System.out.println("Perro adoptado exitosamente");
                            } else {
                                System.out.println("El perro ya ha sido Vacunado");
                            }
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Ingrese el ID del perro a esterilizar:");
                    idPerro = scanner.nextInt();
                    for(Perro p : listaPerros){
                        if (p.getId() == idPerro) {
                            if (!p.isEsterilizado()) {
                                p.esterilizar();
                                System.out.println("Perro esterilizado exitosamente");
                            } else {
                                System.out.println("El perro ya ha sido esterilizado");
                            }
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Perros disponibles para adopcion:");
                    for (Perro p : listaPerros) {
                        if (!p.isAdoptado()) {
                            p.mostrarInfo();
                            System.out.println("-------------------");
                        }
                    }
                }
                case 7 -> {
                    System.out.println("Ingrese el ID del perro a eliminar:");
                    idPerro = scanner.nextInt();
                    if (listaPerros.isEmpty()) {
                        System.out.println("No hay perros en la lista");
                        break;
                    }
                    for (Perro p : listaPerros) {
                        if (p.getId() == idPerro) {
                            listaPerros.remove(p);
                            System.out.println("Perro eliminado exitosamente");
                            break;
                        }
                    }

                }
                case 8 -> {
                    for (Perro p : listaPerros) {
                        p.mostrarInfo();
                        System.out.println("-------------------");
                    }
                }
                case 0 -> System.out.println("Gracias por usar DogShow!");
                default -> System.out.println("Opcion no valida");
            }


        } while (opcion != 0 && opcion < 9 && opcion >= 1);

    }
}