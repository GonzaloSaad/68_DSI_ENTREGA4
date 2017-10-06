/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_estado;

import clases_dominio.Lectura;
import clases_dominio.Propiedad;

/**
 *
 * @author Gonzalo
 */
public abstract class Estado {
    private String nombre; 
    private String ambito;
    private String descripcion;
    
    
    public void crearFactura(Lectura lectura){/**Implementacion Trivial**/}
    public void controlarLectura(Lectura lectura,boolean requiereRevision){/**Implementacion Trivial**/}
    public void corregirLectura(Lectura lectura){/**Implementacion Trivial**/}
    public void registrarMotivoDeNoCorreccion(Lectura lectura){/**Implementacion Trivial**/}
    public void evaluarLectura(Lectura lectura){/**Implementacion Trivial**/}
    public boolean esCreada(){return false;}
    public boolean esFacturada() { return false;}
    
    
}
