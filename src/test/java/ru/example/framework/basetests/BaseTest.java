package ru.example.framework.basetests;

import io.qameta.allure.Allure;
import lombok.Setter;
import org.hibernate.Session;
import ru.example.framework.components.StepContext;
import ru.example.framework.components.WrappableStep;
import ru.example.framework.managers.configmgr.ConfigMgr;

public abstract class BaseTest {
    @Setter
    protected Session databaseSession;
    protected StepContext stepContext = StepContext.getInstance();

    public void setAllureTMS(String allureTMS) {
        String urlLink = ConfigMgr.getConfig().getProject().getAllureTMSUrl() + allureTMS;
        Allure.tms(allureTMS, urlLink);
        Allure.label("AS_ID", urlLink);
    }

    public void closeDatabaseSession() {
        databaseSession.close();
    }

    public String getStep() { return stepContext.getStep(); }

    public void aftStep(final String message, WrappableStep action) {
        stepContext.aftStep(message, action);
    }

    public void aftStep(int stepNo, final String message, WrappableStep action) {
        stepContext.aftStep(stepNo, message, action);
    }
}
