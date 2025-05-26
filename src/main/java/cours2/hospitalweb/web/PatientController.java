package cours2.hospitalweb.web;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.ui.Model;
import cours2.hospitalweb.entities.Patient;
import cours2.hospitalweb.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/user/patients")
    public String index(Model model, @RequestParam(name = "p", defaultValue = "0") int page,
                        @RequestParam(name = "s", defaultValue = "15") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw
    ) {
        Page<Patient> patientPage = patientRepository.findByNomContains(kw, PageRequest.of(page, size));
        model.addAttribute("ListPatients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("username", "Admin");
        return "patients";
    }

    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete( @RequestParam Long id,
                          @RequestParam(defaultValue = "") String kw,
                          @RequestParam(defaultValue = "0")int page) {
        patientRepository.deleteById(id);
        return "redirect:/user/patients?p=" + page + "&keyword=" + kw;
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/user/patients";
    }

    @GetMapping("/api/patients")
    @ResponseBody
    public List<Patient> lisPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/admin/formPatients")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
@PostMapping(path = "/save")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public  String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "") String kw) {
        patientRepository.save(patient);
        if(bindingResult.hasErrors()) { return "formPatients";}
        model.addAttribute("patient", patient);
        return "redirect:/patients?page=" + page + "&keyword=" + kw;
    }
    @GetMapping("/admin/editPatients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public String editPatient(Model model,
                              @RequestParam Long id,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatients";
    }

}
