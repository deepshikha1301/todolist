package com.app.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {
	
	@Id
	@GeneratedValue
	@Column(updatable=false, nullable=false)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private TodoStatus status;

}
