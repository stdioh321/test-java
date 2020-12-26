package com.stdioh321.mvc.controllers;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.stdioh321.mvc.entities.Contact;
import com.stdioh321.mvc.entities.Tarefa;
import com.stdioh321.mvc.entities.User;

@Controller
public class TmpController {

    @PersistenceContext(unitName = "pu-mysql")
    private EntityManager eManager;

    private Tarefa tarefa;


    @Autowired
    public TmpController(Tarefa tarefa) {
        // TODO Auto-generated constructor stub
        this.tarefa = tarefa;
    }

    @RequestMapping(value = "/tmp-controller/{tmp}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String tmp(@Valid Contact c, BindingResult result, ModelMap model, @PathVariable String tmp) {
        if (result.hasFieldErrors()) {
            System.out.println("HAS ERRRORS");
            return "home/home";
        } else
            System.out.println(c);
        System.out.println(tmp);
        // org.springframework.web.servlet.DispatcherServlet
        model.addAttribute("contact", c);
        return "tmp";
    }

    @GetMapping(value = "/tmp-controller")
    public String getTmp(Contact c, ModelMap model) {
        // org.springframework.web.servlet.DispatcherServlet

        System.out.println(c);
        model.addAttribute("contact", c);
        return "tmp";
    }

    @GetMapping(value = "/home")
    public String getHome() {
        return "home/home";
    }

    @ResponseBody
    @GetMapping(value = "/tmp")
    public String getTmp(ModelMap model, HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, JsonProcessingException {

        System.out.println("Req ID: " + req.getParameter("id"));

//		var m = new HashMap<String, String>();
//		m.put("home", "home321");
//		model.addAttribute("home", m);
//		model.addAttribute("title", "Some Title");

        ModelAndView mv = new ModelAndView();
        Contact c = new Contact();
        c.setId("asdas");
        c.setName("asdasxzhcjxh8");

        mv.addObject("title", c);
        mv.addObject("d", Calendar.getInstance().getTime());
        mv.setViewName("home/home");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/fj21?user=root&password=includestdioh");
        var cs = conn.prepareStatement("SELECT * FROM users;");
        var rs = cs.executeQuery();
        List<User> users = new ArrayList<User>();
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getString("id"));
            u.setName(rs.getString("name"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setCreatedAt(rs.getTimestamp("created_at"));
            u.setUpdatedAt(rs.getTimestamp("updated_at"));
            users.add(u);
        }
        conn.close();

        mv.addObject("users", users);
//		return mv;
        resp.setContentType("application/json");

        return new ObjectMapper().writeValueAsString(users);
    }

    @ResponseBody
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() throws JsonProcessingException {

		/*EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("pu-mysql");
		EntityManager em = emFactory.createEntityManager();*/
        System.out.println("WORKS");
        List<User> users = eManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        for (User u : users) {
            System.out.println(u);
        }

        return users;
    }


    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)

    public @ResponseBody
    Object postUser(@Valid User user, BindingResult result, Model model, HttpServletResponse resp) throws JsonProcessingException {
        if (result.hasErrors()) {

            resp.setStatus(400);
            return new ObjectMapper().writeValueAsString(result.getAllErrors());
        }
        System.out.println("----- IT Worked -----");
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("pu-mysql");
		EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();

            String pass = user.getPassword();
            user.setPassword(Hashing.sha256().hashString(pass, StandardCharsets.UTF_8).toString());

            em.persist(user);
            em.flush();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(user);
        em.close();


        return user;
    }


    @ResponseBody
    @GetMapping("/temp")
    public String getTemp(@Value("${config.appname}") String appname, @Value("${db.mysql.host}") String host) {
        return "getTemp: " + appname + ": HOST: " + host;
    }
}
