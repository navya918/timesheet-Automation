//package com.project.middleware.TimesheetModule.service;
//
//import com.project.middleware.TimesheetModule.dto.TimesheetDTO;
//import com.project.middleware.TimesheetModule.entity.Timesheet;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ModelMapperConfig {
//
//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//
//        // Custom mapping for TimesheetDTO -> Timesheet (DTO to Entity)
//        modelMapper.typeMap(TimesheetDTO.class, Timesheet.class)
//                .addMappings(mapper -> {
//                    // Set status to PENDING if it's null or not APPROVED or REJECTED
//                    mapper.map(src ->
//                                    src.getStatus() == null || (src.getStatus() != Timesheet.Status.APPROVED
//                                            && src.getStatus() != Timesheet.Status.REJECTED) ? Timesheet.Status.PENDING : src.getStatus(),
//                            Timesheet::setStatus
//                    );
//
//                    // Default values for various fields if they are null
//                    mapper.map(src ->
//                                    src.getEmailId() == null ? "harshavardhan@middlewaretalents.com" : src.getEmailId(),
//                            Timesheet::setEmailId
//                    );
//                    mapper.map(src ->
//                                    src.getEmployeeId() == null ? "MTL1015" : src.getEmployeeId(),
//                            Timesheet::setEmployeeId
//                    );
//                    mapper.map(src ->
//                                    src.getEmployeeName() == null ? "Harshavardhan" : src.getEmployeeName(),
//                            Timesheet::setEmployeeName
//                    );
//                    mapper.map(src ->
//                                    src.getManagerId() == null ? "MTL1001" : src.getManagerId(),
//                            Timesheet::setManagerId
//                    );
//                    mapper.map(src ->
//                                    src.getManager() == null ? "Jon" : src.getManager(),
//                            Timesheet::setManager
//                    );
//                });
//
//        // Custom mapping for Timesheet -> TimesheetDTO (Entity to DTO)
//        modelMapper.typeMap(Timesheet.class, TimesheetDTO.class)
//                .addMappings(mapper -> mapper.map(
//                        src -> src.getNumberOfHours() + src.getExtraHours(),
//                        TimesheetDTO::setTotalNumberOfHours)
//                );
//
//        return modelMapper;
//    }
//}



//<!--		<dependency>-->
//<!--			<groupId>org.modelmapper</groupId>-->
//<!--			<artifactId>modelmapper</artifactId>-->
//<!--			<version>3.2.1</version>-->
//<!--		</dependency>-->
