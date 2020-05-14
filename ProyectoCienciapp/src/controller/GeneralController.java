package controller;

import controller.ArticulosUsuarios.ArticulosUsuariosController;
import controller.Ctrl.CountryController;
import controller.Publicadores.PublicadoresController;
import controller.SistemaInvestigacion.SistemaInvestigacionController;
import model.ArticulosUsuarios.*;
import model.Ctrl.Country;
import model.Publicadores.Headquarters;
import model.Publicadores.Magazine;
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

    public SistemaInvestigacionController getSistemaInvestigacionController() {
        return sistemaInvestigacionController;
    }

    // ###################################
    // #######SISTEMA INVESTIGACION#######
    // ###################################

    // UNIVERSIDAD
    public int addUniversidad(University oUniversity) {
        return sistemaInvestigacionController.addUniversity(oUniversity);
    }

    public int removeUniversidad(University oUniversity) {
        return sistemaInvestigacionController.removeUniversity(oUniversity);
    }

    public int existeUniversity(University oUniversity) {
        return sistemaInvestigacionController.existeUniversity(oUniversity);
    }

    // FACULTAD
    public int addFaculty(Faculty oFaculty) {
        return sistemaInvestigacionController.addFaculty(oFaculty);
    }

    public int removeFaculty(Faculty oFaculty) {
        return sistemaInvestigacionController.removeFaculty(oFaculty);
    }

    public int existeFaculty(Faculty oFaculty) {
        return sistemaInvestigacionController.existeFaculty(oFaculty);
    }

    // DEPARTAMENTO
    public int addDepartment(Department oDepartment) {
        return sistemaInvestigacionController.addDepartment(oDepartment);
    }

    public int removeDepartment(Department oDepartment) {
        return sistemaInvestigacionController.removeDepartment(oDepartment);
    }

    public int existeDepartment(Department oDepartment) {
        return sistemaInvestigacionController.existeDepartment(oDepartment);
    }

    // ESPECIALIZACION
    public int addSpecialization(Specialization oSpecialization) {
        return sistemaInvestigacionController.addSpecialization(oSpecialization);
    }

    public int removeSpecialization(Specialization oSpecialization) {
        return sistemaInvestigacionController.removeSpecialization(oSpecialization);
    }

    public int existeSpecialization(Specialization oSpecialization) {
        return sistemaInvestigacionController.existeSpecialization(oSpecialization);
    }

    // MIEMBRO
    public int addMember(Member oMember) {
        return sistemaInvestigacionController.addMember(oMember);
    }

    public int removeMember(Member oMember) {
        return sistemaInvestigacionController.removeMember(oMember);
    }

    public int existeMember(Member oMember) {
        return sistemaInvestigacionController.existeMember(oMember);
    }

    // EQUIPO DE INVESTIGACION
    public int addResearchTeam(ResearchTeam oResearchTeam) {
        return sistemaInvestigacionController.addResearchTeam(oResearchTeam);
    }

    public int removeResearchTeam(ResearchTeam oResearchTeam) {
        return sistemaInvestigacionController.removeResearchTeam(oResearchTeam);
    }

    public int existeResearchTeam(ResearchTeam oResearchTeam) {
        return sistemaInvestigacionController.existeResearchTeam(oResearchTeam);
    }


    // ###################################
    // ########COUNTRY CONTROLLER#########
    // ###################################

    public int addCountry(Country oCountry) {
        return countryController.add(oCountry);
    }

    public int removeCountry(Country oCountry) {
        return countryController.remove(oCountry);
    }

    public int existeCountry(Country oCountry) {
        return countryController.existePais(oCountry);
    }

    // ###################################
    // ############PUBLICADORES###########
    // ###################################

    // OFICINA PRINCIPAL
    public int addHeadquarters(Headquarters oHeadquarters) {
        return publicadoresController.addHeadquarters(oHeadquarters);
    }

    public int removeHeadquarters(Headquarters oHeadquartes) {
        return publicadoresController.removeHeadquarters(oHeadquartes);
    }

    public int existeHeadquarters(Headquarters oHeadquarters) {
        return publicadoresController.existeHeadquarters(oHeadquarters);
    }

    // REVISTA
    public int addMagazine(Magazine oMagazine) {
        return publicadoresController.addMagazine(oMagazine);
    }

    public int removeMagazine(Magazine oMagazine) {
        return publicadoresController.removeMagazine(oMagazine);
    }

    public int existeMagazine(Magazine oMagazine) {
        return publicadoresController.existeMagazine(oMagazine);
    }

    // ###################################
    // #########ARTICULOS USUARIO#########
    // ###################################

    // USUARIO
    public int addUser(User oUser) {
        return articulosUsuariosController.addUser(oUser);
    }

    public int removeUser(User oUser) {
        return articulosUsuariosController.removeUser(oUser);
    }

    public int existeUser(User oUser) {
        return articulosUsuariosController.existeUser(oUser);
    }

    // CATEGORIA
    public int addCategory(Category oCategory) {
        return articulosUsuariosController.addCategory(oCategory);
    }

    public int removeCategory(Category oCategory) {
        return articulosUsuariosController.removeCategory(oCategory);
    }

    public int existeCategory(Category oCategory) {
        return articulosUsuariosController.existeCategory(oCategory);
    }

    // TIPO ARTICULO
    public int addArticleType(ArticleType oArticleType) {
        return articulosUsuariosController.addArticleType(oArticleType);
    }

    public int removeArticleType(ArticleType oArticleType) {
        return articulosUsuariosController.removeArticleType(oArticleType);
    }

    public int existeArticleType(ArticleType oArticleType) {
        return articulosUsuariosController.existeArticleType(oArticleType);
    }

    // ARTICULO
    public int addArticle(Article oArticle) {
        return articulosUsuariosController.addArticle(oArticle);
    }

    public int removeArticle(Article oArticle) {
        return articulosUsuariosController.removeArticle(oArticle);
    }

    public int existeArticle(Article oArticle) {
        return articulosUsuariosController.existeArticle(oArticle);
    }

    // PUNTUACION DEL ARTICULO POR USUARIO
    public int addArticleRatingUser(ArticleRatingUser oArticleRatingUser) {
        return articulosUsuariosController.addArticleRatingUser(oArticleRatingUser);
    }

    public int removeArticleRatingUser(ArticleRatingUser oArticleRatingUser) {
        return articulosUsuariosController.removeArticleRatingUser(oArticleRatingUser);
    }

    public int existeArticleRatingUser(ArticleRatingUser oArticleRatingUser) {
        return articulosUsuariosController.existeArticleRatingUser(oArticleRatingUser);
    }

    // CATEGORIA DEL ARTICULO
    public int addArticleXCategory(ArticleXCategory oArticleXCategory) {
        return articulosUsuariosController.addArticleXCategory(oArticleXCategory);
    }

    public int removeArticleXCategory(ArticleXCategory oArticleXCategory) {
        return articulosUsuariosController.removeArticleXCategory(oArticleXCategory);
    }

    public int existeArticleXCategory(ArticleXCategory oArticleXCategory) {
        return articulosUsuariosController.existeArticleXCategory(oArticleXCategory);
    }
}
