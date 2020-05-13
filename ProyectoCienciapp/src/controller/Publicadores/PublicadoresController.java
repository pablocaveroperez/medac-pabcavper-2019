package controller.Publicadores;

import model.Publicadores.Headquarters;
import model.Publicadores.Magazine;

public class PublicadoresController {
    private HeadquartersController headquartersController;
    private MagazineController magazineController;

    public PublicadoresController() {
        headquartersController = new HeadquartersController();
        magazineController = new MagazineController();
    }

    public HeadquartersController getHeadquartersController() {
        return headquartersController;
    }

    public MagazineController getMagazineController() {
        return magazineController;
    }

    // OFICINA PRINCIPAL
    public int addHeadquarters(Headquarters oHeadquarters) {
        return headquartersController.add(oHeadquarters);
    }

    public int removeHeadquarters(Headquarters oHeadquartes) {
        return headquartersController.remove(oHeadquartes);
    }

    public int existeHeadquarters(Headquarters oHeadquarters) {
        return headquartersController.existeHQ(oHeadquarters);
    }

    // REVISTA
    public int addMagazine(Magazine oMagazine) {
        return magazineController.add(oMagazine);
    }

    public int removeMagazine(Magazine oMagazine) {
        return magazineController.remove(oMagazine);
    }

    public int existeMagazine(Magazine oMagazine) {
        return magazineController.existeHQ(oMagazine);
    }
}
