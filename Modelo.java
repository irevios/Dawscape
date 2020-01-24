import java.io.*;
import java.util.LinkedList;
import java.util.TreeSet;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Modelo {
	public static final int CIRCULO = 0;
	public static final int CUADRADO = 1;
	public static final int CORRECTO = 0;
	public static final int ERROR = 1;

	private LinkedList<Escena> escenas;
	private TreeSet<Objeto> objetos;
	private int eleccion;
	private int numeroA;
	private int numeroB;
	private int numeroC;
	private int numeroD;
	private String escenaActual;

	public Modelo() {
		this.escenas = new LinkedList<Escena>();
		this.objetos = new TreeSet<Objeto>();
		this.eleccion = -1;
		this.escenaActual = "inicio";
		generarNumeros();
		iniciarPartida();
	}

	private void generarNumeros() {
		this.numeroA = numeroRandom(0, 99);
		this.numeroB = numeroRandom(50, 99);
		this.numeroC = numeroRandom(20, 99);
		this.numeroD = numeroRandom(20, 99);
		while (numeroD == numeroC) {
			this.numeroD = numeroRandom(20, 99);
		}
	}

	public int numeroRandom(int min, int max) {
		double numeroRandom = (Math.random() * ((max - min) + 1)) + min;
		return (int) numeroRandom;
	}

	public int getEleccion() {return eleccion;}
	public void setEleccion(int eleccion) {this.eleccion = eleccion;}
	public int getNumeroA() {return this.numeroA;}
	public int getNumeroB() {return this.numeroB;}
	public int getNumeroC() {return this.numeroC;}
	public int getNumeroD() {return this.numeroD;}

	public Escena getEscena(String nombreEscena) {
		for (Escena escena : this.escenas) {
			if (escena.getNombre().equals(nombreEscena)) { return escena; }
		}
		return null;
	}
	public String getFondoEscena(String nombre, String estado) {
		String fondo = this.getEscena(nombre).getFondos().get(estado);
		return fondo;
	}
	public void setEscenaActual(String escenaActual) {this.escenaActual = escenaActual;}
	public String getEscenaActual() {return this.escenaActual;}
	
	public void cambiarEstado(String escena, String estado) {this.getEscena(escena).setEstado(estado);}
	
	private Objeto buscarObjeto(String objeto) {
		for (Objeto obj : objetos) {
			if (obj.getNombre().equals(objeto)) { return obj; }
			
		}
		return null;
	}
	
	public Objeto getObjeto(String objeto) {return buscarObjeto(objeto);}
	public String getObjetoImg(String objeto) {return buscarObjeto(objeto).getImagenes().get("frente");}
	public void obtenerObjeto(String objeto) {this.buscarObjeto(objeto).setObtenido(true);	}
	public void objetoUsado(String objeto) {this.buscarObjeto(objeto).setUsado(true);}
	public TreeSet<String> getinventario() {
		TreeSet<String> inventarioActual = new TreeSet<String>();
		for (Objeto objeto : this.objetos) {
			if (objeto.isObtenido()) {
				inventarioActual.add(objeto.getNombre());
			}
		}
		return inventarioActual;
	}

	private String generarPartida() {
		String progreso = eleccion + "\r\n"
				+ escenaActual + "\r\n"
				+ numeroA * 452019 + "\r\n"
				+ numeroB * 452019 + "\r\n"
				+ numeroC * 452019 + "\r\n"
				+ numeroD * 452019;
		return progreso;
	}

	public void iniciarPartida(){
		this.escenas.clear();
		this.objetos.clear();
		generarNumeros() ;
		this.crearEscenasIniciales();
		this.crearObjetosIniciales();
	}
	
	public void guardarPartida() throws IOException{
		new File(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida").mkdirs();
		guardarDatosPartida();
		FileWriter escritor = new FileWriter(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida/partida.dat");
		escritor.write(generarPartida());
		escritor.close();
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	public void leerDatosPartida() throws IOException, ClassNotFoundException {
		FileInputStream streamin = new FileInputStream(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida/objetos.dat");
		ObjectInputStream lector = new ObjectInputStream(streamin);
		this.objetos.clear();
		this.objetos = (TreeSet<Objeto>) lector.readObject();
		streamin = new FileInputStream(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida/escenas.dat");
		lector = new ObjectInputStream(streamin);
		this.escenas.clear();
		this.escenas = (LinkedList<Escena>) lector.readObject();
	}
	
	public void guardarDatosPartida() throws IOException {
		File esc = new File(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida/escenas.dat");
		FileOutputStream streamEsc = new FileOutputStream(esc);
		ObjectOutputStream escritorEsc = new ObjectOutputStream(streamEsc);
		escritorEsc.writeObject(this.escenas);
		escritorEsc.close();
		File obj = new File(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida/objetos.dat");
		FileOutputStream streamObj = new FileOutputStream(obj);
		ObjectOutputStream escritorObj = new ObjectOutputStream(streamObj);
		escritorObj.writeObject(this.objetos);
		escritorObj.close();
	}
	
	public void cargarPartida() throws IOException, ClassNotFoundException {
		this.leerDatosPartida();
		BufferedReader buffer = new BufferedReader(new FileReader(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida/partida.dat"));
		this.eleccion = Integer.parseInt(buffer.readLine());
		this.escenaActual = buffer.readLine();
		this.numeroA = Integer.parseInt(buffer.readLine())/452019;
		this.numeroB = Integer.parseInt(buffer.readLine())/452019;
		this.numeroC = Integer.parseInt(buffer.readLine())/452019;
		this.numeroD = Integer.parseInt(buffer.readLine())/452019;
		buffer.close();
	}
	
	public void exportarPartida(File ficheroSeleccionado) throws ZipException {
		if(!ficheroSeleccionado.getName().contains(".")) {
			ficheroSeleccionado = new File(ficheroSeleccionado.toString() +".sav");
		}
		ZipFile ficheroGuardado = new ZipFile(ficheroSeleccionado);
		ZipParameters parametros = new ZipParameters();
		parametros.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parametros.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		ficheroGuardado.addFolder(System.getenv("APPDATA")+"/Dawscape/bin/datosPartida", parametros);
	}
	public void importarPartida(File ficheroSeleccionado) throws ZipException {
		ZipFile zipFile = new ZipFile(ficheroSeleccionado);
		zipFile.extractAll(System.getenv("APPDATA")+"/Dawscape/bin/");
	}
	
	
	// Creacion de datos iniciales
		private void crearObjetosIniciales() {
			Objeto objeto = new Objeto("Nota", "Parece escrita por alguien que conozco.");
			objeto.getImagenes().put("frente", "/img/Objetos/notaFrente.png");
			objeto.getImagenes().put("posterior", "/img/Objetos/notaPosterior.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Llave", "Encontrada en una planta. Debe abrir algo.");
			objeto.getImagenes().put("frente", "/img/Objetos/llavePlanta.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Hexágono", "Es una pieza de madera muy pulida. Tiene dos caras.");
			objeto.getImagenes().put("frente", "/img/Objetos/hexagonoFrente.png");
			objeto.getImagenes().put("posterior", "/img/Objetos/hexagonoPosterior.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Destornillador plano", "Es imposible usarlo sin algo antideslizante.");
			objeto.getImagenes().put("frente", "/img/Objetos/destornilladorParte.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Mando a distancia", "Está diseñado para algo en concreto.");
			objeto.getImagenes().put("frente", "/img/Objetos/mandoFrente.png");
			objeto.getImagenes().put("posterior", "/img/Objetos/mandoSinBateria.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Mango", "Parece el mango de alguna herramienta.");
			objeto.getImagenes().put("frente", "/img/Objetos/mango.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Destornillador", "Un destornillador listo para usar.");
			objeto.getImagenes().put("frente", "/img/Objetos/destornilladorEntero.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Nota adhesiva", "Tiene algo escrito.");
			objeto.getImagenes().put("frente", "/img/Objetos/postit.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Llave modular", "Es una llave bastante rara.");
			objeto.getImagenes().put("frente", "/img/Objetos/llavePlana.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Cámara", "Cámara de buena calidad, pero no tiene batería. Algo sobresale.");
			objeto.getImagenes().put("frente", "/img/Objetos/camaraFrente.png");
			objeto.getImagenes().put("posterior", "/img/Objetos/camaraPosterior.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Tarjeta de memoria", "Estaba en la cámara. Quizás contenga algo.");
			objeto.getImagenes().put("frente", "/img/Objetos/tarjetaSD.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Batería", "Una batería de litio.");
			objeto.getImagenes().put("frente", "/img/Objetos/bateria.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Sobre blanco", "Lo habrán pasado bajo la puerta. ¿¡Tiene una mancha de sangre!?");
			objeto.getImagenes().put("frente", "/img/Objetos/sobreCuadrado.png");
			objeto.getImagenes().put("posterior", "/img/Objetos/sobreCuadradoPosterior.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Sobre colorido", "Lo habrán pasado bajo la puerta. Tiene unos bordes coloridos.");
			objeto.getImagenes().put("frente", "/img/Objetos/sobreCirculo.png");
			objeto.getImagenes().put("posterior", "/img/Objetos/sobreCirculoPosterior.png");
			this.objetos.add(objeto);
			
			objeto = new Objeto("Tarjeta", "Estaba en el sobre.");
			objeto.getImagenes().put("frente", "/img/Objetos/tarjetaCuadrado.png");
			this.objetos.add(objeto);
	}

	private void crearEscenasIniciales() {
		Escena escena = new Escena("salon", "cuadros", "entrada", null);
		escena.getFondos().put("normal", "/img/Fondos/salonConPapel.jpg");
		escena.getFondos().put("vacio", "/img/Fondos/salonSinPapel.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("cuadros", "ventana", "salon", null);
		escena.getFondos().put("normal", "/img/Fondos/cuadros.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("ventana", "entrada", "cuadros", null);
		escena.getFondos().put("normal", "/img/Fondos/ventanaCerrado.jpg");
		escena.getFondos().put("abiertoIzq", "/img/Fondos/ventanaIzqAbierto.jpg");
		escena.getFondos().put("abiertoDer", "/img/Fondos/ventanaDerAbierto.jpg");
		escena.getFondos().put("vacio", "/img/Fondos/ventanaDerVacio.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("entrada", "salon", "ventana", null);
		escena.getFondos().put("normal", "/img/Fondos/entradaSinSobre.jpg");
		escena.getFondos().put("sobreCirculo", "/img/Fondos/entradaConSobreCirculo.jpg");
		escena.getFondos().put("sobreCuadrado", "/img/Fondos/entradaConSobreCuadrado.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("perchero", null, null, "entrada");
		escena.getFondos().put("normal", "/img/Fondos/percheroConDestornillador.jpg");
		escena.getFondos().put("vacio", "/img/Fondos/percheroSinDestornillador.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("recibidor", null, null, "entrada");
		escena.getFondos().put("normal", "/img/Fondos/recibidorCerrado.jpg");
		escena.getFondos().put("abiertoArriba", "/img/Fondos/recibidorArriba.jpg");
		escena.getFondos().put("abiertoAbajo", "/img/Fondos/recibidorAbajo.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("puertacuadrado", null, null, "perchero");
		escena.getFondos().put("cerrada", "/img/Fondos/puertaCuadradoCerrada.jpg");
		escena.getFondos().put("abierta", "/img/Fondos/puertaCuadradoAbierta.jpg");
		escena.setEstado("cerrada");
		this.escenas.add(escena);
	
		escena = new Escena("puertacirculo", null, null, "entrada");
		escena.getFondos().put("cerrada", "/img/Fondos/puertaCirculoCerrada.jpg");
		escena.getFondos().put("abierta", "/img/Fondos/puertaCirculoAbierta.jpg");
		escena.setEstado("cerrada");
		this.escenas.add(escena);
	
		escena = new Escena("planta", null, null, "entrada");
		escena.getFondos().put("normal", "/img/Fondos/plantaConLlave.jpg");
		escena.getFondos().put("vacio", "/img/Fondos/plantaSinLlave.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("perchero", null, null, "entrada");
		escena.getFondos().put("normal", "/img/Fondos/percheroConDestornillador.jpg");
		escena.getFondos().put("vacio", "/img/Fondos/percheroSinDestornillador.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("sofa", null, null, "salon");
		escena.getFondos().put("normal", "/img/Fondos/sofaConPapel.jpg");
		escena.getFondos().put("vacio", "/img/Fondos/sofaSinPapel.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("estanteria", null, null, "salon");
		escena.getFondos().put("normal", "/img/Fondos/estanteria.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("cajacandado", null, null, "estanteria");
		escena.getFondos().put("cerrada", "/img/Fondos/candadoCerrada.jpg");
		escena.getFondos().put("abierta", "/img/Fondos/candadoAbierta.jpg");
		escena.getFondos().put("vacia", "/img/Fondos/candadoVacia.jpg");
		escena.setEstado("cerrada");
		this.escenas.add(escena);
	
		escena = new Escena("cajatornillos", null, null, "estanteria");
		escena.getFondos().put("cerrada", "/img/Fondos/tornillosCerrada.jpg");
		escena.getFondos().put("abierta", "/img/Fondos/tornillosAbierta.jpg");
		escena.getFondos().put("vacia", "/img/Fondos/tornillosVacia.jpg");
		escena.setEstado("cerrada");
		this.escenas.add(escena);
	
		escena = new Escena("mueble", null, null, "salon");
		escena.getFondos().put("normal", "/img/Fondos/mueble.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("ordenador", null, null, "mueble");
		escena.getFondos().put("normal", "/img/Fondos/pcApagado.jpg");
		escena.getFondos().put("ventanaCodigo", "/img/Fondos/pcEncendido1.jpg");
		escena.getFondos().put("ventanaInforme", "/img/Fondos/pcEncendido2.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("television", null, null, "mueble");
		escena.getFondos().put("normal", "/img/Fondos/tvApagada.jpg");
		escena.getFondos().put("encendida", "/img/Fondos/tvEncendida1.jpg");
		escena.getFondos().put("eleccion", "/img/Fondos/tvEncendida2.jpg");
		escena.getFondos().put("ecuacionCirculo", "/img/Fondos/tvEncendida3.jpg");
		escena.getFondos().put("ecuacionCuadrado", "/img/Fondos/tvEncendida4.jpg");
		escena.setEstado("normal");
		this.escenas.add(escena);
	
		escena = new Escena("cajatriangulos", null, null, "mueble");
		escena.getFondos().put("cerrada", "/img/Fondos/trianguloCerrada.jpg");
		escena.getFondos().put("abierta", "/img/Fondos/trianguloAbierta.jpg");
		escena.getFondos().put("vacia", "/img/Fondos/trianguloVacia.jpg");
		escena.setEstado("cerrada");
		this.escenas.add(escena);
		
		escena = new Escena("inicio", null, null, null);
		escena.getFondos().put("normal", "/img/Fondos/inicio.png");
		escena.setEstado("normal");
		this.escenas.add(escena);
		
		escena = new Escena("final", null, null, null);
		escena.getFondos().put("cuadrado", "/img/Fondos/finalCuadrado.jpg");
		escena.getFondos().put("circulo", "/img/Fondos/finalCirculo.jpg");
		escena.getFondos().put("bueno", "/img/Fondos/finalBueno.jpg");
		escena.setEstado("cuadrado");
		this.escenas.add(escena);
	}
}
