package com.cbt.analyticsservicecbtaug23one;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MainRestController
{
    @GetMapping("get/instance")
    public ResponseEntity<String> getInstance()
    {
        return new ResponseEntity<>("this is from ANALYTICS_SERVICE_ONE", HttpStatus.OK);
    }
}
