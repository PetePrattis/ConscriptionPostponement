package gr.hua.dit.ds.it219151.mappers;

import gr.hua.dit.ds.it219151.domains.Application;
import gr.hua.dit.ds.it219151.forms.ApplicationForm;
import org.springframework.stereotype.Component;


@Component
public class ApplicationFormToApplicationMapper {

    public Application map(ApplicationForm applicationForm) {
        Application application = new Application();
        application.setDocument(applicationForm.getDocument());
        application.setBirthday(applicationForm.getBirthday());

        return application;
    }
}