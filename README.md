# 🌳 Sistema de Gestión de Empleados con Árbol Binario

## 📋 Descripción del Proyecto
Este proyecto implementa un **sistema de gestión de empleados** utilizando un **árbol binario de búsqueda en Java**.  
El sistema permite realizar operaciones **CRUD (Crear, Leer, Actualizar, Eliminar)** sobre registros de empleados, usando el **ID como clave única** para la estructura del árbol.

---

## 🏗️ Estructura del Código

### 📌 Clases Principales

#### 1. Clase `Nodo`
```java
class Nodo {
    int id;            // Identificador único del empleado
    String nombre;     // Nombre del empleado
    String puesto;     // Puesto del empleado
    Nodo izquierdo;    // Referencia al nodo izquierdo
    Nodo derecho;      // Referencia al nodo derecho
}
```
#### 2. Clase `ArbolBinario`
Contiene los métodos principales:

- **`insertar()`** → Añade nuevos empleados  
- **`eliminar()`** → Remueve empleados existentes  
- **`buscar()`** → Encuentra empleados por ID  
- **Recorridos**: `preorden()`, `inorden()`, `postorden()`  

---

#### 3. Clase `GestionEmpleados`
Interfaz de usuario con **menú interactivo** para ejecutar las operaciones principales del sistema.

---

## ⚙️ Funcionamiento del Código

### 🔹 Inserción de Empleados
Los empleados se insertan manteniendo la propiedad del **árbol binario de búsqueda**:  

- Si el nuevo **ID es menor** → se inserta en el subárbol izquierdo  
- Si el nuevo **ID es mayor** → se inserta en el subárbol derecho  
- **IDs duplicados** → no permitidos  

---

### 🔹 Búsqueda Eficiente
La búsqueda aprovecha la estructura ordenada del árbol:  

- Complejidad: **O(log n)** en árbol balanceado  
- Se compara constantemente con el nodo actual  
- Se reduce el espacio de búsqueda en cada paso  

---

### 🔹 Eliminación Inteligente
Existen **tres casos principales**:  

1. **Nodo hoja** → eliminación directa  
2. **Nodo con un hijo** → reemplazo por el hijo  
3. **Nodo con dos hijos** → búsqueda del **sucesor inorden**  

---

### 🔹 Recorridos Implementados
- **Preorden** → Raíz → Izquierdo → Derecho  
- **Inorden** → Izquierdo → Raíz → Derecho (ordenado por ID)  
- **Postorden** → Izquierdo → Derecho → Raíz  

---

## 🖥️ Evidencias de Ejecución

- **Menú Principal**  
  Descripción: Interfaz inicial del sistema mostrando todas las opciones disponibles.  
<img width="948" height="287" alt="captura1" src="https://github.com/user-attachments/assets/326b9e88-3507-476c-a14f-aa36b3f09caa" />

- **Inserción de Empleados**   
  Descripción: Demostración de la inserción de nuevos empleados con validación de duplicados.  
<img width="949" height="227" alt="captura2" src="https://github.com/user-attachments/assets/4c75066c-3ed2-485c-8712-2259f845b16e" />

- **Búsqueda de Empleados**
  Descripción: Resultado de búsqueda exitosa y manejo de búsquedas fallidas.  
<img width="940" height="138" alt="captura3" src="https://github.com/user-attachments/assets/d51c96ac-bb02-4155-8ac6-313d84da3cb1" />

- **Recorridos del Árbol**  
  Descripción: Salida de los tres tipos de recorrido mostrando el orden de procesamiento.  
<img width="949" height="191" alt="captura4" src="https://github.com/user-attachments/assets/b7441973-a68a-44ac-a5c3-080029d99e91" />

- **Comparación de Eficiencia**  
  Descripción: Resultados numéricos mostrando la ventaja del árbol binario vs búsqueda secuencial.  
<img width="952" height="175" alt="captura5" src="https://github.com/user-attachments/assets/2712a4b0-418e-4640-8b32-e5dada5c47a3" />

- **Eliminación de Elementos**  
  Descripción: Proceso de eliminación y resultado final después de remover elementos.  
<img width="942" height="460" alt="captura6" src="https://github.com/user-attachments/assets/13cc5c08-154b-4e37-b0d9-f259e4c192ce" />

---
## 💡 Reflexión sobre la importancia de los Árboles Binarios

Los árboles binarios son estructuras de datos fundamentales en programación, ya que permiten organizar información de manera jerárquica y eficiente. Esto hace que operaciones como **búsqueda, inserción y eliminación** se realicen en tiempo logarítmico en árboles balanceados, mucho más rápido que en listas o arreglos lineales.

Además de su eficiencia, los árboles binarios tienen múltiples aplicaciones prácticas: se usan en **bases de datos** para índices, en **compresión de datos** como Huffman Coding, en **inteligencia artificial** mediante árboles de decisión, y en **sistemas operativos** para la gestión de procesos y memoria. Su versatilidad y rapidez los convierten en una herramienta esencial para cualquier programador.

---

