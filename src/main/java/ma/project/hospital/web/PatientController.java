package ma.project.hospital.web;

import lombok.AllArgsConstructor;
import ma.project.hospital.entities.Patient;
import ma.project.hospital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository ;

    @GetMapping("/index")
    private String index(Model model,
                         @RequestParam(name = "p",defaultValue = "0") int page,
                         @RequestParam(name = "s",defaultValue = "4") int size,
                         @RequestParam(name = "keyword",defaultValue = "") String key){

        Page<Patient> pagePatients = patientRepository.findByNomContains(key,PageRequest.of(page,size));
        model.addAttribute("patients",pagePatients.getContent()) ;
        model.addAttribute("pages" , new int[pagePatients.getTotalPages()]) ;
        model.addAttribute("currentPage",page);
        model.addAttribute("key" , key) ;
        return "patients" ;
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword, int p){
        patientRepository.deleteById(id);
        return "redirect:/index?p="+p+"&keyword="+keyword ;
    }

}
