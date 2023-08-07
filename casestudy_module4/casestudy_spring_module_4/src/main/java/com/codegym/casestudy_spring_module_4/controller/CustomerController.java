package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Customer;
import com.codegym.casestudy_spring_module_4.model.CustomerType;
import com.codegym.casestudy_spring_module_4.service.ICustomerService;
import com.codegym.casestudy_spring_module_4.service.ICustomerTypeService;
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
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable,
                          @RequestParam("nameSearch") Optional<String> nameSearch,
                          @RequestParam("emailSearch") Optional<String> emailSearch,
                          @RequestParam("typeSearch") Optional<String> typeSearch) {
        Page<Customer> customerList;
        String condition = "";

        if (nameSearch.isPresent() || emailSearch.isPresent() || typeSearch.isPresent()) {
            customerList = customerService.searchCustomer(nameSearch.get(), emailSearch.get(), typeSearch.get(), pageable);
            model.addAttribute("customerList", customerList);
        }

        if (nameSearch.isPresent()) {
            condition += "&nameSearch=" + nameSearch.get();
            model.addAttribute("nameSearch", nameSearch.get());
        }
        if (emailSearch.isPresent()) {
            condition += "&emailSearch=" + emailSearch.get();
            model.addAttribute("emailSearch", emailSearch.get());
        }
        if (typeSearch.isPresent()) {
            condition += "&typeSearch=" + typeSearch.get();
            model.addAttribute("typeSearch", typeSearch.get());
        } else {
            customerList = customerService.findAllCustomer(pageable);
            model.addAttribute("customerList", customerList);
        }

        List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("condition", condition);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Customer customer = new Customer();
        List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            customer.setCustomerTypeId(new CustomerType());
            List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();

            model.addAttribute("customerTypeList", customerTypeList);
            model.addAttribute("customer", customer);
            return "customer/create";
        }
        customerService.insertCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Create new successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.selectCustomer(id);
        List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") String id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully");
        return "redirect:/customer/list";
    }
}
