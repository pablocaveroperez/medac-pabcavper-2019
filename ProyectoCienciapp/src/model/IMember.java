package model;

import java.util.GregorianCalendar;

public interface IMember {
    String getsDNI();

    GregorianCalendar getBirthDate();

    boolean setBirthDate(GregorianCalendar birthDate);

    String getsName();

    boolean setsName(String sName);

    String getsSurname();

    boolean setsSurname(String sSurname);

    Specialization getoSpecialization();

    boolean setoSpecialization(Specialization oSpecialization);

    ResearchTeam getoResearchTeam();

    boolean setoResearchTeam(ResearchTeam oResearchTeam);

    boolean checkMember();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
