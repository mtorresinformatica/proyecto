package com.example.proyecto.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase que representa a un empleado.
 *
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
	
	/**
	 * El DNI del empleado.
	 */
	@Id
	@Column(name = "Dni", nullable = false)
	private String dni;
	
	/**
	 * El nombre del empleado.
	 */
	@NotEmpty(message = "debe especificar un nombre")
	@Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	/**
	 * El apellido del empleado.
	 */
	@NotEmpty(message = "debe especificar un apellido")
	@Column(name = "Apellido", nullable = false)
	private String apellido;
	
	/**
	 * La fecha de nacimiento del empleado.
	 */
	//@DateTimeFormat se usa para compatibilizar lo que se recibe del navegador web (<input type="date">) con la clase Date de Java.
	@NotNull(message = "debe registrar la fecha de nacimiento")
	@Column(name = "FechaNacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	/**
	 * Lista de proyectos a los que pertenece el empleado.
	 */
	@ManyToMany
	@JoinTable( name = "empleados_proyectos", 
		joinColumns = @JoinColumn(name = "empleado_dni"), 
		inverseJoinColumns = @JoinColumn(name = "proyecto_id"))
	private List<Proyecto> proyectos;
	
	/**
	 * Constructor principal.
	 */
	public Empleado() {
		super();
	}
	
	/**
	 * Constructor completo
	 * @param dni el dni del empleado.
	 * @param nombre el nombre del empleado.
	 * @param apellido el apellido del empleado.
	 * @param fechaNacimiento la fecha de nacimiento del empleado.
	 * @param proyectos lista de proyectos a los que pertence.
	 */
	public Empleado(String dni,
			@NotEmpty(message = "debe especificar un nombre") @Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12") String nombre,
			@NotEmpty(message = "debe especificar un apellido") String apellido,
			@NotNull(message = "debe registrar la fecha de nacimiento") Date fechaNacimiento,
			List<Proyecto> proyectos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.proyectos = proyectos;
	}

	/**
	 * Constructor solo con la lista de proyectos.
	 * @param proyectos lista de proyectos.
	 */
	public Empleado(List<Proyecto> proyectos) {
		super();
		this.proyectos = proyectos;
	}
	
	/**
	 * Get dni.
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Set dni
	 * @param dni dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Get nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Set nombre
	 * @param nombre nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Get apellido
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Set apellido
	 * @param apellido apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Get fechaNacimiento
	 * @return fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * Set fechaNacimiento
	 * @param fechaNacimiento fechaNacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Get proyectos
	 * @return proyectos
	 */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	/**
	 * Set proyectos
	 * @param proyectos proyectos
	 */
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	/**
	 * toString() with concadenate
	 */
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", proyectos=" + proyectos + "]";
	}

	private static final long serialVersionUID = 1L;
}
