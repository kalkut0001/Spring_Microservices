package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Companycontroller {

    public static final Logger logger= LoggerFactory.getLogger(Companycontroller.class);
    @GetMapping("/company/{companyID}")
    String getCompany(@PathVariable int companyID){
        logger.info("inside company controller..");
        String companyName="NA";
        if(companyID ==1){
            companyName="Accenture";
        }
        else if(companyID ==2){
            companyName="TCS";
        }
        else if(companyID ==3){
            companyName="Infosys";
        }
        else {
            companyName="Seems not working..";
        }
        return companyName;
    }
}
