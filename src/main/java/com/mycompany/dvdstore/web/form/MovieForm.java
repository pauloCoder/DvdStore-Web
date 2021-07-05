package com.mycompany.dvdstore.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm
{
	private Long id;
	@NotBlank(message = "Veuillez entrer un titre")
	@Size(max = 20 , message = "Entrez un titre de 20 caractères au plus")
	private String title;
	@NotBlank(message = "Veuillez choisir un genre")
	private String genre;
	@Size(max = 255 , message = "Entrez une description de 255 caractères au plus") 
	private String description;
	
	@Size(max = 20 , message = "Entrez un nom de 255 caractères au plus") 
	private String nom;
	
	@Size(max = 20 , message = "Entrez un prénom de 255 caractères au plus") 
	private String prenom;
	
	
	public MovieForm()
	{
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}