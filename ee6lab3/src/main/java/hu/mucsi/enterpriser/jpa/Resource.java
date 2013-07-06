package hu.mucsi.enterpriser.jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the resources database table.
 * 
 */
@Entity
@Table(name="ee6lab3_resources")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="resources_id_seq",
                       sequenceName="ee6lab3_resources_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="resources_id_seq")
    @Column(name = "id", updatable=false)
	private Long id;

	@Column(length=32)
	private String category;

	@Column(length=200)
	private String image;

	@Column(length=32)
	private String manufacturer;

	@Column(length=32)
	private String type;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="resources")
	private List<User> users;

	public Resource() {
	}

	public Resource(String category, String manufacturer, String type,
			String image) {
		super();
		this.category = category;
		this.manufacturer = manufacturer;
		this.type = type;
		this.image = image;
	}

	public String getCategory() {
		return this.category;
	}

	public Long getId() {
		return id;
	}

	public String getImage() {
		return this.image;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public String getType() {
		return this.type;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}