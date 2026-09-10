public class MiListaDoble implements ListInterface{
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public MiListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHead() {
        return (head != null) ? head.dato : null;
    }

    @Override
    public Object getTail() {
        return (tail != null) ? tail.dato : null;
    }

    @Override
    public Object get(DoubleNode node) {
        return (node != null) ? node.dato : null;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode current = head;
        while ( current != null) {
            if (current.dato.equals(object)) {
                return current;
            }
            current = current.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) return false;
        if(node == tail) return insertTail(object);

        DoubleNode newNode = new DoubleNode(object);
        newNode.siguiente = node.siguiente;
        newNode.anterior = node;
        node.siguiente.anterior = newNode;
        size++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode refNode = search(objectRef);
        if (refNode != null) {
            return insert(refNode, object);
        }
        return false;
    }
    @Override
    public boolean insertHead(Object object) {
        DoubleNode newNode = new DoubleNode(object);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.siguiente = head;
            head.anterior = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode newNode = new DoubleNode(object);
        if (isEmpty()) {
            tail = newNode;
            head = newNode;
        } else {
            tail.siguiente = newNode;
            newNode.anterior = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node != null) {
            node.dato = object;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) return false;

        if (node == head) {
            head = head.siguiente;
            if (head != null) head.anterior = null;
            else tail = null;
        } else if (node == tail) {
            tail = tail.anterior;
            if (tail != null) tail.siguiente = null;
            else head = null;
        } else {
            node.anterior.siguiente = node.siguiente;
            node.siguiente.anterior = node.anterior;
        }
        node.siguiente = null;
        node.anterior = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        DoubleNode current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.siguiente;
            current = current.siguiente;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object.length < size) {
            return toArray();
        }
        DoubleNode current = head;
        int i = 0;
        while (current != null) {
            object[i++] = current.dato;
            current = current.siguiente;
        }
        if (object.length > size) {
            object[size] = null;
        }
        return object;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble sub = new MiListaDoble();
        DoubleNode current = from;
        while (current != null) {
            sub.add(current.dato);
            if (current == to) break;
            current = current.siguiente;
        }
        return sub;
    }


    @Override
    public MiListaDoble sortList() {
        MiListaDoble sortedList = new MiListaDoble();
        DoubleNode current = head;
        while (current != null) {
            sortedList.add(current.dato);
            current = current.siguiente;
        }
        if (sortedList.getSize() > 1) {
            boolean swapped;
            do {
                swapped = false;
                DoubleNode temp = sortedList.head;
                while (temp.siguiente != null) {
                    if (((Comparable) temp.dato).compareTo(temp.siguiente.dato) > 0) {
                        Object swapDato = temp.dato;
                        temp.dato = temp.siguiente.dato;
                        temp.siguiente.dato = swapDato;
                        swapped = true;
                    }
                    temp = temp.siguiente;
                }
            } while (swapped);
        }
        return sortedList;
    }
}

