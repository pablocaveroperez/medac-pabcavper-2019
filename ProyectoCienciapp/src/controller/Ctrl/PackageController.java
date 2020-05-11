package controller.Ctrl;

public class PackageController {
    private CountryController countryController;
    private UniversityController universityController;
    private FacultyController facultyController;

    public PackageController() {
        countryController = new CountryController();
        universityController = new UniversityController();
        facultyController = new FacultyController();
    }

}
