package controller.SistemaInvestigacion;

public class PackageController {
    private UniversityController universityController;
    private FacultyController facultyController;
    private DepartmentController departmentController;
    private SpecializationController specializationController;
    private MemberController memberController;

    public PackageController() {
        universityController = new UniversityController();
        facultyController = new FacultyController();
        departmentController = new DepartmentController();
        specializationController = new SpecializationController();
        memberController = new MemberController();
    }

}
