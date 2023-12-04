package com.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class Employeecontroller {

    public static final Logger logger = LoggerFactory.getLogger(Employeecontroller.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{empid}")
    public Map<String,String> fetEmploye(@PathVariable int empid){
        logger.info("empid {}",empid);
        Map<String,String> map=new HashMap<>();
        int companyId=0;
        String empName="NA";
        if(empid ==1){
            companyId=1;
            empName="Arijit";
        }
        else if(empid ==2){
            companyId=2;
            empName="Priyanka";

        }
        else if(empid ==3){
            companyId=3;
            empName="Johney";

        }

        String url=String.format("http://localhost:8082/company/%s",companyId);

       String companyName= restTemplate.getForObject(url,String.class);
        map.put(empName,companyName);
        return map;
    }
}
