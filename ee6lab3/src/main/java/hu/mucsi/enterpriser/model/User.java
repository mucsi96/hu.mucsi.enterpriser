package hu.mucsi.enterpriser.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="ee6lab3_users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="users_id_seq",
                       sequenceName="ee6lab3_users_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="users_id_seq")
    @Column(name = "id", updatable=false)
	private Long id;

	@Column(length=32)
	private String email;

	@Column(length=32)
	private String firstname;

	@Column(length=32)
	private String lastname;

	//bi-directional many-to-many association to Resource
	@ManyToMany
	@JoinTable(
		name="ee6lab3_user_resource"
		, joinColumns={
			@JoinColumn(name="user_id", referencedColumnName="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="resource_id", referencedColumnName="id")
			}
		)
	private List<Resource> resources;

	public User() {
	}

	public User(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public Long getId() {
		return id;
	}

	public String getLastname() {
		return this.lastname;
	}

	public List<Resource> getResources() {
		return this.resources;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}