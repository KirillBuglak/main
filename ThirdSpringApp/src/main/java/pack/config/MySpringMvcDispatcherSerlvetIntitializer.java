package pack.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pack.config.MyConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class MySpringMvcDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerHidenFieldFilter(servletContext);
    }
    private void registerHidenFieldFilter(ServletContext servletContext){
        servletContext.addFilter("hiddenMeth", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null ,true, "/*");
    }
}