package actividad_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEmpleados {
    private static ArbolBinario arbol = new ArbolBinario();
    private static Scanner scanner = new Scanner(System.in);
    private static List<Empleado> empleadosBase = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializar algunos empleados de ejemplo
        inicializarEmpleados();
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    insertarEmpleado();
                    break;
                case 2:
                    buscarEmpleado();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    mostrarTodosEmpleados();
                    break;
                case 5:
                    mostrarRecorridos();
                    break;
                case 6:
                    compararEficiencia();
                    break;
                case 7:
                    insertarEmpleadosEjemplo();
                    break;
                case 8:
                    System.out.println("¡Gracias por usar el sistema de gestión de empleados!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE EMPLEADOS ===");
        System.out.println("1. Insertar nuevo empleado");
        System.out.println("2. Buscar empleado por ID");
        System.out.println("3. Eliminar empleado");
        System.out.println("4. Mostrar todos los empleados");
        System.out.println("5. Mostrar recorridos del árbol");
        System.out.println("6. Comparar eficiencia vs búsqueda secuencial");
        System.out.println("7. Insertar empleados de ejemplo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void inicializarEmpleados() {
        empleadosBase.add(new Empleado(50, "Ana García", "Gerente"));
        empleadosBase.add(new Empleado(30, "Carlos López", "Desarrollador"));
        empleadosBase.add(new Empleado(70, "María Rodríguez", "Diseñadora"));
        empleadosBase.add(new Empleado(20, "Pedro Martínez", "Analista"));
        empleadosBase.add(new Empleado(40, "Laura Sánchez", "Recursos Humanos"));
        empleadosBase.add(new Empleado(60, "Juan Pérez", "Contador"));
        empleadosBase.add(new Empleado(80, "Sofía Hernández", "Marketing"));
    }

    private static void insertarEmpleado() {
        System.out.println("\n--- INSERTAR NUEVO EMPLEADO ---");
        
        try {
            System.out.print("ID del empleado: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Puesto: ");
            String puesto = scanner.nextLine();
            
            // Verificar si el ID ya existe
            if (arbol.buscar(id) != null) {
                System.out.println("❌ Error: Ya existe un empleado con ID " + id);
                return;
            }
            
            arbol.insertar(id, nombre, puesto);
            System.out.println("✅ Empleado insertado correctamente: " + nombre);
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: El ID debe ser un número válido");
        }
    }

    private static void buscarEmpleado() {
        System.out.println("\n--- BUSCAR EMPLEADO ---");
        
        try {
            System.out.print("Ingrese el ID a buscar: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Nodo encontrado = arbol.buscar(id);
            if (encontrado != null) {
                System.out.println("✅ EMPLEADO ENCONTRADO:");
                System.out.println("   " + encontrado);
            } else {
                System.out.println("❌ No se encontró ningún empleado con ID " + id);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: El ID debe ser un número válido");
        }
    }

    private static void eliminarEmpleado() {
        System.out.println("\n--- ELIMINAR EMPLEADO ---");
        
        try {
            System.out.print("Ingrese el ID del empleado a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Nodo encontrado = arbol.buscar(id);
            if (encontrado != null) {
                arbol.eliminar(id);
                System.out.println("✅ Empleado eliminado: " + encontrado.nombre);
            } else {
                System.out.println("❌ No se encontró ningún empleado con ID " + id);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: El ID debe ser un número válido");
        }
    }

    private static void mostrarTodosEmpleados() {
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        arbol.mostrarEmpleados();
    }

    private static void mostrarRecorridos() {
        System.out.println("\n--- RECORRIDOS DEL ÁRBOL ---");
        arbol.preorden();
        arbol.inorden();
        arbol.postorden();
    }

    private static void compararEficiencia() {
        System.out.println("\n--- COMPARACIÓN DE EFICIENCIA ---");
        
        if (empleadosBase.isEmpty()) {
            System.out.println("No hay empleados de ejemplo para comparar");
            return;
        }
        
        try {
            System.out.print("Ingrese el ID a buscar para comparar: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            // Búsqueda en árbol binario
            long inicioArbol = System.nanoTime();
            Nodo resultadoArbol = arbol.buscar(id);
            long finArbol = System.nanoTime();
            
            // Búsqueda secuencial en lista
            long inicioSecuencial = System.nanoTime();
            Empleado resultadoSecuencial = null;
            for (Empleado emp : empleadosBase) {
                if (emp.id == id) {
                    resultadoSecuencial = emp;
                    break;
                }
            }
            long finSecuencial = System.nanoTime();
            
            System.out.println("\nRESULTADOS:");
            System.out.println("Árbol binario: " + (finArbol - inicioArbol) + " nanosegundos");
            System.out.println("Búsqueda secuencial: " + (finSecuencial - inicioSecuencial) + " nanosegundos");
            
            long tiempoArbol = finArbol - inicioArbol;
            long tiempoSecuencial = finSecuencial - inicioSecuencial;
            
            if (tiempoArbol > 0) {
                double vecesMasRapido = (double) tiempoSecuencial / tiempoArbol;
                System.out.printf("El árbol binario es %.2f veces más rápido%n", vecesMasRapido);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: El ID debe ser un número válido");
        }
    }

    private static void insertarEmpleadosEjemplo() {
        System.out.println("\n--- INSERTANDO EMPLEADOS DE EJEMPLO ---");
        
        for (Empleado emp : empleadosBase) {
            if (arbol.buscar(emp.id) == null) {
                arbol.insertar(emp.id, emp.nombre, emp.puesto);
                System.out.println("✅ Insertado: " + emp.nombre);
            } else {
                System.out.println("ℹ️  Ya existe: " + emp.nombre);
            }
        }
        
        System.out.println("Empleados de ejemplo insertados correctamente");
    }
}

class Empleado {
    int id;
    String nombre;
    String puesto;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }
}