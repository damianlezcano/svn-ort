package ar.com.pattern.estructural.facade;

/**
 * Con la interface fachada, tenemos una simple interface para acceder a clases diferentes.
 */
class Fachada {
    private LibreriaLibros libros = new LibreriaLibros();
    private LibreriaVideo videos = new LibreriaVideo();
    private LibreriaMusica musica = new LibreriaMusica();
 
    public void buscarLibros() {
        libros.buscarLibros();
    }
 
    public void buscarMusica() {
        musica.buscarMusica();
    }
 
    public void buscarVideo() {
        videos.buscarVideo();
    }
} 
