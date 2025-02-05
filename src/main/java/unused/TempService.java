package unused;

import com.project.middleware.TimesheetModule.dto.TimesheetDTO;
import com.project.middleware.TimesheetModule.entity.Timesheet;
import com.project.middleware.TimesheetModule.exception.TimesheetNotFoundException;
import com.project.middleware.TimesheetModule.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TempService {

    @Autowired
    private TimesheetRepository timesheetRepository;



    //    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null||timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Date is required.");
//        }
//        Timesheet timesheet = getTimesheet(timesheetDTO);
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours()+timesheet.getExtraHours());
//
//        Stream.of(timesheet).collect(Collectors.groupingBy())
//
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet); // Return the saved Timesheet as a DTO
//
//    }


//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet with the same start and end date already exists
//        Optional<Timesheet> existingTimesheetOpt = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//        Timesheet timesheet;
//        if (existingTimesheetOpt.isPresent()) {
//            // Override the existing timesheet
//            timesheet = existingTimesheetOpt.get();
//
//                updateTimesheetFields(timesheet,timesheetDTO);
//        }
//        else {
//            // Create a new timesheet if no existing one is found
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }

//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet with the same start and end date already exists
//        Optional<Timesheet> existingTimesheetOpt = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//        Timesheet timesheet;
//        if (existingTimesheetOpt.isPresent()) {
//            timesheet=existingTimesheetOpt.get();
//           throw new TimesheetNotFoundException(timesheet.getEmployeeId(),timesheet.getStartDate(),timesheet.getEndDate());
//        }
//        else {
//            // Create a new timesheet if no existing one is found
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }


//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        System.out.println(Timesheet.Status.REJECTED == timesheetDTO.getStatus());
//        Timesheet timesheet;
//        if(Timesheet.Status.REJECTED == timesheetDTO.getStatus()) {
//
//            Optional<Timesheet> existingTimesheetOpt = timesheetRepository.findOverlappingTimesheet(
//                    timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//
//            if (existingTimesheetOpt.isPresent()) {
//                timesheet = existingTimesheetOpt.get();
//                throw new TimesheetNotFoundException(timesheet.getEmployeeId(), timesheet.getStartDate(), timesheet.getEndDate());
//            }
//        }
//
//            timesheet = getTimesheet(timesheetDTO);
//
//
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }



    //    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet already exists for this employee for the same date range
//        Optional<Timesheet> existingTimesheetOpt = timesheetRepository.findOverlappingTimesheet(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//        Timesheet timesheet;
//        if (existingTimesheetOpt.isPresent()) {
//            Timesheet existingTimesheet = existingTimesheetOpt.get();
//
//            // Check the status of the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
//                throw new TimesheetNotFoundException(
//                        "Timesheet has already been approved and cannot be modified for dates: " +
//                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
//            }
//
//            // If the timesheet is in `PENDING` status, allow changes to the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//                updateTimesheetFields(existingTimesheet, timesheetDTO);
//                timesheet = existingTimesheet;  // Modify the existing timesheet
//            } else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
//                // If status is REJECTED, allow creating a new timesheet for the same date
//                timesheet = getTimesheet(timesheetDTO); // Create new timesheet for rejected case
//            } else {
//                throw new TimesheetNotFoundException(
//                        "Timesheet cannot be updated in current status: " + existingTimesheet.getStatus());
//            }
//        } else {
//            // If no existing timesheet, create a new one
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        // Calculate total number of hours
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }

//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet already exists for this employee for the same start and end dates
//        List<Timesheet> existingTimesheetOpt = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//        System.out.println(existingTimesheetOpt);
//
//        Timesheet timesheet;
//        if (existingTimesheetOpt.isPresent()) {
//            Timesheet existingTimesheet = existingTimesheetOpt.get();
//
//            // Check the status of the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
//                throw new TimesheetNotFoundException(
//                        "Timesheet has already been approved and cannot be modified for dates: " +
//                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
//            }
//
//            // If the timesheet is in `PENDING` status, allow changes to the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//                System.out.println("Pending timesheet found, updating it.");
//                updateTimesheetFields(existingTimesheet, timesheetDTO);
//                timesheet = existingTimesheet;  // Modify the existing timesheet
//            }
//            else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
//                // If status is REJECTED, allow creating a new timesheet for the same date
//                System.out.println("Rejected timesheet found, creating a new one.");
//                timesheet = getTimesheet(timesheetDTO);  // Create new timesheet for rejected case
//            } else {
//                throw new TimesheetNotFoundException(
//                        "Timesheet cannot be updated in the current status: " + existingTimesheet.getStatus());
//            }
//        } else {
//            // If no existing timesheet, create a new one
//            System.out.println("No existing timesheet found, creating a new one.");
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        // Calculate total number of hours
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }

