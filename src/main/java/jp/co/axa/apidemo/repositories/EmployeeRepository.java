package jp.co.axa.apidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.axa.apidemo.entities.Employee;

/**
 * This interface handles the DB Connection and gives the response back to
 * service class.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
