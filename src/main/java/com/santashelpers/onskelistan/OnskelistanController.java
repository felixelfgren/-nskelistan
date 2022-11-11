
package com.santashelpers.onskelistan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class OnskelistanController {


    @Autowired
    private WisherRepository wisherRepository;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user", new Wisher());
        return "index";
    }

    @PostMapping("/")
    public String login(HttpSession session, @ModelAttribute Wisher user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
            session.setAttribute("username", user.getUsername());
            return "onskelista";
        }
        return "redirect:/";
    }

    @GetMapping("/onskelista")
    public String level1(HttpSession session){
        String username = (String)session.getAttribute("username");
        if (username != null) {
            return "onskelista";
        }
        return "redirect:/";
    }


    @GetMapping("/inloggad")
    public String level333(HttpSession session, @ModelAttribute Wisher wisher, @ModelAttribute List list){
        var onskelista = wisher.getWishlist();
        session.getAttribute("username");
        session.setAttribute("onskelista", onskelista);

        return "logged_in";
    }

    @PostMapping("/inloggad")

    @GetMapping("/add")
    public String add(HttpSession session, @ModelAttribute Wisher user){

    return "nada";
    }

    @PostMapping("/add")
    public String addbook(Model model, HttpSession session, @ModelAttribute Wisher wisher){
        wisherRepository.save(wisher);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse res){
        session.removeAttribute("username"); // this would be an ok solution
        session.invalidate(); // you could also invalidate the whole session, a new session will be created the next request
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String getlogin(Model model){
        model.addAttribute("user", new Wisher());
        return "login";
    }
    @PostMapping("/login")
    public String loginNew(HttpSession session, @ModelAttribute Wisher user){
        if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
            session.setAttribute("username", user.getUsername());
            return "onskelista";
        }
        return "redirect:/";
    }
}



