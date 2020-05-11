package controller.SistemaInvestigacion;


import model.SistemaInvestigacion.*;

public class SistemaInvestigacionController {
    private UniversityController universityController;
    private FacultyController facultyController;
    private DepartmentController departmentController;
    private SpecializationController specializationController;
    private MemberController memberController;

    public SistemaInvestigacionController() {
        universityController = new UniversityController();
        facultyController = new FacultyController();
        departmentController = new DepartmentController();
        specializationController = new SpecializationController();
        memberController = new MemberController();
    }

    public UniversityController getUniversityController() {
        return universityController;
    }

    public FacultyController getFacultyController() {
        return facultyController;
    }

    public DepartmentController getDepartmentController() {
        return departmentController;
    }

    public SpecializationController getSpecializationController() {
        return specializationController;
    }

    public MemberController getMemberController() {
        return memberController;
    }

    // UNIVERSIDAD
    // #################
    public int addUniversity(University oUniversity) {
        return universityController.add(oUniversity);
    }

    // FACULTAD
    // #################
    public int addFaculty(Faculty oFaculty) {
        return facultyController.add(oFaculty);
    }

    // DEPARTAMENTO
    // #################
    public int addDepartment(Department oDepartment) {
        return departmentController.add(oDepartment);
    }

    // ESPECIALIZACION
    // #################
    public int addSpecialization(Specialization oSpecialization) {
        return specializationController.add(oSpecialization);
    }

    // MIEMBRO
    // #################
    public int addMember(Member oMember) {
        return memberController.add(oMember);
    }
}
