package com.project.middleware.TimesheetModule.exception;

import com.project.middleware.TimesheetModule.entity.Timesheet;

import java.time.LocalDate;
import java.util.List;

public class TimesheetNotFoundException extends  RuntimeException{

    public TimesheetNotFoundException(String employeeId) {

        super("Timesheet not found with : " + employeeId);
    }

    public TimesheetNotFoundException(String employeeId, LocalDate date) {
        super("Timesheet not found with ID : " + employeeId+" and Date : "+date);
    }

    public TimesheetNotFoundException(Long id) {

        super("Timesheet not found with ID: " + id);
    }

    public TimesheetNotFoundException(List<Timesheet> timesheet) {

        super("Timesheet is empty: " + timesheet);
    }

    public TimesheetNotFoundException(String employeeId, LocalDate startDate, LocalDate endDate) {
        super("A timesheet already exists for Employee ID: " + employeeId + " with Start Date: " + startDate + " and End Date: " + endDate);
    }


    public TimesheetNotFoundException(Timesheet timesheet) {

        super("Timesheet record already found in the database " + timesheet);
    }


    public TimesheetNotFoundException(String managerId, Timesheet.Status status) {
        super("No timesheet found with Manager ID: " + managerId + " and Status: " + status);
    }

    public TimesheetNotFoundException(Timesheet.Status status){
        super("There is no timesheet with status: " + status);
    }





}
