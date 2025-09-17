
package actividad_4;

class Nodo {
    int id;
    String nombre;
    String puesto;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + nombre + " (" + puesto + ")";
    }
}
