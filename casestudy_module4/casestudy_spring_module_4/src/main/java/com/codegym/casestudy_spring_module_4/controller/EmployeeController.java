package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.*;
import com.codegym.casestudy_spring_module_4.service.IDivisionService;
import com.codegym.casestudy_spring_module_4.service.IEducationDegreeService;
import com.codegym.casestudy_spring_module_4.service.IEmployeeService;
import com.codegym.casestudy_spring_module_4.service.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable,
                          @RequestParam("nameSearch") Optional<String> nameSearch,
                          @RequestParam("emailSearch") Optional<String> emailSearch,
                          @RequestParam("divisionSearch") Optional<String> divisionSearch) {
        Page<Employee> employeeList;
        String condition = "";

        if (nameSearch.isPresent() || emailSearch.isPresent() || divisionSearch.isPresent()) {
            employeeList = employeeService.searchEmployee(nameSearch.get(), emailSearch.get(), divisionSearch.get(), pageable);
            model.addAttribute("employeeList", employeeList);
        }

        if (nameSearch.isPresent()) {
            condition += "&nameSearch=" + nameSearch.get();
            model.addAttribute("nameSearch", nameSearch.get());
        }
        if (emailSearch.isPresent()) {
            condition += "&emailSearch=" + emailSearch.get();
            model.addAttribute("emailSearch", emailSearch.get());
        }
        if (divisionSearch.isPresent()) {
            condition += "&divisionSearch=" + divisionSearch.get();
            model.addAttribute("divisionSearch", divisionSearch.get());
        } else {
            employeeList = employeeService.findAllEmployee(pageable);
            model.addAttribute("employeeList", employeeList);
        }

        List<Position> positionList = positionService.findAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAllEducationDegree();
        List<Division> divisionList = divisionService.findAllDivision();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("condition", condition);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Employee employee = new Employee();
        employee.setPositionId(new Position());
        employee.setEducationDegreeId(new EducationDegree());
        employee.setDivisionId(new Division());

        List<Position> positionList = positionService.findAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAllEducationDegree();
        List<Division> divisionList = divisionService.findAllDivision();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employee", employee);
        return "employee/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            employee.setPositionId(new Position());
            employee.setEducationDegreeId(new EducationDegree());
            employee.setDivisionId(new Division());

            List<Position> positionList = positionService.findAllPosition();
            List<EducationDegree> educationDegreeList = educationDegreeService.findAllEducationDegree();
            List<Division> divisionList = divisionService.findAllDivision();

            model.addAttribute("positionList", positionList);
            model.addAttribute("educationDegreeList", educationDegreeList);
            model.addAttribute("divisionList", divisionList);
            model.addAttribute("employee", employee);
            return "employee/create";
        }
        employeeService.insertEmployee(employee);
        redirectAttributes.addFlashAttribute("mess", "Create new successfully");
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.selectEmployee(id);
        List<Position> positionList = positionService.findAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAllEducationDegree();
        List<Division> divisionList = divisionService.findAllDivision();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.updateEmployee(employee);
        redirectAttributes.addFlashAttribute("mess", "Edit successfully");
        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully");
        return "redirect:/employee/list";
    }
}
