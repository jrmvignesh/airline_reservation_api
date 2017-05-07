package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="Passenger")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Passenger.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passenger implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="PassengerId")
    	private Long id;

        @Column(name="FirstName",nullable = false)
        private String firstname;
                
        @Column(name="LastName",nullable = false)
        private String lastname;
        
        @Column(name="Age",nullable = false)
        private int age;
        
        
        @Column(name="Gender",nullable = false)
        private String gender;
        
        
        @Column(name="Phone", unique=true)
        private String phone;
        
        
        public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public List<Reservation> getReservations() {
			return reservations;
		}


		public void setReservations(List<Reservation> reservations) {
			this.reservations = reservations;
		}


		@OneToMany(mappedBy="passenger")
        private List<Reservation> reservations;
		
        


   
}
