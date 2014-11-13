package com.pb;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by pbourke on 11/12/14.
 */
public class HelloResource extends ResourceSupport {
    public String name;
    public String city;
}
