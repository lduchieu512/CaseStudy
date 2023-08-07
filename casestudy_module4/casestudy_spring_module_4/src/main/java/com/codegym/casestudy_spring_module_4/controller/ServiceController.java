package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.RentType;
import com.codegym.casestudy_spring_module_4.model.Service;
import com.codegym.casestudy_spring_module_4.model.ServiceType;
import com.codegym.casestudy_spring_module_4.service.IRentTypeService;
import com.codegym.casestudy_spring_module_4.service.IServiceService;
import com.codegym.casestudy_spring_module_4.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Service> serviceList = serviceService.findAllService(pageable);
        List<ServiceType> serviceTypeList = serviceTypeService.findAllTypeService();
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "service/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<ServiceType> serviceTypeList = serviceTypeService.findAllTypeService();
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        Service service = new Service();
        service.setServiceTypeId(new ServiceType());
        service.setRentTypeId(new RentType());
        model.addAttribute("service", service);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "service/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            service.setServiceTypeId(new ServiceType());
            service.setRentTypeId(new RentType());
            List<ServiceType> serviceTypeList = serviceTypeService.findAllTypeService();
            List<RentType> rentTypeList = rentTypeService.findAllRentType();

            model.addAttribute("serviceTypeList", serviceTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            model.addAttribute("service", service);
            return "service/create";
        }
        serviceService.insertService(service);
        redirectAttributes.addFlashAttribute("mess", "Create new successfully");
        return "redirect:/service/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") String id, Model model) {
        Service service = serviceService.selectService(id);
        List<ServiceType> serviceTypeList = serviceTypeService.findAllTypeService();
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        model.addAttribute("service", service);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "service/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        serviceService.updateService(service);
        redirectAttributes.addFlashAttribute("mess", "Edit successfully");
        return "redirect:/service/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") String id, RedirectAttributes redirectAttributes) {
        serviceService.deleteService(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully");
        return "redirect:/service/list";
    }
}
