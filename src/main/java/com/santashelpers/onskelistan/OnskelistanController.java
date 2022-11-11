
package com.santashelpers.onskelistan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OnskelistanController {

    private static final int PAGE_SIZE = 10;
    @Autowired
    private WisherRepository wisherRepository;

    @Autowired
    private ListRepository listRepository;
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
@GetMapping("/wishlists")
public String wishlists(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page){
    List<WishList> lists = getPage(page-1, PAGE_SIZE);
    int pageCount = numberOfPages(PAGE_SIZE);
    int[] pages = toArray(pageCount);

    model.addAttribute("lists", lists);
    model.addAttribute("pages", pages);
    model.addAttribute("currentPage", page);
    model.addAttribute("showPrev", page > 1);
    model.addAttribute("showNext", page < pageCount);

        return "wishlists";
}

    private List<WishList> getPage(int page, int pageSize) {
        List<WishList> lists = (List<WishList>)listRepository.findAllByOrderByProduct();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(lists.size(),(page+1)*pageSize);

        return lists.subList(from, to);
    }
    private int numberOfPages(int pageSize) {
        List<WishList> lists = (List<WishList>)listRepository.findAll();
        return (int)Math.ceil((double) lists.size() / pageSize);
    }
    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }
}



