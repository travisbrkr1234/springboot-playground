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

/*Home-------------
-----------------*/
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

/*File Upload-------------
-----------------*/
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String thisfilename = file.getOriginalFilename();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(thisfilename)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + thisfilename;
            } catch (Exception e) {
                return "You failed to upload " + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + " because the file was empty.";
        }
    }

/*Export-------------
-----------------*/
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
