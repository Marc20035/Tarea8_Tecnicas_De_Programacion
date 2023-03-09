//Requisitos previos: EjercicioRefe 

//Dos jugadores se enfrentan en una guerra de dados: cada jugador tiene un dado de seis caras y diez fichas.

//Cree una clase JugadorGuerra, que tenga como atributos de instancia el número de fichas, un dado (una instancia de la clase Dado) y el nombre del jugador. Agregue dentro de esta clase el resto de elementos necesarios. Cree un algoritmo principal usando esta clase.

//El algoritmo debe simular una partida de guerra de dados entre dos jugadores. Para esto, debe crear dos instancias de JugadorGuerra, asignarles un nombre y un número de fichas. Luego, debe simular el juego, donde cada jugador tira su dado y el que obtenga el número más alto gana una ficha del otro jugador. El juego termina cuando uno de los dos jugadores se queda sin fichas.

//Al finalizar el juego, debe mostrar el nombre del jugador ganador.

class Dado {
    private int numCaras;
    private int ultimaCara;

    public Dado() {
        numCaras = 6;
        ultimaCara = 1;
    }

    public Dado(int numCaras) {
        this.numCaras = numCaras;
        ultimaCara = 1;
    }

    public int getNumCaras() {
        return numCaras;
    }

    public int getUltimaCara() {
        return ultimaCara;
    }

    public void setNumCaras(int numCaras) {
        this.numCaras = numCaras;
    }

    public int tirar() {
        Random rand = new Random();
        ultimaCara = rand.nextInt(numCaras) + 1;
        return ultimaCara;
    }
}

public class JugadorGuerra {
    private int numFichas;
    private Dado dado;
    private String nombre;

    public JugadorGuerra(int numFichas, Dado dado, String nombre) {
        this.numFichas = numFichas;
        this.dado = dado;
        this.nombre = nombre;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public void setNumFichas(int numFichas) {
        this.numFichas = numFichas;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int tirar() {
        return dado.tirar();
    }
}

public class Main {
    public static void main(String[] args) {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado(10);
        Dado dado3 = new Dado(12);

        JugadorGuerra jugador1 = new JugadorGuerra(10, dado1, "Jugador 1");
        JugadorGuerra jugador2 = new JugadorGuerra(10, dado2, "Jugador 2");

        while (jugador1.getNumFichas() > 0 && jugador2.getNumFichas() > 0) {
            int resultado1 = jugador1.tirar();
            int resultado2 = jugador2.tirar();

            if (resultado1 > resultado2) {
                jugador1.setNumFichas(jugador1.getNumFichas() + 1);
                jugador2.setNumFichas(jugador2.getNumFichas() - 1);
            } else if (resultado2 > resultado1) {
                jugador2.setNumFichas(jugador2.getNumFichas() + 1);
                jugador1.setNumFichas(jugador1.getNumFichas() - 1);
            }
        }

        if (jugador1.getNumFichas() > 0) {
            System.out.println("El ganador es " + jugador1.getNombre());
        } else {
            System.out.println("El ganador es " + jugador2.getNombre());
        }
    }
}
