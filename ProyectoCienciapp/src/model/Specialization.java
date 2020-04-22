package model;

public class Specialization implements ISpecialization {
    private String sName;
    private String sDescription;

    public Specialization(String sName, String sDescription) {
        setsName(sName);
        setsDescription(sDescription);
    }

    @Override
    public String getsName() {
        return sName;
    }

    @Override
    public String getsDescription() {
        return sDescription;
    }

    @Override
    public boolean setsDescription(String sDescription) {
        boolean bExito = false;
        if (sDescription.length() < 200) {
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName.length() < 50){
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkSpecialization() {
        boolean bExito = false;
        if (getsName().length() < 50 && getsDescription().length() < 200){
            bExito = true;
        }
        return bExito;
    }

}
