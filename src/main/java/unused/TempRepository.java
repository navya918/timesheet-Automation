package unused;

import com.project.middleware.TimesheetModule.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TempRepository  {


//    Timesheet findByIdAndStatus(Long id, Timesheet.Status status);
//    List<Timesheet> findByEmployeeIdAndDate(String employeeId, LocalDate date);

//    List<Timesheet> findByEmployeeIdAndDateBetween(String employeeId, LocalDate startOfWeek,LocalDate endOfWeek);

//    List<Timesheet> findByEmployeeIdAndDateBetweenAndStatus
//   (String employeeId, LocalDate startDate,LocalDate endDate, Timesheet.Status status);


//    // Repository method to check if there's an overlapping timesheet for the employee
//    @Query("SELECT t FROM Timesheet t WHERE t.employeeId = :employeeId " +
//            "AND (:startDate <= t.endDate AND :endDate >= t.startDate)")
//    Optional<Timesheet> findOverlappingTimesheet(@Param("employeeId") String employeeId,
//                                                 @Param("startDate") LocalDate startDate,
//                                                 @Param("endDate") LocalDate endDate);


//    Optional<Timesheet> findByEmployeeIdAndStartDateAndEndDate(String employeeId, LocalDate startDate, LocalDate endDate);

//    Optional<Timesheet> existsByEmployeeIdAndStartDateAndEndDate(String employeeId, LocalDate startDate,LocalDate endDate);

//    List<Timesheet> findByEmployeeIdAndStartDateAndEndDateAndStatus(String employeeId, LocalDate startDate, LocalDate endDate,Timesheet.Status status);
//    @Query("SELECT t FROM Timesheet t WHERE t.employeeId = :employeeId AND t.startDate = :startDate AND t.endDate = :endDate AND t.status = :status AND t.id <> :id")
//    List<Timesheet> findPendingTimesheetsExcludingCurrent(@Param("employeeId") String employeeId,
//                                                          @Param("startDate") LocalDate startDate,
//                                                          @Param("endDate") LocalDate endDate,
//                                                          @Param("status") Timesheet.Status status,
//                                                          @Param("id") Long id);



}
