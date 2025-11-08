package com.example.redkeepithalal;
public class qna {
    //question by men and answer from women
    private boolean takeCareOfFamily ;
    //question by women and answers from men
    private boolean secondMarriage ;
    private boolean furtherStudiesOrWork ;
    //common questiona
    private boolean canCook ;
    private boolean cookPreference ;
    public qna()
    {

    }

    public qna(boolean takeCareOfFamily, boolean secondMarriage, boolean furtherStudiesOrWork, boolean canCook, boolean cookPreference) {
        this.takeCareOfFamily = takeCareOfFamily;
        this.secondMarriage = secondMarriage;
        this.furtherStudiesOrWork = furtherStudiesOrWork;
        this.canCook = canCook;
        this.cookPreference = cookPreference ;
    }

    public boolean isTakeCareOfFamily() {
        return takeCareOfFamily;
    }

    public void setTakeCareOfFamily(boolean takeCareOfFamily) {
        this.takeCareOfFamily = takeCareOfFamily;
    }

    public boolean isSecondMarriage() {
        return secondMarriage;
    }

    public void setSecondMarriage(boolean secondMarriage) {
        this.secondMarriage = secondMarriage;
    }

    public boolean isFurtherStudiesOrWork() {
        return furtherStudiesOrWork;
    }

    public void setFurtherStudiesOrWork(boolean furtherStudiesOrWork) {
        this.furtherStudiesOrWork = furtherStudiesOrWork;
    }

    public boolean isCanCook() {
        return canCook;
    }

    public void setCanCook(boolean canCook) {
        this.canCook = canCook;
    }

    public boolean isCookPreference() {
        return cookPreference;
    }

    public void setCookPreference(boolean cookPreference) {
        this.cookPreference = cookPreference;
    }
}

