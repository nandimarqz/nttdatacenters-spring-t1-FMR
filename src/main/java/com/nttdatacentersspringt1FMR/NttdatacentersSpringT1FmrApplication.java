package com.nttdatacentersspringt1FMR;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdatacentersspringt1FMR.persistence.Flat;
import com.nttdatacentersspringt1FMR.persistence.Floor;
import com.nttdatacentersspringt1FMR.persistence.Person;
import com.nttdatacentersspringt1FMR.services.BuildingManagmentServiceI;
import com.nttdatacentersspringt1FMR.services.FlatManagmentServiceI;
import com.nttdatacentersspringt1FMR.services.FloorManagmentServiceI;
import com.nttdatacentersspringt1FMR.services.PersonManagmentServiceI;

/**
 * Clase principal
 * 
 * @author nandi
 *
 */
@SpringBootApplication
public class NttdatacentersSpringT1FmrApplication implements CommandLineRunner {

	/** Servicio de gestion de los pisos */
	@Autowired
	FlatManagmentServiceI fr;

	/** Servicio de gestion de las plantas */
	@Autowired
	FloorManagmentServiceI flr;

	/** Servicio de gestion de las personas */
	@Autowired
	PersonManagmentServiceI pr;

	/** Servicio de gestion del edificio */
	@Autowired
	BuildingManagmentServiceI br;

	/** Logger para la clase */
	private static final Logger MAINLOG = LoggerFactory.getLogger(NttdatacentersSpringT1FmrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT1FmrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		generateTestData();

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println(showMenu());// Muetsra el menu
			int option = sc.nextInt(); // Recoge la opcion

			// Si la opcion es distinta de -1 entra en el bucle
			while (option != -1) {

				// Va al caso que indique la opcion
				switch (option) {

				case 1:

					MAINLOG.debug("Caso 1 Seleccionado");
					// Muestra los habitantes
					System.out.println(br.showInHabitants());

					break;

				case 2:

					MAINLOG.debug("Caso 2 Seleccionado");

					System.out.println("Introduzca el nombre:");// Pide el nombre
					sc.nextLine();
					String name = sc.nextLine();// Lo recoge

					System.out.println("Introduzca el primer apellido:");// Pide el primer apellido
					String firstSurname = sc.nextLine();// Recoge el primer apellido

					System.out.println("Introduzca el segundo apellido:");// Pide el segundo apellido
					String secondSurname = sc.nextLine();// Recoge el segundo apellido

					// Muestra una persona por nombres y apellidos
					System.out.println(pr.findByNameAndSurnames(name, firstSurname, secondSurname));

					break;

				default:

					MAINLOG.debug("Caso default Seleccionado");

					System.out.println("No se ha encontrado ninguna opcion con el numero introducido");

				}

				System.out.println(showMenu());// Vuelve a mostrar el menu
				option = sc.nextInt();// Recoge la opcion

			}

		}

	}

	/**
	 * Genera datos de prueba en la BBDD
	 */
	public void generateTestData() {

		MAINLOG.debug("Inicio del metodo");

		// Auditoría.
		final String updatedUser = "FMR";
		final Date updatedDate = new Date();

		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();

		Floor f1 = new Floor();
		Floor f2 = new Floor();

		Flat fl1 = new Flat();
		Flat fl2 = new Flat();

		p1.setName("Fernando");
		p1.setFirstSurname("Marquez");
		p1.setSecondSurname("Rodriguez");
		p1.setDni("11111111L");
		p1.setUpdatedDate(updatedDate);
		p1.setUpdatedUser(updatedUser);

		p2.setName("David");
		p2.setFirstSurname("Rodriguez");
		p2.setSecondSurname("Aguilar");
		p2.setDni("11111111X");
		p2.setUpdatedDate(updatedDate);
		p2.setUpdatedUser(updatedUser);

		p3.setName("Antoñito");
		p3.setFirstSurname("Martinez");
		p3.setSecondSurname("Martin");
		p3.setDni("11111111S");
		p3.setUpdatedDate(updatedDate);
		p3.setUpdatedUser(updatedUser);

		f1.setNumber(1);
		f1.setUpdatedDate(updatedDate);
		f1.setUpdatedUser(updatedUser);

		f2.setNumber(2);
		f2.setUpdatedDate(updatedDate);
		f2.setUpdatedUser(updatedUser);

		fl1.setNumber(1);
		fl1.setUpdatedDate(updatedDate);
		fl1.setUpdatedUser(updatedUser);
		fl1.setFloor(f2);
		p1.setFlat(fl1);
		p2.setFlat(fl1);

		fl2.setNumber(2);
		fl2.setUpdatedDate(updatedDate);
		fl2.setUpdatedUser(updatedUser);
		fl2.setFloor(f1);
		p3.setFlat(fl2);

		List<Flat> flatsF1 = new ArrayList<>();
		List<Flat> flatsF2 = new ArrayList<>();

		flatsF1.add(fl2);
		flatsF2.add(fl1);

		f1.setFlats(flatsF1);
		f2.setFlats(flatsF2);

		List<Person> peoplefl1 = new ArrayList<>();
		List<Person> peoplefl2 = new ArrayList<>();

		peoplefl1.add(p1);
		peoplefl1.add(p2);

		peoplefl2.add(p3);

		fl1.setPeople(peoplefl1);
		fl2.setPeople(peoplefl2);

		flr.add(f1);
		flr.add(f2);

		p1.setSecondSurname("Rodríguez");
		p1.setFirstSurname("Márquez");

		pr.update(p1);

		MAINLOG.debug("Fin del metodo");

	}

	/**
	 * Muestra el menu de las opciones que se puede realizar
	 * 
	 * @return String
	 */
	public static String showMenu() {

		MAINLOG.debug("Mostrando menu");

		StringBuilder str = new StringBuilder();

		str.append("Escriba el numero de la opcion que quiere realizar: \n");

		str.append("\t1.Mostrar todos los habitantes\n");
		str.append("\t2.Mostrar habitante por nombre y apellidos\n");

		return str.toString();
	}

}
