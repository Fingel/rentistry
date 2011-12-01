package com.rentistry.domain;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rentusers")
@Controller
@RooWebScaffold(path = "rentusers", formBackingObject = RentUser.class)
public class RentUserController {
}
