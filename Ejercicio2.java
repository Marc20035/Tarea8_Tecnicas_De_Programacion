//Requisitos previos: EjercicioRefe2

//Los clientes creados en el capítulo anterior, pueden comprar libros y vídeos a nuestro editor. Todos los libros y vídeos tienen un título y un autor. Un libro tiene varias páginas, mientras que un vídeo tiene una duración. Crear una clase Obra, agrupando los elementos comunes a libros y vídeos y dos clases Libros y Video, herederas de esta, con los elementos específicos para cada una. Luego cree una clase Pedido, asociando a un cliente un conjunto de obras compradas.

class Obra {
    private String titulo;
    private String autor;

    public Obra(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

public class Libro extends Obra {
    private int numPaginas;

    public Libro(String titulo, String autor, int numPaginas) {
        super(titulo, autor);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
}

public class Video extends Obra {
    private int duracion;

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}

public class Pedido {
    private Cliente cliente;
    private ArrayList<Obra> obras;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        obras = new ArrayList<Obra>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }
}


