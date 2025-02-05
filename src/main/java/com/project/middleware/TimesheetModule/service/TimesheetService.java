package com.project.middleware.TimesheetModule.service;

import com.project.middleware.TimesheetModule.dto.TimesheetDTO;
import com.project.middleware.TimesheetModule.entity.Timesheet;
import com.project.middleware.TimesheetModule.exception.TimesheetNotFoundException;
import com.project.middleware.TimesheetModule.repository.TimesheetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimesheetService {
    @Autowired
    private TimesheetRepository timesheetRepository;

    // Create a helper method to convert Timesheet to TimesheetDTO
    private TimesheetDTO mapToDTO(Timesheet timesheet) {
        // Check if the timesheet is null
        if (timesheet == null) {
            throw new TimesheetNotFoundException("Timesheet data is empty or not found.");
        }
        TimesheetDTO dto = new TimesheetDTO();
        dto.setEmployeeId(timesheet.getEmployeeId());
        dto.setNumberOfHours(timesheet.getNumberOfHours());
        dto.setExtraHours(timesheet.getExtraHours());
        dto.setReportingManager(timesheet.getReportingManager());
        dto.setClientName(timesheet.getClientName());
        dto.setProjectName(timesheet.getProjectName());
        dto.setTaskType(timesheet.getTaskType());
        dto.setWorkLocation(timesheet.getWorkLocation());
        dto.setTaskDescription(timesheet.getTaskDescription());
        dto.setEmailId(timesheet.getEmailId());
        dto.setStartDate(timesheet.getStartDate());
        dto.setEndDate(timesheet.getEndDate());
        dto.setOnCallSupport(timesheet.isOnCallSupport());
        dto.setId(timesheet.getId());
        dto.setEmployeeName(timesheet.getEmployeeName());
        dto.setManager(timesheet.getManager());
        dto.setManagerId(timesheet.getManagerId());
        dto.setStatus(timesheet.getStatus());
        dto.setComments(timesheet.getComments());

        dto.setTotalNumberOfHours(timesheet.getNumberOfHours()+timesheet.getExtraHours());
        return dto;
    }


    private static Timesheet getTimesheet(TimesheetDTO timesheetDTO) {
        Timesheet timesheet = new Timesheet();
        timesheet.setEmployeeId(timesheetDTO.getEmployeeId());
        timesheet.setNumberOfHours(timesheetDTO.getNumberOfHours());
        timesheet.setExtraHours(timesheetDTO.getExtraHours());
        timesheet.setReportingManager(timesheetDTO.getReportingManager());
        timesheet.setClientName(timesheetDTO.getClientName());
        timesheet.setProjectName(timesheetDTO.getProjectName());
        timesheet.setTaskType(timesheetDTO.getTaskType());
        timesheet.setWorkLocation(timesheetDTO.getWorkLocation());
        timesheet.setTaskDescription(timesheetDTO.getTaskDescription());
        timesheet.setEmailId(timesheetDTO.getEmailId());
        timesheet.setStartDate(timesheetDTO.getStartDate());
        timesheet.setEndDate(timesheetDTO.getEndDate());
        timesheet.setOnCallSupport(timesheetDTO.isOnCallSupport());
        timesheet.setId(timesheetDTO.getId());
        timesheet.setEmployeeName(timesheetDTO.getEmployeeName());
        timesheet.setStatus(timesheetDTO.getStatus());
//        timesheet.setStatus(Timesheet.Status.PENDING);
        timesheet.setManager(timesheetDTO.getManager());
        timesheet.setManagerId(timesheetDTO.getManagerId());
        timesheet.setComments(timesheetDTO.getComments());
        if(timesheetDTO.getStatus()!= Timesheet.Status.REJECTED && timesheetDTO.getStatus()!= Timesheet.Status.APPROVED ){
            timesheet.setStatus(Timesheet.Status.PENDING);
        }
        if(timesheetDTO.getEmailId()==null) {
            timesheet.setEmailId("harshavardhan@middlewaretalents.com");
        }
        if(timesheetDTO.getEmployeeId()==null){
            timesheet.setEmployeeId("MTL1015");
        }
        if(timesheetDTO.getEmployeeName()==null){
            timesheet.setEmployeeName("Harshavardhan");
        }
        if(timesheetDTO.getManagerId()==null){
            timesheet.setManagerId("MTL1001");
        }
        if(timesheetDTO.getManager()==null){
            timesheet.setManager("Jon");
        }
        return timesheet;
    }

    public TimesheetDTO createTimesheet(TimesheetDTO timesheetDTO) {
        // Validate the essential fields
        if (timesheetDTO == null || timesheetDTO.getEmployeeId() == null) {
            throw new TimesheetNotFoundException("Timesheet data is invalid or missing. Employee ID is required.");
        }
        if (timesheetDTO.getNumberOfHours() < 0) {
            throw new TimesheetNotFoundException("Number of hours cannot be negative.");
        }
        if (timesheetDTO.getStartDate() == null || timesheetDTO.getEndDate() == null) {
            throw new TimesheetNotFoundException("Start date and end date are required.");
        }

        // Fetch existing timesheets for the employee for the same start and end dates
        List<Timesheet> existingTimesheets = timesheetRepository.findByEmployeeIdAndStartDateAndEndDate(
                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate());

        Timesheet timesheet;

        if (!existingTimesheets.isEmpty()) {
            Timesheet existingTimesheet = existingTimesheets.getFirst(); // Use get(0) to get the first element
            System.out.println(existingTimesheet);

            // Check the status of the existing timesheet
            if (existingTimesheet.getStatus() == Timesheet.Status.APPROVED) {
                throw new TimesheetNotFoundException(
                        "Timesheet has already been approved and cannot be modified for dates: " +
                                existingTimesheet.getStartDate() + " to " + existingTimesheet.getEndDate());
            } else if (existingTimesheet.getStatus() == Timesheet.Status.REJECTED) {
                // If status is REJECTED, allow creating a new timesheet for the same date
                timesheet = getTimesheet(timesheetDTO);  // Create new timesheet for rejected case
            } else {
                // Allow modification of PENDING timesheet
                updateTimesheetFields(existingTimesheet, timesheetDTO);
                timesheet = existingTimesheet;  // Modify the existing timesheet
            }

            System.out.println(timesheet);
        } else {
            // Create a new timesheet if none exists
            timesheet = getTimesheet(timesheetDTO);
            System.out.println(timesheet);
        }

        // Check if a pending timesheet already exists for this employee for the same start and end dates
        if (timesheetRepository.existsByEmployeeIdAndStartDateAndEndDateAndStatus(
                timesheetDTO.getEmployeeId(), timesheetDTO.getStartDate(), timesheetDTO.getEndDate(), Timesheet.Status.PENDING)) {
            if (timesheetDTO.getId() == null) {
                throw new TimesheetNotFoundException("A timesheet with PENDING status already exists for these dates.");
            }
        }
        // Calculate total number of hours
        timesheetDTO.setTotalNumberOfHours(timesheet.getNumberOfHours() + timesheet.getExtraHours());

        // Save and return the updated or new timesheet
        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
        return mapToDTO(savedTimesheet);
    }

    // Method to retrieve all timesheets
    public List<TimesheetDTO> getAllTimesheets() {
        List<Timesheet> timesheets = timesheetRepository.findAll();
        if (timesheets.isEmpty()) {
            throw new TimesheetNotFoundException(timesheets);
        }
        // Convert each Timesheet entity to TimesheetDTO
        return timesheets.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    //getting the particular employee total details
    public List<TimesheetDTO> getTimesheetDetailsParticularEmployeeId(String employeeId) {
        // Retrieve the list of timesheets for the given employee ID
        List<Timesheet> timesheets = timesheetRepository.findByEmployeeId(employeeId);
        List<TimesheetDTO> timesheetDTOs = new ArrayList<>();
        // Check if the list of timesheets is not empty
        if (!timesheets.isEmpty()) {
            // Convert each Timesheet entity to TimesheetDTO
            for (Timesheet timesheet : timesheets) {
                TimesheetDTO timesheetDTO = mapToDTO(timesheet);
                timesheetDTOs.add(timesheetDTO); // Add the mapped DTO to the list
            }
            return timesheetDTOs;
        }
        // Handle no data found case
        throw new TimesheetNotFoundException(employeeId);
    }


    private void updateTimesheetFields(Timesheet existingTimesheet, TimesheetDTO timesheetDTO) {

            existingTimesheet.setNumberOfHours(timesheetDTO.getNumberOfHours());
            existingTimesheet.setExtraHours(timesheetDTO.getExtraHours());
            existingTimesheet.setReportingManager(timesheetDTO.getReportingManager());
            existingTimesheet.setClientName(timesheetDTO.getClientName());
            existingTimesheet.setProjectName(timesheetDTO.getProjectName());
            existingTimesheet.setTaskType(timesheetDTO.getTaskType());
            existingTimesheet.setWorkLocation(timesheetDTO.getWorkLocation());
            existingTimesheet.setTaskDescription(timesheetDTO.getTaskDescription());
            existingTimesheet.setEmailId(timesheetDTO.getEmailId());
            existingTimesheet.setStartDate(timesheetDTO.getStartDate());
            existingTimesheet.setEndDate(timesheetDTO.getEndDate());
            existingTimesheet.setOnCallSupport(timesheetDTO.isOnCallSupport());
//            existingTimesheet.setStatus(Timesheet.Status.PENDING);
            existingTimesheet.setComments(timesheetDTO.getComments());


    }


    //Update Method Based on ID
    public TimesheetDTO updateTimesheetById(Long id, TimesheetDTO timesheetDTO) {
        // Find the Timesheet by ID
        Timesheet existingTimesheet = timesheetRepository.findById(id).orElseThrow(() -> new TimesheetNotFoundException(id));
        updateTimesheetFields(existingTimesheet, timesheetDTO);

        // Save the updated entity
        Timesheet updatedTimesheet = timesheetRepository.save(existingTimesheet);

        // Map the updated entity back to the DTO and return it
        return mapToDTO(updatedTimesheet);
    }


    public List<TimesheetDTO> getDetailsFromManagerId(String managerId) {

        List<Timesheet> timesheets = timesheetRepository.findByManagerId(managerId);

        if (timesheets.isEmpty()) {

            throw new TimesheetNotFoundException(managerId);
        }

        return convertToTimesheetDTOs(timesheets);
    }

    public TimesheetDTO updateRejectStatus(Long id, Timesheet.Status status, String comments) {
        Timesheet timesheet = timesheetRepository.findById(id).orElseThrow(() -> new TimesheetNotFoundException(id));

        // Update status only if it's in PENDING, APPROVED, or REJECTED
        Optional.of(timesheet)
                .filter(t -> t.getStatus() == Timesheet.Status.PENDING || t.getStatus() == Timesheet.Status.APPROVED || t.getStatus() == Timesheet.Status.REJECTED)
                .ifPresent(t -> t.setStatus(status));
        timesheet.setComments(comments);

        timesheetRepository.save(timesheet);

        return mapToDTO(timesheet);
    }


    public TimesheetDTO updateApproveStatus(Long id, Timesheet.Status status) {
        Timesheet timesheet = timesheetRepository.findById(id)
                .orElseThrow(() -> new TimesheetNotFoundException(id));

        // Update status only if it's in PENDING, APPROVED, or REJECTED
        Optional.of(timesheet)
                .filter(t -> t.getStatus() == Timesheet.Status.PENDING ||
                        t.getStatus() == Timesheet.Status.APPROVED ||
                        t.getStatus() == Timesheet.Status.REJECTED)
                .ifPresent(t -> t.setStatus(status));

        timesheetRepository.save(timesheet);

        return mapToDTO(timesheet);
    }


    public List<TimesheetDTO> getDetailsByStatus(String managerId,Timesheet.Status status){
        List<Timesheet> timesheets=timesheetRepository.findByManagerIdAndStatus(managerId,status);
        if (timesheets.isEmpty()) {
            throw new TimesheetNotFoundException(managerId, status);
        }
        return convertToTimesheetDTOs(timesheets);

    }


   //convert List of Timesheet to List of TimesheetDTO
    public List<TimesheetDTO> convertToTimesheetDTOs(List<Timesheet> timesheets) {
        return timesheets.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    public List<TimesheetDTO> getTimesheetsByStatus(Timesheet.Status status){
      List<Timesheet> timesheets=timesheetRepository.findByStatus(status);
        if(timesheets.isEmpty()){
            throw new TimesheetNotFoundException(status);
        }
        return convertToTimesheetDTOs(timesheets);
    }


    public List<TimesheetDTO> getTimesheetsByManagerIdAndStartDate(String managerId,LocalDate startDate){
        List<Timesheet>timesheets=timesheetRepository.findByManagerIdAndStartDate(managerId,startDate);

        if(timesheets.isEmpty()){
            throw new TimesheetNotFoundException(managerId,startDate);
        }
        return convertToTimesheetDTOs(timesheets);
    }


    public boolean deleteTimesheet(Long id) {
        // Check if the Timesheet exists
        if (timesheetRepository.existsById(id)) {

            timesheetRepository.deleteById(id);
            return true; // Successfully deleted
        }
        return false; // No Timesheet found to delete
    }


    // Method to delete the entire timesheet of a particular employee based on employeeId
    public boolean deleteTimesheetByEmployeeId(String employeeId) {
        // Retrieve all timesheets for the given employeeId
        List<Timesheet> timesheets = timesheetRepository.findByEmployeeId(employeeId);
        if (!timesheets.isEmpty()) {
            // Delete all timesheets found for the employee
            timesheetRepository.deleteAll(timesheets);
            return true;
        } else {
            // No timesheets found for the employee, return false or handle accordingly
            return false;
        }
    }

}
