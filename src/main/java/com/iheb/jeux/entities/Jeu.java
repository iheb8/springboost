package com.iheb.jeux.entities;


	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Jeu {	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long IdJeu;
		private String nomJeu;
		private Double prixJeu;
		private Date dateCreation;

		public Jeu() {
			super();
		}

		public Jeu(String nomJeu, Double prixJeu, Date dateCreation) {
			super();
			this.nomJeu = nomJeu;
			this.prixJeu = prixJeu;
			this.dateCreation = dateCreation;
		}

		public Long getIdJeu() {
			return IdJeu;
		}

		public void setIdJeu(Long IdJeu) {
			this.IdJeu = IdJeu;
		}

		public String getNomJeu() {
			return nomJeu;
		}

		public void setNomJeu(String nomJeu) {
			this.nomJeu = nomJeu;
		}

		public Double getPrixJeu() {
			return prixJeu;
		}

		public void setPrixJeu(Double prixJeu) {
			this.prixJeu = prixJeu;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		@Override
		public String toString() {
			return "Jeu [IdJeu=" + IdJeu + ", nomJeu=" + nomJeu + ", prixJeu=" + prixJeu + ", dateCreation="
					+ dateCreation + "]";
		}
		
		
		
		
	
}
