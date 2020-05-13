package controller;

import controller.ArticulosUsuarios.ArticulosUsuariosController;
import controller.Ctrl.CountryController;
import controller.Publicadores.PublicadoresController;
import controller.SistemaInvestigacion.SistemaInvestigacionController;
import model.SistemaInvestigacion.*;

public class GeneralController {
    private PublicadoresController publicadoresController;
    private CountryController countryController;
    private ArticulosUsuariosController articulosUsuariosController;
    private SistemaInvestigacionController sistemaInvestigacionController;

    public GeneralController(String sDatabase) {
        publicadoresController = new PublicadoresController();
        countryController = new CountryController();
        articulosUsuariosController = new ArticulosUsuariosController();
        sistemaInvestigacionController = new SistemaInvestigacionController();
        new ConexionDB(sDatabase);
    }

    public PublicadoresController getPublicadoresController() {
        return publicadoresController;
    }

    public CountryController getCountryController() {
        return countryController;
    }

    public ArticulosUsuariosController getArticulosUsuariosController() {
        return articulosUsuariosController;
    }

    // SISTEMA INVESTIGACION (UNIVERSIDAD)
    public int addUniversidad(University oUniversity) {
        return sistemaInvestigacionController.addUniversity(oUniversity);
    }

    public int removeUniversidad(University oUniversity) {
        return sistemaInvestigacionController.removeUniversity(oUniversity);
    }

    public int existeUniversity(University oUniversity) {
        return sistemaInvestigacionController.existeUniversity(oUniversity);
    }

    // SISTEMA INVESTIGACION (FACULTAD)
    public int addFaculty(Faculty oFaculty) {
        return sistemaInvestigacionController.addFaculty(oFaculty);
    }

    public int removeFaculty(Faculty oFaculty) {
        return sistemaInvestigacionController.removeFaculty(oFaculty);
    }

    public int existeFaculty(Faculty oFaculty) {
        return sistemaInvestigacionController.existeFaculty(oFaculty);
    }

    // SISTEMA INVESTIGACION (DEPARTAMENTO)
    public int addDepartment(Department oDepartment) {
        return sistemaInvestigacionController.addDepartment(oDepartment);
    }

    public int removeDepartment(Department oDepartment) {
        return sistemaInvestigacionController.removeDepartment(oDepartment);
    }

    public int existeDepartment(Department oDepartment) {
        return sistemaInvestigacionController.existeDepartment(oDepartment);
    }

    // SISTEMA INVESTIGACION (ESPECIALIZACION)
    public int addSpecialization(Specialization oSpecialization) {
        return sistemaInvestigacionController.addSpecialization(oSpecialization);
    }

    public int removeSpecialization(Specialization oSpecialization) {
        return sistemaInvestigacionController.removeSpecialization(oSpecialization);
    }

    public int existeSpecialization(Specialization oSpecialization) {
        return sistemaInvestigacionController.existeSpecialization(oSpecialization);
    }

    // SISTEMA INVESTIGACION (MIEMBRO)
    public int addMember(Member oMember) {
        return sistemaInvestigacionController.addMember(oMember);
    }

    public int removeMember(Member oMember) {
        return sistemaInvestigacionController.removeMember(oMember);
    }

    public int existeMember(Member oMember) {
        return sistemaInvestigacionController.existeMember(oMember);
    }
}
