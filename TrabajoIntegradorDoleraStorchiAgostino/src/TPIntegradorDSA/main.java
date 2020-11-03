package TPIntegradorDSA;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class main {

	public static void main(String[] args) {
		
		ArrayList <Cliente> Mecanico = new ArrayList <Cliente>(); 
		
		Cliente Lautaro = new Cliente("Lautaro", "Perez", "Escobar","Oro", "lautaro.perez", "123", 100, 3, 4);
		Cliente Gian = new Cliente("Gian", "Storki", "Pilar", "Plata", "gian.storchi", "456", 100, 2, 3);
		
		Mecanico.add(Lautaro);
		Mecanico.add(Gian);
		
		menu(Mecanico);
		

	}

	
	
	public static void menu(ArrayList <Cliente> a) {
		ArrayList <Cliente> array = new ArrayList<Cliente>();
		
		
		do {
			int option = Integer.parseInt(JOptionPane.showInputDialog(null,
							"1) Registrar nuevo usuario \n"+
							"2) Ingresar con usuario \n" +
							"3) Imprimir lista Clientes \n" +
							"4) Salir \n" +
							"Ingrese opción del 1 al 4", "Menú Mecánico", JOptionPane.QUESTION_MESSAGE));
		
			switch(option) {
			case 1:
				array= register(a);
				a.addAll(array);
				break;
			case 2:
				login(a); break;
			case 3:	
				imprimirClientes(a);
			case 4:
				System.exit(0); break;
			}
		
		} while(true);
		
	}
	
	public static void login(ArrayList <Cliente> lista) {
		JTextField user = new JTextField();
		JTextField pass = new JTextField();
		Boolean register = false;
		String name = "";
		String surname = "";
		int matricula = 0;
		
		Object[] message = {
			    "Usuario:", user,
			    "Contraseña:", pass,		    
			};
			Component parent = null;
			int option = JOptionPane.showConfirmDialog(parent, message, "Ingrese sus credenciales ", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION){
			    String value1 = user.getText();				//Panel para ingresar credenciales
			    String value2 = pass.getText();
			}
		
		String StrPassword = pass.getText();				//Convierte password en String
		
		
			
		for (int i=0; i<lista.size(); i++) {
			if ((lista.get(i).getUser().equalsIgnoreCase(user.getText()) && (lista.get(i).getPassword().equals(StrPassword)))) {
				register = true;							//Valida si existe un cliente con las credenciales dadas
				name = lista.get(i).getNombre();
				surname = lista.get(i).getApellido();
			}
		}	
			
		if (register == false) {						//Devuelve un mensaje si esta o no registrado
			JOptionPane.showMessageDialog(null, "Las credenciales son incorrectas o usted no está registrado");
		} else {
			JOptionPane.showMessageDialog(null, "¡Inicio de sesión con éxito!");
			ServicioOption(lista, name, surname);
		}
		
	}
	
	public static ArrayList <Cliente> register(ArrayList <Cliente> a) {
		
		ArrayList <Cliente> Usuario = new ArrayList<Cliente>();
		
		JTextField nombre = new JTextField();
		JTextField apellido = new JTextField();
		JTextField localidad = new JTextField();
		Boolean register = false;
		int tipo = 0;
		
		Object[] message = {
		    "Nombre: ", nombre,
		    "Apellido: ", apellido,
		    "Localidad: ", localidad,
		};
		Component parent = null;
		int option = JOptionPane.showConfirmDialog(parent, message, "Ingrese sus datos personales: ", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION){			//Panel para ingresar los datos
		    String value1 = nombre.getText();
		    String value2 = apellido.getText();
		    String value4 = localidad.getText();
		}
		
		//Crea password numerica y la convierte a string
		int password = (int) (Math.random()*10000);
		String pass = String.valueOf(password);
		
		String usuario = nombre.getText().toLowerCase() + "."+ apellido.getText().toLowerCase();
		System.out.println(usuario);
		System.out.println(password);
		
		
		/*
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog(null,
											"1) Auxilio Mecánico \n" +
											"2) Grúa \n" +
											"3) Cerrajero \n" +
											"4) Salir " +
											"Ingrese opción del 1 al 4", "Servicios Mecánicos", JOptionPane.QUESTION_MESSAGE));
			switch(option) {
				case 1: servicio = 1 ;
				register = true; break;
				case 2: servicio = 2;
				register = true; break;
				case 3: servicio = 3;
				register = true; break;
				case 4: System.exit(0); break;
			}
		} while(register = false);
		*/
	
				
		int servAux = 0;
		int servGrua = 0;
		int servCer = 0;
		
		tipo = JOptionPane.showOptionDialog( null,"Seleccione el tipo de servicio que usted desea adquirir: ",
						  "Servicio Mecánico",JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
						new Object[] { "Oro", "Plata",},null);
					String tipo1 = "";
															//Genera un menu para guardar el tipo de cliente
					if (tipo == 1){
						tipo1 = "Oro";
						servAux = 100;
						servGrua = 3;					//Agrega cantidad de servicios dependiendo del tipo de cliente
						servCer = 4;
					}else if(tipo == 2){
						tipo1 = "Plata";
						servAux = 100;
						servGrua = 2;
						servCer = 3;
					}
				 
		
		
				 
		
		//Genera el cliente con los datos dados y lo agrega al ArrayList
		Cliente user = new Cliente (nombre.getText(), apellido.getText(), localidad.getText(), tipo1, usuario, pass, servAux, servGrua, servCer);
		Usuario.add(user);
		
		
		//Escribe mensaje avisando que se cargo correctamente y los datos del usuario
		String message2 ="";
		
		message2 = message2 + "	Los datos del usuario son:\n\n "+ usuario + " \n"+ password + "\n\n >>Recuérdelos para volver a iniciar sesión<< " ;
		JOptionPane.showMessageDialog(null, message2);
		
		return Usuario;
	}
	
	public static void ServicioOption(ArrayList<Cliente> lista, String name, String surname) {
		int contMeca;
		int contGrua;
		int contCerrajero;
		int distMax = 700;
		int indice = 0;
		
		System.out.println(name + " " + surname);
		
		int seleccion = JOptionPane.showOptionDialog( null,"Seleccione el tipo de servicio que usted desea adquirir: ",
				  "Servicio Mecánico",JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto. //Genera un menu para guardar el tipo de servicio
				  new Object[] { "Auxilio Mecánico", "Grúa", "Cerrajero",},null);
		
		
		
		for(int i = 0; i<lista.size(); i++) {			//Busca el indice del cliente para ubicarlo en la lista
			if(lista.get(i).getNombre().equalsIgnoreCase(name) && lista.get(i).getApellido().equalsIgnoreCase(surname)) {
				indice = i;
			}
		}
		
		
		switch(seleccion) {
			case 0: JOptionPane.showMessageDialog(null, "Usted selecciono Auxilio Mecanico.\nLe quedan ilimitados llamados.");
					break;
			case 1: VerificarTipo(lista, name, surname, seleccion, indice);
					break;
			case 2: VerificarTipo(lista, name, surname, seleccion, indice); 
					break;
		}

		
	}
	
	public static void VerificarTipo(ArrayList<Cliente> lista, String name, String surname, int seleccion, int indice) {
		int flag = 0;
		
		if(lista.get(indice).getTipo().equals("Oro")) {				//Verifica de que tipo es para asi cuantificar las cantidades de servicios
			if(seleccion == 1) {
				flag = lista.get(indice).getServicioGrua();
				flag = flag - 1;
				lista.get(indice).setServicioGrua(flag);
				JOptionPane.showMessageDialog(null, "Usted selecciono Servicio de Grua.\nLe quedan " + lista.get(indice).getServicioGrua() + " restantes."); 
			} else {
				flag = lista.get(indice).getServicioCer();
				flag = flag - 1;
				lista.get(indice).setServicioCer(flag);;
				JOptionPane.showMessageDialog(null, "Usted selecciono Servicio de Cerrajero.\nLe quedan " + lista.get(indice).getServicioCer() + " restantes.");
			}
		} else {
			if(seleccion == 1) {
				flag = lista.get(indice).getServicioGrua();
				flag = flag - 1;
				lista.get(indice).setServicioGrua(flag);
				JOptionPane.showMessageDialog(null, "Usted selecciono Servicio de Grua.\nLe quedan " + lista.get(indice).getServicioGrua() + " restantes."); 
			} else {
				flag = lista.get(indice).getServicioCer();
				flag = flag - 1;
				lista.get(indice).setServicioCer(flag);;
				JOptionPane.showMessageDialog(null, "Usted selecciono Servicio de Cerrajero.\nLe quedan " + lista.get(indice).getServicioCer() + " restantes.");
			}
		}
		
		
	}
	
	public static void imprimirClientes(ArrayList<Cliente> lista) {
		
		for(Cliente e : lista) {
			System.out.println("Cliente: " + e.getNombre() + " " + e.getApellido() + ".\nUser: " + e.getUser() + "  Password: " + e.getPassword() + ", es de tipo " + e.getTipo() + "." +
								"\nLe quedan " + e.getServicioAux() + " Servicios de Auxilio Mecanico." +
								"\n          " + e.getServicioGrua() + " Servicios de Grua." +
								"\n          " + e.getServicioCer() + " Servicios de Cerrajero.\n");
		}
	}
	
}
