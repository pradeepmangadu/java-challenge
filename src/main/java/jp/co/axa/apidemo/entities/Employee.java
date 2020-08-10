package jp.co.axa.apidemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

/**
 * This Class represents the DAO of the Rest Controller.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
@Data // Instead of using Getter and setter for each parameter @Data can be used.
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Employee Name is Required") // Added a Null constraint
	@Column(name = "EMPLOYEE_NAME")
	private String name;

	@NotNull(message = "Employee Salary is Required") // Added a Null constraint
	@Positive(message = "Employee Salary must be greater than 0") // Salary check to see if it is greater than zero
	@Column(name = "EMPLOYEE_SALARY")
	private Integer salary;

	@NotBlank(message = "Employee Department is Required") // Added a Null constraint
	@Column(name = "DEPARTMENT")
	private String department;

}
