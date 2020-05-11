package controller.Ctrl;

public class PackageController {
    private CountryController countryController;
    private UniversityController universityController;

    public PackageController() {
        universityController = new UniversityController();
        countryController = new CountryController();
    }

}
