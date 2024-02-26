#include <iostream>
using namespace std;
class Persona {
	protected : string nombres, apellidos, direccion, fecha_nacimiento;
	int telefono ;
	
	Persona (){
	}
	Persona ( string nom, string ape, string dir, string fec_nacimiento, int tel){
		nombres = nom;
		apellidos = ape;
		direccion = dir;
		fecha_nacimiento = fec_nacimiento;
		telefono = tel;
	}
	void crear();
	void leer();
	void borrar(); 
	void actualizar ();
	
	
	
};
