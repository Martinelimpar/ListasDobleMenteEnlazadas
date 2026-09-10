public class Main {
    public static void imprimirLista(MiListaDoble lista) {
        Object[] datos = lista.toArray();
        System.out.print("[");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i]);
            if (i < datos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        System.out.println("--- PRUEBAS DE ESTRUCTURA DE DATOS ---");
        MiListaDoble lista = new MiListaDoble();

        //Insertar datos
        lista.insertHead(20);
        lista.insertTail(40);
        lista.insertTail(10);
        lista.add(30);

        System.out.print("1. Lista inicial: ");
        imprimirLista(lista);
        System.out.println("   Tamaño: " + lista.getSize());
        System.out.println("---------------------------------------------------");

        //Insertar en el medio
        DoubleNode nodoRef = lista.search(40);
        lista.insert(nodoRef, 99);
        System.out.print("2. Tras insertar 99 después del 40: ");
        imprimirLista(lista);

        //Ordenar la lista
        MiListaDoble listaOrdenada = lista.sortList();
        System.out.print("3. Lista ordenada de menor a mayor: ");
        imprimirLista(listaOrdenada);

        //Eliminar un dato
        DoubleNode nodoAEliminar = lista.search(10);
        lista.remove(nodoAEliminar);
        System.out.print("4. Tras eliminar el 10: ");
        imprimirLista(lista);

        //Verificar extremos de los punteros
        System.out.println("5. Extremos actuales de la memoria:");
        System.out.println("   Cabeza (Head): " + lista.getHead());
        System.out.println("   Cola (Tail): " + lista.getTail());
    }
}