//    public List<TimesheetDTO> getApproveData(String managerId){
//        List<Timesheet> timesheets = timesheetRepository.findByManagerId(managerId);
//        List<Timesheet>approveData=timesheets.stream().filter(t->t.getStatus()== Timesheet.Status.APPROVED).toList();
//        List<TimesheetDTO> timesheetDTOS=new ArrayList<>();
//        for(Timesheet timesheet:approveData){
//            timesheetDTOS.add(mapToDTO(timesheet));
//        }
//        return timesheetDTOS;
//    }
//
//    public List<TimesheetDTO> getRejectData(String managerId){
//        List<Timesheet> timesheets = timesheetRepository.findByManagerId(managerId);
//        List<Timesheet>pendingData=timesheets.stream().filter(t->t.getStatus()== Timesheet.Status.REJECTED).toList();
//        List<TimesheetDTO> timesheetDTOS=new ArrayList<>();
//        for(Timesheet timesheet:pendingData){
//            timesheetDTOS.add(mapToDTO(timesheet));
//        }
//        return timesheetDTOS;
//    }


//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
////        // Validate the essential fields
////        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
////            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
////        }
////        if (timesheetDTO.getNumberOfHours() < 0) {
////            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
////        }
////        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
////            throw new TimesheetNotFoundException("Start date and end date are required.");
////        }
////
////        // Check if a timesheet already exists for this employee for the same start and end dates
////        List<Timesheet> existingTimesheets = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
////                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
////        System.out.println(existingTimesheets);
////
////        Timesheet timesheet;
////
////        if (!existingTimesheets.isEmpty()) {
////            Timesheet existingTimesheet = existingTimesheets.getLast();
////
////            // Check the status of the existing timesheet
////            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
////                throw new TimesheetNotFoundException(
////                        "Timesheet has already been approved and cannot be modified for dates: " +
////                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
////            }
////
////            // If the timesheet is in `PENDING` status, allow changes to the existing timesheet
////            if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//////                System.out.println("Pending timesheet found, updating it.");
////                updateTimesheetFields(existingTimesheet, timesheetDTO);
////                timesheet = existingTimesheet;  // Modify the existing timesheet
////
////
////            }
////            else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
////                // If status is REJECTED, allow creating a new timesheet for the same date
//////                System.out.println("Rejected timesheet found, creating a new one.");
////                timesheet = getTimesheet(timesheetDTO);  // Create new timesheet for rejected case
////            }
////            else {
////                throw new TimesheetNotFoundException(
////                        "Timesheet cannot be updated in the current status: " + existingTimesheet.getStatus());
////            }
////        } else {
////            // If no existing timesheet, create a new one
//////            System.out.println("No existing timesheet found, creating a new one.");
////            timesheet = getTimesheet(timesheetDTO);
////        }
////
////        // Calculate total number of hours
////        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
////
////        // Save the timesheet and return the DTO
////        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
////        return mapToDTO(savedTimesheet);
////    }

//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet already exists for this employee for the same start and end dates
//        List<Timesheet> existingTimesheets = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//        System.out.println(existingTimesheets);
//
//        Timesheet timesheet;
//
//        // If an existing timesheet is found
//        if (!existingTimesheets.isEmpty()) {
//            Timesheet existingTimesheet = existingTimesheets.getFirst(); // Assuming get(0) retrieves the first one
//
//            // Check the status of the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
//                throw new TimesheetNotFoundException(
//                        "Timesheet has already been approved and cannot be modified for dates: " +
//                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
//            }
//
//            // Throw an exception if the existing timesheet is PENDING
//            if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//                throw new TimesheetNotFoundException(
//                        "A pending timesheet already exists for these dates: " +
//                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
//            }
//
//            // If the status is REJECTED, allow creating a new timesheet for the same date
//            if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
//                timesheet = getTimesheet(timesheetDTO);  // Create new timesheet for rejected case
//            } else {
//                throw new TimesheetNotFoundException(
//                        "Timesheet cannot be updated in the current status: " + existingTimesheet.getStatus());
//            }
//        } else {
//            // If no existing timesheet, create a new one
//            timesheet = getTimesheet(timesheetDTO);
//        }
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }


