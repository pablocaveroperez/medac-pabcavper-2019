package view.SistemaInvestigacion;

import controller.GeneralController;
import validaciones.ValidaLibrary;

public class SistemaInvestigacionView {
    public static void menuSistemaInvestigacion(GeneralController controller) {
        byte bOpcion = 0;
        do {
            bOpcion = opcionMenuSistemaInvestigacion();
            switch (bOpcion) {
                case 1:
                    UniversityView.menuUniversidades(controller);
                    break;
                case 2:
                    FacultyView.menuFacultades(controller);
                    break;
                case 3:
                    DepartmentView.menuDepartamentos(controller);
                    break;
                case 4:
                    ResearchTeamView.menuEquiposInvestigacion(controller);
                    break;
                case 5:
                    MemberView.menuMiembros(controller);
                    break;
                case 6:
                    SpecializationView.menuEspecializacion(controller);
                    break;
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 7);
    }

    private static byte opcionMenuSistemaInvestigacion() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nSISTEMA INVESTIGACION: ");
        System.out.println("1. Gestionar Universidades.");
        System.out.println("2. Gestionar Facultades.");
        System.out.println("3. Gestionar Departamentos.");
        System.out.println("4. Gestionar Equipos de investigacion.");
        System.out.println("5. Gestionar Miembros.");
        System.out.println("6. Gestionar Especializaciones.");
        System.out.println("7. Volver al menu principal.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 7, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
