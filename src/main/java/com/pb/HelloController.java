package com.pb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by pbourke on 11/12/14.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    @Resource(name="message")
    private String theMessage;

    @Autowired
    private MessageMaker messageMaker;

    @RequestMapping(method = RequestMethod.GET, produces = {"text/plain"})
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>("Hello!! " + messageMaker.getMessage(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<HelloResource> namedHello(@PathVariable("name") String name) {
        final HelloResource resource = new HelloResource();
        resource.name = name;
        resource.city = "New York";
        resource.add(new Link("http://google.com", "content"));

        return new ResponseEntity<HelloResource>(resource, HttpStatus.OK);
    }
}
