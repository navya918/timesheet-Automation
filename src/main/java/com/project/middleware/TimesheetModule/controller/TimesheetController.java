package com.project.middleware.TimesheetModule.controller;
import com.project.middleware.TimesheetModule.dto.TimesheetDTO;
import com.project.middleware.TimesheetModule.entity.Timesheet;
import com.project.middleware.TimesheetModule.service.EmailService;
import com.project.middleware.TimesheetModule.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http//localhost:3000")
@RequestMapping("/api/timesheets")
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @Autowired
    private EmailService emailService;




    @PostMapping
    public ResponseEntity<TimesheetDTO> createTimesheets(@RequestBody TimesheetDTO timesheetDTO) {
        TimesheetDTO createdTimesheet = timesheetService.createTimesheet(timesheetDTO);
        return new ResponseEntity<>(createdTimesheet, HttpStatus.CREATED);
    }

    // API endpoint to retrieve all timesheets
    @GetMapping("/all")
    public ResponseEntity<List<TimesheetDTO>> getAllTimesheets() {
        List<TimesheetDTO> timesheets = timesheetService.getAllTimesheets();
        return new ResponseEntity<>(timesheets, HttpStatus.OK);
    }

    @GetMapping("/list/{employeeId}")
    public List<TimesheetDTO> getTimesheetDetails(@PathVariable String employeeId) {
        return timesheetService.getTimesheetDetailsParticularEmployeeId(employeeId);
    }



    @GetMapping("/list/manager/{managerId}")
    public List<TimesheetDTO> getTimesheetDetailsByManagerId(@PathVariable String managerId) {
        return timesheetService.getDetailsFromManagerId(managerId);
    }


    // Endpoint to update timesheet by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<TimesheetDTO> updateTimesheet(
            @PathVariable Long id,
            @RequestBody TimesheetDTO timesheetDTO) {

        TimesheetDTO updatedTimesheetDTO = timesheetService.updateTimesheetById(id, timesheetDTO);
        return ResponseEntity.ok(updatedTimesheetDTO);
    }



    @PutMapping("/Approve/{id}/status/{status}")
    public ResponseEntity<TimesheetDTO> approveUpdateStatus(
            @PathVariable Long id,
            @PathVariable Timesheet.Status status) {

        // Update the status and get the list of updated timesheets as DTOs
        TimesheetDTO updatedTimesheets = timesheetService.updateApproveStatus(id, status);

        if (updatedTimesheets != null ) {
            if(updatedTimesheets.getStatus()==Timesheet.Status.APPROVED){
                emailService.sendApprovalNotification(updatedTimesheets);
            }

            return ResponseEntity.ok(updatedTimesheets);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if no timesheets found
        }

    }

    @PutMapping("/reject/{id}/status/{status}/comments/{comments}")
    public ResponseEntity<TimesheetDTO> rejectUpdateStatus(
            @PathVariable Long id,
            @PathVariable Timesheet.Status status,
            @PathVariable String comments) {

        // Update the status and get the list of updated timesheets as DTOs
        TimesheetDTO updatedTimesheets = timesheetService.updateRejectStatus(id, status,comments);

        if (updatedTimesheets != null ) {

            if(updatedTimesheets.getStatus()==Timesheet.Status.REJECTED){
                emailService.sendRejectionNotification(updatedTimesheets,comments);
            }
            return ResponseEntity.ok(updatedTimesheets);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if no timesheets found
        }

    }

    @GetMapping("/status/{managerId}/{status}")
    public List<TimesheetDTO> getStatusDetails(@PathVariable String  managerId
            ,@PathVariable Timesheet.Status status) {
        return timesheetService.getDetailsByStatus(managerId,status);
    }

    @GetMapping("/status/{status}")
    public List<TimesheetDTO> getDetailsByStatus(@PathVariable Timesheet.Status status){
        return timesheetService.getTimesheetsByStatus(status);
    }

    @GetMapping("manager/{managerId}/startDate/{startDate}")
    public List<TimesheetDTO> getDetailsByStartDate(@PathVariable String managerId,
                                                    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        return timesheetService.getTimesheetsByManagerIdAndStartDate(managerId,startDate);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTimesheet(@PathVariable Long id) {
        boolean isDeleted = timesheetService.deleteTimesheet(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Timesheet deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Timesheet not found.");
        }
    }



    //Delete an entire timesheet particular employee based on employeeId
    @DeleteMapping("/delete/employeeId/{employeeId}")
    public ResponseEntity<Void> deleteTimesheet(@PathVariable String employeeId) {

        boolean isDeleted = timesheetService.deleteTimesheetByEmployeeId(employeeId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }



}
