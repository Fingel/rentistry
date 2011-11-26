package com.rentistry.web;

import com.rentistry.domain.ItemTag;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/itemtags")
@Controller
@RooWebScaffold(path = "itemtags", formBackingObject = ItemTag.class)
public class ItemTagController {
}
