/* 
* @Author: carlos.ochoa
* @Date:   7/31/2015
* @Last Modified 2015-08-17
* @Modified By Jeremiah Marks - Jeremiah@JLMarks.org
*/
package com.datamigration;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.Map;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@EnableAutoConfiguration
@ComponentScan
@Controller
public class MigrationApp extends WebMvcConfigurerAdapter {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("account", new ImportIntegration());
        return "home";
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String baseSubmit(@ModelAttribute ImportIntegration account, Model model){
        model.addAttribute("account", account);
        if (account.getConnected()){
                return "home";
        }else{
            return "home";
        }
    }
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    //new stuff

   /* @RequestMapping(value="/importData", method=RequestMethod.GET)
    public String importData(Model model) {
        model.addAttribute("importData", new importData());
        return "import";
    }*/
    /*
    The /upload needs to be rewritten where it only returns the string that is served, I think.
    I think that @ResponseBody is more for API stuff than just serving html.
    */
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
/*
I am going to try and 
*/
    @RequestMapping(value="/export", method=RequestMethod.GET)
    public String exportForm(Model model) {
        model.addAttribute("export", new Export());
        return "export";
    }

    @RequestMapping(value="/export", method=RequestMethod.POST)
    public String exportSubmit(@ModelAttribute Export export, Model model) {
        model.addAttribute("export", export);
        return "exportResults";
    }

    //dne

    @RequestMapping(value="/CIA", method=RequestMethod.GET)
    public String ciaSubmit(Model model) {
        model.addAttribute("cia", new CIA());
        return "cia";
    }

    @RequestMapping(value="/CIA", method=RequestMethod.POST)
    public String ciaSubmit(@ModelAttribute CIA cia, Model model) {
        model.addAttribute("cia", cia);
        return "cia";
    }

    @RequestMapping("/foo")
    public String foo() {
        throw new RuntimeException("Expected exception in controller");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/wizardoptions").setViewName("wizardoptions");
        //registry.addViewController("/export").setViewName("export");
    }

    @Bean
    public ApplicationSecurity applicationSecurity() {
        return new ApplicationSecurity();
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(MigrationApp.class).run(args);
    }

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        private SecurityProperties security;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/upload","/css/**").permitAll().anyRequest()
                    .fullyAuthenticated().and().formLogin().loginPage("/login")
                    .failureUrl("/login?error").permitAll().and().logout().permitAll();
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        }

    }

}
