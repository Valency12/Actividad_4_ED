package actividad_4;

class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Insertar nodo
    public void insertar(int id, String nombre, String puesto) {
        raiz = insertarRecursivo(raiz, id, nombre, puesto);
    }

    private Nodo insertarRecursivo(Nodo actual, int id, String nombre, String puesto) {
        if (actual == null) {
            return new Nodo(id, nombre, puesto);
        }

        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre, puesto);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre, puesto);
        }

        return actual;
    }

    // Buscar nodo
    public Nodo buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {
        if (actual == null || actual.id == id) {
            return actual;
        }

        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        } else {
            return buscarRecursivo(actual.derecho, id);
        }
    }

    // Eliminar nodo
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private Nodo eliminarRecursivo(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id < actual.id) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
        } else if (id > actual.id) {
            actual.derecho = eliminarRecursivo(actual.derecho, id);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Nodo con dos hijos: obtener el sucesor inorden (mínimo en el subárbol derecho)
            actual.id = encontrarMinimo(actual.derecho).id;
            actual.derecho = eliminarRecursivo(actual.derecho, actual.id);
        }

        return actual;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // Recorridos
    public void preorden() {
        System.out.println("Recorrido Preorden:");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.id + " ");
            preordenRecursivo(nodo.izquierdo);
            preordenRecursivo(nodo.derecho);
        }
    }

    public void inorden() {
        System.out.println("Recorrido Inorden:");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.id + " ");
            inordenRecursivo(nodo.derecho);
        }
    }

    public void postorden() {
        System.out.println("Recorrido Postorden:");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo);
            postordenRecursivo(nodo.derecho);
            System.out.print(nodo.id + " ");
        }
    }

    // Mostrar todos los empleados en orden
    public void mostrarEmpleados() {
        System.out.println("Lista de empleados (ordenados por ID):");
        mostrarEmpleadosRecursivo(raiz);
        System.out.println();
    }

    private void mostrarEmpleadosRecursivo(Nodo nodo) {
        if (nodo != null) {
            mostrarEmpleadosRecursivo(nodo.izquierdo);
            System.out.println(nodo);
            mostrarEmpleadosRecursivo(nodo.derecho);
        }
    }
}