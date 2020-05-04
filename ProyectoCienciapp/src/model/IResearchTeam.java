package model;

public interface IResearchTeam {
    byte getIdResearchTeam();

    Department getoDepartment();

    boolean setoDepartment(Department oDepartment);

    String getsName();

    boolean setsName(String sName);

    int getiBudget();

    boolean setiBudget(int iBudget);

    boolean checkResearchTeam();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
