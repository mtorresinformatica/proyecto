package com.example.proyecto.entidades;

import java.io.Serializable;
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


import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Clase que representa a un proyecto.
 *
 */
@Entity
@Table(name = "proyectos")
@Data @NoArgsConstructor
public class Proyecto implements Serializable{
	
	private static final long serialVersionUID = 1L;

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

	
}
