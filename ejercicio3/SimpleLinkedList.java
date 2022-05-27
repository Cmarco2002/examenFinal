package ejercicio3;

/**
 * Esta clase almacena el primer nodo y el tamaño de la lista simple,
 * ademas de añadir nodos a la lista y eliminarlos
 */
public class SimpleLinkedList {
	private Node first;
	private int size;
	
	public SimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public SimpleLinkedList(Node first) {
		this.first = first;
		this.size = 1;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Pre: ---
	 * Post: Este comprueba el tamaño de la lista y si esta a 0
	 * te inserta el nodo en la primera posicion, sino en la siguiente.
	 */
	public boolean add(Node node) {
		try {
			if (size==0) {
				first = node;
			} else {
				Node p = first;
				for(int i=1; i<size; i++) {
					p = p.getNext();
				}p.setNext(node);
			} size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este comprueba la posicion que le manda y si esta a 0
	 * te inserta el nodo en la primera posicion, sino en la posicion que se mande.
	 */
	public boolean add(int position, Node node) {
		if(position==0) {
			node.setNext(first);
			first = node;
		} else if(position == (size-1)) {
			return add(node);
		} else {
			Node p = first;
			for(int i=1; i<position; i++) {
				p = p.getNext();
			}
			node.setNext(p.getNext());
			p.setNext(node);
			size++;
		}
		return true;
	}
	
	/**
	 * Pre: ---
	 * Post: Este comprueba la posicion que se le manda y se elimina el nodo que esta
	 * en esa posicion.
	 */
	public boolean delete(int position) {
		if(position==0) {
			first = first.getNext();
			size--;
		} else if(position == (size)) {
			Node p = first;
			for(int i=1; i<size; i++) {
				p = p.getNext();
			}
			p.setNext(null);
			size--;
		} else {
			Node p = first;
			for(int i=1; i<position; i++) {
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
			size--;
		}
		return true;
	}
	
	/**
	 * Pre: ---
	 * Post: Este compara todos los nodos y va cogiendo el mayor,
	 * cuando finaliza elimina el mayor.
	 */
	public void deleteMayor() {
		Node p = first;
		Node node = first;
		int mayor = 0;
		for (int i=0; i<size; i++) {
			if (p.getContent() > node.getContent()) {
				mayor = i;
			}
			p = p.getNext();
		}
		delete(mayor);
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo te recorre la lista y te la muestra nodo por nodo.
	 */
	public void show() {
		Node p = first;
		for (int i=0; i<size; i++) {
			System.out.println("[" + i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}

}