//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//
//        Optional<Timesheet> existingTimesheetOpt = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//        Timesheet timesheet;
//
//        if (existingTimesheetOpt.isPresent()) {
//            Timesheet existingTimesheet = existingTimesheetOpt.get();
//
//            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
//                throw new TimesheetNotFoundException("Timesheet already approved for these dates.");
//            }
//            else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
//                timesheet = getTimesheet(timesheetDTO);
//            }
//            else if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//                // Check if another pending timesheet exists with the same dates excluding the current one
//                if (anotherPendingTimesheetExists(existingTimesheet)) {
//                    throw new TimesheetNotFoundException("A timesheet for the selected dates has already been submitted. Please check and try again.");
//                }
//                updateTimesheetFields(existingTimesheet, timesheetDTO);
//                timesheet = existingTimesheet;
//            }
//            else {
//                throw new TimesheetNotFoundException("Timesheet cannot be modified in its current status: " + existingTimesheet.getStatus());
//            }
//        }
//        else {
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        timesheetDTO.setTotalNumberOfHours((timesheet.getNumberOfHours() != null ? timesheet.getNumberOfHours() : 0) +
//                (timesheet.getExtraHours() != null ? timesheet.getExtraHours() : 0));
//
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }
//
//    private boolean anotherPendingTimesheetExists(Timesheet currentTimesheet) {
//        List<Timesheet> pendingTimesheets = timesheetRepository.findPendingTimesheetsExcludingCurrent(
//                currentTimesheet.getEmployeeId(),
//                currentTimesheet.getStartDate(),
//                currentTimesheet.getEndDate(),
//                Timesheet.Status.PENDING,
//                currentTimesheet.getId()
//        );
//        return !pendingTimesheets.isEmpty();
//    }




    // Helper method to check if data has changed, excluding date fields
//    private boolean dataChanged(Timesheet existingTimesheet, TimesheetDTO timesheetDTO) {
//        return !existingTimesheet.getNumberOfHours().equals(timesheetDTO.getNumberOfHours()) ||
//                !existingTimesheet.getExtraHours().equals(timesheetDTO.getExtraHours()) ||
//                !existingTimesheet.getReportingManager().equals(timesheetDTO.getReportingManager()) ||
//                !existingTimesheet.getClientName().equals(timesheetDTO.getClientName()) ||
//                !existingTimesheet.getProjectName().equals(timesheetDTO.getProjectName()) ||
//                !existingTimesheet.getTaskType().equals(timesheetDTO.getTaskType()) ||
//                !existingTimesheet.getWorkLocation().equals(timesheetDTO.getWorkLocation()) ||
//                !existingTimesheet.getTaskDescription().equals(timesheetDTO.getTaskDescription()) ||
//                !existingTimesheet.getEmailId().equals(timesheetDTO.getEmailId()) ||
//                existingTimesheet.isOnCallSupport() != timesheetDTO.isOnCallSupport() ||
//                !existingTimesheet.getComments().equals(timesheetDTO.getComments());
//    }





//    public TimesheetDTO mapToDTO(Timesheet timesheet){
//        return modelMapper.map(timesheet,TimesheetDTO.class);
//    }
//    public Timesheet getTimesheet(TimesheetDTO timesheetDTO){
//        return modelMapper.map(timesheetDTO,Timesheet.class);
//    }


//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet already exists for this employee for the same start and end dates
//        List<Timesheet> existingTimesheets = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//        Timesheet timesheet;
//
//        if (!existingTimesheets.isEmpty()) {
//
//            // Count the number of pending timesheets
//            long pendingCount = existingTimesheets.stream()
//                    .filter(t -> t.getStatus() == Timesheet.Status.PENDING)
//                    .count();
//            System.out.println(pendingCount);
//
//            // If more than one pending timesheet exists, throw an exception
//            if (pendingCount > 1) {
//                throw new TimesheetNotFoundException("Multiple pending timesheets exist for these dates.");
//            }
//            Timesheet existingTimesheet = existingTimesheets.getLast();
//
//            // Check the status of the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
//                throw new TimesheetNotFoundException(
//                        "Timesheet has already been approved and cannot be modified for dates: " +
//                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
//            }
//
//            // If the timesheet is in `PENDING` status, allow changes to the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//
////                if(existingTimesheets.size()>1){
////                    throw new TimesheetNotFoundException(
////                            "Timesheet has already been pending and cannot be modified for dates: " +
////                                    existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
////                }
//                if(updateData(existingTimesheet)) {
//                    updateTimesheetFields(existingTimesheet, timesheetDTO);
//                    timesheet = existingTimesheet;  // Modify the existing timesheet
//                }
//                else {
//                    throw  new TimesheetNotFoundException("already exist");
//                }
//            }
//            else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
//                // If status is REJECTED, allow creating a new timesheet for the same date
//                timesheet = getTimesheet(timesheetDTO);  // Create new timesheet for rejected case
//            }
//            else {
//                throw new TimesheetNotFoundException(
//                        "Timesheet cannot be updated in the current status: " + existingTimesheet.getStatus());
//            }
//        } else {
//            // If no existing timesheet, create a new one
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        // Calculate total number of hours
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }
//
//    private boolean updateData(Timesheet timesheet){
//        Timesheet existingTimesheet=new Timesheet();
//
//        existingTimesheet.setNumberOfHours(timesheet.getNumberOfHours());
//        existingTimesheet.setExtraHours(timesheet.getExtraHours());
//        existingTimesheet.setReportingManager(timesheet.getReportingManager());
//        existingTimesheet.setClientName(timesheet.getClientName());
//        existingTimesheet.setProjectName(timesheet.getProjectName());
//        existingTimesheet.setTaskType(timesheet.getTaskType());
//        existingTimesheet.setWorkLocation(timesheet.getWorkLocation());
//        existingTimesheet.setTaskDescription(timesheet.getTaskDescription());
//        existingTimesheet.setEmailId(timesheet.getEmailId());
//        existingTimesheet.setStartDate(timesheet.getStartDate());
//        existingTimesheet.setEndDate(timesheet.getEndDate());
//        existingTimesheet.setOnCallSupport(timesheet.isOnCallSupport());
////            existingTimesheet.setStatus(Timesheet.Status.PENDING);
//        existingTimesheet.setComments(timesheet.getComments());
//
//        return existingTimesheet.equals(timesheet)?false:true;
//
//    }


