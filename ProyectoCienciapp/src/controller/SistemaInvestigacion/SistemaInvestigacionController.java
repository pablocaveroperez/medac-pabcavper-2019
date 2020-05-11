package controller.SistemaInvestigacion;


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


}
