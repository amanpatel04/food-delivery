package com.foodservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ratings")
public class Rating {
	
	@Id
	@Column(name="rating_id")
	private Integer ratingId;
	

	@Column(name="rating")
	private Integer rating;
	
	@Column(name="review")
	private String review;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;

}
