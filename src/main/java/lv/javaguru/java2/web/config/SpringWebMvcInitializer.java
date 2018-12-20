package lv.javaguru.java2.web.config;

import lv.javaguru.java2.console.config.SpringAppConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class SpringWebMvcInitializer extends AbstractDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(SpringAppConfig.class);
        return applicationContext;
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(SpringWebMVCConfig.class);
        return applicationContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}