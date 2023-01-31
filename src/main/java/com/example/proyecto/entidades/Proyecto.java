package com.example.proyecto.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Clase que representa a un proyecto.
 *
 */
@Entity
@Table(name = "proyectos")
public class Proyecto {
	
	/**
	 * La ID del proyecto. Se genera por el motor de la base de datos.
	 */
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * El titulo del proyecto.
	 */
	@NotEmpty(message = "debe especificar un titulo")
	@Column(name = "Titulo")
	private String titulo;
	
	/**
	 * La fecha de inicio del proyecto.
	 */
	@NotNull(message = "debe registrar la fecha de inicio")
	@Column(name = "FechaInicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	
	/**
	 * La fecha de fin del proyecto.
	 */
	@NotNull(message = "debe registrar la fecha de fin")
	@Column(name = "FechaFin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFin;
	
	/**
	 * La descripción del proyecto.
	 */
	@Column(name = "Descripcion")
	private String descripcion;
	
	/**
	 * Los empleados pertenecientes al proyectos.
	 */
	@ManyToMany
	@JoinTable( name = "empleados_proyectos", 
		joinColumns = @JoinColumn(name = "proyecto_id"), 
		inverseJoinColumns = @JoinColumn(name = "empleado_dni"))
	private List<Empleado> empleados;
	
	/**
	 * Constructor básico.
	 */
	public Proyecto() {
		super();
	}
	
	/**
	 * Constructor completo.
	 * @param id la id.
	 * @param titulo el titulo.
	 * @param fechaInicio la fecha de inicio.
	 * @param fechaFin la fecha de fin.
	 * @param descripcion la descripcion.
	 * @param integrantes la lista de empleados pertenecientes.
	 */
	public Proyecto(Long id, @NotEmpty(message = "debe especificar un titulo") String titulo,
			@NotNull(message = "debe registrar la fecha de inicio") Date fechaInicio,
			@NotNull(message = "debe registrar la fecha de fin") Date fechaFin, String descripcion,
			List<Empleado> integrantes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.empleados = integrantes;
	}

	/**
	 * Constructor solo con la lista de empleados pertenecientes.
	 * @param integrantes la lista de empleados.
	 */
	public Proyecto(List<Empleado> integrantes) {
		super();
		this.empleados = integrantes;
	}

	/**
	 * Get id
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set id
	 * @param id id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get titulo
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Set titulo
	 * @param titulo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Get empleados
	 * @return empleados
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * Set empleados
	 * @param empleados empleados
	 */
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	/**
	 * Get fechaInicio
	 * @return fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Set fechaInicio
	 * @param fechaInicio fechaInicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Get fechaFin
	 * @return fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Set fechaFin
	 * @param fechaFin fechaFin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Get descripcion
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Get descripcion
	 * @param descripcion descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
