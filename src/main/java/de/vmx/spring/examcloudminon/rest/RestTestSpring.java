package de.vmx.spring.examcloudminon.rest;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestSpring {

    private static final String template = "Hello";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public static String name() {
    	System.out.println("RestINterface -------------------------------------------------------------------------------");
    	return template;
	}
        
}