package liga.medical.personservice.core.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    @GetMapping
    public String getAdminPage() {
        return "This is admin page";
    }
}