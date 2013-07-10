package hu.mucsi.enterpriser.jpa;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> id;
	  public static volatile SingularAttribute<User, String> email;
	  public static volatile SingularAttribute<User, String> firstname;
	  public static volatile SingularAttribute<User, String> lastname;
	  public static volatile SetAttribute<User, Resource> resources;
}
