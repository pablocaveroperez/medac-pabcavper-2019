package controller.SistemaInvestigacion;

import controller.Ctrl.CountryController;

public class PackageController {
    private UniversityController universityController;
    private FacultyController facultyController;
    private DepartmentController departmentController;
    private SpecializationController specializationController;

    public PackageController() {
        universityController = new UniversityController();
        facultyController = new FacultyController();
        departmentController = new DepartmentController();
        specializationController = new SpecializationController();
    }

}
