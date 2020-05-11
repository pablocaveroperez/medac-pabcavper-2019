package controller;

public class GeneralController {

    public GeneralController(String sDatabase) {

        new ConexionDB(sDatabase);
    }
}