//
//    private boolean updateData(Timesheet existingTimesheet, TimesheetDTO timesheetDTO) {
//        // Compare numeric values directly and check for equality
//        return existingTimesheet.getNumberOfHours() != timesheetDTO.getNumberOfHours() ||
//                existingTimesheet.getExtraHours() != timesheetDTO.getExtraHours() ||
//                !existingTimesheet.getReportingManager().equals(timesheetDTO.getReportingManager()) ||
//                !existingTimesheet.getClientName().equals(timesheetDTO.getClientName()) ||
//                !existingTimesheet.getProjectName().equals(timesheetDTO.getProjectName()) ||
//                !existingTimesheet.getTaskType().equals(timesheetDTO.getTaskType()) ||
//                !existingTimesheet.getWorkLocation().equals(timesheetDTO.getWorkLocation()) ||
//                !existingTimesheet.getTaskDescription().equals(timesheetDTO.getTaskDescription()) ||
//                !existingTimesheet.getEmailId().equals(timesheetDTO.getEmailId()) ||
//                !existingTimesheet.getStartDate().equals(timesheetDTO.getStartDate()) ||
//                !existingTimesheet.getEndDate().equals(timesheetDTO.getEndDate()) ||
//                existingTimesheet.isOnCallSupport() != timesheetDTO.isOnCallSupport() ||
//                !existingTimesheet.getComments().equals(timesheetDTO.getComments());
//    }





//    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
//        // Validate the essential fields
//        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
//            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
//        }
//        if (timesheetDTO.getNumberOfHours() < 0) {
//            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
//        }
//        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
//            throw new TimesheetNotFoundException("Start date and end date are required.");
//        }
//
//        // Check if a timesheet already exists for this employee for the same start and end dates
//        List<Timesheet> existingTimesheets = timesheetRepository.findByEmployeeIdAndStartDateAndEndDates(
//                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());
//
//        Timesheet timesheet;
//
//        if (!existingTimesheets.isEmpty()) {
//
//           // Count the number of pending timesheets
//            long pendingCount = existingTimesheets.stream()
//                    .filter(t -> t.getStatus() == Timesheet.Status.PENDING)
//                    .count();
//            System.out.println(pendingCount);
//
//            // If more than one pending timesheet exists, throw an exception
//            if (pendingCount > 1) {
//                throw new TimesheetNotFoundException("Multiple pending timesheets exist for these dates.");
//            }
//            Timesheet existingTimesheet = existingTimesheets.getLast();
//
//            // Check the status of the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
//                throw new TimesheetNotFoundException(
//                        "Timesheet has already been approved and cannot be modified for dates: " +
//                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
//            }
//
//            // If the timesheet is in `PENDING` status, allow changes to the existing timesheet
//            if (existingTimesheet.getStatus() == Timesheet.Status.PENDING) {
//                updateTimesheetFields(existingTimesheet, timesheetDTO);
//                timesheet = existingTimesheet;  // Modify the existing timesheet
//
//            }
//            else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
//                // If status is REJECTED, allow creating a new timesheet for the same date
//                timesheet = getTimesheet(timesheetDTO);  // Create new timesheet for rejected case
//            }
//            else {
//                throw new TimesheetNotFoundException(
//                        "Timesheet cannot be updated in the current status: " + existingTimesheet.getStatus());
//            }
//        } else {
//            // If no existing timesheet, create a new one
//            timesheet = getTimesheet(timesheetDTO);
//        }
//
//        // Calculate total number of hours
//        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());
//
//        // Save the timesheet and return the DTO
//        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
//        return mapToDTO(savedTimesheet);
//    }














}
