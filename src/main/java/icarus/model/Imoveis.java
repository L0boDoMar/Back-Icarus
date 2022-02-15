package icarus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "imovel")

public class Imoveis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String name; //nome
	
	@Column(name = "rua", nullable = false)
	private String street; //endereço
	
	@Column(name="descricao")
	@Lob
	private String description;//descrição
	
	@Column(name = "cidade", nullable = false)
	private String city; //cidade
	
	@Column(name="bairro", nullable=false)
	private String district; //bairro
	
	@Column(name="cep", nullable=false)
	private String cep;
	
	@Column(name = "vigilancia")
	private String surveillance; //há vigilancia?
	
	@Column(name = "estacionamento")
	private String parkinglots; //há estacionamento?
	
	@Column(name = "imagem")
	private String picture; //imagens
	
	@Column(name="numero")
	private int number; //número
	
	@Column(name = "area", nullable = false)
	private double area; //área
	
	@Column(name = "ano_construcao")
	private int construction_year; //ano de construção
	
	@Column(name = "preco_aluguel", nullable = false)
	private double rent_price; //preço do aluguel
	
	@Column(name = "preco_m2", nullable = false)
	private double price_perm2; //preço por m2
	
	@Column(name = "banheiros", nullable = false)
	private int bathrooms; //quantidade de banheiros
	
	
	//getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getConstruction_year() {
		return construction_year;
	}
	public void setConstruction_year(int construction_year) {
		this.construction_year = construction_year;
	}
	public double getRent_price() {
		return rent_price;
	}
	public void setRent_price(double rent_price) {
		this.rent_price = rent_price;
	}
	public double getPrice_perm2() {
		return price_perm2;
	}
	public void setPrice_perm2(double price_perm2) {
		this.price_perm2 = price_perm2;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSurveillance() {
		return surveillance;
	}
	public void setSurveillance(String surveillance) {
		this.surveillance = surveillance;
	}
	
	public String getParkinglots() {
		return parkinglots;
	}
	public void setParkinglots(String parkinglots) {
		this.parkinglots = parkinglots;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
}
