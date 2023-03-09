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

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        int opcion = 0;
        do {
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear clientes");
            System.out.println("3 - Crear una obra");
            System.out.println("4 - Crear un pedido");
            System.out.println("5 - Mostrar pedidos");
            System.out.println("6 - Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = sc.next();
                    System.out.println("Ingrese el apellido del cliente");
                    String apellido = sc.next();
                    System.out.println("Ingrese el dni del cliente");
                    int dni = sc.nextInt();
                    System.out.println("Ingrese el telefono del cliente");
                    int telefono = sc.nextInt();
                    System.out.println("Ingrese el email del cliente");
                    String email = sc.next();
                    Cliente cliente = new Cliente(nombre, apellido, dni, telefono, email);
                    clientes.add(cliente);
                    break;
                case 3:
                    System.out.println("Ingrese el titulo de la obra");
                    String titulo = sc.next();
                    System.out.println("Ingrese el autor de la obra");
                    String autor = sc.next();
                    System.out.println("Ingrese el tipo de obra (1 - Libro, 2 - Video)");
                    int tipoObra = sc.nextInt();
                    if (tipoObra == 1) {
                        System.out.println("Ingrese el numero de paginas");
                        int numPaginas = sc.nextInt();
                        Libro libro = new Libro(titulo, autor, numPaginas);
                    } else {
                        System.out.println("Ingrese la duracion");
                        int duracion = sc.nextInt();
                        Video video = new Video(titulo, autor, duracion);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el dni del cliente");
                    int dniCliente = sc.nextInt();
                    Cliente clientePedido = null;
                    for (Cliente clienteAux : clientes) {
                        if (clienteAux.getDni() == dniCliente) {
                            clientePedido = clienteAux;
                        }
                    }
                    if (clientePedido != null) {
                        Pedido pedido = new Pedido(clientePedido);
                        System.out.println("Ingrese el titulo de la obra");
                        String tituloObra = sc.next();
                        System.out.println("Ingrese el autor de la obra");
                        String autorObra = sc.next();
                        System.out.println("Ingrese el tipo de obra (1 - Libro, 2 - Video)");
                        int tipoObraPedido = sc.nextInt();
                        if (tipoObraPedido == 1) {
                            System.out.println("Ingrese el numero de paginas");
                            int numPaginas = sc.nextInt();
                            Libro libro = new Libro(tituloObra, autorObra, numPaginas);
                            pedido.agregarObra(libro);
                        } else {
                            System.out.println("Ingrese la duracion");
                            int duracion = sc.nextInt();
                            Video video = new Video(tituloObra, autorObra, duracion);
                            pedido.agregarObra(video);
                        }
                        pedidos.add(pedido);
                    } else {
                        System.out.println("No se encontro el cliente");
                    }
                    break;
                case 5:
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido);
                    }
                    break;
                case 6:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 6);
    }
}
