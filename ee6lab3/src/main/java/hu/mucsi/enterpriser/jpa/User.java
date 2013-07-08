package hu.mucsi.enterpriser.jpa;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users",schema="ee6lab3")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE lower(u.firstname) like :name or lower(u.lastname) like :name")
})
public class User implements Serializable {
	
	@Override
	public String toString() {
		return firstname + " " + lastname ;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="users_id_seq",
                       sequenceName="users_id_seq",
                       allocationSize=1,schema="ee6lab3")
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
		name="user_resource",schema="ee6lab3"
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

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public User addResources(Resource resource) {
		if (resources == null) {
			resources = new LinkedList<Resource>();
		}
		resources.add(resource);
		return this;
	}

}