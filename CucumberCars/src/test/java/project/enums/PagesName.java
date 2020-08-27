package project.enums;

import aquality.selenium.forms.Form;
import project.forms.*;

public enum PagesName {

    RESEARCHPAGE(new ResearchPage()),
    MAINPAGE(new MainPage()),
    COMPARETRIM(new CompareTrimPage()),
    COMPARECARS(new CompareSideBySideCarsPage()),
    MODELCOMPAREPAGE(new ModelComparePage()),
    ;

    private Form page;

    PagesName(Form page) {
        this.page = page;
    }

    public Form getPage() {
        return page;
    }
}
