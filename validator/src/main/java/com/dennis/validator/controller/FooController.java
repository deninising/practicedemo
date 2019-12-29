package com.dennis.validator.controller;

import com.dennis.validator.annontion.StrValid;
import com.dennis.validator.dto.Foo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @author Dennis
 * @version 1.0
 * @date 2019/12/29 15:03
 */
@RestController
@RequestMapping
@Validated
public class FooController {

    @PostMapping(value = "/foo/one")
    public String fooOne(@Validated @RequestBody Foo foo) {
        return "success";
    }

    @GetMapping(value = "/foo/two")
    public String fooTwo(@StrValid(minimumLength = "8") String testStr,
                         @StrValid(minimumLength = "8") String testStr01 ) {
        System.out.println(testStr);
        System.out.println(testStr01);
        return "success";
    }

}
