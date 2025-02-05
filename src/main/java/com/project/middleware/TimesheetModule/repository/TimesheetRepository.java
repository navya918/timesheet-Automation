package com.project.middleware.TimesheetModule.repository;
import com.project.middleware.TimesheetModule.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    // Custom query to find timesheets by employee ID
    List<Timesheet> findByEmployeeId(String employeeId);

    List<Timesheet> findByStatus(Timesheet.Status status);  // Find timesheets by status

    List<Timesheet> findByManagerId(String managerId);


List<Timesheet> findByEmployeeIdAndStartDateAndEndDate(String employeeId, LocalDate startDate, LocalDate endDate);
    List<Timesheet> findByManagerIdAndStatus(String managerId, Timesheet.Status status);
    List<Timesheet> findByManagerIdAndStartDate(String managerId,LocalDate startDate);

    boolean existsByEmployeeIdAndStartDateAndEndDateAndStatus(String employeeId, LocalDate startDate, LocalDate endDate,Timesheet.Status status);


//    Optional<Timesheet> findByEmployeeIdAndStartDateAndEndDate(String employeeId, LocalDate startDate, LocalDate endDate);



}
