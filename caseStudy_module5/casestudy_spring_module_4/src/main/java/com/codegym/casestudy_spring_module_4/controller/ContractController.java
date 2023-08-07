package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Contract;
import com.codegym.casestudy_spring_module_4.model.Customer;
import com.codegym.casestudy_spring_module_4.model.Employee;
import com.codegym.casestudy_spring_module_4.model.Service;
import com.codegym.casestudy_spring_module_4.service.IContractService;
import com.codegym.casestudy_spring_module_4.service.ICustomerService;
import com.codegym.casestudy_spring_module_4.service.IEmployeeService;
import com.codegym.casestudy_spring_module_4.service.IServiceService;
import com.codegym.casestudy_spring_module_4.validation.ValidationDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IContractService contractService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Contract> contractList = contractService.findAllContract(pageable);
        List<Employee> employeeList = employeeService.findAllList();
        List<Customer> customerList = customerService.findAllList();
        List<Service> serviceList = serviceService.findAllList();
        model.addAttribute("contractList", contractList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("serviceList", serviceList);
        return "contract/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<Employee> employeeList = employeeService.findAllList();
        List<Customer> customerList = customerService.findAllList();
        List<Service> serviceList = serviceService.findAllList();
        Contract contract = new Contract();
        contract.setEmployeeId(new Employee());
        contract.setCustomerId(new Customer());
        contract.setServiceId(new Service());
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("contract", contract);
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        ValidationDate validation = new ValidationDate();
        validation.validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            contract.setEmployeeId(new Employee());
            contract.setCustomerId(new Customer());
            contract.setServiceId(new Service());
            List<Employee> employeeList = employeeService.findAllList();
            List<Customer> customerList = customerService.findAllList();
            List<Service> serviceList = serviceService.findAllList();

            model.addAttribute("employeeList", employeeList);
            model.addAttribute("customerList", customerList);
            model.addAttribute("serviceList", serviceList);
            model.addAttribute("contract", contract);
            return "contract/create";
        }
        contractService.insertContract(contract);
        redirectAttributes.addFlashAttribute("mess", "Create new successfully");
        return "redirect:/contract/list";
    }
}
